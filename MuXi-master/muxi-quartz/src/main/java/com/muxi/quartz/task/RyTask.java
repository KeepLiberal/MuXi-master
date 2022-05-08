package com.muxi.quartz.task;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.muxi.common.utils.JsonUtil;
import com.muxi.common.utils.StringUtils;
import com.muxi.common.utils.http.HttpUtils;
import com.muxi.investment.domain.InvCompany;
import com.muxi.investment.domain.InvStock;
import com.muxi.investment.mapper.InvCompanyMapper;
import com.muxi.investment.mapper.InvStockMapper;
import com.muxi.quartz.async.MyAsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时任务调度测试
 *
 * @author wenyong.yang
 */
@Component("ryTask")
@Slf4j
public class RyTask {
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        log.info(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params) {
        log.info("执行有参方法：" + params);
    }


    @Resource
    private Environment ev;
    @Resource
    private MyAsyncTask myAsyncTask;
    @Resource
    private InvStockMapper invStockMapper;
    @Resource
    private InvCompanyMapper invCompanyMapper;


    public void stockTask() {
        log.info("========stockTask任务开始=========");
        String url = ev.getProperty("muxi.stock-list");
        String jsonStr = HttpUtils.sendGet(url, "", "UTF-8");

        if (null != jsonStr) {
            List<InvStock> invStocks = invStockMapper.selectInvStockList(null);
            Map<String, InvStock> stockMap = new HashMap<>();
            for (InvStock stock : invStocks) {
                stockMap.put(stock.getCode(), stock);
            }

            JSONObject json = JsonUtil.parseObject(jsonStr);// 解析jsonStr
            JSONArray diffArray = json.getJSONObject("data").getJSONArray("diff");
            for (int i = 0; i < diffArray.size(); i++) {
                JSONObject jsonObject = diffArray.getJSONObject(i);
                String code = jsonObject.getString("f12");
                String name = jsonObject.getString("f14");
                String market = "";
                if (code.startsWith("000") || code.startsWith("001") || code.startsWith("002") || code.startsWith("003") ||
                        code.startsWith("200") || code.startsWith("201") || code.startsWith("300") || code.startsWith("301")) {
                    market = "sz";
                } else if (code.startsWith("600") || code.startsWith("601") ||
                        code.startsWith("603") || code.startsWith("605") ||
                        code.startsWith("688") || code.startsWith("689") || code.startsWith("900")) {
                    market = "sh";
                }
                InvStock stock = new InvStock(code, name, market);
                if (!stockMap.containsKey(code)) {//数据库不存在，直接插入
                    invStockMapper.insertInvStock(stock);
                } else {
                    if (!stockMap.get(code).equals(stock)) {//数据库存在，但是有数据变更，进行更新
                        invStockMapper.updateInvStock(stock);
                    }
                }
            }
        }
        log.info("========stockTask任务完成=========");
    }


    public void companyTask() {
        log.info("========CompanyJob任务线程分发开始=========");
        List<InvCompany> companyList = invCompanyMapper.selectInvCompanyList(null);
        Map<String, InvCompany> companyMap = new HashMap<>();
        for (InvCompany company : companyList) {
            companyMap.put(company.getCode(), company);
        }
        List<InvStock> stockList = invStockMapper.selectInvStockVoNoDelisting();//获取所有未退市股
        for (InvStock stock : stockList) {
            myAsyncTask.companyTask(stock, companyMap.get(stock.getCode()));
        }
        log.info("========CompanyJob任务线程分发完成=========");

    }


}

package com.muxi.quartz.async;

import com.alibaba.fastjson.JSONObject;
import com.muxi.common.utils.DateUtils;
import com.muxi.common.utils.JsonUtil;
import com.muxi.common.utils.NumFormatUtil;
import com.muxi.common.utils.http.HttpUtils;
import com.muxi.investment.domain.InvCompany;
import com.muxi.investment.domain.InvStock;
import com.muxi.investment.mapper.InvCompanyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Map;
import java.util.Set;


/**
 * @describe:@Async注解开启异步线程示例
 * @author: weny.yang
 * @date: 2021-08-22 13:53
 */
@Slf4j
@Component
public class MyAsyncTask {
    @Resource
    private Environment ev;
    @Resource
    private InvCompanyMapper invCompanyMapper;


    /**
     * @Title: 异步执行companyTask任务
     * @Description:
     * @author weny.yang
     * @date Sep 9, 2020
     */
    @Async("threadPoolTaskExecutor")
    public void companyTask(InvStock stock, InvCompany companies) {
        try{
            String url = ev.getProperty("muxi.company-detail") + stock.getMarket() + stock.getCode();
            String jsonStr = HttpUtils.sendGet(url, "", "UTF-8");
            if (null != jsonStr && !"".equals(jsonStr)) {
                JSONObject json = JsonUtil.parseObject(jsonStr);// 解析jsonStr
                JSONObject jbzl = json.getJSONObject("jbzl");//基本信息
                JSONObject fxxg = json.getJSONObject("fxxg");//发行相关
                Set<Map.Entry<String, Object>> jbzlEntries = jbzl.entrySet();
                Set<Map.Entry<String, Object>> fxxgEntries = fxxg.entrySet();

                //反射赋值
                InvCompany company = new InvCompany(stock.getCode());
                Class<? extends InvCompany> clazz = company.getClass();
                for (Map.Entry entry : jbzlEntries) {//基本信息
                    Field field = clazz.getDeclaredField((String) entry.getKey());
                    field.setAccessible(true);
                    String genericType = field.getGenericType().toString();
                    if(!"--".equals(entry.getValue().toString())){
                        if ("class java.lang.String".equals(genericType)) {
                            field.set(company, entry.getValue().toString());
                        } else if ("class java.lang.Integer".equals(genericType)) {
                            Integer value = NumFormatUtil.toInteger(entry.getValue().toString());
                            field.set(company, value);
                        } else if ("class java.lang.Double".equals(genericType)) {
                            Double value = NumFormatUtil.toDouble(entry.getValue().toString());
                            field.set(company, value);
                        } else if ("class java.util.Date".equals(genericType)) {
                            Date value = DateUtils.parseDate(entry.getValue().toString());
                            field.set(company, value);
                        }
                    }
                }
                for (Map.Entry entry : fxxgEntries) {//发行相关
                    Field field = clazz.getDeclaredField((String) entry.getKey());
                    field.setAccessible(true);
                    String genericType = field.getGenericType().toString();
                    if(!"--".equals(entry.getValue().toString())){
                        if ("class java.lang.String".equals(genericType)) {
                            field.set(company, entry.getValue().toString());
                        } else if ("class java.lang.Integer".equals(genericType)) {
                            Integer value = NumFormatUtil.toInteger(entry.getValue().toString());
                            field.set(company, value);
                        } else if ("class java.lang.Double".equals(genericType)) {
                            Double value = NumFormatUtil.toDouble(entry.getValue().toString());
                            field.set(company, value);
                        } else if ("class java.util.Date".equals(genericType)) {
                            Date value = DateUtils.parseDate(entry.getValue().toString());
                            field.set(company, value);
                        }
                    }
                }
                if(null==companies){//数据库没有，直接插入
                    invCompanyMapper.insertInvCompany(company);
                }else{
                    if(!companies.equals(company)){//数据库有，但是字段有变更，进行更新
                        invCompanyMapper.updateInvCompany(company);
                    }
                }
            }
        } catch (Exception e) {
            log.error(">>>company("+stock.getCode()+")数据初始化异常" + e);
            e.printStackTrace();
        }
    }

}

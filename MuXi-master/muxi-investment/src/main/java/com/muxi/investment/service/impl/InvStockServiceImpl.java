package com.muxi.investment.service.impl;

import java.util.List;

import com.muxi.investment.domain.InvStock;
import com.muxi.investment.mapper.InvStockMapper;
import com.muxi.investment.service.IInvStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muxi.common.core.text.Convert;

/**
 * 沪深A股Service业务层处理
 *
 * @author wenyong.yang
 * @date 2022-05-03
 */
@Service
public class InvStockServiceImpl implements IInvStockService {
    @Autowired
    private InvStockMapper invStockMapper;

    /**
     * 查询沪深A股
     *
     * @param code 沪深A股主键
     * @return 沪深A股
     */
    @Override
    public InvStock selectInvStockByCode(String code) {
        return invStockMapper.selectInvStockByCode(code);
    }

    /**
     * 查询沪深A股列表
     *
     * @param invStock 沪深A股
     * @return 沪深A股
     */
    @Override
    public List<InvStock> selectInvStockList(InvStock invStock) {
        return invStockMapper.selectInvStockList(invStock);
    }

    /**
     * 新增沪深A股
     *
     * @param invStock 沪深A股
     * @return 结果
     */
    @Override
    public int insertInvStock(InvStock invStock) {
        return invStockMapper.insertInvStock(invStock);
    }

    /**
     * 修改沪深A股
     *
     * @param invStock 沪深A股
     * @return 结果
     */
    @Override
    public int updateInvStock(InvStock invStock) {
        return invStockMapper.updateInvStock(invStock);
    }

    /**
     * 批量删除沪深A股
     *
     * @param codes 需要删除的沪深A股主键
     * @return 结果
     */
    @Override
    public int deleteInvStockByCodes(String codes) {
        return invStockMapper.deleteInvStockByCodes(Convert.toStrArray(codes));
    }

    /**
     * 删除沪深A股信息
     *
     * @param code 沪深A股主键
     * @return 结果
     */
    @Override
    public int deleteInvStockByCode(String code) {
        return invStockMapper.deleteInvStockByCode(code);
    }
}

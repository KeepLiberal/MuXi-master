package com.muxi.investment.service;

import java.util.List;

import com.muxi.investment.domain.InvStock;

/**
 * 沪深A股Service接口
 * 
 * @author wenyong.yang
 * @date 2022-05-03
 */
public interface IInvStockService 
{
    /**
     * 查询沪深A股
     * 
     * @param code 沪深A股主键
     * @return 沪深A股
     */
    public InvStock selectInvStockByCode(String code);

    /**
     * 查询沪深A股列表
     * 
     * @param invStock 沪深A股
     * @return 沪深A股集合
     */
    public List<InvStock> selectInvStockList(InvStock invStock);

    /**
     * 新增沪深A股
     * 
     * @param invStock 沪深A股
     * @return 结果
     */
    public int insertInvStock(InvStock invStock);

    /**
     * 修改沪深A股
     * 
     * @param invStock 沪深A股
     * @return 结果
     */
    public int updateInvStock(InvStock invStock);

    /**
     * 批量删除沪深A股
     * 
     * @param codes 需要删除的沪深A股主键集合
     * @return 结果
     */
    public int deleteInvStockByCodes(String codes);

    /**
     * 删除沪深A股信息
     * 
     * @param code 沪深A股主键
     * @return 结果
     */
    public int deleteInvStockByCode(String code);
}

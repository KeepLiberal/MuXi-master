package com.muxi.investment.mapper;

import java.util.List;

import com.muxi.investment.domain.InvStock;

/**
 * 沪深A股Mapper接口
 *
 * @author wenyong.yang
 * @date 2022-05-03
 */
public interface InvStockMapper {
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
     * 查询未退市沪深A股列表
     *
     * @return 沪深A股集合
     */
    public List<InvStock> selectInvStockVoNoDelisting();

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
     * 删除沪深A股
     *
     * @param code 沪深A股主键
     * @return 结果
     */
    public int deleteInvStockByCode(String code);

    /**
     * 批量删除沪深A股
     *
     * @param codes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInvStockByCodes(String[] codes);
}

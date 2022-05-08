package com.muxi.investment.mapper;

import java.util.List;

import com.muxi.investment.domain.InvCompany;

/**
 * 公司基本信息Mapper接口
 *
 * @author wenyong.yang
 * @date 2022-05-03
 */
public interface InvCompanyMapper {
    /**
     * 查询公司基本信息
     *
     * @param code 公司基本信息主键
     * @return 公司基本信息
     */
    public InvCompany selectInvCompanyByCode(String code);

    /**
     * 查询公司基本信息列表
     *
     * @param invCompany 公司基本信息
     * @return 公司基本信息集合
     */
    public List<InvCompany> selectInvCompanyList(InvCompany invCompany);

    /**
     * 新增公司基本信息
     *
     * @param invCompany 公司基本信息
     * @return 结果
     */
    public int insertInvCompany(InvCompany invCompany);

    /**
     * 修改公司基本信息
     *
     * @param invCompany 公司基本信息
     * @return 结果
     */
    public int updateInvCompany(InvCompany invCompany);

    /**
     * 删除公司基本信息
     *
     * @param code 公司基本信息主键
     * @return 结果
     */
    public int deleteInvCompanyByCode(String code);

    /**
     * 批量删除公司基本信息
     *
     * @param codes 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInvCompanyByCodes(String[] codes);
}

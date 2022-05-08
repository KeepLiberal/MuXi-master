package com.muxi.investment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.muxi.investment.mapper.InvCompanyMapper;
import com.muxi.investment.domain.InvCompany;
import com.muxi.investment.service.IInvCompanyService;
import com.muxi.common.core.text.Convert;

/**
 * 公司基本信息Service业务层处理
 *
 * @author wenyong.yang
 * @date 2022-05-03
 */
@Service
public class InvCompanyServiceImpl implements IInvCompanyService {
    @Autowired
    private InvCompanyMapper invCompanyMapper;

    /**
     * 查询公司基本信息
     *
     * @param code 公司基本信息主键
     * @return 公司基本信息
     */
    @Override
    public InvCompany selectInvCompanyByCode(String code) {
        return invCompanyMapper.selectInvCompanyByCode(code);
    }

    /**
     * 查询公司基本信息列表
     *
     * @param invCompany 公司基本信息
     * @return 公司基本信息
     */
    @Override
    public List<InvCompany> selectInvCompanyList(InvCompany invCompany) {
        return invCompanyMapper.selectInvCompanyList(invCompany);
    }

    /**
     * 新增公司基本信息
     *
     * @param invCompany 公司基本信息
     * @return 结果
     */
    @Override
    public int insertInvCompany(InvCompany invCompany) {
        return invCompanyMapper.insertInvCompany(invCompany);
    }

    /**
     * 修改公司基本信息
     *
     * @param invCompany 公司基本信息
     * @return 结果
     */
    @Override
    public int updateInvCompany(InvCompany invCompany) {
        return invCompanyMapper.updateInvCompany(invCompany);
    }

    /**
     * 批量删除公司基本信息
     *
     * @param codes 需要删除的公司基本信息主键
     * @return 结果
     */
    @Override
    public int deleteInvCompanyByCodes(String codes) {
        return invCompanyMapper.deleteInvCompanyByCodes(Convert.toStrArray(codes));
    }

    /**
     * 删除公司基本信息信息
     *
     * @param code 公司基本信息主键
     * @return 结果
     */
    @Override
    public int deleteInvCompanyByCode(String code) {
        return invCompanyMapper.deleteInvCompanyByCode(code);
    }
}

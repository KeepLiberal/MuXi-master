package com.muxi.web.controller.investment;

import java.util.List;

import com.muxi.investment.domain.InvCompany;
import com.muxi.investment.service.IInvCompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.muxi.common.annotation.Log;
import com.muxi.common.enums.BusinessType;
import com.muxi.common.core.controller.BaseController;
import com.muxi.common.core.domain.AjaxResult;
import com.muxi.common.utils.poi.ExcelUtil;
import com.muxi.common.core.page.TableDataInfo;

/**
 * 公司基本信息Controller
 *
 * @author wenyong.yang
 * @date 2022-05-03
 */
@Controller
@RequestMapping("/investment/company")
public class InvCompanyController extends BaseController {
    private String prefix = "investment/company";

    @Autowired
    private IInvCompanyService invCompanyService;

    @RequiresPermissions("investment:company:view")
    @GetMapping()
    public String company() {
        return prefix + "/company";
    }

    /**
     * 查询公司基本信息列表
     */
    @RequiresPermissions("investment:company:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(InvCompany invCompany) {
        startPage();
        List<InvCompany> list = invCompanyService.selectInvCompanyList(invCompany);
        return getDataTable(list);
    }

    /**
     * 导出公司基本信息列表
     */
    @RequiresPermissions("investment:company:export")
    @Log(title = "公司基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(InvCompany invCompany) {
        List<InvCompany> list = invCompanyService.selectInvCompanyList(invCompany);
        ExcelUtil<InvCompany> util = new ExcelUtil<InvCompany>(InvCompany.class);
        return util.exportExcel(list, "公司基本信息数据");
    }

    /**
     * 新增公司基本信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存公司基本信息
     */
    @RequiresPermissions("investment:company:add")
    @Log(title = "公司基本信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(InvCompany invCompany) {
        return toAjax(invCompanyService.insertInvCompany(invCompany));
    }

    /**
     * 修改公司基本信息
     */
    @RequiresPermissions("investment:company:edit")
    @GetMapping("/edit/{code}")
    public String edit(@PathVariable("code") String code, ModelMap mmap) {
        InvCompany invCompany = invCompanyService.selectInvCompanyByCode(code);
        mmap.put("invCompany", invCompany);
        return prefix + "/edit";
    }

    /**
     * 修改保存公司基本信息
     */
    @RequiresPermissions("investment:company:edit")
    @Log(title = "公司基本信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(InvCompany invCompany) {
        return toAjax(invCompanyService.updateInvCompany(invCompany));
    }

    /**
     * 删除公司基本信息
     */
    @RequiresPermissions("investment:company:remove")
    @Log(title = "公司基本信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(invCompanyService.deleteInvCompanyByCodes(ids));
    }
}

package com.muxi.web.controller.investment;

import java.util.List;

import com.muxi.investment.domain.InvStock;
import com.muxi.investment.service.IInvStockService;
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
 * 沪深A股Controller
 *
 * @author wenyong.yang
 * @date 2022-05-03
 */
@Controller
@RequestMapping("/investment/stock")
public class InvStockController extends BaseController
{
    private String prefix = "investment/stock";

    @Autowired
    private IInvStockService invStockService;

    @RequiresPermissions("investment:stock:view")
    @GetMapping()
    public String stock()
    {
        return prefix + "/stock";
    }

    /**
     * 查询沪深A股列表
     */
    @RequiresPermissions("investment:stock:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(InvStock invStock)
    {
        startPage();
        List<InvStock> list = invStockService.selectInvStockList(invStock);
        return getDataTable(list);
    }

    /**
     * 导出沪深A股列表
     */
    @RequiresPermissions("investment:stock:export")
    @Log(title = "沪深A股", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(InvStock invStock)
    {
        List<InvStock> list = invStockService.selectInvStockList(invStock);
        ExcelUtil<InvStock> util = new ExcelUtil<InvStock>(InvStock.class);
        return util.exportExcel(list, "沪深A股数据");
    }

    /**
     * 新增沪深A股
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存沪深A股
     */
    @RequiresPermissions("investment:stock:add")
    @Log(title = "沪深A股", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(InvStock invStock)
    {
        return toAjax(invStockService.insertInvStock(invStock));
    }

    /**
     * 修改沪深A股
     */
    @RequiresPermissions("investment:stock:edit")
    @GetMapping("/edit/{code}")
    public String edit(@PathVariable("code") String code, ModelMap mmap)
    {
        InvStock invStock = invStockService.selectInvStockByCode(code);
        mmap.put("invStock", invStock);
        return prefix + "/edit";
    }

    /**
     * 修改保存沪深A股
     */
    @RequiresPermissions("investment:stock:edit")
    @Log(title = "沪深A股", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(InvStock invStock)
    {
        return toAjax(invStockService.updateInvStock(invStock));
    }

    /**
     * 删除沪深A股
     */
    @RequiresPermissions("investment:stock:remove")
    @Log(title = "沪深A股", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(invStockService.deleteInvStockByCodes(ids));
    }
}

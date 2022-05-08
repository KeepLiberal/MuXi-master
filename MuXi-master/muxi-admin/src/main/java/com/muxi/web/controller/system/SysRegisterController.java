package com.muxi.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.muxi.common.core.controller.BaseController;
import com.muxi.common.core.domain.AjaxResult;
import com.muxi.common.core.domain.entity.SysUser;
import com.muxi.common.utils.StringUtils;
import com.muxi.framework.shiro.service.SysRegisterService;
import com.muxi.investment.service.ISysConfigService;

/**
 * 注册验证
 *
 * @author wenyong.yang
 */
@Controller
public class SysRegisterController extends BaseController {
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public AjaxResult ajaxRegister(SysUser user) {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser")))) {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}

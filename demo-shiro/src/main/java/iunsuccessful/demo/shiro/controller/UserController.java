package iunsuccessful.demo.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;

/**
 * Created by Anonymous on 2016-08-27.
 */
@Controller
public class UserController {

    @RequiresPermissions("user:create")
    public String list() {
        return "user/list";
    }

}

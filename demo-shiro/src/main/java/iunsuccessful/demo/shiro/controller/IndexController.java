package iunsuccessful.demo.shiro.controller;

import iunsuccessful.demo.shiro.comon.shiro.Anonymous;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequiresGuest 只有游客有权限访问，并且资源要设置 anon
 * @author LiQZ on 2016/8/12.
 */
@Controller
public class IndexController {

    @RequestMapping({"", "index"})
    public String index() {
        return "index";
    }

    @Anonymous
    @ResponseBody
    @RequestMapping("test")
    public String test() {
        return "test";
    }

}

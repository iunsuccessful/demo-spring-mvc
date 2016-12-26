package iunsuccessful.demo.shiro.controller.common;

import iunsuccessful.demo.shiro.domain.ApiResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录相关
 * Created by Anonymous on 2016-08-27.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ApiResponse success(@RequestParam("username") String username, @RequestParam("password") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception e) {
            return new ApiResponse(400, "登录失败");
        }
        return new ApiResponse(200, "登录成功");
    }

}

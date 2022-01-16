package com.zhysunny.controller;

import com.zhysunny.bean.CommonResult;
import com.zhysunny.pojo.User;
import com.zhysunny.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.UUID;

/**
 * @author zhysunny
 * @date 2020/12/20 19:39
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResult login(HttpServletRequest request, @RequestBody User user) {
        String username = user.getName();
        String password = user.getPassword();
        if (userService.match(username, password)) {
            log.info("[{}] login success", username);
            HttpSession session = request.getSession();
            if (session != null) {
                session.setAttribute("user", userService.info(username));
            }
            String token = username + "-" + UUID.randomUUID().toString().replace("-", "");
            return CommonResult.success(token);
        } else {
            log.info("[{}] login failed", username);
            return CommonResult.validateFailed();
        }
    }

    @GetMapping("/info/{token}")
    public CommonResult info(@PathVariable("token") String token) {
        return CommonResult.success(userService.info(getUserName(token)));
    }

    @PostMapping("/logout")
    public CommonResult logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.removeAttribute("user");
        }
        return CommonResult.success();
    }

    private String getUserName(String token) {
        return Optional.ofNullable(token).orElse("").split("-")[0];
    }

}

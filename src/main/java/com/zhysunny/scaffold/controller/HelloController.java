package com.zhysunny.scaffold.controller;

import com.zhysunny.scaffold.bean.CommonResult;
import com.zhysunny.scaffold.pojo.Hello;
import com.zhysunny.scaffold.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhysunny
 * @date 2020/12/12 11:38
 */
@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public CommonResult hello() {
        Hello hello = helloService.hello();
        String data = String.format("Hello %s! This port: %d", hello.getName(), hello.getPort());
        return CommonResult.success(data);
    }

}

package com.zhysunny.scaffold.service;

import com.zhysunny.scaffold.mapper.HelloMapper;
import com.zhysunny.scaffold.pojo.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhysunny
 * @date 2020/12/12 11:39
 */
@Service
public class HelloService {
    @Autowired
    private HelloMapper helloMapper;

    public Hello hello() {
        return helloMapper.hello();
    }
}

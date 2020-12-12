package com.zhysunny.scaffold;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * @author zhysunny
 * @date 2020/12/12 11:36
 */
@SpringBootApplication(scanBasePackages = { "com.zhysunny.scaffold.controller", "com.zhysunny.scaffold.service" })
@MapperScan(basePackages = { "com.zhysunny.scaffold.mapper" })
public class ScaffoldMain {
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(ScaffoldMain.class, args);
    }
}

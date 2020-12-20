package com.zhysunny.scaffold;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zhysunny
 * @date 2020/12/12 11:36
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.zhysunny.scaffold.mapper"})
@ImportResource("spring/*.xml")
public class ScaffoldMain {
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(ScaffoldMain.class, args);
    }
}

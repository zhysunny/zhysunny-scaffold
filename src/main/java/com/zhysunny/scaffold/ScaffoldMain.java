package com.zhysunny.scaffold;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhysunny
 * @date 2020/12/12 11:36
 */
@SpringBootApplication
@ImportResource("spring/*.xml")
@ServletComponentScan
@EnableTransactionManagement
@MapperScan(basePackages = {"com.zhysunny.scaffold.mapper"})
public class ScaffoldMain {
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(ScaffoldMain.class, args);
    }
}

package com.xinyonghang.supplychain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 该注解指定项目为springboot，程序入口
 * 发布到外部tomcat改用下面的 注释的程序
 *
 * @author chengjiawei 2018年3月29日下午3:39:33
 */
@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}


//@SpringBootApplication
//public class SpringBootWebApplication extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        // 注意这里要指向原先用main方法执行的Application启动类
//        return builder.sources(SpringBootWebApplication.class);
//    }
//}
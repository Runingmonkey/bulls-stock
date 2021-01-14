package com.itcast.bulls.cat.demo.account.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: </p>
 * @date  
 * @author   
 * @version 1.0
 * @name   
 * <p>Copyright:Copyright(c)2020</p>
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.itcast"})
@RestController
public class CatDemoAccountApplication {

    /**
     * 提供账户服务接口
     * @return
     * @throws Exception
     */
    @RequestMapping("/account")
    public String account() throws Exception {
        Thread.sleep(150);
        return "account success";
    }


    public static void main(String[] args) {
        SpringApplication.run(CatDemoAccountApplication.class, args);
    }
}

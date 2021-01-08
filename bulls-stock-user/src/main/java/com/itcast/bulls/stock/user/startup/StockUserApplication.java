package com.itcast.bulls.stock.user.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: mike ling
 * @date: 2021/1/8 16:08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StockUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockUserApplication.class, args);
    }

}

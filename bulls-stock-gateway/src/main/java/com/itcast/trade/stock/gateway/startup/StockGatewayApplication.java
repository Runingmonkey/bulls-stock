package com.itcast.trade.stock.gateway.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: mike ling
 * @date: 2021/1/8 15:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StockGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockGatewayApplication.class, args);
    }

}

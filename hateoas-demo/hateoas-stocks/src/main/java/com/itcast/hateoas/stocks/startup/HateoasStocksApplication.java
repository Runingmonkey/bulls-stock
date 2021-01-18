package com.itcast.hateoas.stocks.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author mike ling
 * @description
 * @date 2021/1/18 17:06
 */
@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = "com.itcast")
@EnableJpaRepositories(basePackages = "com.itcast")
@EntityScan(basePackages = "com.itcast")
public class HateoasStocksApplication {
    public static void main(String[] args) {
        SpringApplication.run(HateoasStocksApplication.class, args);
    }
}

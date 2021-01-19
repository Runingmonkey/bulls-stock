package com.itcast.hateoas.order.startup;

import com.itcast.hateoas.order.entity.OrderEntity;
import com.itcast.hateoas.order.entity.StocksEntity;
import com.itcast.hateoas.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author mike ling
 * @description
 * @date 2021/1/18 17:04
 */
@Component
@Slf4j
public class RemoteRunner implements ApplicationRunner {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderRepository orderRepository;

    private static final URI ROOT_URL = URI.create("http://localhost:8080/");

    /** 业务场景就是, 同花顺登录之后第一页就是自己的自选股
     * Callback used to run the bean.
     *  继承ApplicationRunner, 系统启动成功后就会执行run
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Link stocksLink = getLink(ROOT_URL, "stocksEntity");
        // 1. 查询股票信息
        queryStocks(stocksLink);
        // 2. 更新股票信息
        Link updateLink = getLink(ROOT_URL.resolve("stocks/1"), "stocksEntity");
        updateStocks(updateLink);
        // 3: 重新查询打印股票信息
        queryStocks(stocksLink);

        // 4: 生成订单信息
        OrderEntity order = OrderEntity.builder()
                .user("mirson")
                .stockName("建设银行")
                .volume(1000)
                .price(99.9)
                .build();
        orderRepository.save(order);

    }

    /**
     *  获取请求链接
     * @param uri
     * @param rel
     * @return {@link Link}
     */
    public Link getLink(URI uri, String rel) {
        ResponseEntity<Resource<Link>> rootResp =
                restTemplate
                        .exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<Resource<Link>>() {});
        Link link = rootResp.getBody().getLink(rel);
        log.info("Link:{}" + link);
        return link;
    }

    /**
     *  查询股票信息, 打印
     * @param stocksLink
     */
    public void queryStocks(Link stocksLink) {
        // 响应体, 分页
        ResponseEntity<PagedResources<Resource<StocksEntity>>> stocksResp = restTemplate.exchange(stocksLink.getTemplate().expand(), HttpMethod.GET, null,
                new ParameterizedTypeReference<PagedResources<Resource<StocksEntity>>>() {
                });
        if (null != stocksResp.getBody() && null != stocksResp.getBody().getContent()) {
            StringBuffer strs = new StringBuffer();
            stocksResp.getBody().getContent().forEach((s) -> {
                strs.append(s.getContent().getName()).append(":")
                        .append(s.getContent().getPrice()).append(",");
            });
            strs.toString().replaceAll(",$", "");
            log.info("query stocks ==>" + strs);
        } else {
            log.info("query stocks ==> empty");
        }
    }

    /**
     * 更新股票信息
     * @param link
     * @return
     */
    private Resource<StocksEntity> updateStocks(Link link) {

        StocksEntity americano = StocksEntity.builder()
                .name("中国平安")
                .price(68.9)
                .build();
        RequestEntity<StocksEntity> req =
                RequestEntity.put(link.getTemplate().expand()).body(americano);
        ResponseEntity<Resource<StocksEntity>> resp =
                restTemplate.exchange(req,
                        new ParameterizedTypeReference<Resource<StocksEntity>>() {});
        log.info("add Stocks ==> {}", resp);
        return resp.getBody();
    }


}

package com.itcast.hateoas.stocks.repository;

import com.itcast.hateoas.stocks.entity.StocksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author mike ling
 * @description JPA操作数据库, 已规定方式命名方法即可, 不用写sql
 * @date 2021/1/18 17:06
 */
@RepositoryRestResource(path = "/stocks")
public interface StockRespository extends JpaRepository<StocksEntity, Long> {

    // 根据名称集合查询多个股票信息
    List<StocksEntity> findByNameInOrderById(@Param("list") List<String> list);

    // 根据名称查询股票
    StocksEntity findByName(@Param("name") String name);

}

package com.itcast.hateoas.order.repository;

import com.itcast.hateoas.order.entity.OrderEntity;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author mike ling
 * @description
 * @date 2021/1/18 17:04
 */
@RepositoryRestResource(path = "/order")
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    List<OrderEntity> findByUser(@Param("user") String user);

}

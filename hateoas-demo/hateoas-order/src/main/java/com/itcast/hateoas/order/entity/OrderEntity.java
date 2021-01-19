package com.itcast.hateoas.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "T_ORDER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity {
    private String user;
    private String stockName;
    private Integer volume;
    private Double price;
    private Date createTime;
    private Date updateTime;
}

package com.itcast.hateoas.stocks.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author mike ling
 * @description
 * @date 2021/1/19 11:57
 */
@Data
@Builder
@Entity
@Table(name = "T_STOCKS")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StocksEntity extends BaseEntity {
    private String name;
    private Double price;
}

package com.itcast.hateoas.order.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>Description: </p>
 * @date 2019/7/9
 * @author 贺锟 
 * @version 1.0
 * <p>Copyright:Copyright(c)2019</p>
 */
@Entity
@Table(name = "T_STOCKS")
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StocksEntity extends BaseEntity {
    private String name;
    private Double price;
}

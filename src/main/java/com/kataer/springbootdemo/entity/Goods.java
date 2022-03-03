package com.kataer.springbootdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品数据对象
 */
@Data
public class Goods implements Serializable {
    /**
     * 商品id
     */
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private String price;
    /**
     * 商品图片
     */
    private String pic;

    /**
     * 商品库存
     */
    private Integer num;

}
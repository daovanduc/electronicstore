package com.daovanduc.shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = ProductModel.PRODUCT)
@Table(name = ProductModel.PRODUCT)
public class ProductModel {
    protected static final String PRODUCT = "product";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private int catalogID;
    private String name;
    private double price;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
}

package com.daovanduc.shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = ProductModel.PRODUCT)
@Table(name = ProductModel.PRODUCT)
public class ProductModel {
    protected static final String PRODUCT = "product";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    @Nullable
    private int catalogID;
    private String name;
    private double price;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;
}

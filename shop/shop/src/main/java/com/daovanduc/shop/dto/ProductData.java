package com.daovanduc.shop.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductData {
    private Integer id;
    private String name;
    private String code;
    private double price;
    private byte[] image;

    private boolean newProduct = false;

    public ProductData() {
        this.newProduct = true;
    }
}

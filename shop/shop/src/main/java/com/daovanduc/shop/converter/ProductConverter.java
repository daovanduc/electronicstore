package com.daovanduc.shop.converter;

import com.daovanduc.shop.dto.ProductData;
import com.daovanduc.shop.model.ProductModel;

public class ProductConverter implements Converter<ProductModel, ProductData> {

    @Override
    public ProductData convert(ProductModel var1) {
        return new ProductData().setImage(var1.getImage())
                .setName(var1.getName())
                .setPrice(var1.getPrice())
                .setImage(var1.getImage())
                .setId(var1.getId());
    }

    @Override
    public ProductModel convertDataToModel(ProductData var3) {
        ProductModel productModel = new ProductModel();
        productModel.setName(var3.getName());
        productModel.setPrice(var3.getPrice());
        productModel.setImage(var3.getImage());
        productModel.setCatalogID(2);
        productModel.setCode(var3.getCode());
        return productModel;

    }

    @Override
    public ProductData convert(ProductModel var1, ProductData var2) {
        return var2.setId(var1.getId())
                .setName(var1.getName())
                .setPrice(var1.getPrice())
                .setImage(var1.getImage());
    }
}

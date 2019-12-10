package com.daovanduc.shop.service;

import com.daovanduc.shop.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<ProductModel> getProductById(Integer id);

    List<ProductModel> getAllProducts();

    void saveProduct(ProductModel productModel);
}

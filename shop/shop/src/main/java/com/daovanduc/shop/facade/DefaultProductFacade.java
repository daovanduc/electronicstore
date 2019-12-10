package com.daovanduc.shop.facade;

import com.daovanduc.shop.converter.ProductConverter;
import com.daovanduc.shop.dto.ProductData;
import com.daovanduc.shop.model.ProductModel;
import com.daovanduc.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Required;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DefaultProductFacade implements ProductFacade {
    private ProductService productService;
    private ProductConverter productConverter;

    @Override
    public ProductData getProduct(Integer id) {
        Optional<ProductModel> productModel = productService.getProductById(id);
        Objects.requireNonNull(productModel);
        return productModel.map(model -> productConverter.convert(model)).orElse(null);
    }

    @Override
    public List<ProductData> getAllProducts() {
        List<ProductModel> productsList = productService.getAllProducts();
        return productConverter.convertAll(productsList);
    }

    @Override
    public void saveProduct(ProductData productData) {
        ProductModel productModel = productConverter.convertDataToModel(productData);
        productService.saveProduct(productModel);
    }

    protected ProductService getProductService() {
        return productService;
    }

    @Required
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    protected ProductConverter getProductConverter() {
        return productConverter;
    }

    @Required
    public void setProductConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }
}

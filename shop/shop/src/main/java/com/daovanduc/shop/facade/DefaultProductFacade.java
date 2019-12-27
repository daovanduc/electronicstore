package com.daovanduc.shop.facade;

import com.daovanduc.shop.converter.ProductConverter;
import com.daovanduc.shop.dto.ProductData;
import com.daovanduc.shop.model.ProductModel;
import com.daovanduc.shop.service.ProductService;
import com.daovanduc.shop.util.PageResult;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DefaultProductFacade implements ProductFacade {
    private ProductService productService;
    private ProductConverter productConverter;

    private int totalPage;

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

    @Override
    public Page<ProductData> findPaginated(int page, int size) {

        Page<ProductModel> resultPages = productService.getPagedProducts(page, size);
        totalPage = resultPages.getTotalPages();
        if (page > resultPages.getTotalPages()) {
            throw new RuntimeException();
        }
        return new PageImpl<>(productConverter.convertAll(resultPages.getContent()), PageRequest.of(page, size), resultPages.getSize());
    }

    public int getTotalPage() {
        return totalPage;
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

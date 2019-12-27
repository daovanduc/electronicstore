package com.daovanduc.shop.service;

import com.daovanduc.shop.model.ProductModel;
import com.daovanduc.shop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Transactional
public class DefaultProductService implements ProductService {

    @Resource
    private ProductRepository productRepository;

    @Override
    @Transactional
    public Optional<ProductModel> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void saveProduct(ProductModel productModel) {
        productRepository.save(productModel);
    }

    @Override
    public Page<ProductModel> getPagedProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }
}

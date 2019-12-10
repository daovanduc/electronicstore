package com.daovanduc.shop.service;

import com.daovanduc.shop.model.ProductModel;
import com.daovanduc.shop.repository.ProductDao;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Transactional
public class DefaultProductService implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    @Transactional
    public Optional<ProductModel> getProductById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    @Transactional
    public List<ProductModel> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    @Transactional
    public void saveProduct(ProductModel productModel) {
        productDao.save(productModel);
    }
}

package com.daovanduc.shop.repository;

import com.daovanduc.shop.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<ProductModel, Integer> {
}

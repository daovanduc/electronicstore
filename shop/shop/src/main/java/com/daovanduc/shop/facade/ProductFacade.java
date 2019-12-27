package com.daovanduc.shop.facade;

import com.daovanduc.shop.dto.ProductData;
import com.daovanduc.shop.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ProductFacade {
    ProductData getProduct(Integer id);

    List<ProductData> getAllProducts();

    void saveProduct(ProductData productData) throws IOException, SQLException;

    Page<ProductData> findPaginated(int page, int size);

    int getTotalPage();
}

package com.sda.dao;

import com.sda.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    List<ProductEntity> getProducts();
    Optional<ProductEntity> getProduct(Long id);
}

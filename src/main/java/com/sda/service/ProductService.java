package com.sda.service;

import com.sda.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product getProduct(Long id);

}

package com.sda.service;

import com.sda.dao.ProductDao;
import com.sda.dao.ProductDaoImpl;
import com.sda.dao.ProductImageDao;
import com.sda.dao.ProductImageDaoImpl;
import com.sda.entity.ProductEntity;
import com.sda.model.Product;

import java.util.List;
import java.util.stream.Collectors;

import static com.sda.mapper.ProductMapper.mapToProduct;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao = new ProductDaoImpl();
    private final ProductImageDao productImageDao = new ProductImageDaoImpl();

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts().stream()
                .map(p -> mapToProduct(p, productImageDao.getImagePathForProduct(p.getId())))
                .collect(Collectors.toList());
    }

    @Override
    public Product getProduct(Long id) {
        ProductEntity product = productDao.getProduct(id).orElse(null);
        String imagePathForProduct = productImageDao.getImagePathForProduct(id);
        return mapToProduct(product, imagePathForProduct);

    }


}

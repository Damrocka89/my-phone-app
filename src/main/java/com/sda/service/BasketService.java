package com.sda.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BasketService {

    void addProduct(String id, HttpServletRequest req);
    void deleteProduct(Long id,HttpServletRequest req);
    void cleanBasket(HttpServletRequest req);
    List<Long> getProductsIds(HttpServletRequest req);

}

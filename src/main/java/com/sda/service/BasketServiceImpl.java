package com.sda.service;

import com.sda.model.Product;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasketServiceImpl implements BasketService {

    private final ProductService productService = new ProductServiceImpl();

    private static void accept(Cookie c) {
        c.setMaxAge(0);
    }

    @Override
    public void addProduct(String id, HttpServletRequest req) {
        List<Long> basket = (List<Long>) req.getSession().getAttribute("basket");
        if (basket == null) {
            basket = new ArrayList<>();
            req.getSession().setAttribute("basket", basket);
        }
        basket.add(Long.valueOf(id));
    }

    @Override
    public void deleteProduct(Long id, HttpServletRequest req) {
       List<Long> basket=(List<Long>) req.getSession().getAttribute("basket");
       if (basket!=null){
           basket.remove(id);
       }
    }

    @Override
    public void cleanBasket(HttpServletRequest req) {
        ((List<Long>) req.getSession().getAttribute("basket")).clear();
    }

    @Override
    public List<Long> getProductsIds(HttpServletRequest req) {
        return (List<Long>) req.getSession().getAttribute("basket");
    }
}

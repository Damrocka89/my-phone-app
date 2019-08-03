package com.sda.controller;

import com.sda.model.Product;
import com.sda.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/toBasket")
public class GoToBasketController extends HttpServlet {

    private final BasketService basketService = new BasketServiceImpl();

    private final ProductService productService = new ProductServiceImpl();

    private final BillService billService = new BillServiceImpl();
    private final AuthenticationService authenticationService = new AuthenticationServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        if (basketService.getProductsIds(req) != null) {
            products.addAll(basketService.getProductsIds(req).stream()
                    .map(productService::getProduct)
                    .collect(Collectors.toList()));
        }
        req.setAttribute("products", products);
        req.setAttribute("toPay", billService.getFinalBill(products));
        req.setAttribute("isLogin", authenticationService.isAuthenticated(req));
        req.getRequestDispatcher("/WEB-INF/view/basket.jsp").forward(req, resp);
    }
}

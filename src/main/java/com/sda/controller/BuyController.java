package com.sda.controller;

import com.sda.service.BasketService;
import com.sda.service.BasketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buyNow")
public class BuyController extends HttpServlet {

    private final BasketService basketService = new BasketServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        basketService.addProduct(id, req);
        resp.sendRedirect("/toBasket");
    }
}

package com.sda.controller;

import com.sda.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pay-and-buy")
public class PayAndBuyController extends HttpServlet {
    private BasketService basketService = new BasketServiceImpl();
    private ProductService productService=new ProductServiceImpl();
    private OrderService orderService=new OrderServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Long> boughtProducts = basketService.getProductsIds(req);
        String login=(String) req.getSession().getAttribute("login");
        orderService.order(login, boughtProducts);
        basketService.cleanBasket(req);
        req.getRequestDispatcher("/WEB-INF/view/summary.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/produkty");
    }
}

package com.sda.controller;

import com.sda.model.Brand;
import com.sda.service.ProductService;
import com.sda.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/produkty")
public class ShowProductsController extends HttpServlet {

    private final ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> filteredBrands = getBrands(req);
        req.setAttribute("checkedBrands", filteredBrands);
        req.setAttribute("brands", Brand.values());
        if (filteredBrands.isEmpty()) {
            req.setAttribute("products", productService.getProducts());
        } else {
            req.setAttribute("products", productService.getProductsByBrand(filteredBrands));
        }
        req.getRequestDispatcher("/WEB-INF/view/products.jsp").forward(req, resp);
    }

    private List<Brand> getBrands(HttpServletRequest req) {
        String[] brands = req.getParameterMap().get("marka");
        return brands == null ? new ArrayList<>() : Arrays.asList(brands).stream().map(b -> Brand.valueOf(b)).collect(Collectors.toList());
    }
}

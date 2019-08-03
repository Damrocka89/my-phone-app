package com.sda.controller;

import com.sda.service.AuthenticationService;
import com.sda.service.AuthenticationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authentication")
public class AuthenticationController extends HttpServlet {

    private final AuthenticationService authenticationService = new AuthenticationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean authenticated = authenticationService.authenticate(req);

        if (authenticated) {
            String login = req.getParameter("login");
            req.getSession().setAttribute("login", login);
            resp.sendRedirect("/toBasket");
        } else {
            req.setAttribute("invalidCredentials", true);
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        }

    }
}

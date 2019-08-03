package com.sda.service;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {
    boolean isAuthenticated(HttpServletRequest req);

    boolean authenticate(HttpServletRequest req);

    void logout(HttpServletRequest req);
}

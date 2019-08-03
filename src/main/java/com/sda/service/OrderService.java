package com.sda.service;

import java.util.List;

public interface OrderService {
    void order(String login, List<Long> boughtProducts);
}

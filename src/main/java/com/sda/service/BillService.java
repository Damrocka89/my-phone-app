package com.sda.service;

import com.sda.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface BillService {
    BigDecimal getFinalBill(List<Product> products);
}

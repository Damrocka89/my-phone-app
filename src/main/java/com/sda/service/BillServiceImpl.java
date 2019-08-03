package com.sda.service;

import com.sda.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class BillServiceImpl implements BillService {
    @Override
    public BigDecimal getFinalBill(List<Product> products) {
        return products.stream()
                .map(p->p.getPrice())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}

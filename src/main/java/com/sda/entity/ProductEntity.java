package com.sda.entity;

import com.sda.model.Brand;
import com.sda.model.OperatingSystem;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductEntity {

    private Long id;

    private Brand brand;

    private String model;

    private BigDecimal purchasePrice;

    private BigDecimal sellingPrice;

    private OperatingSystem operatingSystem;

    private int primaryCameraMp;

    private int secondaryCameraMp;

}

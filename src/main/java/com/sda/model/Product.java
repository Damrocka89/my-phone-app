package com.sda.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Product {

    private Long id;

    private Brand brand;

    private String model;

    private BigDecimal price;

    private OperatingSystem operatingSystem;

    private int primaryCameraMp;

    private int secondaryCameraMp;

    private String imagePath;


}

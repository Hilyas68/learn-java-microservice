package com.hcodeStudio.microservice.currencyconversionservice.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyConversionBean {
    private Long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculatedAmount;
    private int port;

    public CurrencyConversionBean() {
    }

    public CurrencyConversionBean(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple, BigDecimal totalCalculatedAmount, int port) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.conversionMultiple = conversionMultiple;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.port = port;
    }
}

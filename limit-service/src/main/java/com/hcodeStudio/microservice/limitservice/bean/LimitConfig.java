package com.hcodeStudio.microservice.limitservice.bean;

import lombok.Data;

@Data
public class LimitConfig {
    int maximum;
    int minimum;

    public LimitConfig(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }
}

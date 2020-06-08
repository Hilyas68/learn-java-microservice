package com.hcodeStudio.microservice.limitservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("limit-service")
public class Configuration {
    private int minimum;
    private int maximum;

}

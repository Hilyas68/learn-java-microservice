package com.hcodeStudio.microservice.limitservice;

import com.hcodeStudio.microservice.limitservice.bean.LimitConfig;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfig retreiveLimitfromConfig() {
        return new LimitConfig(configuration.getMaximum(), configuration.getMinimum());
    }

    @GetMapping("/faullt-tolorance")
    @HystrixCommand(fallbackMethod = "fallbackGetConfig")
    public LimitConfig getConfig() {
        throw new RuntimeException("No available");
    }

    public LimitConfig fallbackGetConfig() {
        return new LimitConfig(999, 9);
    }
}

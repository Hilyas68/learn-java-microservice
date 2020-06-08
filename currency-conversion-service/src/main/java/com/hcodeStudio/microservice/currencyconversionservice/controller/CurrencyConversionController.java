package com.hcodeStudio.microservice.currencyconversionservice.controller;

import com.hcodeStudio.microservice.currencyconversionservice.bean.CurrencyConversionBean;
import com.hcodeStudio.microservice.currencyconversionservice.service.CurrencyExchangeProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CurrencyExchangeProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity){

        Map<String, String> params = new HashMap<>();
        params.put("from", from);
        params.put("to", to);

        CurrencyConversionBean response = new RestTemplate()
                .getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,params)
                .getBody();

        BigDecimal calculatedAmount = quantity.multiply(response.getConversionMultiple());
        return new CurrencyConversionBean(response.getId(), from, to,quantity,
                response.getConversionMultiple(),calculatedAmount,
                response.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity){

        CurrencyConversionBean response = proxy.getExchangeValue(from,to);

        logger.info("{}", response);

        BigDecimal calculatedAmount = quantity.multiply(response.getConversionMultiple());

        return new CurrencyConversionBean(response.getId(), from, to,quantity,
                response.getConversionMultiple(),calculatedAmount,
                response.getPort());
    }
}

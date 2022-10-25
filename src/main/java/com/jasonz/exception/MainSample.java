package com.jasonz.exception;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

@Slf4j
public class MainSample {

    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try {
            int c = a / b;
        } catch (Exception exp) {
            log.error(exp.getMessage(), exp);
            exp.printStackTrace();
        }
    }

    public Double getSurcharge(Double transaction) {
        log.info("Surcharge Caliculation begins");
        log.debug("Surcharge amount " + transaction);
        if (Double.isNaN(transaction)) {
            log.error(transaction + " is not a valid amount");
            throw new RuntimeException("Invalid Transaction");
        }
        return Math.PI;
    }


}

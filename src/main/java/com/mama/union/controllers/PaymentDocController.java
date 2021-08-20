package com.mama.union.controllers;

import com.mama.union.service.implementation.PaymentDocService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class  PaymentDocController{

    private final PaymentDocService paymentDocService;

    public PaymentDocController(PaymentDocService paymentDocService) {
        this.paymentDocService = paymentDocService;
    }

    public <T> List<T> all() {
        return null;
    }

    public PaymentDocController byId(Long id) {
        return null;
    }

    public PaymentDocController create(PaymentDocController item) {
        return null;
    }

    public PaymentDocController update(Long id, PaymentDocController item) {
        return null;
    }

    public PaymentDocController delete(Long id) {
        return null;
    }
}

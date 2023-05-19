package com.tpe.controller;

import com.tpe.dto.PaymentDto;
import com.tpe.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    //define createPayment method here
    @PostMapping("/create")
    public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.createPayment(paymentDto);
    }

    //define updatePayment method here
    @PutMapping("/update/{id}")
    public ResponseEntity<PaymentDto> updatePayment(@PathVariable Long id,@RequestBody PaymentDto paymentDto) {
        return paymentService.updatePayment(id,paymentDto);
    }

    //define deletePayment method here
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PaymentDto> deletePayment(@PathVariable Long id) {
        return paymentService.deletePayment(id);
    }

    //define getPaymentById method here
    @GetMapping("/get/{id}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    //define getAllPayments method here
    @GetMapping("/getAll")
    public ResponseEntity<List<PaymentDto>> getAllPayments() {
        return paymentService.getAllPayments();
    }
}

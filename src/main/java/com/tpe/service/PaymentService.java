package com.tpe.service;

import com.tpe.dto.LeaseDto;
import com.tpe.dto.PaymentDto;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.model.Lease;
import com.tpe.model.Payment;
import com.tpe.repository.LeaseRepository;
import com.tpe.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private LeaseRepository leaseRepository;
    @Autowired
    ModelMapper modelMapper;

    public ResponseEntity<PaymentDto> createPayment(PaymentDto paymentDto) {

        Lease lease = leaseRepository.findById(paymentDto.getLeaseId())
                .orElseThrow(()-> new ResourceNotFoundException("Lease not found"));

        Payment payment = Payment.builder()
                .isRentPaid(paymentDto.getIsRentPaid())
                .paymentDate(paymentDto.getPaymentDate())
                .electricityBill(paymentDto.getElectricityBill())
                .waterBill(paymentDto.getWaterBill())
                .heatingBill(paymentDto.getHeatingBill())
                .isWaterPaid(paymentDto.getIsWaterPaid())
                .isElectricityPaid(paymentDto.getIsElectricityPaid())
                .isHeatingPaid(paymentDto.getIsHeatingPaid())
                .lease(lease)
                .build();

        paymentRepository.save(payment);

        return new ResponseEntity<>(modelMapper.map(payment, PaymentDto.class), HttpStatus.CREATED);
    }

    public ResponseEntity<PaymentDto> updatePayment(Long id, PaymentDto paymentDto) {
        Payment payment = paymentRepository.findById(id).orElse(null);

        Lease lease = leaseRepository.findById(paymentDto.getLeaseId())
                .orElseThrow(()-> new ResourceNotFoundException("Lease not found"));

        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        payment.setIsRentPaid(paymentDto.getIsRentPaid() == null ? payment.getIsRentPaid() : paymentDto.getIsRentPaid());
        payment.setPaymentDate(paymentDto.getPaymentDate() == null ? payment.getPaymentDate() : paymentDto.getPaymentDate());
        payment.setElectricityBill(paymentDto.getElectricityBill() == null ? payment.getElectricityBill() : paymentDto.getElectricityBill());
        payment.setWaterBill(paymentDto.getWaterBill() == null ? payment.getWaterBill() : paymentDto.getWaterBill());
        payment.setHeatingBill(paymentDto.getHeatingBill() == null ? payment.getHeatingBill() : paymentDto.getHeatingBill());
        payment.setIsWaterPaid(paymentDto.getIsWaterPaid() == null ? payment.getIsWaterPaid() : paymentDto.getIsWaterPaid());
        payment.setIsElectricityPaid(paymentDto.getIsElectricityPaid() == null ? payment.getIsElectricityPaid() : paymentDto.getIsElectricityPaid());
        payment.setIsHeatingPaid(paymentDto.getIsHeatingPaid() == null ? payment.getIsHeatingPaid() : paymentDto.getIsHeatingPaid());
        payment.setLease(lease);

        paymentRepository.save(payment);

        return new ResponseEntity<>(modelMapper.map(payment, PaymentDto.class), HttpStatus.OK);
    }

    public ResponseEntity<PaymentDto> deletePayment(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paymentRepository.delete(payment);
        return new ResponseEntity<>(modelMapper.map(payment, PaymentDto.class), HttpStatus.OK);
    }

    public ResponseEntity<PaymentDto> getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(modelMapper.map(payment, PaymentDto.class), HttpStatus.OK);
    }

    public ResponseEntity<List<PaymentDto>> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return new ResponseEntity<>(modelMapper.map(payments, List.class), HttpStatus.OK);
    }
}

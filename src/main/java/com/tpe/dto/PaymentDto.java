package com.tpe.dto;

import com.tpe.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private Long paymentId;
    private PaymentStatus isRentPaid;
    private LocalDateTime paymentDate;
    private Integer electricityBill;
    private Integer waterBill;
    private Integer heatingBill;
    private PaymentStatus isElectricityPaid;
    private PaymentStatus isWaterPaid;
    private PaymentStatus isHeatingPaid;
    private Long leaseId;
}

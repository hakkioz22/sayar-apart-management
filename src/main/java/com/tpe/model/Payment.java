package com.tpe.model;

import com.tpe.enums.PaymentStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "paymentList")
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private PaymentStatus isRentPaid;
    private LocalDateTime paymentDate;
    private Integer electricityBill;
    private Integer waterBill;
    private Integer heatingBill;
    private PaymentStatus isElectricityPaid;
    private PaymentStatus isWaterPaid;
    private PaymentStatus isHeatingPaid;
    @OneToOne(mappedBy = "paymentId")
    private Lease lease;
}

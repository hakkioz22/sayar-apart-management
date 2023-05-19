package com.tpe.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "leaseList")
public class Lease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaseId;
    private String apartName;
    private Double rentPrice;
    private LocalDateTime leaseStartDate;
    private LocalDateTime leaseEndDate;
    private String leaserName;
    private String leaserLastName;
    private String leaserPhone;
    @Column(unique = true)
    private String socialSecurityNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentId", referencedColumnName = "paymentId")
    private Payment payment;
}

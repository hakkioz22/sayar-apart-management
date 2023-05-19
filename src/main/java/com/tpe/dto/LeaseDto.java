package com.tpe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaseDto {

    private Long leaseId;
    private String apartName;
    private Double rentPrice;
    private LocalDateTime leaseStartDate;
    private LocalDateTime leaseEndDate;
    private String leaserName;
    private String leaserLastName;
    private String leaserPhone;
    private String socialSecurityNumber;
    private Long paymentId;
}

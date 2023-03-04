package com.tpe.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Apart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please provide Apart's name")
    @Column(length = 100,nullable = false,unique = true)
    private String name;

    @NotBlank(message = "Please provide Apart's rent price")
    @Column
    private double rentPrice;

    @NotBlank(message = "Please provide Tenant Name")
    @Column
    private String tenantName;

    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$", message = "Please provide valid phone number")
    @Column(length = 14)
    private String phoneNumber;

    @NotBlank(message = "Did tenant pay his/her payments? True or False")
    private Boolean isPaid;
}

package com.tpe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
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

    @NotBlank(message = "Did tenant pay his/her payments? True or False")
    private Boolean isPaid;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate rentDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "tenant_fullName")
    private Tenant tenant;
}

package com.tpe.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please provide a name")
    @Column(length = 50)
    private String fullName;

    @NotBlank(message = "Please provide a SSN")
    @Column
    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$")
    private String SSN;

    @Pattern(regexp = "/^(0)([2348]{1})([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$/", message = "Please provide valid phone number")
    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "tenant",cascade = CascadeType.ALL)
    private List<Apart> apartList;
}

package com.companyname.peopledbweb.biz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "cannot be empty")
    private String firstName;

    @NotEmpty(message = "cannot be empty")
    private String lastName;

    @Past
    @NotEmpty(message = "cannot be empty")
    private LocalDate dob;

    @Email
    @NotEmpty(message = "cannot be empty")
    private String email;

    @NotEmpty(message = "cannot be empty")
    private BigDecimal salary;
}







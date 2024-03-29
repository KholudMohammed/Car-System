package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "full_name can not null")
    @Size(min = 4,message = "full_name length more than 4")
    @Column(columnDefinition = "varchar(40) not null unique")
    private String fullName;

    @NotEmpty(message = "email can not null")
    @Email(message = "email must be valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;

    @NotEmpty(message = "password can not null")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;

    @NotEmpty(message = "phone_number can not null")
    @Column(columnDefinition = "varchar(10) not null")
    private String phoneNumber;

    @NotEmpty(message = "address_number can not null")
    @Column(columnDefinition = "varchar(225) not null")
    private String address;





}





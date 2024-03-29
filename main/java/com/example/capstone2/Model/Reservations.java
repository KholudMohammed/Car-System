package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "carId cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer carId;


    @NotNull(message = "customerId cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer customerId;


    @Column(columnDefinition = "date not null")
    private LocalDate startDate;


    @Column(columnDefinition = "date not null")
    private LocalDate endDate;




    @NotNull(message = "totalCost cannot be null")
    @Column(columnDefinition = "double not null")
    private Double totalCost;



//    reservation_id INT
//    car_id INT
//    customer_id INT
//    start_date DATE
//    end_date DATE
//    total_cost



}

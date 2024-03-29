package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponse.ApiResponse;
import com.example.capstone2.Model.Reservations;
import com.example.capstone2.Service.ReservationsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationsController {


    private final ReservationsService reservationsService;

    @GetMapping("/get")
    public ResponseEntity getAllReservations(){

        return ResponseEntity.status(200).body(reservationsService.getAllReservations());}


    @PostMapping("/add")
    public ResponseEntity addReservations(@RequestBody @Valid Reservations reservations, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        reservationsService.addReservations(reservations);
        return ResponseEntity.status(200).body(new ApiResponse("Reservations Added"));
    }











    @PutMapping("/update/{id}")
    public ResponseEntity updateReservations(@PathVariable Integer id, @RequestBody @Valid Reservations reservations, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }

        reservationsService.updateReservations(id,reservations);
        return ResponseEntity.status(200).body(new ApiResponse( "Reservation updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteReservations(@PathVariable Integer id){
        reservationsService.deleteReservations(id);
        return ResponseEntity.status(200).body(new ApiResponse("Reservations deleted!"));
    }


    @GetMapping("/getReservationsByStarDate/{starDate}")
    public ResponseEntity getReservationsByStarDate(@PathVariable LocalDate starDate) {
        return ResponseEntity.status(200).body(reservationsService.getReservationsByStarDate(starDate));

    }





















}

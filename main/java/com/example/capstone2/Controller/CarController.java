package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponse.ApiResponse;
import com.example.capstone2.Model.Car;
import com.example.capstone2.Service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private  final CarService carService;


    @GetMapping("/get")
    public ResponseEntity getAllCars(){

        return ResponseEntity.status(200).body(carService.getAllCars());}


    @PostMapping("/add")
    public ResponseEntity addCar(@RequestBody @Valid Car car, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);

        }
        carService.addCar(car);
        return ResponseEntity.status(200).body(new ApiResponse("Car Added"));

    }

    // Update Car
    @PutMapping("/update/{id}")
    public ResponseEntity updateCar(@PathVariable Integer id, @RequestBody @Valid Car car , Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }

       carService.updateCar(id ,car);
        return ResponseEntity.status(200).body(new ApiResponse( "Car updated"));
    }

     //Delete Car
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        carService.deleteCar(id);
        return ResponseEntity.status(200).body(new ApiResponse("Car deleted!"));
    }


    @GetMapping("/getCarByName/{carName}")
    public ResponseEntity getCarByName(@PathVariable String carName) {
        return ResponseEntity.status(200).body(carService.getCarByName(carName));
    }


    @GetMapping("/availableCar/{startDate}/{endtDate}")
    public ResponseEntity getAvailableCars(@PathVariable LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = carService.getAvailableCars(startDate,endDate);
        return ResponseEntity.ok(availableCars);
    }
















}

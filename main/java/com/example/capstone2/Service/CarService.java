package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiException;
import com.example.capstone2.Model.Car;
import com.example.capstone2.Repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CarService {

    private final CarRepository carRepository;


    //• Get all the Cars
    public List<Car> getAllCars() {

        return carRepository.findAll();
    }

    //• Add new Car
    public void addCar(Car car) {
        carRepository.save(car);
    }


    //• Update Car
    public void updateCar(Integer id, Car car) {
        Car c = carRepository.findCarById(id);
        if (c == null) {
            throw new ApiException("Wrong id");
        }
        c.setCarName(car.getCarName());
        c.setModel(car.getModel());
        c.setMake(car.getMake());
        c.setYear(car.getYear());
        c.setColor(car.getColor());
        c.setTransmissionType(car.getTransmissionType());
        c.setPricePerDay(car.getPricePerDay());
        c.setAvailable(car.getAvailable());
        carRepository.save(c);
    }


    //• Delete Car
    public void deleteCar(Integer id) {
        Car car =carRepository.findCarById(id);
        if (car == null) {
            throw new ApiException("Wrong id");
        }
        carRepository.delete(car);

    }


    // endpoint #3
    public List<Car> getCarByName(String carName) {
        List<Car> c= carRepository.findCarByCarName(carName) ;
        if (c == null) {
            throw new ApiException("Car not found");
        }
        return c;
    }


    // endpoint #4
    public List<Car> getAvailableCars(LocalDate startDate,LocalDate endDate) {
        List<Car> availableCars = carRepository.findAvailableCars(startDate,endDate);
        return availableCars;
    }









}








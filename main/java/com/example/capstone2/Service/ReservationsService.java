package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiException;
import com.example.capstone2.Model.Car;
import com.example.capstone2.Model.Customers;
import com.example.capstone2.Model.Reservations;
import com.example.capstone2.Repository.CarRepository;
import com.example.capstone2.Repository.CustomersRepository;
import com.example.capstone2.Repository.ReservationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationsService {


    private final ReservationsRepository reservationsRepository;
    private final CarRepository carRepository;
    private final CustomersRepository customersRepository;

    //• Get all the Reservations
    public List<Reservations> getAllReservations() {
       ;
        return reservationsRepository.findAll();
    }


    //• Add new Reservations
//    public void addReservations(Reservations reservations) {
//        Car car=carRepository.findCarById(reservations.getId());
//        Customers customers=customersRepository.findCustomersById(reservations.getId());
//          if(car==null){
//            throw new ApiException("Wrong id");
//        } if(customers==null){
//            throw new ApiException("Wrong id");
//        }
//        reservationsRepository.save(reservations);
//
//
//    }

    public void addReservations(Reservations reservations) {
        Car car = carRepository.findCarById(reservations.getCarId());
        Customers customer = customersRepository.findCustomersById(reservations.getCustomerId());

        if (car == null) {
            throw new ApiException("Car Id found");
        }
        if (customer == null) {
            throw new ApiException("Customer Id not found");
        }

        reservationsRepository.save(reservations);
    }


//    Reservations
//    reservation_id INT
//    car_id INT
//    customer_id INT
//    start_date DATE
//    end_date DATE
//    total_cost

    //• Update Reservations
    public void updateReservations(Integer id,Reservations reservations) {
        Reservations r=reservationsRepository.findReservationsById(id);
        Car car = carRepository.findCarById(reservations.getCarId());
        Customers customer = customersRepository.findCustomersById(reservations.getCustomerId());
        if (r == null) {
            throw new ApiException("id not found");
        }

        if (car == null) {
            throw new ApiException("Car Id found");
        }
        if (customer == null) {
            throw new ApiException("Customer Id not found");
        }


        r.setCarId(reservations.getCarId());
        r.setCustomerId(reservations.getCustomerId());
        r.setStartDate(reservations.getStartDate());
        r.setEndDate(reservations.getEndDate());
        r.setTotalCost(reservations.getTotalCost());
        reservationsRepository.save(r);
    }

    //• Delete Reservations
    public void deleteReservations(Integer id) {
        Reservations reservations = reservationsRepository.findReservationsById(id);
        if (reservations == null) {
            throw new ApiException("id not found");
        }
        reservationsRepository.delete(reservations);

    }


   //endpoint #5
   public List<Reservations> getReservationsByStarDate(LocalDate starDate) {
       List<Reservations> r = reservationsRepository.findReservationsByStartDate(starDate) ;
       if (r == null) {
           throw new ApiException("Reservation not found");
       }
       return r;

   }
























}

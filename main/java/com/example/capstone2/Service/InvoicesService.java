package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiException;
import com.example.capstone2.Model.Customers;
import com.example.capstone2.Model.Invoices;
import com.example.capstone2.Model.Reservations;
import com.example.capstone2.Repository.CustomersRepository;
import com.example.capstone2.Repository.InvoicesRepository;
import com.example.capstone2.Repository.ReservationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoicesService {

    private final InvoicesRepository invoicesRepository;
    private final ReservationsRepository reservationsRepository;

    //• Get all the Invoices
    public List<Invoices> getAllInvoices() {
        return invoicesRepository.findAll();
    }


    //• Add new Invoice
//    public void addInvoice(Invoices invoices) {
//        Reservations reservations=reservationsRepository.findReservationsById(invoices.getId());
//        if(reservations==null){
//            throw new ApiException("Wrong id");
//        }
//
//        invoicesRepository.save(invoices);
//    }



    //• Add new Invoice
    public void addInvoice(Invoices invoices) {
        Reservations reservation = reservationsRepository.findReservationsById(invoices.getReservationId());
        if (reservation == null) {
            throw new ApiException("Wrong reservation id");
        }

        invoicesRepository.save(invoices);
    }


    //• Update Invoices
    public void updateInvoices(Integer id,Invoices invoices) {
        Invoices i=invoicesRepository.findInvoicesById(id);

        if (i == null) {
            throw new ApiException("Wrong id");
        }

        i.setReservationId(invoices.getReservationId());
        i.setIssueDate(invoices.getIssueDate());
        i.setDueDate(invoices.getDueDate());
        i.setAmountDue(invoices.getAmountDue());
        i.setPaymentStatus(invoices.getPaymentStatus());
        invoicesRepository.save(i);


    }

    //• Delete Invoices
    public void deleteInvoices(Integer id) {
        Invoices invoices=invoicesRepository.findInvoicesById(id);
        if (invoices == null) {
            throw new ApiException("Wrong id");
        }
        invoicesRepository.delete(invoices);
    }




}

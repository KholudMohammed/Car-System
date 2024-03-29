package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponse.ApiResponse;
import com.example.capstone2.Model.Invoices;
import com.example.capstone2.Service.InvoicesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ap1/v1/invoices")
@RequiredArgsConstructor
public class InvoicesController {


    private final InvoicesService invoicesService;

    @GetMapping("/get")
    public ResponseEntity getAllInvoices(){

        return ResponseEntity.status(200).body(invoicesService.getAllInvoices());}


    @PostMapping("/add")
    public ResponseEntity addInvoices(@RequestBody @Valid Invoices invoices, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);

        }
        invoicesService.addInvoice(invoices);
        return ResponseEntity.status(200).body(new ApiResponse("Invoices Added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateInvoices(@PathVariable Integer id, @RequestBody @Valid Invoices invoices, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }
        invoicesService.updateInvoices(id,invoices);
        return ResponseEntity.status(200).body(new ApiResponse( "Invoices updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteInvoices(@PathVariable Integer id){
        invoicesService.deleteInvoices(id);
        return ResponseEntity.status(200).body(new ApiResponse("Invoices deleted!"));
    }

























}

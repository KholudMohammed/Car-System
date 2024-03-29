package com.example.capstone2.Repository;

import com.example.capstone2.Model.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends JpaRepository<Invoices,Integer> {
    Invoices findInvoicesById(Integer id);


}

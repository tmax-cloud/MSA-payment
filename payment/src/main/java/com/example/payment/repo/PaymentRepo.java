package com.example.payment.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.payment.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}







package com.bus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entities.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Long> {

}

package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Payment;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

// FILTRO PAGO POR CLIENTE 
    @Query("SELECT p.id, c.firstName, p.paymentDate, p.total, pm.methodName " +
           "FROM Payment p " +
           "JOIN p.customer c " +
           "JOIN p.paymentMethod pm " +
           "WHERE c.id = :customerId")
    List<Object[]> findPaymentsByCustomer(@Param("customerId") Long customerId);
    
//FILTRO PAGO POR METODO DE PAGO
    @Query("SELECT p.id, c.firstName, p.paymentDate, p.total, c.firstName, c.lastName1 " +
           "FROM Payment p " +
           "JOIN p.customer c " +
           "WHERE p.paymentMethod.id = :paymentMethodId")
    List<Object[]> findPaymentsByPaymentMethod(@Param("paymentMethodId") Long paymentMethodId);
}


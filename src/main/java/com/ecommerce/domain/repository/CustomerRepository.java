package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    //FILTRO DE CLIENTE POR CIUDAD
    @Query("SELECT c.id, c.firstName, c.lastName1, c.lastName2, c.email, ct.name " +
           "FROM Customer c " +
           "JOIN c.city ct " +
           "WHERE ct.id = :id")
    List<Object[]> findCustomerDataByCityId(@Param("id") Long id);

    //FILTRO DE CLIENTE POR ESTADO
    @Query("SELECT c, o, s " +
            "FROM Customer c " +
            "JOIN c.nOrders o " +
            "JOIN o.statusCodeOr s " +
            "WHERE c.id = :id")
    List<Object[]> findCustomerByIdWithStatus(@Param("id") Long id);
             
}
package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.NOrder;

//import java.sql.Date; 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NOderRepository extends CrudRepository<NOrder, Long> {

    //consultar pedido por estado
    @Query("SELECT o.id, o.orderDate, o.expectedDate, o.deliveryDate, o.comment, s.statusName " +
            "FROM NOrder o " +
            "JOIN o.statusCodeOr s " +
            "WHERE s.id = :id")
        List<Object[]> findOrderDataByStatusId(@Param("id") Long id);


    //consultar pedido por rango de fecha
//    @Query("SELECT o.id, c.firstName, s.stateName, o.orderDate, o.expectedDate, o.deliveryDate " +
//            "FROM NOrder o " +
//            "JOIN o.customer c " +
//            "JOIN o.statusCodeOr s " +
//            "WHERE o.orderDate BETWEEN :startDate AND :endDate")
//    List<Object[]> findOrdersByOrderDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}

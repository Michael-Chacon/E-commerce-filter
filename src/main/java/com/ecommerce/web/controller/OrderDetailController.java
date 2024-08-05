package com.ecommerce.web.controller;

import com.ecommerce.domain.service.orderdetail.IOrderDetail;
import com.ecommerce.persistence.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nOrders")
public class OrderDetailController {
    @Autowired
    private IOrderDetail service;

    @GetMapping
    public List<OrderDetail> listOrderDetails() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> view(@PathVariable Long id) {
        Optional<OrderDetail> orderDetailOpt = service.findById(id);
        if (orderDetailOpt.isPresent()) {
            return ResponseEntity.ok(orderDetailOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<OrderDetail> create(@RequestBody OrderDetail orderDetail) {
        OrderDetail orderDetailNew = service.save(orderDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDetailNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> update(@PathVariable Long id, @RequestBody OrderDetail orderDetail) {
        Optional<OrderDetail> orderDetailOpt = service.update(id,orderDetail);
        if (orderDetailOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(orderDetailOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDetail> delete(@PathVariable Long id) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        Optional<OrderDetail> orderDetailOpt = service.delete(id);
        if (orderDetailOpt.isPresent()) {
            return ResponseEntity.ok(orderDetailOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}

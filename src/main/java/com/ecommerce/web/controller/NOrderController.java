package com.ecommerce.web.controller;

import com.ecommerce.domain.service.norder.INOrder;
import com.ecommerce.persistence.entity.NOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nOrders")
public class NOrderController {
    @Autowired
    private INOrder service;

    @GetMapping
    public List<NOrder> listNOrder(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NOrder> view(@PathVariable Long id){
        Optional<NOrder> orderOpt = service.findById(id);
        if(orderOpt.isPresent()){
            return ResponseEntity.ok(orderOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<NOrder> create(@RequestBody NOrder nOrder){
        NOrder nOrderNew = service.save(nOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(nOrderNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NOrder> update(@PathVariable Long id, @RequestBody NOrder nOrder){
        Optional<NOrder> orderOpt = service.update(id, nOrder);
        if(orderOpt.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(orderOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NOrder> delete(@PathVariable Long id){
        NOrder nOrder = new NOrder();
        nOrder.setId(id);
        Optional<NOrder> orderOpt = service.delete(id);
        if(orderOpt.isPresent()){
            return ResponseEntity.ok(orderOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}

package com.ecommerce.web.controller;

import com.ecommerce.domain.service.position.IPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {
    @Autowired
    private IPosition service;

}

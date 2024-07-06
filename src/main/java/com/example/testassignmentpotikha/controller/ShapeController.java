package com.example.testassignmentpotikha.controller;

import com.example.testassignmentpotikha.model.Shape;
import com.example.testassignmentpotikha.model.ShapeResult;
import com.example.testassignmentpotikha.service.ShapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/shape")
@Validated
public class ShapeController {
    private final ShapeService shapeService;

    @Autowired
    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<ShapeResult> calculate(@Valid @RequestBody Shape shape) {
        return new ResponseEntity<>(shapeService.calculate(shape), HttpStatus.OK);
    }
}

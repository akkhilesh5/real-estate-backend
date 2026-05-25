package com.realestate.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.realestate.app.dto.PropertyDto;
import com.realestate.app.service.PropertyService;

@RestController
@RequestMapping("/api/properties") // ✨ Fixed: Changed to plural to match Frontend Axios calls perfectly!
@CrossOrigin(origins = "http://localhost:5173")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    // CREATE PROPERTY
    @PostMapping
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto propertyDto) {
        PropertyDto savedProperty = propertyService.createProperty(propertyDto);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    } // ✨ Fixed: Added missing closing brace for the method block!

    // GET ALL WITH PAGINATION
    @GetMapping("/")
    public ResponseEntity<List<PropertyDto>> getAllProperty(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {

        List<PropertyDto> allProperties = propertyService.getAllProperties(pageNumber, pageSize);
        return ResponseEntity.ok(allProperties);
    }

    // GET BY ID
    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable Long propertyId) {
        return ResponseEntity.ok(propertyService.getPropertyById(propertyId));
    }

    // FILTER BY TYPE
    @GetMapping("/filter")
    public ResponseEntity<List<PropertyDto>> getPropertyByType(@RequestParam String propertyType) {
        return ResponseEntity.ok(propertyService.getPropertiesByType(propertyType));
    }
}
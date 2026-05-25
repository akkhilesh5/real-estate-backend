package com.realestate.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.realestate.app.dto.PropertyDto;
import com.realestate.app.entity.Property;
import com.realestate.app.repository.PropertyRepository;
import com.realestate.app.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ModelMapper modelMapper;

    // ➕ 1. IMPLEMENT PROPERTY CREATION LOGIC
    @Override
    public PropertyDto createProperty(PropertyDto propertyDto) {
        // Convert incoming DTO payload to a DB Entity row
        Property property = this.modelMapper.map(propertyDto, Property.class);
        
        // Commit row to MySQL database
        Property savedProperty = this.propertyRepository.save(property);
        
        // Convert the newly committed entity back to a DTO wrapper for the controller
        return this.modelMapper.map(savedProperty, PropertyDto.class);
    }

    // 🔍 2. GET SINGLE PROPERTY BY PRIMARY KEY
    @Override
    public PropertyDto getPropertyById(Long propertyId) {
        Property property = this.propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property record not found with ID: " + propertyId));
        return this.modelMapper.map(property, PropertyDto.class);
    }

    // 📑 3. GET PAGINATED PROPERTIES 
    @Override
    public List<PropertyDto> getAllProperties(Integer pageNumber, Integer pageSize) {
        // Adjust for 0-indexed pagination behind the scenes in Spring Data
        int adjustedPage = (pageNumber > 0) ? pageNumber - 1 : 0;
        Pageable pageable = PageRequest.of(adjustedPage, pageSize);
        
        Page<Property> pageProperties = this.propertyRepository.findAll(pageable);
        List<Property> allProperties = pageProperties.getContent();
        
        return allProperties.stream()
                .map(prop -> this.modelMapper.map(prop, PropertyDto.class))
                .collect(Collectors.toList());
    }

    // 🎛️ 4. FILTER LISTINGS BY TYPE WITH IGNORING CASE SENSITIVITY
    @Override
    public List<PropertyDto> getPropertiesByType(String propertyType) {
        List<Property> properties = this.propertyRepository.findByPropertyTypeIgnoreCase(propertyType);
        return properties.stream()
                .map(prop -> this.modelMapper.map(prop, PropertyDto.class))
                .collect(Collectors.toList());
    }
}
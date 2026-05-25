package com.realestate.app.service;

import java.util.List;
import com.realestate.app.dto.PropertyDto;

public interface PropertyService {
	
	PropertyDto createProperty(PropertyDto propertyDto);

    PropertyDto getPropertyById(Long propertyId);

    List<PropertyDto> getAllProperties(Integer pageNumber, Integer pageSize);

    List<PropertyDto> getPropertiesByType(String propertyType);
    
}
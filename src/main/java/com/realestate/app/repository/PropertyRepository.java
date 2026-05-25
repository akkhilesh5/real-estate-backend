package com.realestate.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    List<Property> findByPropertyTypeIgnoreCase(String propertyType);

}
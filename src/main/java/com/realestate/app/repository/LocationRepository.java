package com.realestate.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
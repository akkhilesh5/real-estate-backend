package com.realestate.app.dto;

import java.time.LocalDateTime;

public class PropertyDto {

    private Long propertyId;
    private String propertyTitle;
    private double propertyPrice;
    private int propertyBedrooms;
    private int propertyBathrooms;
    private double propertyArea;
    private String propertyImage;
    private String description;
    private String propertyType;
    private String propertyStyle;
    private String listedBy;
    private LocalDateTime listedTime;
    private boolean favorite;
    private LocationDto location;

    // Constructor
    public PropertyDto() {
    }

    // Getters and Setters

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public double getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(double propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public int getPropertyBedrooms() {
        return propertyBedrooms;
    }

    public void setPropertyBedrooms(int propertyBedrooms) {
        this.propertyBedrooms = propertyBedrooms;
    }

    public int getPropertyBathrooms() {
        return propertyBathrooms;
    }

    public void setPropertyBathrooms(int propertyBathrooms) {
        this.propertyBathrooms = propertyBathrooms;
    }

    public double getPropertyArea() {
        return propertyArea;
    }

    public void setPropertyArea(double propertyArea) {
        this.propertyArea = propertyArea;
    }

    public String getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(String propertyImage) {
        this.propertyImage = propertyImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyStyle() {
        return propertyStyle;
    }

    public void setPropertyStyle(String propertyStyle) {
        this.propertyStyle = propertyStyle;
    }

    public String getListedBy() {
        return listedBy;
    }

    public void setListedBy(String listedBy) {
        this.listedBy = listedBy;
    }

    public LocalDateTime getListedTime() {
        return listedTime;
    }

    public void setListedTime(LocalDateTime listedTime) {
        this.listedTime = listedTime;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }
}
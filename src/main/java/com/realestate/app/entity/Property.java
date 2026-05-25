package com.realestate.app.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "title")
    private String propertyTitle;

    @Column(name = "property_price")
    private double propertyPrice;

    @Column(name = "property_bedrooms")
    private int propertyBedrooms;

    @Column(name = "property_bathrooms")
    private int propertyBathrooms;

    @Column(name = "property_area")
    private double propertyArea;

    @Column(name = "property_image")
    private String propertyImage;

    @Column(name = "property_description")
    private String description;

    @Column(name = "property_style")
    private String propertyStyle;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "listed_by")
    private String listedBy;

    @Column(name = "listed_time")
    private LocalDateTime listedTime;

    @Column(name = "favorite")
    private boolean favorite;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

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

	public String getPropertyStyle() {
		return propertyStyle;
	}

	public void setPropertyStyle(String propertyStyle) {
		this.propertyStyle = propertyStyle;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

    

}
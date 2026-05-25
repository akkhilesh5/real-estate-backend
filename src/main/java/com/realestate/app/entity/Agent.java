package com.realestate.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    @Column(name = "agent_name", nullable = false)
    private String agentName;

    @Column(name = "agent_contact", nullable = false)
    private String agentContact;

    @Column(name = "agent_review")
    private Double agentReview;

    @Column(name = "agent_city")
    private String agentCity;

    @Column(name = "agent_country")
    private String agentCountry;

    public Agent() {
    }

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentContact() {
		return agentContact;
	}

	public void setAgentContact(String agentContact) {
		this.agentContact = agentContact;
	}

	public Double getAgentReview() {
		return agentReview;
	}

	public void setAgentReview(Double agentReview) {
		this.agentReview = agentReview;
	}

	public String getAgentCity() {
		return agentCity;
	}

	public void setAgentCity(String agentCity) {
		this.agentCity = agentCity;
	}

	public String getAgentCountry() {
		return agentCountry;
	}

	public void setAgentCountry(String agentCountry) {
		this.agentCountry = agentCountry;
	}

    
    
}
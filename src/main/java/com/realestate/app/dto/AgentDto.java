package com.realestate.app.dto;

public class AgentDto {

    private Long agentId;
    private String agentName;
    private String agentContact;
    private Double agentReview;
    private String agentCity;
    private String agentCountry;

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
package com.realestate.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realestate.app.entity.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    List<Agent> findByAgentCityAndAgentCountry(String agentCity, String agentCountry);

    List<Agent> findByAgentCity(String agentCity);

    List<Agent> findByAgentCountry(String agentCountry);
}
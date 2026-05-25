package com.realestate.app.service;

import java.util.List;
import com.realestate.app.dto.AgentDto;

public interface AgentService {

    List<AgentDto> getAllAgents();

    AgentDto getAgentById(Long agentId);

    List<AgentDto> getAgentsByCityAndCountry(String agentCity, String agentCountry);
}
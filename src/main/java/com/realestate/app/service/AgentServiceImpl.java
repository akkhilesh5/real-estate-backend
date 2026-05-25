package com.realestate.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.app.dto.AgentDto;
import com.realestate.app.entity.Agent;
import com.realestate.app.repository.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AgentDto> getAllAgents() {
        return convertToDtoList(agentRepository.findAll());
    }

    @Override
    public List<AgentDto> getAgentsByCityAndCountry(String agentCity, String agentCountry) {

        List<Agent> agents;

        boolean hasCity = agentCity != null && !agentCity.trim().isEmpty();
        boolean hasCountry = agentCountry != null && !agentCountry.trim().isEmpty();

        if (hasCity && hasCountry) {
            agents = agentRepository.findByAgentCityAndAgentCountry(agentCity, agentCountry);

        } else if (hasCity) {
            agents = agentRepository.findByAgentCity(agentCity);

        } else if (hasCountry) {
            agents = agentRepository.findByAgentCountry(agentCountry);

        } else {
            agents = agentRepository.findAll();
        }

        return convertToDtoList(agents);
    }

    @Override
    public AgentDto getAgentById(Long agentId) {
        return agentRepository.findById(agentId)
                .map(this::convertToDto)
                .orElseThrow(() ->
                        new RuntimeException("Agent not found with ID: " + agentId));
    }

    private AgentDto convertToDto(Agent agent) {
        return modelMapper.map(agent, AgentDto.class);
    }

    private List<AgentDto> convertToDtoList(List<Agent> agents) {
        return agents.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
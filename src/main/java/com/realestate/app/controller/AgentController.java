package com.realestate.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.realestate.app.dto.AgentDto;
import com.realestate.app.service.AgentService;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    // GET ALL AGENTS
    @GetMapping("") // ✨ FIXED: Removed trailing slash constraint so '/api/agents' matches perfectly
    public ResponseEntity<List<AgentDto>> getAllAgent() {
        return ResponseEntity.ok(agentService.getAllAgents());
    }

    // GET AGENT BY ID
    @GetMapping("/{agentId}")
    public ResponseEntity<AgentDto> getAgentById(@PathVariable Long agentId) {
        return ResponseEntity.ok(
                agentService.getAgentById(agentId)
        );
    }

    // FILTER BY CITY / COUNTRY
    @GetMapping("/filter")
    public ResponseEntity<List<AgentDto>> getAgents(
            @RequestParam(required = false) String agentCity,
            @RequestParam(required = false) String agentCountry) {

        return ResponseEntity.ok(
                agentService.getAgentsByCityAndCountry(agentCity, agentCountry)
        );
    }
}
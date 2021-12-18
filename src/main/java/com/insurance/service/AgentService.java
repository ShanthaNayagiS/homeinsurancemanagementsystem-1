package com.insurance.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.AgentNotFoundException;
import com.insurance.model.Agent;
import com.insurance.repository.AgentRepository;
@Service
public class AgentService {

	@Autowired
	private AgentRepository agentRepository;

// CREATE
	public Agent createAgent(Agent agent) {
	return agentRepository.save(agent);
	}
	public List<Agent> getAllAgent() throws AgentNotFoundException {
		return (List<Agent>) agentRepository.findAll();
		}
// ADD
	
	public Agent save(Agent agent) {
		return agentRepository.save(agent);
	}
			
// UPDATE
	
	public Agent updateAgent(Agent agentId) throws AgentNotFoundException {
		return agentRepository.save(agentId);
	}
	
	public Optional<Agent> getAgentById(int agentId) throws AgentNotFoundException {
		return agentRepository.findById(agentId);
	}
	
// DELETE
	
	public void deleteAgentById(int agentId)throws AgentNotFoundException {
		 agentRepository.deleteById(agentId);
	}
	
	

}
	
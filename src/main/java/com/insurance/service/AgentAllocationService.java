package com.insurance.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.AgentAllocationNotFoundException;
import com.insurance.model.AgentAllocation;
import com.insurance.repository.AgentAllocationRepository;
@Service
public class AgentAllocationService {
@Autowired
private AgentAllocationRepository agentAllocationRepository;
public AgentAllocation createagentAllocation(AgentAllocation agentAllocation) {
return agentAllocationRepository.save(agentAllocation);
}

public Optional<AgentAllocation> getagentAllocationDetailsById(int agentId)throws AgentAllocationNotFoundException {
return agentAllocationRepository.findById(agentId);
}
public void deletePolicyDetailsById(int agentId)throws AgentAllocationNotFoundException {
	agentAllocationRepository.deleteById(agentId);
}
public AgentAllocation updateagentAllocation(AgentAllocation agentAllocation)throws AgentAllocationNotFoundException {
return agentAllocationRepository.save(agentAllocation); // if the bsnkId already exists in the db merge // if the bankId is not there in db then persist
}
public List<AgentAllocation> getAllagentAllocation()throws AgentAllocationNotFoundException {
// TODO Auto-generated method stub
return (List<AgentAllocation>) agentAllocationRepository.findAll();
}
}

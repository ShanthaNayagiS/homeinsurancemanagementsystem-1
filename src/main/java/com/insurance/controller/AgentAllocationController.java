package com.insurance.controller;

import java.util.List;

import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.exception.AgentAllocationNotFoundException;
import com.insurance.model.AgentAllocation;
import com.insurance.service.AgentAllocationService;

@RestController
public class AgentAllocationController {
	@Autowired
	private AgentAllocationService agentAllocationService;
	
	static final Logger LOGGER = LoggerFactory.getLogger(AgentAllocationController.class);

	@RequestMapping(value = "/agentallocation", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome to Home Insurance Policy project";
	}

	@PostMapping(value = "/createagentallocation")
	public AgentAllocation createagentAllocation(@Valid @RequestBody AgentAllocation agentAllocation) {
		LOGGER.info("AgentAllocation Added!!!");
		return agentAllocationService.createagentAllocation(agentAllocation);
	}

	@RequestMapping(value = "/getagentallocation", method = RequestMethod.GET)
	public List<AgentAllocation> getAllagentAllocation()throws AgentAllocationNotFoundException {
		return agentAllocationService.getAllagentAllocation();
	}

	@RequestMapping(value = "/getagentallocation/agentallocationid/{agentAllocationId}", method = RequestMethod.GET)
	public AgentAllocation getagentAllocationDetailsById(@PathVariable("agentAllocationId") int Id) throws AgentAllocationNotFoundException{
		Optional<AgentAllocation> agentAllocation = agentAllocationService.getagentAllocationDetailsById(Id);
		return agentAllocation.get();
	}

	@RequestMapping(value = "/updateagentallocation", method = RequestMethod.PUT)
	public AgentAllocation updateagentAllocationDetails(@RequestBody AgentAllocation agentAllocation)throws AgentAllocationNotFoundException {
		LOGGER.info("AgentAllocation updated!!!");
		return agentAllocationService.updateagentAllocation(agentAllocation);
	}

	@RequestMapping(value = "/deleteagentallocation/{agentAllocationId}", method = RequestMethod.DELETE)
	public String deleteagentAllocationDetails(@PathVariable("agentAllocationId") int Id)throws AgentAllocationNotFoundException {
		Optional<AgentAllocation> p = agentAllocationService.getagentAllocationDetailsById(Id);
		if (p.isPresent()) {
			agentAllocationService.deletePolicyDetailsById(Id);
			LOGGER.info("AgentAllocation deleted!!!");
			return "The Policy Details deleted with the agents ID: " + Id;
		}
		return "The Policy Details Not deleted with the agent ID: " + Id;
	}
}
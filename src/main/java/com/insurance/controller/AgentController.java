package com.insurance.controller;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.exception.AgentNotFoundException;
import com.insurance.model.Agent;
import com.insurance.service.AgentService;

@RestController
public class AgentController {
	@Autowired
	private AgentService agentService;
	static final Logger LOGGER = LoggerFactory.getLogger(AgentController.class);

	@GetMapping(value = "/agent")
	public String Welcome() {
		return "Welcome to Agents Lounge";
	}

	@PostMapping(value = "/createagent")
	public Agent createAgent(@Valid @RequestBody Agent agent) {
		LOGGER.info("Agent Added!!!");

		return agentService.createAgent(agent);
	}

	@GetMapping(value = "/getagent")
	public List<Agent> getAllAgent() throws AgentNotFoundException {
		return agentService.getAllAgent();
	}

	@GetMapping(value = "/getagent/agentid/{agentId}")
	public Optional<Agent> agentByAgentId(@PathVariable("agentId") int agentId) throws AgentNotFoundException {
		return agentService.getAgentById(agentId);
	}

	@PutMapping(value = "/updateagent/agentid")
	public Agent updateAgent(@RequestBody Agent agentId) throws AgentNotFoundException {
		LOGGER.info("Agent updated!!!");

		return agentService.updateAgent(agentId);

	}

// DELETE

	@RequestMapping(value = "/deleteagent/agentid/{agentId}", method = RequestMethod.DELETE)
	public String deleteAgent(@PathVariable("agentId") int agentId) throws AgentNotFoundException {
		Optional<Agent> a = agentService.getAgentById(agentId);
		if (a.isPresent()) {
			agentService.deleteAgentById(agentId);
			LOGGER.info("Agent Deleted!!!");

			return "Agent details deleted :" + agentId;
		} else {
			return "Agent details not found :" + agentId;
		}
	}
}
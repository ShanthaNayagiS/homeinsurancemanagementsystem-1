package com.insurance.controller;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.exception.PolicyNotFoundException;
import com.insurance.model.Policy;
import com.insurance.service.PolicyService;

@RestController
public class PolicyController {
	@Autowired
	private PolicyService policyService;
	static final Logger LOGGER = LoggerFactory.getLogger(PolicyController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome to Home Insurance Policy project";
	}

	@PostMapping(value = "/policy")
	public Policy createPolicy(@Validated @RequestBody Policy policy) {
		LOGGER.info("Policy Added!!!");

		return policyService.createPolicy(policy);
	}

	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	public List<Policy> getAllPolicy() throws PolicyNotFoundException {
		return policyService.getAllPolicy();
	}

	@RequestMapping(value = "/policy/{policyId}", method = RequestMethod.GET)
	public Policy getPolicyDetailsById(@PathVariable("policyId") int Id) throws PolicyNotFoundException {
		Optional<Policy> policy = policyService.getPolicyDetailsById(Id);
		return policy.get();
	}

	@PutMapping(value = "/policy/update")
	public Policy updatePolicyDetails(@RequestBody Policy policy)throws PolicyNotFoundException  {
		LOGGER.info("Policy updated!!!");

		return policyService.updatePolicy(policy);
	}

	@RequestMapping(value = "/policy/delete/{policyId}", method = RequestMethod.DELETE)
	public String deletePolicyDetails(@PathVariable("policyId") int Id)throws PolicyNotFoundException  {
		Optional<Policy> p = policyService.getPolicyDetailsById(Id);
		if (p.isPresent()) {
			policyService.deletePolicyDetailsById(Id);
			return "The Policy Details deleted with the Policy ID: " + Id;
		}
		return "The Policy Details Not deleted with the Policy ID: " + Id;
	}
}
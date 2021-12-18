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

import com.insurance.model.PolicyHolder;
import com.insurance.service.PolicyHolderService;

@RestController
public class PolicyHolderController {
	@Autowired
	private PolicyHolderService policyHolderService;
	static final Logger LOGGER = LoggerFactory.getLogger(PolicyHolderController.class);

	
	@RequestMapping(value = "/policyholder", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome to Home Insurance Policy Holder project";
	}
	
	@PostMapping(value="/createpolicyholder")
	public PolicyHolder createPolicyHolder(@Valid @RequestBody PolicyHolder policyHolder) {
		LOGGER.info("PolicyHolder Added!!!");

		return policyHolderService.createPolicyHolder(policyHolder);
	}
	
	@RequestMapping(value="/getpolicyholder", method=RequestMethod.GET )
	public List<PolicyHolder> getAllPolicyHolders() {
		return policyHolderService.getAllPolicyHolder(); 
	}
	
	@RequestMapping(value="/getpolicyholder/{policyHolderId}", method=RequestMethod.GET )
	public PolicyHolder getPolicyHolderDetailsById(@PathVariable("policyHolderId") int pId) {
		Optional<PolicyHolder> policyHolder = policyHolderService.getPolicyHolderDetailsById(pId);
		return policyHolder.get();
		
	}	
	
	@RequestMapping(value="/updatepolicyholder", method=RequestMethod.PUT )
	public PolicyHolder updatePolicyHolderDetails(@RequestBody PolicyHolder policyHolder) {
		LOGGER.info("PolicyHolder updated!!!");

		return policyHolderService.updatePolicyHolder(policyHolder);	
	}
	@RequestMapping(value="/policyholder/{policyHolderId}", method=RequestMethod.DELETE)
	public String deletePolicyHolderDetails(@PathVariable("policyHolderId") int pId) {
		Optional<PolicyHolder> p =policyHolderService.getPolicyHolderDetailsById(pId);
		if(p.isPresent()) {
			policyHolderService.deletePolicyHolderDetailsById(pId);
			return "The PolicyHolder Details deleted with the PolicyHolder ID: "+pId;
		}
		
		return "The PolicyHolder Details Not deleted with the PolicyHolder ID: "+pId;
		
	}
}


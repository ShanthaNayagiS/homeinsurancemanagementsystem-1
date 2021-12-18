package com.insurance.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.PolicyNotFoundException;
import com.insurance.model.Policy;
import com.insurance.repository.PolicyRepository;

@Service
public class PolicyService {
	@Autowired
	private PolicyRepository policyRepository;

	public Policy createPolicy(Policy policy) {
		return policyRepository.save(policy);
	}

	public Optional<Policy> getPolicyDetailsById(int policyId)throws PolicyNotFoundException {

		return policyRepository.findById(policyId);
	}

	public void deletePolicyDetailsById(int policyId)throws PolicyNotFoundException {
		policyRepository.deleteById(policyId);
	}

	public Policy updatePolicy(Policy policy) throws PolicyNotFoundException{
		return policyRepository.save(policy);
	}

	public List<Policy> getAllPolicysByName(String policyName)throws PolicyNotFoundException { // Query Generation
		return policyRepository.findByPolicyName(policyName);
	}

	public List<Policy> getAllPolicy()throws PolicyNotFoundException {
		return (List<Policy>) policyRepository.findAll();
	}
}
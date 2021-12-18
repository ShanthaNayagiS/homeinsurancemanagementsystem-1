package com.insurance.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.model.PolicyHolder;
import com.insurance.repository.PolicyHolderRepository;
@Service
public class PolicyHolderService {
	@Autowired
	private PolicyHolderRepository policyHolderRepository;
	
	public PolicyHolder createPolicyHolder(PolicyHolder policyHolder) {
		return policyHolderRepository.save(policyHolder);
	}	
	public Optional<PolicyHolder> getPolicyHolderDetailsById(int policyHolderId) {
	
		return policyHolderRepository.findById(policyHolderId);
	}
	
	public void deletePolicyHolderDetailsById(int policyHolderId) {
		policyHolderRepository.deleteById(policyHolderId);
	}
	public PolicyHolder updatePolicyHolder(PolicyHolder policyHolder) {
		return policyHolderRepository.save(policyHolder);
	}
	 
	public List<PolicyHolder> getAllPolicyHoldersByName(String policyHolderName){
		return policyHolderRepository.findByPolicyHolderName(policyHolderName);
	}


	public List<PolicyHolder> getAllPolicyHolder() {
		// TODO Auto-generated method stub
		return (List<PolicyHolder>) policyHolderRepository.findAll();
	}
	
	
	
}
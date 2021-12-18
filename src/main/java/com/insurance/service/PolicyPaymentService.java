package com.insurance.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.PolicyPaymentNotFoundException;
import com.insurance.model.PolicyPayment;
import com.insurance.repository.PolicyPaymentRepository;

@Service
public class PolicyPaymentService {
	@Autowired
	private PolicyPaymentRepository paymentRepository;
	
	public PolicyPayment createPolicyPayment(PolicyPayment policyPayment) {
		return paymentRepository.save(policyPayment);	
	}
	public List<PolicyPayment> getAllPolicyPayment() {
		return (List<PolicyPayment>) paymentRepository.findAll();
	}
	public Optional<PolicyPayment> getPolicyPaymentDetailsByPaymentId(int policyPaymentId) throws PolicyPaymentNotFoundException{
		
		return paymentRepository.findById(policyPaymentId);
		
	}
	public Optional<PolicyPayment> getAllPolicyPaymentByUserId(int userId)throws PolicyPaymentNotFoundException {
		
		return  paymentRepository.findById(userId);
	}
	public Optional<PolicyPayment> getAllPolicyPaymentByPolicyId(int policyId)throws PolicyPaymentNotFoundException {
		return paymentRepository.findById(policyId);

	}
	public void deletePolicyPayment(int pId)throws PolicyPaymentNotFoundException{
		paymentRepository.deleteById(pId);
		
	}
	public Optional<PolicyPayment> getpolicyPaymentDetailsById(int pId)throws PolicyPaymentNotFoundException {
		
		return paymentRepository.findById(pId);
	}

	public PolicyPayment updatePolicyPayment(PolicyPayment policyPaymentId)throws PolicyPaymentNotFoundException{
		
		return paymentRepository.save(policyPaymentId);
	}

}

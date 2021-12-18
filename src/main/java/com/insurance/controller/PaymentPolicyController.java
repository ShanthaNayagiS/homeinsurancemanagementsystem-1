package com.insurance.controller;
import java.util.List;

import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.insurance.exception.PolicyPaymentNotFoundException;
import com.insurance.model.PolicyPayment;
import com.insurance.service.PolicyPaymentService;

@RestController
public class PaymentPolicyController {
	@Autowired
	private PolicyPaymentService paymentService;
	static final Logger LOGGER = LoggerFactory.getLogger(PaymentPolicyController.class);

	
	@GetMapping(value="/policypayment")
	public String Welcome() {
		return "Welcome to Policy Payment";
		
	}
	@PostMapping(value="/createpolicypayment" )
	public PolicyPayment createPolicyPayment(@Valid @RequestBody PolicyPayment policyPayment) {
		LOGGER.info("PolicyPayment Added!!!");

		return paymentService.createPolicyPayment(policyPayment);
	}
	@GetMapping(value="/getpolicypayment" )
	public List<PolicyPayment> getAllPolicyPayments() {
		return paymentService.getAllPolicyPayment();
		
	}
	@GetMapping(value="/getpolicypayment/policypaymentid/{policyPaymentId}")
	public Optional<PolicyPayment> bankDetailsByPaymentId(@PathVariable("policyPaymentId") int policyPaymentId) throws PolicyPaymentNotFoundException{
		Optional<PolicyPayment> b=paymentService.getPolicyPaymentDetailsByPaymentId(policyPaymentId);
		
			 return paymentService.getPolicyPaymentDetailsByPaymentId(policyPaymentId);
		
	}
	@GetMapping(value="/getpolicypayment/userid/{userId}")
	public Optional<PolicyPayment> getAllPolicyPaymentByUserId(@PathVariable("userId") int userId) throws PolicyPaymentNotFoundException {
		return paymentService.getAllPolicyPaymentByUserId(userId);
		
	}
	@GetMapping(value="/getpolicypayment/policyid/{policyId}")
	public Optional<PolicyPayment> getAllPolicyPaymentByPolicyId(@PathVariable("policyId") int policyId) throws PolicyPaymentNotFoundException {
		return paymentService.getAllPolicyPaymentByPolicyId(policyId);
		
	}
	
	@PutMapping(value="/updatepolicypayment")
	public PolicyPayment updatePolicyPayment(@RequestBody PolicyPayment policyPaymentId) throws PolicyPaymentNotFoundException {
		LOGGER.info("PolicyPayment updated!!!");

		return paymentService.updatePolicyPayment(policyPaymentId);
		
	}
	@DeleteMapping(value="/deletepolicypayment/policypaymentid/{policyPaymentId}")
	public String deletePolicyPayment(@PathVariable("policyPaymentId") int pId) throws PolicyPaymentNotFoundException {
		Optional<PolicyPayment> b=paymentService.getpolicyPaymentDetailsById(pId);
		if(b.isPresent())
		{
			paymentService.deletePolicyPayment(pId);
			return "Policy Payment details deleted"+pId;
		}
		else {
			return "Policy Payment details not found"+pId;
		}
	}

}

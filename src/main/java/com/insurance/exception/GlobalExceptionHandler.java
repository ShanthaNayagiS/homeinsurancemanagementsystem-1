package com.insurance.exception;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=AssetNotFoundException.class)
	public ResponseEntity<Object> assetAllocationException(AssetNotFoundException e){
	return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}


@ExceptionHandler(value=AgentAllocationNotFoundException.class)
public ResponseEntity<Object> agentAllocationException(AgentAllocationNotFoundException e){
return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
}

//Exception for user
@ExceptionHandler(value=UserNotFoundException.class)
public ResponseEntity<Object> userException(UserNotFoundException e){
return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
}


@ExceptionHandler(value=PolicyPaymentNotFoundException.class)
public ResponseEntity<Object> policyPaymentException(PolicyPaymentNotFoundException e){
return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
}

//Exception for policy holder
@ExceptionHandler(value=PolicyHolderNotFoundException.class)
public ResponseEntity<Object> policyHolderException(PolicyHolderNotFoundException e){
return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
}

//Exception for policy
@ExceptionHandler(value=PolicyNotFoundException.class)
public ResponseEntity<Object> policyException(PolicyNotFoundException e){
return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
}

//Exception for agent
@ExceptionHandler(value=AgentNotFoundException.class)
public ResponseEntity<Object> agentException(AgentNotFoundException e){
return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
}
}
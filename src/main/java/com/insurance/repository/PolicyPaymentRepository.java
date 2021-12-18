package com.insurance.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.insurance.model.PolicyPayment;

@Repository
public interface PolicyPaymentRepository extends CrudRepository<PolicyPayment, Integer>{

}

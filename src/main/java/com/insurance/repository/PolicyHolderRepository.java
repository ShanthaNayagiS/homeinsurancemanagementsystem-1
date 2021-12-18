package com.insurance.repository;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.PolicyHolder;

@Repository
public interface PolicyHolderRepository extends CrudRepository<PolicyHolder, Integer>{

	List<PolicyHolder> findByPolicyHolderName(String policyHolderName);

}

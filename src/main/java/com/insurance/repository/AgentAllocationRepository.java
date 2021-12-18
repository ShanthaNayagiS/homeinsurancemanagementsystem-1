package com.insurance.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.AgentAllocation;

@Repository
public interface AgentAllocationRepository extends CrudRepository<AgentAllocation, Integer> {

	

}

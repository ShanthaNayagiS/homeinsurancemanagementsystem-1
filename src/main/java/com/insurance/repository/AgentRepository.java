package com.insurance.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.insurance.model.Agent;

@Repository
public interface AgentRepository extends CrudRepository<Agent, Integer>{

}

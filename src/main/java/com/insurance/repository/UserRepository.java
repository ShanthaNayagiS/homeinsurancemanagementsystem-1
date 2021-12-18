package com.insurance.repository;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insurance.model.UserEntry;

@Repository
public interface UserRepository extends CrudRepository<UserEntry, Integer>{

	Optional<UserEntry> findByUserName(String uName);

}

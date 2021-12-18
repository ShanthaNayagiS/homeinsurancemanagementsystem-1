package com.insurance.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.insurance.model.Asset;
@Repository
public interface AssetRepository extends CrudRepository<Asset, Integer> {

}

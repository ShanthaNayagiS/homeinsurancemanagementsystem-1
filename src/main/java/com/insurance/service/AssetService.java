package com.insurance.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.exception.AssetNotFoundException;
import com.insurance.model.Asset;
import com.insurance.repository.AssetRepository;
@Service
public class AssetService {
	@Autowired
	private AssetRepository assetRepository;
	
	public Asset createAsset(Asset asset) {
		return assetRepository.save(asset); 		
	}
	public Iterable<Asset> getAllAsset()throws AssetNotFoundException {
		return assetRepository.findAll();
	}
	
	public Optional<Asset> getAssetDetailsById(int assetId)throws AssetNotFoundException  {
	
		return assetRepository.findById(assetId);
	}
	
	public void deleteAssetDetailsById(int assetId)throws AssetNotFoundException  {
		assetRepository.deleteById(assetId);
	}
	public Asset updateAsset(Asset asset) throws AssetNotFoundException {
		return assetRepository.save(asset); 
	}
	 
}

package com.insurance.controller;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.exception.AssetNotFoundException;
import com.insurance.model.Asset;
import com.insurance.service.AssetService;

@RestController
public class AssetController {
	@Autowired
	private AssetService assetService;
	static final Logger LOGGER = LoggerFactory.getLogger(AssetController.class);


	@RequestMapping(value = "/asset", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome to asset module";
	}

	@RequestMapping(value = "/createasset", method = RequestMethod.POST)
	public Asset createAsset(@Valid @RequestBody Asset asset) {
		LOGGER.info("Asset Added!!!");

		return assetService.createAsset(asset);
	}

	@RequestMapping(value = "/getasset", method = RequestMethod.GET)
	public Iterable<Asset> getAllAssets() throws AssetNotFoundException {
		return assetService.getAllAsset(); // List<Bank>
	}

	@RequestMapping(value = "/getasset/{assetId}", method = RequestMethod.GET)
	public Asset getAssetDetailsById(@PathVariable("assetId") int aId)throws AssetNotFoundException {
		Optional<Asset> asset = assetService.getAssetDetailsById(aId);
		return asset.get();

	}

	@RequestMapping(value = "/updateasset", method = RequestMethod.PUT)
	public Asset updateAssetDetails(@RequestBody Asset asset)throws AssetNotFoundException  {
		LOGGER.info("Asset updated!!!");

		return assetService.updateAsset(asset);
	}

	@RequestMapping(value = "/deleteasset/{assetId}", method = RequestMethod.DELETE)
	public String deleteAssetDetails(@PathVariable("assetId") int aId)throws AssetNotFoundException  {
		Optional<Asset> a = assetService.getAssetDetailsById(aId);
		if (a.isPresent()) {
			assetService.deleteAssetDetailsById(aId);
			return "The Asset Details deleted with the asset ID: " + aId;
		}

		return "The Asset Details Not deleted with the asset ID: " + aId;

	}
}

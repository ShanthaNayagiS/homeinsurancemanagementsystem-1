package com.insurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.insurance.exception.AssetNotFoundException;
import com.insurance.model.Asset;
import com.insurance.repository.AssetRepository;
import com.insurance.service.AssetService;

@SpringBootTest
public class AssetTest {
	@InjectMocks
	private AssetService assetService;
	@Mock
	private AssetRepository assetRepository;

	@Test
	public void createAssetTest() {
		Asset asset = new Asset();
		asset.setAssetId(1);
		asset.setAssetType("home");
		asset.setAssetArea(500);
		asset.setAssetValue(100000);

		Mockito.when(assetRepository.save(asset)).thenReturn(asset);

		assertEquals(asset, assetService.createAsset(asset));

	}

	@Test
	public void getAllAssetTest() throws AssetNotFoundException {
		Asset asset = new Asset();
		asset.setAssetId(1);
		asset.setAssetType("home");
		asset.setAssetArea(500);
		asset.setAssetValue(100000);

		Asset asset1 = new Asset();
		asset1.setAssetId(2);
		asset1.setAssetType("villa");
		asset1.setAssetArea(600);
		asset1.setAssetValue(200000);

		List<Asset> list = new ArrayList<Asset>();
		list.add(asset);
		list.add(asset1);

		Mockito.when(assetRepository.findAll()).thenReturn(list);

		assertEquals(list, assetService.getAllAsset());
	}

	@Test
	public void deleteAssetDetailsByIdTest() throws AssetNotFoundException {
		Asset asset = new Asset();
		asset.setAssetId(1);
		asset.setAssetType("home");
		asset.setAssetArea(500);
		asset.setAssetValue(100000);

		Mockito.when(assetRepository.save(asset)).thenReturn(asset);
		Mockito.when(assetRepository.existsById(1)).thenReturn(true);

		assetService.deleteAssetDetailsById(1);

		verify(assetRepository, Mockito.atLeastOnce()).deleteById(1);
	}

}

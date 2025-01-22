package com.dinh.networth.Services;

import com.dinh.networth.Models.Asset;
import com.dinh.networth.Repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    public Asset getAssetById(Long id) {
        return assetRepository.findById(id).orElseThrow(() -> new RuntimeException("Asset with " + id + " does not exist."));
    }

    public List<Asset> getAssetByUserId(Long userId) {
        return assetRepository.findByUserId(userId);
    }

    public List<Asset> getAssetByCategory(String category) {
        return assetRepository.findByCategory(category);
    }
}

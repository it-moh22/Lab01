/* ========================================
   InventoryFlowerServiceImpl.java
   ======================================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.BusinessLayer.Inventory_Flower;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Inventory.InventoryIdentifier;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers.*;
import com.champsoft.cardealershipwebapp_v2.utils.Currency;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerRequestModel;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerResponseModel;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.Flower.FlowerRequestMapper;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.Flower.FlowerResponseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryFlowerServiceImpl implements InventoryFlowerService {

    private final FlowerRepository flowerRepository;
    private final FlowerResponseMapper flowerResponseMapper;
    private final FlowerRequestMapper flowerRequestMapper;

    public InventoryFlowerServiceImpl(
            FlowerRepository flowerRepository,
            FlowerResponseMapper flowerResponseMapper,
            FlowerRequestMapper flowerRequestMapper
    ) {
        this.flowerRepository = flowerRepository;
        this.flowerResponseMapper = flowerResponseMapper;
        this.flowerRequestMapper = flowerRequestMapper;
    }

    @Override
    public List<FlowerResponseModel> getFlowersInInventory(String inventoryId) {
        List<Flower> flowers = flowerRepository.findByInventoryIdentifier_InventoryId(inventoryId);
        return flowers.stream()
                .map(flowerResponseMapper::entityToResponseModel)
                .collect(Collectors.toList());
    }

    @Override
    public FlowerResponseModel getInventoryFlowerById(String inventoryId, String flowerId) {
        Flower flower = flowerRepository
                .findByInventoryIdentifier_InventoryIdAndVehicleIdentifier_Vin(inventoryId, flowerId)
                .orElseThrow(() -> new RuntimeException("Flower not found in inventory " + inventoryId));
        return flowerResponseMapper.entityToResponseModel(flower);
    }

    @Override
    public FlowerResponseModel addFlowerToInventory(String inventoryId, FlowerRequestModel flowerRequestModel) {
        Flower flower = flowerRequestMapper.requestModelToEntity(flowerRequestModel);
        flower.setInventoryIdentifier(new InventoryIdentifier(inventoryId));
        Flower savedFlower = flowerRepository.save(flower);
        return flowerResponseMapper.entityToResponseModel(savedFlower);
    }

    @Override
    public FlowerResponseModel updateFlowerInInventory(String inventoryId, String flowerId, FlowerRequestModel flowerRequestModel) {
        Flower existingFlower = flowerRepository
                .findByInventoryIdentifier_InventoryIdAndVehicleIdentifier_Vin(inventoryId, flowerId)
                .orElseThrow(() -> new RuntimeException("Flower not found in inventory " + inventoryId));

        existingFlower.setMake(flowerRequestModel.getMake());
        existingFlower.setModel(flowerRequestModel.getModel());
        existingFlower.setManufacturer(flowerRequestModel.getManufacturer());
        existingFlower.setBodyClass(flowerRequestModel.getBodyClass());
        existingFlower.setStatus(Status.valueOf(flowerRequestModel.getFlowerStatus()));
        existingFlower.setUsageType(UsageType.valueOf(flowerRequestModel.getUsageType()));

        Price price = new Price();
        price.setCurrency(Currency.valueOf(flowerRequestModel.getCurrency()));
        price.setAmount(flowerRequestModel.getPrice());
        existingFlower.setPrice(price);

        Flower updatedFlower = flowerRepository.save(existingFlower);
        return flowerResponseMapper.entityToResponseModel(updatedFlower);
    }

    @Override
    public void removeFlowerFromInventory(String inventoryId, String flowerId) {
        Flower flower = flowerRepository
                .findByInventoryIdentifier_InventoryIdAndVehicleIdentifier_Vin(inventoryId, flowerId)
                .orElseThrow(() -> new RuntimeException("Flower not found in inventory " + inventoryId));
        flowerRepository.delete(flower);
    }
}

package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.BusinessLayer.Inventory;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Inventory.Inventory;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Inventory.InventoryIdentifier;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Inventory.InventoryRepository;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers.Flower;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers.FlowerRepository;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.Inventory.InventoryRequestMapper;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.Inventory.InventoryResponseMapper;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Inventory.InventoryRequestModel;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Inventory.InventoryResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final FlowerRepository flowerRepository;
    private final InventoryRequestMapper inventoryRequestMapper;
    private final InventoryResponseMapper inventoryResponseMapper;

    public InventoryServiceImpl(
            InventoryRepository inventoryRepository,
            FlowerRepository flowerRepository,
            InventoryRequestMapper inventoryRequestMapper,
            InventoryResponseMapper inventoryResponseMapper) {
        this.inventoryRepository = inventoryRepository;
        this.flowerRepository = flowerRepository;
        this.inventoryRequestMapper = inventoryRequestMapper;
        this.inventoryResponseMapper = inventoryResponseMapper;
    }

    @Override
    public List<InventoryResponseModel> getInventories() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories.stream()
                .map(inventoryResponseMapper::entityToResponseModel)
                .collect(Collectors.toList());
    }

    @Override
    public InventoryResponseModel getInventoryById(String inventoryId) {
        Inventory inventory = inventoryRepository.findByInventoryIdentifier_InventoryId(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found with ID: " + inventoryId));

        return inventoryResponseMapper.entityToResponseModel(inventory);
    }

    @Override
    public InventoryResponseModel addInventory(InventoryRequestModel inventoryRequestModel) {
        Inventory inventory = inventoryRequestMapper.requestModelToEntity(inventoryRequestModel);

        if (inventory.getInventoryIdentifier() == null) {
            inventory.setInventoryIdentifier(new InventoryIdentifier());
        }

        inventory.getInventoryIdentifier().generateIfMissing();

        Inventory savedInventory = inventoryRepository.save(inventory);

        return inventoryResponseMapper.entityToResponseModel(savedInventory);
    }


    @Override
    public InventoryResponseModel updateInventoryDetails(InventoryRequestModel inventoryRequestModel, String inventoryId) {
        Inventory existingInventory = inventoryRepository.findByInventoryIdentifier_InventoryId(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found with ID: " + inventoryId));
        existingInventory.setType(inventoryRequestModel.getType());
        Inventory updatedInventory = inventoryRepository.save(existingInventory);
        return inventoryResponseMapper.entityToResponseModel(updatedInventory);
    }

    @Override
    public void deleteInventory(String inventoryId) {
        Inventory existingInventory = inventoryRepository.findByInventoryIdentifier_InventoryId(inventoryId)
                .orElseThrow(() -> new RuntimeException("Inventory not found with ID: " + inventoryId));

        List<Flower> flowers = flowerRepository.findAllByInventoryIdentifier_InventoryId(inventoryId);
        for (Flower flower : flowers) {
            flowerRepository.delete(flower);
        }

        inventoryRepository.delete(existingInventory);
    }
}
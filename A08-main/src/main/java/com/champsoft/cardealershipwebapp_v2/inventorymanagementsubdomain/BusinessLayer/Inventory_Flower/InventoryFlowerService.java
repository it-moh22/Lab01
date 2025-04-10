/* =====================================
   InventoryFlowerService.java
   ===================================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.BusinessLayer.Inventory_Flower;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerRequestModel;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerResponseModel;

import java.util.List;

public interface InventoryFlowerService {
    List<FlowerResponseModel> getFlowersInInventory(String inventoryId);
    FlowerResponseModel getInventoryFlowerById(String inventoryId, String flowerId);
    FlowerResponseModel addFlowerToInventory(String inventoryId, FlowerRequestModel flowerRequestModel);
    FlowerResponseModel updateFlowerInInventory(String inventoryId, String flowerId, FlowerRequestModel flowerRequestModel);
    void removeFlowerFromInventory(String inventoryId, String flowerId);
}

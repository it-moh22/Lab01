package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.BusinessLayer.Inventory;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Inventory.InventoryRequestModel;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Inventory.InventoryResponseModel;

import java.util.List;

public interface InventoryService {
    List<InventoryResponseModel> getInventories();
    InventoryResponseModel getInventoryById(String inventoryId);
    InventoryResponseModel addInventory(InventoryRequestModel inventoryRequestModel);
    InventoryResponseModel updateInventoryDetails(InventoryRequestModel inventoryRequestModel, String inventoryId);
    void deleteInventory(String inventoryId);
}

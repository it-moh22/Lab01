/* ===============================
   FlowerInventoryResponseMapper.java
   =============================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.Inventory_Flower;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Inventory.Inventory;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerResponseModel;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Inventory_Flower.InventoryFlowerResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlowerInventoryResponseMapper {

    @Mapping(expression = "java(inventory.getInventoryIdentifier().getInventoryId())", target = "inventoryId")
    @Mapping(expression = "java(flowers)", target = "availableFlowers")
    InventoryFlowerResponseModel entitiesToResponseModel(Inventory inventory, List<FlowerResponseModel> flowers);
}

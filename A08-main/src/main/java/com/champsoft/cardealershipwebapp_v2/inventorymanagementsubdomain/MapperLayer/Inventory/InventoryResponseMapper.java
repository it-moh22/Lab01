/* ==============================
   InventoryResponseMapper.java
   ============================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.Inventory;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Inventory.Inventory;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Inventory.InventoryResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryResponseMapper {

    @Mapping(expression = "java(inventory.getInventoryIdentifier().getInventoryId())", target = "inventoryId")
    InventoryResponseModel entityToResponseModel(Inventory inventory);

    List<InventoryResponseModel> entityListToResponseModelList(List<Inventory> inventories);
}

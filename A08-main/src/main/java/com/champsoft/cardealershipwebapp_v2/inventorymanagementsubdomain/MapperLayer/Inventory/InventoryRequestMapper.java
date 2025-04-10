/* =============================
   InventoryRequestMapper.java
   ============================= */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.Inventory;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Inventory.Inventory;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Inventory.InventoryRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "inventoryIdentifier", ignore = true)
    Inventory requestModelToEntity(InventoryRequestModel requestModel);
}

/* =====================================
   InventoryFlowerResponseModel.java
   ===================================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Inventory_Flower;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryFlowerResponseModel {
    private String inventoryId;
    private String type;
    private List<FlowerResponseModel> availableFlowers;
}

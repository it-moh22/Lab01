/* ===========================
   FlowerService.java
   =========================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.BusinessLayer.Flower;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerRequestModel;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerResponseModel;

import java.util.List;

public interface FlowerService {
    List<FlowerResponseModel> getAllFlowers();
    FlowerResponseModel getFlowerById(String flowerId);
    FlowerResponseModel addFlower(FlowerRequestModel flowerRequestModel);
    FlowerResponseModel updateFlower(String flowerId, FlowerRequestModel flowerRequestModel);
    void deleteFlower(String flowerId);
}

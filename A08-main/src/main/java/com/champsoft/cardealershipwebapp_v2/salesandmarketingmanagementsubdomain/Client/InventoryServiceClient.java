/* =======================================
   InventoryServiceClient.java
   ======================================= */
package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.Client;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerRequestModel;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerResponseModel;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryServiceClient {

    private final RestTemplate restTemplate;
    private final String INVENTORY_SERVICE_BASE_URL = "http://localhost:8080/api/v1/inventories";

    public InventoryServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FlowerResponseModel getFlowerByFlowerId(String inventoryId, String flowerId) {
        return restTemplate.getForObject(
                INVENTORY_SERVICE_BASE_URL + "/" + inventoryId + "/flowers/" + flowerId,
                FlowerResponseModel.class
        );
    }

    public void updateFlowerStatus(FlowerRequestModel flowerRequestModel, String inventoryId, String flowerId) {
        restTemplate.put(
                INVENTORY_SERVICE_BASE_URL + "/" + inventoryId + "/flowers/" + flowerId,
                flowerRequestModel
        );
    }
}

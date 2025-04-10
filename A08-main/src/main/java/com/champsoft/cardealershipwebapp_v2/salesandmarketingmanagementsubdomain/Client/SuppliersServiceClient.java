/* ========================================
   SuppliersServiceClient.java
   ======================================== */
package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.Client;

import com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.PresentationLayer.SupplierResponseModel;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SuppliersServiceClient {

    private final RestTemplate restTemplate;
    private final String SUPPLIER_SERVICE_BASE_URL = "http://localhost:8080/api/v1/suppliers";

    public SuppliersServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SupplierResponseModel getSupplierBySupplierId(String supplierId) {
        return restTemplate.getForObject(
                SUPPLIER_SERVICE_BASE_URL + "/" + supplierId,
                SupplierResponseModel.class
        );
    }
}

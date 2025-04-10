/* ===================================
   PurchaseOrderService.java
   =================================== */
package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.BusinessLayer;

import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.PresentationLayer.PurchaseRequestModel;
import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.PresentationLayer.PurchaseResponseModel;

import java.util.List;

public interface PurchaseOrderService {
    List<PurchaseResponseModel> getAllPurchaseOrders();
    PurchaseResponseModel getPurchaseOrderById(String purchaseId);
    PurchaseResponseModel addPurchaseOrder(PurchaseRequestModel requestModel);
    PurchaseResponseModel updatePurchaseOrder(String purchaseId, PurchaseRequestModel requestModel);
    void deletePurchaseOrder(String purchaseId);
}

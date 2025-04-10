package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.MapperLayer;


import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Purchase.PurchaseOrder;
import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.PresentationLayer.PurchaseResponseModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseOrderResponseModelMapper {

    @Mapping(target = "payment_currency",
            expression = "java(purchaseOrder.getPrice().getPayment_currency().toString())")
    @Mapping(target = "currecy",
            expression = "java(purchaseOrder.getPrice().getCurrency().toString())")
    @Mapping(target = "salePrice",
            expression = "java(purchaseOrder.getPrice().getAmount())")
    @Mapping(target = "vehicleIdentificationNumber",
            expression = "java(purchaseOrder.getFlowersIdentifier().getVin())")
    @Mapping(target = "purchaseOrderId",
            expression = "java(purchaseOrder.getPurchaseOrderIdentifier().getPurchaseId())")
    @Mapping(target = "inventoryId",
            expression = "java(purchaseOrder.getInventoryIdentifier().getInventoryId())")
    @Mapping(target = "employeeId",
            expression = "java(purchaseOrder.getSupplierIdentifier().getEmployeeId())")
    @Mapping(target = "customerId",
            expression = "java(purchaseOrder.getCustomerIdentifier().getCustomerId())")
    @Mapping(source = "salePurchaseStatus", target = "salePurchaseStatus")
    PurchaseResponseModel entityToResponseModel(PurchaseOrder purchaseOrder);


    List<PurchaseResponseModel> entityToResponseModelList(List<PurchaseOrder> purchaseOrders);
}


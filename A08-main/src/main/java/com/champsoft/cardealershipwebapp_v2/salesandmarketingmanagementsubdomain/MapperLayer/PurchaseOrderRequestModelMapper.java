package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.MapperLayer;

import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Purchase.PurchaseOrder;
import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.PresentationLayer.PurchaseRequestModel;
import org.mapstruct.*;
@Mapper(componentModel = "spring")
public interface PurchaseOrderRequestModelMapper {

    @Mapping(target = "id", ignore = true) // ID is usually auto-generated
    @Mapping(target = "flowerIdentifier.vin", source = "vehicleIdentificationNumber")
    @Mapping(target = "inventoryIdentifier.inventoryId", source = "inventoryId")
    @Mapping(target = "supplierIdentifier.employeeId", source = "employeeId")
    @Mapping(target = "customerIdentifier.customerId", source = "customerId")
    @Mapping(target = "price.amount", source = "salePrice")
    @Mapping(target = "price.currency", source = "currency")
    @Mapping(target = "price.payment_currency", source = "payment_currency")
    @Mapping(target = "saleOfferDate", source = "saleOfferDate")
    @Mapping(source = "salePurchaseStatus", target = "salePurchaseStatus")

    PurchaseOrder requestModelToEntity(PurchaseRequestModel purchaseRequestModel);
}



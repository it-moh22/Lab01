package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.PresentationLayer;


import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Purchase.FinancingAgreementDetails;
import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Purchase.PurchaseStatus;
import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Purchase.Warranty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PurchaseResponseModel {
    private String purchaseOrderId;
    private String inventoryId;
    private String vehicleIdentificationNumber;
    private String customerId;
    private String employeeId;

    private BigDecimal salePrice;
    private String currecy;           // e.g., "CAD"
    private String payment_currency;
    // e.g., "USD"
    private LocalDate saleOfferDate;
    private PurchaseStatus salePurchaseStatus;
    private FinancingAgreementDetails financingAgreementDetails;
    private Warranty warranty;
}


package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Purchase;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.UUID;

@Embeddable
@Getter
@Setter
public class PurchaseOrderIdentifier {

    private String purchaseId;

    public PurchaseOrderIdentifier() {
        this.purchaseId = UUID.randomUUID().toString();
    }

    public PurchaseOrderIdentifier(String id) {
        this.purchaseId = id;
    }

}


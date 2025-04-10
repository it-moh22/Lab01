package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Identifiers;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryIdentifier {
    private String inventoryId;
}

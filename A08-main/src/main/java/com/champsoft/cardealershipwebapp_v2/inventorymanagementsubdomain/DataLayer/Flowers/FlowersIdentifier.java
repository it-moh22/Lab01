/* =========================
   FlowersIdentifier.java
   ========================= */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowersIdentifier {

    private String flowerNumber;

    public void generateIfMissing() {
        if (this.flowerNumber == null || this.flowerNumber.isEmpty()) {
            // Prefix can stay as "VIN-" or you can change it to "FLOWER-"
            this.flowerNumber = "VIN-" + UUID.randomUUID().toString().substring(0, 13);
        }
    }
}

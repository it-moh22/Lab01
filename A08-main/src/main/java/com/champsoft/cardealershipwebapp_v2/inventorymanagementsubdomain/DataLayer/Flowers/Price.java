/* =============
   Price.java
   ============= */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers;

import com.champsoft.cardealershipwebapp_v2.utils.Currency;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private com.champsoft.cardealershipwebapp_v2.utils.Currency currency; // e.g., "CAD"

    @Enumerated(EnumType.STRING)
    private Currency payment_currency; // e.g., "USD"
}

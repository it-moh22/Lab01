package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Purchase;


import com.champsoft.cardealershipwebapp_v2.utils.Currency;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;         // e.g., "CAD"

    @Enumerated(EnumType.STRING)
    private Currency payment_currency; // e.g., "USD"
}


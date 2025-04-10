/* =============
   Option.java
   ============= */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Option {
    private String name;
    private String description;
    private BigDecimal price;
}

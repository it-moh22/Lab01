/* =============
   Address.java
   ============= */
package com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.DataLayer;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Address {
    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;
}

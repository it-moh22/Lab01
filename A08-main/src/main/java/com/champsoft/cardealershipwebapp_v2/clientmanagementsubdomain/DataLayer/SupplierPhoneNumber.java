/* ============================
   SupplierPhoneNumber.java
   ============================ */
package com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.DataLayer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class SupplierPhoneNumber {

    @Enumerated(EnumType.STRING)
    @Column(name = "phone_type")
    private PhoneType type;

    @Column(name = "phone_number")
    private String number;
}

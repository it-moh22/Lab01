/* ==============================
   SupplierRequestModel.java
   ============================== */
package com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.PresentationLayer;

import com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.DataLayer.SupplierPhoneNumber;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SupplierRequestModel {

    private String supplierId;
    private String companyName;
    private String contactPerson;
    private String emailAddress;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;
    private String username;
    private String password1;
    private String password2;
    private List<SupplierPhoneNumber> phoneNumbers;
}

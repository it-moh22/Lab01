/* ==============================
   SupplierResponseModel.java
   ============================== */
package com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.PresentationLayer;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SupplierResponseModel {

    private String supplierId;
    private String companyName;
    private String contactPerson;
    private String emailAddress;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;
    private List<PhoneNumberDTO> phoneNumbers;
}

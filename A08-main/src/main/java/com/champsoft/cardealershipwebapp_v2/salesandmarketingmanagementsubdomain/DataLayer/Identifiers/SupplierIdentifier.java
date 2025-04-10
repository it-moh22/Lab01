package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Identifiers;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierIdentifier {
    private String employeeId;
}

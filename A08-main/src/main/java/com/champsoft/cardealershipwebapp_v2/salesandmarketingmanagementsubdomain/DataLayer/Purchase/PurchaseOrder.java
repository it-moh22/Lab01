package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Purchase;


import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Identifiers.CustomerIdentifier;
import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Identifiers.SupplierIdentifier;
import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Identifiers.InventoryIdentifier;
import com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Identifiers.FlowerIdentifier;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "purchaseId", column = @Column(name = "purchase_id", nullable = false))
    })
    private PurchaseOrderIdentifier purchaseOrderIdentifier = new PurchaseOrderIdentifier();


    @Enumerated(EnumType.STRING)
    @Column(name = "sale_status")
    private PurchaseStatus salePurchaseStatus;

    @Embedded
    private FinancingAgreementDetails financingAgreementDetails;

    private LocalDate saleOfferDate;

    @Embedded
    private Price price = new Price();

    @Embedded
    private Warranty warranty;

    @Embedded
    private InventoryIdentifier inventoryIdentifier;

    @Embedded
    private FlowerIdentifier flowerIdentifier = new FlowerIdentifier();

    @Embedded
    private CustomerIdentifier customerIdentifier;

    @Embedded
    private SupplierIdentifier supplierIdentifier;

}


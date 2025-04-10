/* ================
   Flower.java
   ================ */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Inventory.InventoryIdentifier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "flowers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private FlowersIdentifier flowersIdentifier;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "inventoryId", column = @Column(name = "inventory_id"))
    })
    private InventoryIdentifier inventoryIdentifier;

    @Enumerated(EnumType.STRING)
    @Column(name = "flower_status")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "usage_type")
    private UsageType usageType;

    @Column(name = "flower_year")
    private int flowerYear;

    private String manufacturer;
    private String make;
    private String model;

    @Column(name = "body_class")
    private String bodyClass;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "flower_options", joinColumns = @JoinColumn(name = "flower_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "option_name")),
            @AttributeOverride(name = "description", column = @Column(name = "option_description")),
            @AttributeOverride(name = "price", column = @Column(name = "option_price"))
    })
    private List<Option> options;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency")),
            @AttributeOverride(name = "payment_currency", column = @Column(name = "price_payment_currency"))
    })
    private Price price;

    @PrePersist
    public void ensureFlowerNumberExists() {
        if (this.flowersIdentifier == null) {
            this.flowersIdentifier = new FlowersIdentifier();
        }
        this.flowersIdentifier.generateIfMissing();
    }
}

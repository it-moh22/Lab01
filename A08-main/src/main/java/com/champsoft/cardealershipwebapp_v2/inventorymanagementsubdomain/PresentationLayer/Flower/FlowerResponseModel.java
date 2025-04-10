/* ===========================
   FlowerResponseModel.java
   =========================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.OptionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerResponseModel {
    private String flowerId;
    private String inventoryId;
    private String flowerStatus;
    private String usageType;
    private int flowerYear;
    private String manufacturer;
    private String make;
    private String model;
    private String bodyClass;
    private BigDecimal price;
    private String currency;
    private List<OptionDto> options;
}

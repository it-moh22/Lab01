/* ============================
   FlowerResponseMapper.java
   ============================ */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.Flower;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers.Flower;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.OptionMapper;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.PriceMapper;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OptionMapper.class, PriceMapper.class})
public interface FlowerResponseMapper {

    @Mapping(source = "flowersIdentifier.flowerNumber", target = "flowerId")
    @Mapping(source = "inventoryIdentifier.inventoryId", target = "inventoryId")
    @Mapping(source = "status", target = "flowerStatus")
    @Mapping(source = "usageType", target = "usageType")
    @Mapping(source = "manufacturer", target = "manufacturer")
    @Mapping(source = "make", target = "make")
    @Mapping(source = "model", target = "model")
    @Mapping(source = "bodyClass", target = "bodyClass")
    @Mapping(source = "flowerYear", target = "flowerYear")
    @Mapping(source = "options", target = "options", qualifiedByName = "entityListToDtoList")
    @Mapping(source = "price", target = "price", qualifiedByName = "priceToBigDecimal")
    @Mapping(source = "price.currency", target = "currency")
    FlowerResponseModel entityToResponseModel(Flower flower);

    List<FlowerResponseModel> entityListToResponseModelList(List<Flower> flowers);
}

/* ===========================
   FlowerRequestMapper.java
   =========================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.Flower;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers.Flower;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.OptionMapper;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer.PriceMapper;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.Flower.FlowerRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OptionMapper.class, PriceMapper.class})
public interface FlowerRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "flowersIdentifier.flowerNumber", source = "flowerId")
    @Mapping(target = "inventoryIdentifier.inventoryId", source = "inventoryId")
    @Mapping(source = "options", target = "options", qualifiedByName = "dtoListToEntityList")
    @Mapping(source = "price", target = "price", qualifiedByName = "bigDecimalToPrice")
    @Mapping(target = "status", source = "flowerStatus")
    @Mapping(target = "usageType", source = "usageType")
    @Mapping(target = "flowerYear", source = "flowerYear")
    @Mapping(target = "manufacturer", source = "manufacturer")
    @Mapping(target = "make", source = "make")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "bodyClass", source = "bodyClass")
    Flower requestModelToEntity(FlowerRequestModel flowerRequestModel);
}

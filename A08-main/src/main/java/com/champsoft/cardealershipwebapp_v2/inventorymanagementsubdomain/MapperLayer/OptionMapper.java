/* ======================
   OptionMapper.java
   ====================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers.Option;
import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.PresentationLayer.OptionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OptionMapper {

    @Named("entityToDto")
    OptionDto entityToDto(Option option);

    @Named("entityListToDtoList")
    List<OptionDto> entityListToDtoList(List<Option> options);

    @Named("dtoToEntity")
    Option dtoToEntity(OptionDto optionDto);

    @Named("dtoListToEntityList")
    List<Option> dtoListToEntityList(List<OptionDto> optionDtos);
}

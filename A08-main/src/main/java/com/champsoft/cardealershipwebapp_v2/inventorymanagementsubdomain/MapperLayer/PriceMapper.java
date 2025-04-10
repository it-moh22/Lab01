/* ======================
   PriceMapper.java
   ====================== */
package com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.MapperLayer;

import com.champsoft.cardealershipwebapp_v2.inventorymanagementsubdomain.DataLayer.Flowers.Price;
import com.champsoft.cardealershipwebapp_v2.utils.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Named("priceToBigDecimal")
    default BigDecimal priceToBigDecimal(Price price) {
        return (price != null) ? price.getAmount() : null;
    }

    @Named("bigDecimalToPrice")
    default Price bigDecimalToPrice(BigDecimal amount) {
        if (amount == null) {
            return null;
        }
        return new Price(
                amount,
                Currency.USD,
                Currency.USD
        );
    }
}

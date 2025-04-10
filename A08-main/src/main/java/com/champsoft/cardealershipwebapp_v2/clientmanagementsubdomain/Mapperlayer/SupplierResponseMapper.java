/* ==============================
   SupplierResponseMapper.java
   ============================== */
package com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.Mapperlayer;

import com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.DataLayer.Supplier;
import com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.DataLayer.SupplierPhoneNumber;
import com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.PresentationLayer.SupplierResponseModel;
import com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.PresentationLayer.PhoneNumberDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierResponseMapper {

    @Mapping(target = "supplierId",
            expression = "java(supplier.getSupplierIdentifier() != null ? supplier.getSupplierIdentifier() : null)")
    @Mapping(target = "companyName",
            expression = "java(supplier.getCompanyName() != null ? supplier.getCompanyName() : null)")
    @Mapping(target = "contactPerson",
            expression = "java(supplier.getContactPerson() != null ? supplier.getContactPerson() : null)")
    @Mapping(target = "emailAddress",
            expression = "java(supplier.getEmailAddress() != null ? supplier.getEmailAddress() : null)")
    @Mapping(target = "streetAddress",
            expression = "java(supplier.getAddress() != null ? supplier.getAddress().getStreetAddress() : null)")
    @Mapping(target = "province",
            expression = "java(supplier.getAddress() != null ? supplier.getAddress().getProvince() : null)")
    @Mapping(target = "postalCode",
            expression = "java(supplier.getAddress() != null ? supplier.getAddress().getPostalCode() : null)")
    @Mapping(target = "city",
            expression = "java(supplier.getAddress() != null ? supplier.getAddress().getCity() : null)")
    @Mapping(target = "phoneNumbers", source = "phoneNumbers")
    SupplierResponseModel entityToResponseModel(Supplier supplier);

    List<SupplierResponseModel> entityListToResponseModelList(List<Supplier> suppliers);

    @Mapping(target = "type", expression = "java(phoneNumber != null ? phoneNumber.getType().toString() : null)")
    @Mapping(target = "number", source = "number")
    PhoneNumberDTO phoneNumberToDto(SupplierPhoneNumber phoneNumber);

    List<PhoneNumberDTO> phoneNumberListToDtoList(List<SupplierPhoneNumber> phoneNumbers);
}

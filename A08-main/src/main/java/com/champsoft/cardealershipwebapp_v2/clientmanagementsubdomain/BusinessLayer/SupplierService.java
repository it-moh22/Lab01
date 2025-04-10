package com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.BusinessLayer;

import com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.PresentationLayer.SupplierRequestModel;
import com.champsoft.cardealershipwebapp_v2.clientmanagementsubdomain.PresentationLayer.SupplierResponseModel;

import java.util.List;

public interface SupplierService {
    List<SupplierResponseModel> getSuppliers();

    SupplierResponseModel getSupplierBySupplierId(String supplierId);

    SupplierResponseModel addSupplier(SupplierRequestModel newSupplierData);

    SupplierResponseModel updateSupplier(String supplierId, SupplierRequestModel newSupplierData);

    String deleteSupplierBySupplierId(String supplierId);
}

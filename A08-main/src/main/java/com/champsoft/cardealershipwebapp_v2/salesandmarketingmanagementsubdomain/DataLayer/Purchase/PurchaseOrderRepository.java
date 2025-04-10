package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Purchase;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {
    PurchaseOrder findPurchaseOrderByPurchaseOrderIdentifierPurchaseId(String purchaseId);
}


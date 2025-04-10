package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.DataLayer.Purchase;


import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancingAgreementDetails {
    private Integer numberOfMonthlyPayments;
    private Double monthlyPaymentAmount;
    private Double downPaymentAmount;
}


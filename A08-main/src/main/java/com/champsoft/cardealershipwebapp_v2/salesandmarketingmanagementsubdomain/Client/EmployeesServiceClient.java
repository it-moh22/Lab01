/* ======================================
   EmployeesServiceClient.java
   ====================================== */
package com.champsoft.cardealershipwebapp_v2.salesandmarketingmanagementsubdomain.Client;

import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.PresentationLayer.EmployeeResponseModel;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmployeesServiceClient {

    private final RestTemplate restTemplate;
    private final String EMPLOYEE_SERVICE_BASE_URL = "http://localhost:8080/api/v1/employees";

    public EmployeesServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmployeeResponseModel getEmployeeByEmployeeId(String employeeId) {
        return restTemplate.getForObject(
                EMPLOYEE_SERVICE_BASE_URL + "/" + employeeId,
                EmployeeResponseModel.class
        );
    }
}

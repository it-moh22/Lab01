package com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.BusniessLayer;

import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.PresentationLayer.EmployeeRequestModel;
import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.PresentationLayer.EmployeeResponseModel;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseModel> getAllEmployees();
    EmployeeResponseModel getEmployeeById(String employeeId);
    EmployeeResponseModel addEmployee(EmployeeRequestModel employee);
    EmployeeResponseModel updateEmployee(String employeeId, EmployeeRequestModel employee);
    String deleteEmployee(String employeeId);
}

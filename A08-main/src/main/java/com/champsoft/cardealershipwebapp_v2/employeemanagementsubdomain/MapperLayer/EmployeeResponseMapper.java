package com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.MapperLayer;

import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.DataLayer.Employee;
import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.PresentationLayer.EmployeeResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeResponseMapper {
    EmployeeResponseModel entityToResponseModel(Employee employee);
    List<EmployeeResponseModel> entityListToResponseModelList(List<Employee> employees);
}

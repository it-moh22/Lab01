package com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.MapperLayer;

import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.DataLayer.Employee;
import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.PresentationLayer.EmployeeRequestModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeRequestMapper {
    Employee requestModelToEntity(EmployeeRequestModel employeeRequestModel);
}

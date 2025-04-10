package com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.BusniessLayer;

import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.DataLayer.Employee;
import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.DataLayer.EmployeeRepository;
import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.MapperLayer.EmployeeRequestMapper;
import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.MapperLayer.EmployeeResponseMapper;
import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.PresentationLayer.EmployeeRequestModel;
import com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.PresentationLayer.EmployeeResponseModel;
import com.champsoft.cardealershipwebapp_v2.utils.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeResponseMapper employeeResponseMapper;
    private final EmployeeRequestMapper employeeRequestMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeResponseMapper employeeResponseMapper,
                               EmployeeRequestMapper employeeRequestMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeResponseMapper = employeeResponseMapper;
        this.employeeRequestMapper = employeeRequestMapper;
    }

    @Override
    public List<EmployeeResponseModel> getAllEmployees() {
        return employeeResponseMapper.entityListToResponseModelList(employeeRepository.findAll());
    }

    @Override
    public EmployeeResponseModel getEmployeeById(String employeeIdentifier) {
        log.info("Fetching employee with ID: {}", employeeIdentifier);
        Optional<Employee> employeeOpt = employeeRepository.findByEmployeeIdentifier(employeeIdentifier);
        if (employeeOpt.isEmpty()) {
            log.error("Employee with ID {} not found.", employeeIdentifier);
            throw new NotFoundException("Employee with ID " + employeeIdentifier + " not found.");
        }
        return employeeResponseMapper.entityToResponseModel(employeeOpt.get());
    }

    @Override
    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequest) {
        Employee employee = employeeRequestMapper.requestModelToEntity(employeeRequest);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeResponseMapper.entityToResponseModel(savedEmployee);
    }

    @Override
    public EmployeeResponseModel updateEmployee(String employeeId, EmployeeRequestModel updatedEmployee) {
        Optional<Employee> existingEmployeeOpt = employeeRepository.findByEmployeeIdentifier(employeeId);
        if (existingEmployeeOpt.isEmpty()) {
            log.error("Employee with ID {} not found.", employeeId);
            throw new NotFoundException("Employee with ID " + employeeId + " not found.");
        }

        Employee existingEmployee = existingEmployeeOpt.get();
        Employee employee = employeeRequestMapper.requestModelToEntity(updatedEmployee);
        employee.setId(existingEmployee.getId());
        employee.setEmployeeIdentifier(employeeId);

        Employee savedEmployee = employeeRepository.save(employee);
        return employeeResponseMapper.entityToResponseModel(savedEmployee);
    }

    @Override
    public String deleteEmployee(String employeeId) {
        Optional<Employee> employeeOpt = employeeRepository.findByEmployeeIdentifier(employeeId);
        if (employeeOpt.isEmpty()) {
            log.error("Employee with ID {} not found.", employeeId);
            throw new NotFoundException("Employee with ID " + employeeId + " not found.");
        }
        employeeRepository.delete(employeeOpt.get());
        return "Employee with ID " + employeeId + " deleted successfully.";
    }
}

package com.champsoft.cardealershipwebapp_v2.employeemanagementsubdomain.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
}

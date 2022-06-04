package com.transaction.service;

import com.transaction.VO.EmployeeRequestVO;
import com.transaction.entity.Department;
import com.transaction.entity.Employee;
import com.transaction.repository.DepartmentRepository;
import com.transaction.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional 
    public String saveEmployee(EmployeeRequestVO employeeRequestVO) {

        Department department = new Department();
        department.setDepartmentName(employeeRequestVO.getDepartmentName());
        department.setDepartmentCode(employeeRequestVO.getDepartmentName());

//        departmentRepository.save(department);

        Long departmentId = departmentRepository.save(department).getDepartmentId();

//        Employee employee = new Employee();
        Employee employee = null;

        employee.setEmpName(employeeRequestVO.getEmpName());
        employee.setEmail(employeeRequestVO.getEmail());
        employee.setDepartmentId(departmentId);

        employeeRepository.save(employee);

        return "Employee is saved with Employee ID : " + employee.getEmployeeId();
    }
}

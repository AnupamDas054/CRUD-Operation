package com.example.employeemanagement.management.controller;

import com.example.employeemanagement.management.Employee;
import com.example.employeemanagement.management.service.EmployeeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeManagementService employeeService;

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public  Employee getEmployee(@PathVariable String id)
    {
        return  employeeService.getEmployee(id);
    }

    @RequestMapping( method = RequestMethod.POST,value = "/employees")
    public String addEmployee(@RequestBody Employee employee)
    {
        employeeService.addEmployee(employee);
        return "Successfully Added";
    }

    @RequestMapping( method = RequestMethod.PUT, value = "/employees/{id}")
    public String updateEmployee(@RequestBody Employee employee , @PathVariable String id)
    {
        employeeService.updateEmployee(employee,id);
        return "Successfully Updated";
    }

    @RequestMapping( method = RequestMethod.DELETE, value = "/employees/{id}" )
    public String deleteEmployee( @PathVariable String id)
    {
        employeeService.deleteEmployee(id);
        return "Successfully Deleted";
    }

}

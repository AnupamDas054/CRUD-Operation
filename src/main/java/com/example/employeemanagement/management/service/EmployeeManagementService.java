package com.example.employeemanagement.management.service;
import com.example.employeemanagement.management.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeManagementService {
        private List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("2","Tamim","Trainee",34),
                new Employee("23","Mushfiq","Trainee",35),
                new Employee("46","Sakib","Permanent",34)
        ));

        public List<Employee> getAllEmployees()
        {
            return employees;
        }

        public Employee getEmployee(String id){
            try{
                Employee em = employees.stream().filter(e -> e.getId().equals(id)).findFirst().get();
                return em;
            }
            catch (RuntimeException r)
            {
                System.out.println("This id is not present");
                return null;
            }

        }

        public void addEmployee(Employee employee) {
            employees.add(employee);
        }

        public void updateEmployee(Employee employee, String id) {
                boolean flag=true;
                for (int i = 0; i < employees.size(); i++) {
                    Employee e = employees.get(i);
                    if (e.getId().equals(id)) {
                        employees.set(i, employee);
                        flag=false;
                    }
                }
                if(flag==true) throw new RuntimeException("Id not found");
        }

        public void deleteEmployee(String id) {
            boolean flag=true;
            for (int i = 0; i < employees.size(); i++) {
                Employee e = employees.get(i);
                if (e.getId().equals(id)) {
                    employees.remove(e);
                    flag=false;
                }
            }
            if(flag==true) throw new RuntimeException("Id not found");
               /* employees.removeIf(e -> e.getId().equals(id));
                return;*/
        }
}

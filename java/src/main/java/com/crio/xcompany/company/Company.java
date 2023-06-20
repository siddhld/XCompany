package com.crio.xcompany.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Company {
    private String companyName;
    private Employee founder;
    private Map<Employee, List<Employee>> empManager;
    private Map<String, Employee> employeeBook;


    private Company(String companyName, Employee founder) {
        this.companyName = companyName;
        this.founder = founder;
        employeeBook = new HashMap<String, Employee>();
        empManager = new HashMap<>();
        employeeBook.put(founder.getName(), founder);
    }


    public static Company create(String companyName, Employee founder) {
        return new Company(companyName, founder);
    }


    public String getCompanyName() {
        return companyName;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone
    // for each functionality before implementing the logic.
    // This will ensure that the project can be compiled successfully.

    public void registerEmployee(String employeeName, Gender valueOf) {
        Employee employee = new Employee(employeeName, valueOf);
        employeeBook.put(employee.getName(), employee);
    }


    public void assignManager(String employeeName, String managerName) {
        Employee employee = getEmployee(employeeName);
        Employee manager = getEmployee(managerName);
        employee.assignManager(manager);
    }


    public List<Employee> getDirectReports(String managerName) {
        Employee employee = getEmployee(managerName);
        return employee.getDirectReportees();
    }


    public void deleteEmployee(String employeeName) {
        employeeBook.remove(employeeName);
    }


    // Debug this one
    public List<List<Employee>> getEmployeeHierarchy(String managerName) {

        List<List<Employee>> employeeHierarchy = new ArrayList();
        Queue<Employee> empQ = new LinkedList();

        empQ.add(getEmployee(managerName));

        while(!empQ.isEmpty()){
            List<Employee> employees = new ArrayList();  
            int len = empQ.size();

            while(len != 0){
                Employee emp = empQ.remove();
                employees.add(emp);
                for (Employee e : emp.getDirectReportees()) {
                    empQ.add(e);
                }
                len--;
            }
            employeeHierarchy.add(employees);   
        }
        return employeeHierarchy;
    }


    public Employee getEmployee(String employeeName) {
        if (employeeBook.containsKey(employeeName))
            return employeeBook.get(employeeName);
        return null;
    }


    public List<Employee> getTeamMates(String employeeName) {
        Employee employee = getEmployee(employeeName);
        return employee.getTeamMates();
    }

}

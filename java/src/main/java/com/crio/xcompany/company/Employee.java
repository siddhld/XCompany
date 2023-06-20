package com.crio.xcompany.company;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private Gender gender;
    private List<Employee> directReportees; 
    private List<Employee> teamMates;


    public Employee(String name, Gender gender) {
        this.name = name; 
        this.gender = gender;
        this.directReportees = new ArrayList<>();
        this.teamMates = new ArrayList<>(); 
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    // TODO: CRIO_TASK_MODULE_XCOMPANY
    // Please define all the methods required here as mentioned in the XCompany BuildOut Milestone before implementing the logic.
    // This will ensure that the project can be compiled successfully.

    
    public List<Employee> getDirectReportees() {
        return directReportees;
    }
    
    public List<Employee> getTeamMates(){
        return teamMates;
    }
    
    // Debug this one
    public void assignManager(Employee employee)
    {
        // Debugging
        // System.err.println("Employee  --> "+this.toString());
        // System.err.println("Manager  --> "+employee.toString());
        // System.out.println();
        
        // this --> reffering to this current Object (The object through this method is called)

        // Adding (this current employee) to the employee manager's directReportees 
       employee.directReportees.add(this);
       // Adding the employee manager as a team mate in this (this current employee)
       this.teamMates.add(employee);
       // Adding the employee manager's directReportees as a team mate in this (this current employee)
       this.teamMates.addAll(employee.directReportees);
       
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", gender=" + gender + "]";
    }   
}

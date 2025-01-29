/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act7_1A;

import java.util.ArrayList;

/**
 *
 * @author Richard
 */
public class Manager extends Employee {
    private String deptName;
    private ArrayList<Employee> staff;

    public Manager(String deptName, int empId, String name, String ssn, double salary) {
        super(empId, name, ssn, salary);
        this.deptName = deptName;
        this.staff = new ArrayList<>();
    }
    
    public String getDeptName() {
        return deptName;
    }
    
    public boolean addEmployee(Employee e) {
        for (Employee s : this.staff)
            if (s.equals(e.getName()))
                return false;
            else {
                this.staff.add(e);
                return true;
            }
    }
    
    public boolean removeEmployee(Employee e){
        return this.staff.remove(e);
    }
    
    public getEmployees() {
        
    }
    
    public String printManager() {
        return super.printEmployee() + "Departamento " + deptName;
    }   
}
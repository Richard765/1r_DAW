/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act7_1A;

/**
 *
 * @author Richard
 */
public class Director extends Manager {
    private double budget;

    public Director(int empId, String name, String ssn, double salary, String deptName, double budget) {
        super(empId, name, ssn, salary, deptName);
        this.budget = budget;
    }
    
    public double getBudget() {
        return budget;
    }
    
    public String printDirector(){
        return super.printEmployee();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT11_2B;

/**
 *
 * @author Richard
 */
public class Employee {
    private int employeeId;
    private String lastName;
    private String firstName;
    private String email;
    private int departmentId;
    
    //Constructor
    public Employee(int employeeId, String lastName, String firstName, String email, int departmentId) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.departmentId = departmentId;
    }

    //Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public int getDepartmentId() {
        return departmentId;
    }
    
    

}

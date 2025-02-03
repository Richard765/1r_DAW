package act7_1C;

import java.util.Objects;

/**
 *
 * @author Administrador
 */
public class Employee {
    private int empId;
    private String name;
    private String jobTitle;
    private String level;
    //
    private static int employeeIdCounter=0;

    public Employee(String name, String jobTitle, String level) {
        this.empId = this.calculateEmployeeId();
        this.name = name;
        this.jobTitle = jobTitle;
        this.level = level;
    }
    
    public int calculateEmployeeId() {
        return Employee.employeeIdCounter++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        final Employee e = (Employee) o;
        return Objects.equals(this.name, e.name);
    }
    
    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", name=" + name + ", jobTitle=" + jobTitle + ", level=" + level + '}';
    }
}
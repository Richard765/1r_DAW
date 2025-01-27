package act7_1A;

public class Employee {
    private int empId;
    private String name;
    private String ssn;
    private double salary;
    
    public Employee(int empId, String name, String ssn, double salary) {
        /*this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;*/
        
        this.setEmpId(empId);
    }

    public void setName(String name) {
        
        this.name = name;
    }

    public void raiseSalary(double increase) {
        this.salary += increase;
    }

    public String printEmployee() {
        return "ID: " + empId + ", Name: " + name + ", SSN: " + ssn + ", Salary: " + salary;
    }   
}

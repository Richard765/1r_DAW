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
        this.setName(name);
        this.setSsn(ssn);
        this.setSalary(salary);
    }

    public void raiseSalary(double increase) {
        if (increase > 0)
            //this.salary += increase;
            setSalary(this.salary + increase);
    }
    
    public int getEmpId() {
        return empId;
    }
    
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (! (name.equals("") | name == null))
            this.name = name;
    }
    
    public double getsalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String getSsn() {
        return ssn;
    }
    
    public String setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    public String printEmployee() {
        return "ID: " + empId + ", Name: " + name + ", SSN: " + ssn + ", Salary: " + salary;
    }   
    
    public int calculateEmployeeId(){
        
    }
    
    public String toString() {
        
    }
    
    public boolean equals() {
        
    }
}

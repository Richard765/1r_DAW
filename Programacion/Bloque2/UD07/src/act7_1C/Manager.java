package act7_1C;

import java.util.ArrayList;

class Manager extends Employee {
    private ArrayList<Employee> employeeList;

    public Manager(String name, String jobTitle, String level) {
        super(name,jobTitle, level);
        this.employeeList = new ArrayList<>();
    }
    
    public ArrayList getEmployees() {
        return this.employeeList;
    }
    
    public boolean addEmployee(Employee e) {  // setEmployee()
        if (this.employeeList.contains(e))
            return false;
        else {
            this.employeeList.add(e);
            return true;
        }
    }
    
    public boolean removeEmployee(Employee e) {
        return this.employeeList.remove(e);
    }
    
    @Override
    public String toString() {
        String text = "Manager {" + super.toString() + ", Employee List=";
        for (Employee e : this.employeeList)
            text = text + "\n\t" + e.toString();
        return text + "}";
    }
    
}
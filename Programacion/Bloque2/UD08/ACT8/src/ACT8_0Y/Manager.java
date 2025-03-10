package ACT8_0Y;

public class Manager extends Employee {
    public String deptName;

    public Manager(String name, String deptName) {
        super(name);
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }
    
    /**
     * gets details about a Manager
     * @return String
     */
    public String getDetails() {
        return super.getName() + " " + this.deptName;
    }
}

package ACT11_2C;

public class Department implements Comparable<Department> {
    private int departmentId;
    private String departmentName;

    public Department(int department_id, String departmentName) throws IllegalArgumentException  {
        setDepartmentId(department_id);
        setDepartmentName(departmentName);
    }
    
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) throws IllegalArgumentException {
        if (departmentName == null)
            throw new IllegalArgumentException ("Department name incorrecte");
        else
            this.departmentName = departmentName;
    }
    
    @Override
    public int compareTo(Department other) {
        return Integer.compare(this.departmentId, other.departmentId); // Ordenar per ID
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.departmentId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Department other = (Department) obj;
        return this.departmentId == other.departmentId;
    }
    
    @Override
    public String toString() {
        return "Department{" + "department_id=" + departmentId + ", departmentName=" + departmentName + '}';
    }
    
}

package ACT11_2C;

public class Employee implements Comparable<Employee> {
    private int employeeId;
    private String lastName;
    private String firstName;
    private String email;
    private int departmentId;

    public Employee(int employeeId, String last_name, String first_name, String email, int department_id) throws IllegalArgumentException {
        setEmployeeId(employeeId);
        setLastName(last_name);
        setFirstName(first_name);
        setEmail(email);
        setDepartmentId(department_id);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null)
            throw new IllegalArgumentException ("Last name incorrecte");
        else
            this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null)
            throw new IllegalArgumentException ("First name incorrecte");
        else
            this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if ((email == null) || (!(email.matches("^[a-zA-Z0-9\\._%+-]+@[a-zA-Z0-9\\.-]+\\.[a-zA-Z]{2,}$"))))  // en comptes de: email.contains("@")
            throw new IllegalArgumentException ("Email incorrecte");
        else
            this.email = email;
                
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.employeeId;
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
        final Employee other = (Employee) obj;
        return this.employeeId == other.employeeId;
    }
    
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.employeeId, other.employeeId); // Ordenar per ID
    }
    
    @Override
    public String toString() {
        return "Persona{" + "id=" + employeeId + ", last_name=" + lastName + ", first_name=" + firstName + ", email=" + email + ", departmentId=" + departmentId + '}';
    }
    
}

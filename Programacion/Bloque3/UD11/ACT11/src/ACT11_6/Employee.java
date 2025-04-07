package ACT11_6;

import java.io.Serializable;

/**
 *
 * @author winadmin
 */
public class Employee implements Serializable {
        private int employeeId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String hireDate;
        private String jobTitle;
        private double salary;
        private double comissionPct;
        private String departmentName;

        public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobTitle, double salary, double comissionPct, String departmentName) {
            this.employeeId = employeeId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.hireDate = hireDate;
            this.jobTitle = jobTitle;
            this.salary = salary;
            this.comissionPct = comissionPct;
            this.departmentName = departmentName;
        }

    @Override
    public String toString() {
        return "Employee{" + "employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobTitle=" + jobTitle + ", salary=" + salary + ", comissionPct=" + comissionPct + ", departmentName=" + departmentName + '}';
    }

}

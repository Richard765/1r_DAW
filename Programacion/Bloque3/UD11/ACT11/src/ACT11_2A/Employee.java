package ACT11_2A;

/**
 *
 * @author Administrador
 */
public class Employee {
    private int id;
    private String lastName;
    private String firstName;
    private String email;

    public Employee(int id, String last_name, String first_name, String email) throws IllegalArgumentException {
        setId(id);
        setLastName(last_name);
        setFirstName(first_name);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null || lastName.isBlank())
            throw new IllegalArgumentException ("Last name incorrecte");
        else
            this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null || firstName.isBlank())
            throw new IllegalArgumentException ("First name incorrecte");
        else
            this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if (email == null || email.isBlank() || !email.matches("^[a-zA-Z0-9\\._%+-]+@[a-zA-Z0-9\\.-]+\\.[a-zA-Z]{2,}$"))  // en comptes de: email.contains("@")
            throw new IllegalArgumentException ("Email incorrecte");
        else
            this.email = email;
                
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", last_name=" + lastName + ", first_name=" + firstName + ", email=" + email + '}';
    }
    
}

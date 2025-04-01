package ACT11_2A;


/**
 *
 * @author Richard
 */
public class Persona {
    private int id;
    private String lastName;
    private String firstName;
    private String email;

    public Persona(int id, String last_name, String first_name, String email) throws Exception {
        setId(id);
        setLastName(last_name);
        setFirstName(first_name);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if (firstName == null)
            throw new Exception ("Id incorrecte");
        else
            this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if ((lastName == null) | (lastName.equals("")))
            throw new Exception ("Last name incorrecte");
        else
            this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        if ((firstName == null) | (firstName.equals("")))
            throw new Exception ("First name incorrecte");
        else
            this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (email == null || !email.contains("@"))
            throw new Exception ("Email incorrecte");
        else
            this.email = email;
                
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", last_name=" + lastName + ", first_name=" + firstName + ", email=" + email + '}';
    }
    
}
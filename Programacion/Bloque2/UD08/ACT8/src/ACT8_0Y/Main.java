package ACT8_0Y;

/** Exemple de polimorfisme
 *
 * @author winadmin
 */
public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("Pérez");
        Manager m1 = new Manager("Sanchez","Sistemes");
        Employee e2 = new Manager("Vives","Informàtica");
        Employee e3 = (Employee) e2;
        Employee e4 = (Manager) e1;
        // Manager m2 = new Employee("Marcus"); --> Error de compilació
        
        System.out.println(e1.getDetails());  // un 'Employee' que es comporta com a un 'Employee'
        System.out.println(m1.getDetails());  // un 'Manager' que es comporta com a un 'Manager';
        System.out.println(e2.getDetails());  // un 'Employee' que es comporta com a un 'Manager'
        System.out.println(e3.getDetails());  // un 'Employee' que es comporta com a un 'Manager'
        System.out.println(e4.getDetails());  // un 'Employee' que es comporta com a un 'Manager' però al que falten dades --> error d'execució
    }
    
}

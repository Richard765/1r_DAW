package ACT11_2A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws Exception {
        String arxiu = "C:\\temp\\ACT11_2A.cvs";
        Map<Integer, Employee> employees;

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
            ) {
            
            // Llegir el contingut línia a línia
            employees = LlegeixArxiu(bufferedReader);
            
            // Mostrar el map
            MostraEmployees(employees);

        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    
    private static Map<Integer,Employee> LlegeixArxiu(BufferedReader bufferedReader) throws IOException, Exception {
        Map<Integer,Employee> employees = new HashMap<>();
        String linea;
        String[] parts;
        Integer clau;
        Employee employee;
        
        while ((linea = bufferedReader.readLine()) != null) {
            try {
                // format: xxxx; yyyy; zzzz; ...
                if (!(linea.isEmpty() || linea.startsWith("#"))) {
                    parts = linea.split(";");
                    if (!linea.substring(0, 1).equals("#")) {
                        clau = Integer.valueOf(parts[0].trim());
                        employee = new Employee(Integer.parseInt(parts[0]), parts[1].trim(), parts[2].trim(), parts[3].trim());
                        employees.put(clau, employee);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error carregant Employee: " + e.getMessage());
            }
        }
        return employees;
    }

    private static void MostraEmployees(Map<Integer,Employee> employees) {
        for (Integer k : employees.keySet()) {
            Employee v = employees.get(k);
            System.out.println(k + " = " + v);
        }
    }

}


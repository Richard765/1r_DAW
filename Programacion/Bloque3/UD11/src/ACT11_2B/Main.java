/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT11_2B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Richard
 */
public class Main {
    public static void main(String[] args) {
        String arxiu1 = "C:\\Users\\Richard\\Desktop\\1r_DAW\\Programacion\\Bloque3\\UD11\\ACT11_2B_csv\\ACT11_2B_departments.cvs";
        String arxiu2 = "C:\\Users\\Richard\\Desktop\\1r_DAW\\Programacion\\Bloque3\\UD11\\ACT11_2B_csv\\ACT11_2B_employees.cvs";
        
        //Estructura de memoria
        List<Department> departments = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        Map<Department, List<Employee>> depEmps = new HashMap<>();  // Relació 1:N
        Map<Employee, Department> empDeps = new HashMap<>();  // Relació N:1
        
        try ( BufferedReader bufferedReader1 = new BufferedReader(new FileReader(arxiu1));
              BufferedReader bufferedReader2 = new BufferedReader(new FileReader(arxiu2));
            ) {
            
            //Leer archivos
            llegirDepartments(bufferedReader1, departments);
            llegirEmployees(bufferedReader2, employees);
            
            //Cargar "depEmps"
            carregaDepEmps(depEmps, departments, employees);  // Relacio 1:N
            carregaEmpDeps(empDeps, departments, employees);  // Relació N:1
            
            //Mostrar el mapa 
            mostraDepartments(departments);
            mostraEmployees(employees);
            mostraDepEmps(depEmps);
            mostraEmpDeps(empDeps);
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
        }
    }
    private static void llegirDepartments(BufferedReader bufferedReader, List<Department> departments) throws IOException {
        String linea;
        String[] parts;
        
        while((linea = bufferedReader.readLine()) != null) {
            try {
                
            } catch (Exception e) {
                
            }
        }
    }

    private static void llegirEmployees(BufferedReader bufferedReader2, List<Employee> employees) {
    }

    private static void carregaDepEmps(Map<Department, List<Employee>> depEmps, List<Department> departments, List<Employee> employees) {
    }

    private static void carregaEmpDeps(Map<Employee, Department> empDeps, List<Department> departments, List<Employee> employees) {
    }

    private static void mostraDepartments(List<Department> departments) {
    }

    private static void mostraEmployees(List<Employee> employees) {
    }

    private static void mostraDepEmps(Map<Department, List<Employee>> depEmps) {
    }

    private static void mostraEmpDeps(Map<Employee, Department> empDeps) {
    }

    
}

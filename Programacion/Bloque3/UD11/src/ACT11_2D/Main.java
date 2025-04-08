/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT11_2D;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Richard
 */
public class Main {
    public static void main(String[] args) {
        String arxiu = "C:\\Users\\Richard\\Desktop\\1r_DAW\\Programacion\\Bloque3\\UD11\\ACT11_2D_cvs\\ACT11_2D_products_per_warehouses.cvs";  

        //Estructura de memoria
        List<Product> products = new ArrayList<>();
        List<Warehouse> warehouses = new ArrayList<>();
        
        try {
            mostraProducts(products);
            mostraWarehouses(warehouses);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private static void carregaArxiu(String arxiu, List<Product> products, List<Warehouse> warehouses) throws IOException, NumberFormatException, IllegalArgumentException {
        String linea;
        int _productId, _warehouseId, _warehouseName;
        String _productName, _warehouseName;
        String[] parts;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuLog)) ) {
            if (!(linea.isEmpty() || linea.startsWith("#"))) {
                _productId = Integer.parseInt(linea.substring(0, 8).trim());
                _productName = linea.substring(8,32).trim();
                _warehouseId = Integer.parseInt(linea.substring(32, 37).trim());
                _warehouseName = linea.substring(37, 61).trim();
                _quantity = Integer.parseInt(linea.substring(61, linea.length()).trim());
                        
                // Products
                carregaProducts(_productId, _productName, products );
                        
                // Warehouses
                carregaWarehouses(_warehouseId, _warehouseName, _quantity, warehouses );
        } catch (NumberFormatException e) {
            System.err.println("Error carregant Department: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error carregant Department: " + e.getMessage());
        }
    }
    
    private static void carregaProducts(int productId, String productName, List<Product> products) {
        Product product;
        int indexProducts = products.indexOf(new Product(productId,".",0));
        
        if (indexProducts == -1) {
            product = new Product( productId, productName, 1 );
            products.add(product);
        } else {
            products.get(indexProducts).setNumWarehouses( products.get(indexProducts).getNumWarehouses() + 1 );
        }
    }
    
    private static void carregaWarehouses(int warehouseId, String warehouseName, int quantity, List<Warehouse> warehouses) {
        Warehouse warehouse;
        int indexWarehouses = warehouses.indexOf(new Warehouse(warehouseId,".",0));
        
        if (indexWarehouses == -1) {
            warehouse = new Warehouse( warehouseId, warehouseName, quantity );
            warehouses.add(warehouse);
        } else {
            warehouses.get(indexWarehouses).setNumProducts( warehouses.get(indexWarehouses).getNumProducts() + quantity );
        }
    }
    
    private static void mostraProducts(List<Product> products) {
        Collections.sort(products);
        
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }
    
    private static void mostraWarehouses(List<Warehouse> warehouses) {
        Collections.sort(warehouses);
        
        for (Warehouse w : warehouses) {
            System.out.println(w.toString());
        }
    }
}

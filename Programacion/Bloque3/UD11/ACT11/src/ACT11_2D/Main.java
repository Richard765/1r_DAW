package ACT11_2D;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Arxius per a la càrrega de dades:
        String arxiu = "C:\\temp\\ACT11_2D_products_per_warehouses.csv";
        String arxiuLog = "C:\\temp\\ACT11_2D_log.txt";
        
        // Estructures de memòria:
        List<Warehouse> warehouses = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        
        try {
            // Llegir el contingut dels arxius línia a línia:
            CarregaArxiu(arxiu, arxiuLog, products, warehouses);

            // Mostrar les estructures de memòria:
            System.out.println("PRODUCTS");
            mostraProducts(products);
            System.out.println("WAREHOUSES");
            mostraWarehouses(warehouses);
        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }

    private static void CarregaArxiu(String arxiu, String arxiuLog,  List<Product> products, List<Warehouse> warehouses) throws IOException, NumberFormatException, IllegalArgumentException {
        String linea;
        int numLinea = 0;
        int _productId, _warehouseId, _quantity;
        String _productName, _warehouseName;
        //String[] parts;
        
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu));
              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arxiuLog)) ) {       
            while ((linea = bufferedReader.readLine()) != null) {
                try {
                    // format: XXXXXXX XXXXXXXXXXXXXXXXXXXXXXX XXXX XXXXXXXXXXXXXXXXXXXXXXX XXXXXXX
                    //         1       9                       33   38                      62
                    numLinea = numLinea + 1 ;
                    
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
                        
                    }
                } catch (NumberFormatException e) {
                    bufferedWriter.write("Error carregant Línia " + numLinea + ": " + e.getMessage());
                    bufferedWriter.newLine();
                } catch (IllegalArgumentException e) {
                    bufferedWriter.write("Error carregant Línia " + numLinea + ": " + e.getMessage());
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error llegint l'arxiu: " + e.getMessage());
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
        Collections.sort(products); // Ordena la llista 'departments'
        
        for (Product p: products) {
            System.out.println(p.toString());
        }
    }
    
    private static void mostraWarehouses(List<Warehouse> warehouses) {
        Collections.sort(warehouses); // Ordena la llista 'employees'

        for (Warehouse w : warehouses) {  
            System.out.println(w.toString());
        }
    }

}


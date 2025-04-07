package ACT11_2D;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Arxius per a la càrrega de dades:
        String arxiu = "C:\\temp\\ACT11_2D_products_per_warehouses.csv";
        
        // Estructures de memòria:
        List<Warehouse> warehouses = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        
        try {
            // Llegir el contingut dels arxius línia a línia:
            LlegeixArxiu(arxiu, products, warehouses);

            // Mostrar les estructures de memòria:
            System.out.println("PRODUCTS");
            mostraProducts(products);
            System.out.println("WAREHOUSES");
            mostraWarehouses(warehouses);
        } catch (Exception e) {
            System.err.println("Error GENERAL " + e.getMessage());
        }
    }

    private static void LlegeixArxiu(String arxiu,  List<Product> products, List<Warehouse> warehouses) throws IOException, NumberFormatException, IllegalArgumentException {
        String linea;
        int productId, warehouseId, quantity;
        String productName, warehouseName;
        //String[] parts;
        
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(arxiu)) ) {       
            while ((linea = bufferedReader.readLine()) != null) {
                try {
                    // format: xxxx  yyyy  zzzz  ...
                    if (!(linea.isEmpty() || linea.startsWith("#"))) {
                        productId = Integer.parseInt(linea.substring(0, 8).trim());
                        productName = linea.substring(8,32).trim();
                        warehouseId = Integer.parseInt(linea.substring(32, 37).trim());
                        warehouseName = linea.substring(38, 61).trim();
                        quantity = Integer.parseInt(linea.substring(61, linea.length()).trim());
                        
                        // Products
                        carregaProducts(productId, productName, products );
                        
                        // Warehouses
                        carregaWarehouses(warehouseId, warehouseName, quantity, warehouses );
                        
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error carregant Department: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.err.println("Error carregant Department: " + e.getMessage());
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


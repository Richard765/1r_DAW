package ACT11_6A;

import ACT11_6A.Utils.GestorVendes;

public class Main {
    public static void main(String[] args) {
        GestorVendes gestorVendes = new GestorVendes();
        
        try {
            // CÀRREGA CLIENTS, PRODUCTES i VENDES
            System.out.println("CLIENTS");
            gestorVendes.carregaClients("c:\\temp\\clients.csv");
            System.out.println("PRODUCTES");
            gestorVendes.carregaProductes("c:\\temp\\productes.csv");
            System.out.println("VENDES");
            gestorVendes.carregaVendes("c:\\temp\\vendes.csv");
            
            // MODIFICA DADES
            gestorVendes.modifica();
            
            // DESA CLIENTS, PRODUCTES i VENDES
            gestorVendes.desaClients("c:\\temp\\clients_out.csv");
            gestorVendes.desaProductes("c:\\temp\\productes_out.csv");
            gestorVendes.desaVendes("c:\\temp\\vendes_out.csv");

        } catch (Exception e) {
            System.out.println("Error GENERAL: " + e.getMessage());
        }
    }
}

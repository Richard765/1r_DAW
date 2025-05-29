package ACT11_6B;

import ACT11_6B.Utils.*;

public class Main {
    public static void main(String[] args) {
        GestorTaller gestorTaller = new GestorTaller();

        try {
            // CÀRREGA CLIENTS, VEHICLES i REPARACIONS
            System.out.println("CLIENTS");
            gestorTaller.carregaClients("c:\\temp\\clients.csv");
            System.out.println("VEHICLES");
            gestorTaller.carregaVehicles("c:\\temp\\vehicles.csv");
            System.out.println("REPARACIONS");
            gestorTaller.carregaReparacions("c:\\temp\\reparacions.csv");
            
            // MODIFICA DADES
            gestorTaller.modifica();

            // DESA CLIENTS, VEHICLES i REPARACIONS
            gestorTaller.desaClients("c:/temp/clients_out.csv");
            gestorTaller.desaVehicles("c:/temp/vehicles_out.csv");
            gestorTaller.desaReparacions("c:/temp/reparacions_out.csv");

        } catch (Exception e) {
            System.err.println("Error GENERAL: " + e.getMessage());
        }
    }
}
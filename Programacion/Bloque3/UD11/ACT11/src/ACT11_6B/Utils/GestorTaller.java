package ACT11_6B.Utils;

import ACT11_6B.Classes.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class GestorTaller {
    final String MYSQL_CON = "c:\\temp\\mysql.con";
    GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
    
    Set<Client> clients = new HashSet<>();
    Set<Vehicle> vehicles = new HashSet<>();
    Map<Integer, Reparacio> reparacions = new HashMap<>();

    // --- CÀRREGA CLIENTS 
    public void carregaClients(String path) throws SQLException, IOException {
        carregaClientsBBDD(this.clients);
        carregaClientsCSV(this.clients, path);

        System.out.println(this.clients);
    }
    
    public void carregaClientsBBDD(Set<Client> clients) throws SQLException, IOException{ 
        String sql = "SELECT id, nom, email FROM clients";
        
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql) ) {   
            
            while (resultSet.next())
                afegeixClient( clients, new Client( resultSet.getInt("id"),
                                                    resultSet.getString("nom"), 
                                                    resultSet.getString("email") )
                             );
            
        } catch (SQLException e) {
            System.err.println("Error carregant clients BBDD: " + e.getMessage());
        }
    }

    public void carregaClientsCSV(Set<Client> clients, String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                
                System.out.println(linia);
                
                if (!(linia.isEmpty() || linia.startsWith("#"))) {
                    String[] parts = linia.split(",");
                    if (parts.length == 3) 
                        afegeixClient(clients, new Client( Integer.parseInt(parts[0].trim()),
                                                           parts[1].trim(),
                                                           parts[2].trim()) );
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant clients CSV: " + e.getMessage());
        }
    }
    
    public void afegeixClient(Set<Client> clients, Client client) {
        clients.add(client);
    }
    
    private Client cercaClient (Client c) throws NoSuchElementException {
        for (Client client : this.clients) 
            if (c.equals(client))
                return client;
        
        throw new NoSuchElementException("Client no trobat a la llista.");
    }
 
    // --- CÀRREGA VEHICLES
    public void carregaVehicles(String path) throws SQLException, IOException {
        carregaVehiclesBBDD(this.vehicles);
        carregaVehiclesCSV(this.vehicles, path);

        System.out.println(this.vehicles);
    }

    private void carregaVehiclesBBDD(Set<Vehicle> vehicles) throws SQLException, IOException {
        String sql = "SELECT matricula, marca, model, client_id FROM vehicles";
        
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql) ) { 
            
            while (resultSet.next())
                afegeixVehicle( vehicles, new Vehicle( resultSet.getString("matricula"),
                                                       resultSet.getString("marca"), 
                                                       resultSet.getString("model"),
                                                       cercaClient( new Client(resultSet.getInt("client_id"), ".", ".") ) )
                              );
            
        } catch (SQLException e) {
            System.err.println("Error carregant vehicles BBDD: " + e.getMessage());
        }
    }
        
    private void carregaVehiclesCSV(Set<Vehicle> vehicles, String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.startsWith("#") && !linia.isBlank()) {
                    String[] parts = linia.split(",");
                 
                    afegeixVehicle( vehicles, new Vehicle( parts[0].trim(), 
                                                           parts[1].trim(), 
                                                           parts[2].trim(), 
                                                           cercaClient( new Client(Integer.parseInt(parts[3].trim()), ".", ".") ) ) );
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant vehicles CSV: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general carregant vehicles CSV: " + e.getMessage());
        }
    }

   public void afegeixVehicle(Set<Vehicle> vehicles, Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    
    private Vehicle cercaVehicle (Vehicle v) throws NoSuchElementException {
        for (Vehicle vehicle : this.vehicles) 
            if (v.equals(vehicle))
                return vehicle;
        
        throw new NoSuchElementException("Vehicle no trobat a la llista.");
    }
    
    // CARREGA REPARACIONS  
    public void carregaReparacions(String path) throws SQLException, IOException {
        carregaReparacionsBBDD(this.reparacions);
        carregaReparacionsCSV(this.reparacions, path);

        System.out.println(mostraReparacions(this.reparacions));
    }
    
    private void carregaReparacionsBBDD(Map<Integer, Reparacio> reparacions) throws SQLException, IOException {
        String sql = "SELECT r.id id, dataEntrada, matricula, cost, descripcio, estat FROM reparacions r, tasques t where r.id = t.reparacio_id";
        
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql) ) { 
            
            Reparacio reparacio = null;
            while (resultSet.next()) {
                reparacio = reparacions.get(resultSet.getInt("id"));
                if ( reparacio == null)
                    reparacio = new Reparacio( resultSet.getInt("id"),
                                               resultSet.getDate("dataEntrada").toLocalDate(),
                                               cercaVehicle( new Vehicle(resultSet.getString("matricula"), ".", ".", null) ),
                                               resultSet.getDouble("cost"),
                                               new ArrayList<>() ); 
                reparacio.getTasques().add( new Tasca( resultSet.getString("descripcio"), 
                                                       EstatReparacio.valueOf(resultSet.getString("estat").toUpperCase()) )  );
                afegeixReparacio( reparacions, reparacio );
            }
            
                                                  
        } catch (SQLException e) {
            System.err.println("Error carregant clients BBDD: " + e.getMessage());
        }        
    }

    private void carregaReparacionsCSV(Map<Integer, Reparacio> reparacions, String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!linia.startsWith("#") && !linia.isBlank()) {
                    String[] parts = linia.split(",",5);
                     
                    if (parts.length == 5) {
                        Reparacio reparacio = new Reparacio( Integer.parseInt(parts[0].trim()),
                                                             LocalDate.parse(parts[1].trim()),
                                                             cercaVehicle( new Vehicle(parts[2].trim(), null, null, null) ),
                                                             Double.parseDouble(parts[3].trim()),
                                                             new ArrayList<>() );
                        
                        
                        
                        String[] llistaTasques = parts[4].trim().split(";");
                        for (String llTasques: llistaTasques) {
                            String[] t = llTasques.split(",");
                            
                            reparacio.getTasques().add ( new Tasca(t[0].trim(), EstatReparacio.valueOf(t[1].trim())) );
                        }
                        afegeixReparacio( reparacions, reparacio );
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant reparacions CSV: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general carregant reparacions CSV: " + e.getMessage());
        }
    }
    
    public void afegeixReparacio(Map<Integer, Reparacio> reparacions, Reparacio reparacio) {
        reparacions.put(reparacio.getId(), reparacio);
    }
    
    public String mostraReparacions(Map<Integer, Reparacio> reparacions) {
        String text="Reparacions: \n";
        for (Reparacio r : reparacions.values())
            text += "\t" + r.toString() + "\n";
        
        return text;
    }
    
    // --- DESCÀRREGA CLIENTS
    public void desaClients(String path) throws SQLException, IOException {
        desaClientsBBDD(this.clients);
        desaClientsCSV(this.clients, path);
    }
    
    private void desaClientsBBDD(Set<Client> clients) throws SQLException, IOException {
        try ( Connection conn = gestorBBDD.getConnectionFromFile()  ) {
            conn.setAutoCommit(true);
            
            for (Client c : clients)
                try {
                    gestorBBDD.executaSQL( conn, "INSERT INTO clients (id, nom, email) VALUES (?,?,?)",
                                           (Integer) c.getId(),  c.getNom(), c.getEmail() );

                } catch (SQLException e) {
                    if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062)
                        // Error per PK, modificar
                        gestorBBDD.executaSQL( conn, "UPDATE clients SET nom = ?, email = ? WHERE id = ?",
                                               c.getNom(), c.getEmail(), (Integer) c.getId() );
                    else
                        throw e; // Re-llança si no és error de PK
                }
        } catch (SQLException e) {        
            System.err.println("Error descarregant clients BBDD: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("");
        }
    }
    
    private void desaClientsCSV(Set<Client> clients, String path) {
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(path))) {
            for (Client c : clients) {
                br.write(c.getId() + "," + c.getNom() + "," + c.getEmail());
                br.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error descarregant clients CSV: " + e.getMessage());
        }
    }
    
    // --- DESCÀRREGA VEHICLES
    public void desaVehicles(String path) throws SQLException, IOException {
        desaVehiclesBBDD(this.vehicles);
        desaVehiclesCSV(this.vehicles, path);
    }
    
    private void desaVehiclesBBDD(Set<Vehicle> vehicles) throws SQLException, IOException {
        try ( Connection conn = gestorBBDD.getConnectionFromFile() ) {
            conn.setAutoCommit(true);
            
            for (Vehicle v : vehicles) {
                try {
                    gestorBBDD.executaSQL( conn, "INSERT INTO vehicles (matricula, marca, model, client_id) VALUES (?,?,?,?)",
                                           v.getMatricula(), v.getMarca(), v.getModel(), v.getClient().getId() );
                } catch (SQLException e) {
                    if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062)
                        // Error per PK, modificar
                        gestorBBDD.executaSQL( conn, "UPDATE vehicles SET marca = ?, model = ?, client_id = ? WHERE matricula = ?",
                                               v.getMarca(), v.getModel(), v.getClient().getId(), v.getMatricula() );
                    else
                        throw e; // Re-llança si no és error de PK
                }
            }
        } catch (SQLException e) {
            System.err.println("Error descarregant vehicles BBDD: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("");
        }
    }
    
    private void desaVehiclesCSV(Set<Vehicle> vehicles, String path) {
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(path))) {
            for (Vehicle v : vehicles) {
                br.write(v.getMatricula() + "," + v.getMarca() + "," + v.getModel() + "," + v.getClient().getId());
                br.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error descarregant clients CSV: " + e.getMessage());
        }
    }  

    
    // --- DESCÀRREGA VEHICLES
    public void desaReparacions(String path) throws SQLException, IOException {
        desaReparacionsBBDD(this.reparacions);
        desaReparacionsCSV(this.reparacions, path);
    }
    
    private void desaReparacionsBBDD(Map<Integer,Reparacio> reparacions) {
        try ( Connection conn = gestorBBDD.getConnectionFromFile() ) {
            conn.setAutoCommit(true);
            
            for (Reparacio r : reparacions.values()) {
                try {
                    gestorBBDD.executaSQL( conn, "INSERT INTO reparacions (id, dataEntrada, matricula, cost) VALUES (?, ?, ?, ?)",  
                                           (Integer) r.getId(), java.sql.Date.valueOf(r.getDataEntrada()), r.getVehicle().getMatricula(), (Double) r.getCost() );
                } catch (SQLException e) {
                    if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062)
                        // Error per PK, modificar
                        gestorBBDD.executaSQL( conn, "UPDATE reparacions SET dataEntrada = ?, matricula = ?, cost = ? WHERE id = ?",
                                               java.sql.Date.valueOf(r.getDataEntrada()), r.getVehicle().getMatricula(), (Double) r.getCost(), (Integer) r.getId() );
                    else 
                        throw e; // Re-llança si no és error de PK
                } finally {
                    gestorBBDD.executaSQL( conn, "DELETE FROM tasques where reparacio_id = ?",
                                           (Integer) r.getId() );
                    
                    for (Tasca t : r.getTasques()) 
                        gestorBBDD.executaSQL( conn, "INSERT INTO tasques (reparacio_id, descripcio, estat) VALUES(?, ?, ?)",
                                               (Integer) r.getId(), t.getDescripcio(), t.getEstat() );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error descarregant reparacions BBDD: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("");
        }
    }
    
    private void desaReparacionsCSV(Map<Integer,Reparacio> reparacions, String path) {
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(path))) {
            for (Reparacio r : reparacions.values()) {
                String text = r.getId() + "," + r.getDataEntrada() + "," + r.getVehicle().getMatricula() + "," + r.getCost() + ",";
                for (Tasca t : r.getTasques())
                    text += t.getDescripcio() + "," + t.getEstat() + ";";
                br.write(text);
                br.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error descarregant vendes CSV: " + e.getMessage());
        }
    }

    // MODIFICACIONS
    public void modifica() {
        clients.forEach( client -> { client.setNom(client.getNom().toUpperCase());
                                     client.setEmail(client.getEmail().toLowerCase());
                                   } );

        vehicles.forEach( vehicle -> { vehicle.setModel(vehicle.getModel().toUpperCase());
                                       vehicle.setMarca(vehicle.getMarca().toUpperCase());
                                     } );

        reparacions.values().forEach( reparacio -> reparacio.setCost(reparacio.getCost() * 1.05) );
    }

}
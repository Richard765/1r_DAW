package ACT11_6A.Utils;

import ACT11_6A.Classes.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;


public class GestorVendes {
    final String MYSQL_CON = "c:\\temp\\mysql.con";
    GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
    
    Set<Client> clients = new HashSet<>();
    Set<Producte> productes = new HashSet<>();
    Map<Integer,Venda> vendes = new HashMap<>();
    
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
    
    // cerca la referència del client en 'clients'
    private Client cercaClient (Client c) throws NoSuchElementException {
        for (Client client : this.clients) 
            if (c.equals(client))
                return client;
        
        throw new NoSuchElementException("Client no trobat a la llista.");
    }
    
    // --- CÀRREGA PRODUCTES
    public void carregaProductes(String path) throws SQLException, IOException {
        carregaProductesBBDD(this.productes);
        carregaProductesCSV(this.productes, path);
        
        System.out.println(this.productes);
        
    }
        
    public void carregaProductesBBDD(Set<Producte> productes) throws SQLException, IOException{ 
        String sql = "SELECT id, nom, preu, categoria FROM productes";
        
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql) ) { 
            
            while (resultSet.next())
                afegeixProducte( productes, new Producte( resultSet.getInt("id"),
                                                          resultSet.getString("nom"), 
                                                          resultSet.getDouble("preu"),
                                                          Categoria.valueOf(resultSet.getString("categoria").toUpperCase()) )
                             );
            
        } catch (SQLException e) {
            System.err.println("Error carregant productes BBDD: " + e.getMessage());
        }
    }
    
    public void carregaProductesCSV(Set<Producte> productes, String path) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!(linia.isEmpty() || linia.startsWith("#"))) {
                    String[] parts = linia.split(",");
                    if (parts.length == 4)
                        afegeixProducte(productes, new Producte( Integer.parseInt(parts[0].trim()),
                                                                 parts[1].trim(),
                                                                 Double.parseDouble(parts[2].trim()),
                                                                 Categoria.valueOf(parts[3].trim())) );
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant productes CSV: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general carregant productes CSV: " + e.getMessage());
        }
    }

    public void afegeixProducte(Set<Producte> productes, Producte producte) {
        productes.add(producte);
    }
    
    // cerca la referència del producte en 'productes'
    private Producte cercaProducte (Producte p) throws NoSuchElementException {
        for (Producte producte : this.productes) 
            if (p.equals(producte))
                return producte;
        
        throw new NoSuchElementException("Producte no trobat a la llista.");
    }
    
    // --- CÀRREGA VENDES 
    public void carregaVendes(String path) throws SQLException, IOException {
        carregaVendesCSV(this.vendes, path);
        carregaVendesBBDD(this.vendes);
        
        
        System.out.println(mostraVendes(this.vendes));
    }
  
    public void carregaVendesBBDD(Map<Integer,Venda> vendes) throws SQLException, IOException{ 
        String sql = "SELECT id, client_id, data, producte_id FROM vendes, venda_producte where id = venda_id";
        
        try ( Connection conn = gestorBBDD.getConnectionFromFile();
              ResultSet resultSet = gestorBBDD.executaQuerySQL(conn, sql) ) { 
            
            Venda venda = null;
            while (resultSet.next()) {
                venda = vendes.get(resultSet.getInt("id"));  // cerca venda en el 'map' vendes ?
                if ( venda == null)  // si no existeix, crear nova venda
                    venda = new Venda(  resultSet.getInt("id"),
                                        resultSet.getDate("data").toLocalDate(),
                                        cercaClient( new Client(resultSet.getInt("client_id"), ".", ".") ),
                                        new HashSet<>() ); 
                // crear el producte sobre l'arraylist creat o trobat
                venda.getProductes().add( cercaProducte( new Producte(resultSet.getInt("producte_id"), ".", 0.0, null) ) );
                afegeixVenda(vendes, venda);  // afegeix l'objecte al 'map' vendes
            }
                                                          
        } catch (SQLException e) {
            System.err.println("Error carregant clients BBDD: " + e.getMessage());
        }
    }

    public void carregaVendesCSV(Map<Integer,Venda> vendes, String path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                if (!(linia.isEmpty() || linia.startsWith("#"))) {
                    String[] parts = linia.split(",");
                    if (parts.length == 4) {
                        // Processar els productes separats per ;
                        Venda venda = vendes.get(Integer.parseInt(parts[0].trim()));  // cerca venda en el 'map' vendes ?
                        if ( venda == null)  // si no existeix, crear nova venda 
                            venda = new Venda( Integer.parseInt(parts[0].trim()),
                                                     LocalDate.parse(parts[1].trim()),
                                                     cercaClient( new Client(Integer.parseInt(parts[2].trim()), null, null) ), // 'client' temporal
                                                     new HashSet<>() );
                        
                        // crear els productes sobre l'arraylist creat o trobat
                        String[] producteIds = parts[3].trim().split(";");
                        for (String pId : producteIds) 
                            if (!pId.trim().isEmpty()) 
                                venda.getProductes().add( cercaProducte( new Producte(Integer.parseInt(pId.trim()), null, 0.0, null) ) );
                        
                        afegeixVenda(this.vendes, venda );  // afegeix l'objecte al 'map' vendes
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error carregant vendes CSV: " + e.getMessage());
        }
    }
  
    public void afegeixVenda(Map<Integer,Venda> vendes, Venda venda) {
        vendes.put(venda.getId(), venda);
    }
    
    public String mostraVendes(Map<Integer,Venda> vendes) {
        String text="Vendes: \n";
        for (Venda v : vendes.values())
            text += "\t" + v.toString() + "\n";
        
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
                    gestorBBDD.executaSQL( conn, "INSERT INTO clients (id, nom, email) VALUES (?, ?, ?)",
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
    
    // --- DESCÀRREGA PRODUCTES
    public void desaProductes(String path) throws SQLException, IOException {
        desaProductesBBDD(this.productes);
        desaProductesCSV(this.productes, path);
    }
    
    private void desaProductesBBDD(Set<Producte> productes) throws SQLException, IOException {
        try ( Connection conn = gestorBBDD.getConnectionFromFile()  ) {
            conn.setAutoCommit(true);
            
            for (Producte p : productes) {
                try {
                    gestorBBDD.executaSQL( conn, "INSERT INTO productes (id, nom, preu, categoria) VALUES (?, ?, ?, ?)",
                                           (Integer) p.getId(), p.getNom(), (Double) p.getPreu(), p.getCategoria() );
                } catch (SQLException e) {
                    if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062)
                        // Error per PK, modificar
                        gestorBBDD.executaSQL( conn, "UPDATE productes SET nom = ?, preu = ?, categoria = ? WHERE id = ?",
                                               p.getNom(), (Double) p.getPreu(), p.getCategoria(), (Integer) p.getId() );
                    else
                        throw e; // Re-llança si no és error de PK
                }
            }
        } catch (SQLException e) {
            System.err.println("Error descarregant productes BBDD: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("");
        }
    }
    
    private void desaProductesCSV(Set<Producte> productes, String path) {
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(path))) {
            for (Producte p : productes) {
                br.write(p.getId() + "," + p.getNom() + "," + p.getPreu() + "," + p.getCategoria());
                br.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error descarregant productes CSV: " + e.getMessage());
        }
    }  
    
    // --- DESCÀRREGA VENDES
    public void desaVendes(String path) {
        desaVendesBBDD(this.vendes);
        desaVendesCSV(this.vendes, path);
    }
    
    private void desaVendesBBDD(Map<Integer,Venda> vendes) {
        try ( Connection conn = gestorBBDD.getConnectionFromFile()  ) {
            conn.setAutoCommit(true);
            
            for (Venda v : vendes.values()) {
                try {
                    gestorBBDD.executaSQL( conn, "INSERT INTO vendes (id, client_id, data) VALUES (?,?,?)",  
                                           (Integer) v.getId(), (Integer) v.getClient().getId(), java.sql.Date.valueOf(v.getDataVenda()) );
                } catch (SQLException e) {
                    if (e.getSQLState().equals("23000") && e.getErrorCode() == 1062)
                        // Error per PK, modificar
                        gestorBBDD.executaSQL( conn, "UPDATE vendes SET client_id = ?, data = ? WHERE id = ?",
                                               (Integer) v.getClient().getId(), java.sql.Date.valueOf(v.getDataVenda()), (Integer) v.getId());
                    else 
                        throw e; // Re-llança si no és error de PK
                } finally {
                    gestorBBDD.executaSQL( conn, "DELETE FROM venda_producte where venda_id = ?",
                                           (Integer) v.getId() );
                    
                    for (Producte p : v.getProductes()) 
                        gestorBBDD.executaSQL( conn, "INSERT INTO venda_producte (venda_id, producte_id) VALUES(?,?)",
                                               (Integer) v.getId(), (Integer) p.getId());

                }
            }
        } catch (SQLException e) {
            System.err.println("Error descarregant vendes BBDD: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("");
        }
    }
    
    private void desaVendesCSV(Map<Integer,Venda> vendes, String path) {
        try (BufferedWriter br = Files.newBufferedWriter(Paths.get(path))) {
            for (Venda v : vendes.values()) {
                String text = v.getId() + "," + v.getDataVenda() + "," + v.getClient().getId() + ",";
                for (Producte p : v.getProductes())
                    text += p.getId() + ";";
                br.write(text);
                br.newLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error descarregant vendes CSV: " + e.getMessage());
        }
    }
    
    // MODIFICACIONS
    public void modifica() {
        modificaClients();
        modificaProductes();
        modificaVendes();
    }
    
    public void modificaClients() {
        for (Client client : this.clients) {
            client.setNom(client.getNom().toUpperCase());
            client.setEmail(client.getEmail().toLowerCase());
        }
    }
    
    public void modificaProductes() {
        for (Producte producte: this.productes) {
            producte.setNom(producte.getNom().toUpperCase());
            producte.setPreu(producte.getPreu()*10);
        }
    }

    public void modificaVendes() {
        for (Venda venda: this.vendes.values()) {
            venda.setDataVenda(venda.getDataVenda().plusYears(1));

            vendes.put(venda.getId(), venda);  // modifica el map
        }
    }
}
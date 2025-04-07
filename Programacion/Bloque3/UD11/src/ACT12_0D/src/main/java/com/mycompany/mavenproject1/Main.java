package com.mycompany.mavenproject1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author winadmin
 */
public class Main {
    static String arxiuJSON = "C:\\temp\\persones.json";
    static File fileJSON = new File(arxiuJSON);

    public static void main(String[] args) {
        List<Persona> persones = new ArrayList<>();
        
        persones = lecturaJSON(persones);
        persones = modificacioJSON(persones);
        escripturaJSON(persones);
    }

    private static List<Persona> lecturaJSON(List<Persona> persones) {
        // Crear un ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            persones = objectMapper.readValue(fileJSON, new TypeReference<List<Persona>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persones;
    }
    
   private static List<Persona> modificacioJSON(List<Persona> persones) {
        for (Persona p : persones) {
            p.setLlinatge(p.getLlinatge().toUpperCase());
            p.setNom(p.getNom().toUpperCase());
            System.out.println(p.getLlinatge());
        }
        return persones;
    }
 
    private static void escripturaJSON(List<Persona> persones) {
        // Crear un ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            objectMapper.writeValue(new File(arxiuJSON), persones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
package com.mycompany.mavenproject1;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Mavenproject1 {

    public static void main(String[] args) {
        try {
            leer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void leer() throws IOException {
        JSONParser JSONParser = new JSONParser();
        try (FileReader reader = new FileReader("c:\\temp\\personas.json")) {
            Object obj = JSONParser.parse(reader);
            JSONArray personas = (JSONArray) obj;
            System.out.println(personas);
            
            for (Object p : personas) {
                JSONObject pp = (JSONObject) p;
                JSONObject persona = (JSONObject) pp.get("persona");
                String nombre = (String) persona.get("nombre");
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    
}


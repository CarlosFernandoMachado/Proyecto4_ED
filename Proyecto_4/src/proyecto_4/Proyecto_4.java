/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Proyecto_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Persona> Personas = leerarchivo();
        
    }

    public static ArrayList<Persona> leerarchivo() {
        ArrayList<Persona> personas = new ArrayList();
        String cadena;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("Personas.txt");
            br = new BufferedReader(fr);
            while ((cadena = br.readLine()) != null) {
                String temp[] = cadena.split(",");
                personas.add(new Persona(temp[0], Boolean.getBoolean(temp[1])));
            }
        } catch (Exception e) {
        }
        try {
            br.close();
        } catch (Exception e) {
        }
        return personas;
    }
}

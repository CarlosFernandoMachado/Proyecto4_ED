/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        int integrantes = 0,ContParejas = 0, Descanso = 0;
        for (Persona persona : Personas) {
            if (persona.isPareja()) {
                ContParejas += 1;
            }
        }
        boolean limitarparejas = false,seguir = true,extra = false;
        while(seguir){
            System.out.println("Hay " + totalpersonas(Personas) + " personas disponibles\n" + (Personas.size()-ContParejas) + " No son pareja\n" + (ContParejas*2) + " Son pareja\n");
            while(integrantes <= 0){
                System.out.print("De cuantas personas desea el grupo? ");
                integrantes = sc.nextInt();
            }
            System.out.println("1) Limitar parejas\n2) No limitar parejas\n");
            int temp = sc.nextInt();
            if (temp == 1) {
                limitarparejas = true;
            }else{
                limitarparejas = false;
            }
            while(Descanso < 0){
                System.out.print("Por cuantos turnos desea que un lider descanse? ");
                Descanso = sc.nextInt();
            }
            if (totalpersonas(Personas) % integrantes != 0) {
                extra = true;
            }else{
                extra = false;
            }
            
        }
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
                personas.add(new Persona(temp[0], Boolean.valueOf(temp[1])));
            }
        } catch (Exception e) {
        }
        try {
            br.close();
        } catch (Exception e) {
        }
        return personas;
    }
    public static int totalpersonas(ArrayList<Persona> personas){
        int peso = 0;
        for (int i = 0; i < personas.size(); i++) {
            peso += personas.get(i).getPeso();
        }
        return peso;
    }
}

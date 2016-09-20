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
        int integrantes = 0, ContParejas = 0, Descanso = 0;
        for (Persona persona : Personas) {
            if (persona.isPareja()) {
                ContParejas += 1;
            }
        }
        boolean limitarparejas = false, seguir = true, extra = false;
        while (seguir) {
            System.out.print("Hay " + totalpersonas(Personas) + " personas disponibles\n" + (Personas.size() - ContParejas) + " No son pareja\n" + (ContParejas * 2) + " Son pareja\n");
            while (integrantes <= 0) {
                System.out.print("De cuantas personas desea el grupo? ");
                integrantes = sc.nextInt();
            }
            System.out.print("1) Limitar parejas\n2) No limitar parejas\n");
            int temp = sc.nextInt();
            if (temp == 1) {
                limitarparejas = true;
            } else {
                limitarparejas = false;
            }
            while (Descanso < 0) {
                System.out.print("Por cuantos turnos desea que un lider descanse? ");
                Descanso = sc.nextInt();
            }
            if (totalpersonas(Personas) % integrantes != 0) {
                extra = true;
            } else {
                extra = false;
            }
            ArrayList<Grupo> grupos = new ArrayList();
            int cantgrupos = totalpersonas(Personas) / integrantes;
            validarlider(Personas, cantgrupos);
            for (int i = 0; i < cantgrupos; i++) {
                temp = optimolider(Personas);
                Persona lider = Personas.remove(temp);
                Grupo nuevogrupo = new Grupo();
                nuevogrupo.add(lider);
                if (limitarparejas) {
                    if (!nuevogrupo.tienepareja()) {
                        for (int j = 0; j < Personas.size(); j++) {
                            if (Personas.get(j).isPareja() && !Personas.get(j).conoce(lider)) {
                                nuevogrupo.add(Personas.remove(j));
                                break;
                            }
                        }
                        if (!nuevogrupo.tienepareja()) {
                            for (int j = 0; j < Personas.size(); j++) {
                                if (Personas.get(j).isPareja()) {
                                    nuevogrupo.add(Personas.remove(j));
                                    break;
                                }
                            }
                        }
                    }
                    if (integrantes > nuevogrupo.getPeso()) {
                        temp = integrantes - nuevogrupo.getPeso();
                        for (int j = 0; j < temp; j++) {
                            for (int k = 0; k < Personas.size(); k++) {
                                if (!Personas.get(k).conoce(lider) && !Personas.get(i).isPareja()) {
                                    nuevogrupo.add(Personas.remove(k));
                                    break;
                                }
                            }
                        }
                        if (integrantes > nuevogrupo.getPeso()) {
                            temp = integrantes - nuevogrupo.getPeso();
                            for (int j = 0; j < temp; j++) {
                                for (int k = 0; k < Personas.size(); k++) {
                                    if (!Personas.get(i).isPareja()) {
                                        nuevogrupo.add(Personas.remove(k));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (integrantes > nuevogrupo.getPeso()) {
                        temp = integrantes - nuevogrupo.getPeso();
                        for (int j = 0; j < temp; j++) {
                            for (int k = 0; k < Personas.size(); k++) {
                                if (!Personas.get(k).conoce(lider)) {
                                    nuevogrupo.add(Personas.remove(k));
                                    break;
                                }
                            }
                        }
                        if (integrantes > nuevogrupo.getPeso()) {
                            temp = integrantes - nuevogrupo.getPeso();
                            for (int j = 0; j < temp; j++) {
                                for (int k = 0; k < Personas.size(); k++) {
                                    nuevogrupo.add(Personas.remove(k));
                                    break;
                                }
                            }
                        }
                    }
                }
                grupos.add(nuevogrupo);
            }
            for (int i = 0; i < grupos.size(); i++) {
                grupos.get(i).imprimir();
                grupos.get(i).getlider().setContLider(Descanso);
                grupos.get(i).presentar();
                System.out.println("");
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

    public static int totalpersonas(ArrayList<Persona> personas) {
        int peso = 0;
        for (int i = 0; i < personas.size(); i++) {
            peso += personas.get(i).getPeso();
        }
        return peso;
    }

    public static void validarlider(ArrayList<Persona> personas, int cantgrupos) {
        int cont = 0;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getContLider() == 0) {
                cont += 1;
            }
        }
        while (cont < cantgrupos) {
            Persona temp = personas.get(0);
            for (int i = 1; i < personas.size(); i++) {
                if (temp.getContLider() > personas.get(i).getContLider()) {
                    temp = personas.get(i);
                }
            }
            temp.setContLider(0);
            cont += 1;
        }
    }

    public static int optimolider(ArrayList<Persona> personas) {
        int posmin = 0, max = 0, cont = 0;
        for (int i = 0; i < personas.size(); i++) {
            Persona temp = personas.get(i);
            if (temp.getContLider() == 0) {
                for (int j = 0; j < personas.size(); j++) {
                    if (!temp.equals(personas.get(j))) {
                        if (!personas.get(j).conoce(temp)) {
                            cont += 1;
                        }
                    }
                }
                if (max < cont) {
                    max = cont;
                    posmin = i;
                    cont = 0;
                }
            }
        }
        return posmin;
    }

    public static void bajar1(ArrayList<Persona> personas) {
        for (int i = 0; i < personas.size(); i++) {
            personas.get(i).bajar();
        }
    }
}

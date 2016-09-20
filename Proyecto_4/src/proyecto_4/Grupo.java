/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_4;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Grupo {

    ArrayList<Persona> grupo = new ArrayList();

    public Grupo() {
    }

    public int getPeso() {
        int peso = 0;
        for (int i = 0; i < grupo.size(); i++) {
            peso += grupo.get(i).getPeso();
        }
        return peso;
    }

    public void reset() {
        grupo.clear();
    }

    public ArrayList<Persona> getGrupo() {
        return grupo;
    }

    public void add(Persona p) {
        grupo.add(p);
    }

    public void presentar() {
        if (grupo.size() > 0) {
            Persona lider = grupo.get(0);
            for (int i = 1; i < grupo.size(); i++) {
                grupo.get(i).presentar(lider);
            }
        }
    }

    public boolean tienepareja() {
        for (int i = 0; i < grupo.size(); i++) {
            if (grupo.get(i).isPareja()) {
                return true;
            }
        }
        return false;
    }

    public Persona getlider() {
        if (grupo.size() > 0) {
            return grupo.get(0);
        }
        return null;
    }

    public void imprimir() {
        for (int i = 0; i < grupo.size(); i++) {
            if (i == 0) {
                System.out.println("Lider: " + grupo.get(i).getNombre());
            } else {
                System.out.println(grupo.get(i).getNombre());
            }
        }
    }
}

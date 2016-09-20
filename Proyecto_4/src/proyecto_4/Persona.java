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
public class Persona {

    private String nombre;
    private boolean pareja;
    private int ContLider;
    private int peso;
    private ArrayList<Persona> conocidos = new ArrayList();

    public Persona(String nombre, boolean pareja) {
        this.nombre = nombre;
        this.pareja = pareja;
        ContLider = 0;
        if (pareja) {
            peso = 2;
        } else {
            peso = 1;
        }
    }
    
    public boolean conoce(Persona p){
        for (int i = 0; i < conocidos.size(); i++) {
            if (conocidos.get(i).getNombre().equals(p.getNombre())) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Persona> getConocidos() {
        return conocidos;
    }

    public void presentar(Persona p){
        conocidos.add(p);
    }
    public int getPeso() {
        return peso;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isPareja() {
        return pareja;
    }

    public int getContLider() {
        return ContLider;
    }

    public void setContLider(int ContLider) {
        this.ContLider = ContLider;
    }

    public void bajar(){
        if (ContLider > 0) {
            ContLider -= 1;
        }
    }
    public void reset(){
        conocidos.clear();
        ContLider = 0;
    }
}

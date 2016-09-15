/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_4;

/**
 *
 * @author carlos
 */
public class Persona {
    private String nombre;
    private boolean pareja;
    private int ContLider;

    public Persona(String nombre, boolean pareja) {
        this.nombre = nombre;
        this.pareja = pareja;
        ContLider = 0;
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
    
}

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
}

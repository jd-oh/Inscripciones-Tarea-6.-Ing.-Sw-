/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import modelo.Estudiante;

/**
 *
 * @author Juan David Osorio y Nicolás Estupiñán
 */
public class ControlRegistro {

    private ArrayList<Estudiante> estudiantes;

    public void registrarEstudiante() {

    }

    public boolean buscarEstudiante(String cedula) {

        return false;
    }

    public boolean buscarCodigoMateria(String cedula) {

        return false;
    }

    public ArrayList<Estudiante> listarEstudiantes() {
        return estudiantes;
    }

    public int totalMateriasEstudiante(Estudiante estudiante) {

        return 0;
    }

    public ArrayList<String> cargarLista(String ruta) {
        ArrayList<String> datos = new ArrayList<String>();

        return datos;
    }

}

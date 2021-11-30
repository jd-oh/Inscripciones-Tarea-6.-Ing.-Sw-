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

    /**
     * Método que busca un estudiante en la lista de estudiantes para saber si
     * existe
     *
     * @param cedula la cédula del estudiante
     * @return el estudiante si existe o null si no existe.
     */
    public Estudiante buscarEstudiante(String cedula) {

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }

        return null;
    }


    /**
     * Llama al método convertirArchivo de la clase controlArchivo 
     * para traer los datos del archivo y guardarlos en una lista
     * @return los datos leídos del archivo en una lista de String
     */
    public ArrayList<String> cargarLista() {

        ArrayList<String> datos = new ArrayList<String>();
        ControlArchivo controlArchivo = new ControlArchivo();
        
        datos = controlArchivo.convertirArchivo();

        return datos;
    }

}

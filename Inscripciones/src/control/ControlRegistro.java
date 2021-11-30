/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import javax.swing.JOptionPane;
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
     * Metodo para comprobar si el codigo de la materia ya se encuentra 
     * registrada en la lista del estudiante
     * @param estudiante nos permite saber a cual estudiante debemos verificar
     * @param codigo materia a ser buscada en el estudiante 
     * @return falso si la materia no este en la lista del estudiante
     * @return true si la materia ya esta en la lista 
     */
    public boolean buscarCodigoMateria(Estudiante estudiante, String codigo) {
        ArrayList<String> materias = estudiante.mostrarCodigoMaterias();
        for (String materia : materias) {
            if (materia.equals(codigo)){
                JOptionPane.showMessageDialog(null, "Esta materia ya está "
                        + "registrada para este estudiante " + codigo);
                return true;
            }
            /*else 
                estudiante.agregarCodMateriasCursadas(codigo);*/
        }
        return false;
    }
    
    /**
     * Metodo para agregar una materia a la lista de un estudiante 
     * @param estudiante nos permite saber a cual estudiante debemos agregar
     * @param codigo materia a ser agregada a la lista del estudiante
     */
    public void agregarMateria(Estudiante estudiante, String codigo){
        estudiante.agregarCodMateriasCursadas(codigo);
    }
    
    /**
     * metodo que nos devuelve la lsita de estudiantes
     * @return Arraylist con los objetos de tipo estudiante
     */
    public ArrayList<Estudiante> listarEstudiantes() {
        return estudiantes;
    }

    /**
     * metodo para saber la cantidad de materias del estudiante
     * @param estudiante nos permite saber de cual estudiante necesitamos 
     * la cantidad de materias
     * @return un entero que es la cantidad de materias del estudiante
     */
    public int totalMateriasEstudiante(Estudiante estudiante) {
        
        return estudiante.mostrarCodigoMaterias().size();
    }


}

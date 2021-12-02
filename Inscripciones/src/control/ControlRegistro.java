/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Estudiante;

/**
 *
 * @author Juan David Osorio y Nicolás Estupiñán
 */
public class ControlRegistro {

    private ArrayList<Estudiante> estudiantes;

    public ControlRegistro() {
        this.estudiantes = new ArrayList<Estudiante>();
    }

    /**
     * Metodo para registrar los datos del archivo como estudiantes junto con
     * sus materias
     *
     * @param inscripciones lista de datos provenientes del archivo previamente
     * cargado
     * @exception EstudianteException en caso de que los datos proporcionados no
     * sean los previamente acordados para la inscripción
     */
    public void registrarEstudiante(ArrayList<String> inscripciones) {
        
        int contador=0;
            for (String datoInscripcion : inscripciones) {
                contador++;
                System.out.println(contador + " "+datoInscripcion);
                String[] inscripcionDividida = datoInscripcion.split(",");

                
                if (inscripcionDividida.length != 4) {
                    
                    
                    JOptionPane.showMessageDialog(null,"El registro en la línea "+ 
                            contador+" no cumple con "
                            + "la estructura necesaria");
                    continue;

                    
                }
           
                Estudiante estudiante = buscarEstudiante(inscripcionDividida[0]);
                if (estudiante != null) {
                    boolean materiaExiste = buscarCodigoMateria(estudiante, inscripcionDividida[2]);
                    if (!materiaExiste) {
                        agregarMateria(estudiante, inscripcionDividida[2]);
                    }
                } else {

                    matricularEstudiante(inscripcionDividida);
                }


            }
        
    }

    /**
     * Metodo para crear un nuevo estudiante y agregarlo a la lista de
     * estudiantes inscritos
     *
     * @param estudiante Objeto estudiante vacio que espera datos
     * @param inscripcionDividida arreglo con los datos de la inscripción a
     * realizar
     */
    private void matricularEstudiante(String[] inscripcionDividida) {
        Estudiante estudiante = new Estudiante();
        estudiante.setCedula(inscripcionDividida[0]);
        estudiante.setNombre(inscripcionDividida[1]);
        agregarMateria(estudiante, inscripcionDividida[2]);
        estudiantes.add(estudiante);
    }

    /**
     * Método que busca un estudiante en la lista de estudiantes para saber si
     * existe
     *
     * @param cedula la cédula del estudiante
     * @return el estudiante si existe o null si no existe.
     */
    private Estudiante buscarEstudiante(String cedula) {
        if (estudiantes.size() == 0) {
            return null;
        }
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
        }

        return null;
    }

    /**
     * Llama al método convertirArchivo de la clase controlArchivo para traer
     * los datos del archivo y guardarlos en una lista
     *
     * @return los datos leídos del archivo en una lista de String
     */
    public ArrayList<String> cargarLista(File archivoAConvertir) {

        ArrayList<String> datos = new ArrayList<String>();
        ControlArchivo controlArchivo = new ControlArchivo();

        try {
            datos = controlArchivo.convertirArchivo(archivoAConvertir);
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, "ERROR: El archivo no pudo leerse."
                    + "correctamente.");
        } catch (ControlArchivoException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        return datos;
    }

    /**
     * Metodo para comprobar si el codigo de la materia ya se encuentra
     * registrada en la lista del estudiante
     *
     * @param estudiante nos permite saber a cual estudiante debemos verificar
     * @param codigo materia a ser buscada en el estudiante
     * @return falso si la materia no este en la lista del estudiante
     * @return true si la materia ya esta en la lista
     */
    private boolean buscarCodigoMateria(Estudiante estudiante, String codigo) {
        ArrayList<String> materias = estudiante.mostrarCodigoMaterias();
        for (String materia : materias) {
            if (materia.equals(codigo)) {
                JOptionPane.showMessageDialog(null, "Esta materia ya está "
                        + "registrada para este estudiante " + codigo);
                return true;
            }
            
        }
        return false;
    }

    /**
     * Metodo para agregar una materia a la lista de un estudiante
     *
     * @param estudiante nos permite saber a cual estudiante debemos agregar
     * @param codigo materia a ser agregada a la lista del estudiante
     */
    private void agregarMateria(Estudiante estudiante, String codigo) {
        estudiante.agregarCodMateriasCursadas(codigo);
    }

    /**
     * metodo que nos devuelve la lsita de estudiantes
     *
     * @return Arraylist con los objetos de tipo estudiante
     */
    public ArrayList<Estudiante> listarEstudiantes() {
        return estudiantes;
    }

    /**
     * metodo para saber la cantidad de materias del estudiante
     *
     * @param estudiante nos permite saber de cual estudiante necesitamos la
     * cantidad de materias
     * @return un entero que es la cantidad de materias del estudiante
     */
    public int totalMateriasEstudiante(Estudiante estudiante) {

        return estudiante.mostrarCodigoMaterias().size();
    }

}

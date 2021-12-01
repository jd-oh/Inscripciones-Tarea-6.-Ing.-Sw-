/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Juan David Osorio y Nicolás Estupiñán
 */
public class Estudiante {
    
    private String nombre;
    private String cedula;
    private ArrayList<String> codigoMateriasCursadas;

    public Estudiante(String nombre, String cedula, ArrayList<String> codMateriasCursadas) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.codigoMateriasCursadas = codMateriasCursadas;
    }

    public Estudiante() {
        codigoMateriasCursadas = new ArrayList<>();
    }
   
    
    
    public ArrayList<String> mostrarCodigoMaterias(){
        return codigoMateriasCursadas;
    }

    public void agregarCodMateriasCursadas(String codigoMateria) {
        codigoMateriasCursadas.add(codigoMateria);
    }
    
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ControlRegistro;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author Juan David
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            JFileChooser chooser = new JFileChooser();

        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        Component parent = null;
        int returnVal = chooser.showSaveDialog(parent);
        String rutaArchivo="";
        ControlRegistro controlRegistro=new ControlRegistro();

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            String nombreCarpeta = chooser.getSelectedFile().getParent();
            String nombreArchivo = chooser.getSelectedFile().getName();
            
            rutaArchivo = nombreCarpeta + "\\" + nombreArchivo;
            System.out.println(rutaArchivo);
        }
        
        File archivo=new File(rutaArchivo);
        
        ArrayList<String> datos=new ArrayList<>();
        
            datos = controlRegistro.cargarLista(archivo);
        
        for (String dato : datos) {
            System.out.println(dato);
        }
    }
    
}

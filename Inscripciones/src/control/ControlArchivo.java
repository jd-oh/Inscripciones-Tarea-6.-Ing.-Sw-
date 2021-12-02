/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Juan David Osorio y Nicolás Estupiñán
 */
public class ControlArchivo {
    
    
    /**
     * Método que recibe un archivo y lo divide por cada línea. 
     *
     * @param archivoAConvertir el archivo que se leerá y convertirá
     * @return lista con cada una de las líneas del archivo
     * @throws FileNotFoundException se lanza la excepcion si no se encuentra el
     * archivo
     * @throws IOException Si el archivo no pudo leerse correctamente
     * @throws ControlArchivoException Si el archivo no tiene formato .txt
     */
    public ArrayList<String> convertirArchivo(File archivoAConvertir)
            throws FileNotFoundException, IOException, ControlArchivoException{
        
        if (!archivoAConvertir.getName().endsWith("txt")) {
            throw new ControlArchivoException("El archivo debe ser de formato .txt");
        }
        
        ArrayList<String> datosString = new ArrayList<>();

        File archivo = new File(archivoAConvertir.getPath());
        FileReader fileReader = new FileReader(archivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String linea;

        while ((linea = bufferedReader.readLine()) != null) {
            String[] palabrasLineaComas = linea.split("\n");
            for (String palabra : palabrasLineaComas) {
                datosString.add(palabra);

            }

        }


        return datosString;

    }
}

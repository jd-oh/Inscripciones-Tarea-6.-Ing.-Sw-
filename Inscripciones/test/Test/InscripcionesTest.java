package Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import control.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.Ventana;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juan David
 */
public class InscripcionesTest {

    public InscripcionesTest() {
    }

    /**
     * Test donde se ingresa un archivo de texto con los datos siguiendo el
     * formato dado.
     *
     */
    @Test
    public void testConvertirArchivoEstructuraCorrecta() throws IOException, FileNotFoundException, ControlArchivoException {
        ControlArchivo controlArchivo = new ControlArchivo();

        File archivo = new File("registro.txt");
        ArrayList<String> resultadoReal = controlArchivo.convertirArchivo(archivo);

        ArrayList<String> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add("1234567,Lulu Lopez,1040,Calculo");
        resultadoEsperado.add("9876534,Pepito Perez,1040,Calculo");
        resultadoEsperado.add("4567766,Calvin Clein,1050,Fisica I");

        assertEquals(resultadoEsperado, resultadoReal);
    }

    /**
     * Test donde se ingresa un archivo con un formato diferente a texto.
     *
     */
    @Test(expected = ControlArchivoException.class)
    public void testConvertirArchivoFormatoDiferente() throws IOException, FileNotFoundException, ControlArchivoException {
        ControlArchivo controlArchivo = new ControlArchivo();

        File archivo = new File("registro.jpg");
        controlArchivo.convertirArchivo(archivo);

    }

}

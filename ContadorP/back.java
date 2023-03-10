import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;


public class back {
    private File carpeta;
    private File[] archivos;


    /**
     * este es el constructor de la clase no hago la conversion a tipo File porque no se si la ruta es correcta
     * y puede salir un error
     * @param ruta
     */
    public back(String ruta) {
        this.carpeta = new File(ruta);
    }


    /**
     * convertimos la ruta en carpeta esta puede sacar un error si no existe
     */
     
    public void setArchivos() throws FileNotFoundException {
        if (this.carpeta.exists() && this.carpeta.isDirectory()) {
            this.archivos = this.carpeta.listFiles();
            }
        else{
            System.out.println("La carpeta no existe");
        }
}


/**
 * 
 * @param palabra
 * @return el total de veces que aparece la palabra en todos los archivos de la carpeta
 * @throws FileNotFoundException si no encuentra el archivo o no puede conectarse con el buffer
 */
public int contarPalabra(String palabra) throws FileNotFoundException {
    int Total = 0;
    int archivosCorrectos = 0;
    int contador = 0;
    for (File archivo : this.archivos) {
        if (archivo.isFile()) {
            String nombre = archivo.getName();
            if (nombre.endsWith(".txt") || nombre.endsWith(".xml") || nombre.endsWith(".json") || nombre.endsWith(".csv")) {
                archivosCorrectos++;
                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] palabras = linea.split("\\W|\\s+|(?<=\\()|(?=\\))");
                        for (String palabraArchivo : palabras) {
                            if (palabraArchivo.equals(palabra)) {
                                contador++;
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "La palabra " + palabra + " aparece " + contador + " veces en el archivo " + nombre);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e +"con el archivo" + archivo.getName());                }
            }
            else {
                JOptionPane.showMessageDialog(null, "El archivo " + nombre + " no es un archivo de texto por lo cual no se puede leer");
            }
        }
        Total = Total + contador;
        contador = 0;
    }
    if (archivosCorrectos == 0) {
        JOptionPane.showMessageDialog(null, "No hay archivos de texto en la carpeta");
    }
    return Total;
}}


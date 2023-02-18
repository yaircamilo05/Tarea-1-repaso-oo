import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class back {
    private File carpeta;
    private File[] archivos;

    public back(String ruta) {
        this.carpeta = new File(ruta);
    }


    public void setArchivos() throws FileNotFoundException {
        if (this.carpeta.exists() && this.carpeta.isDirectory()) {
            this.archivos = this.carpeta.listFiles();
            }
        else{
            System.out.println("La carpeta no existe");
        }
}


public int contarPalabra(String palabra) throws FileNotFoundException {
    int Total = 0;
    int contador = 0;
    for (File archivo : this.archivos) {
        if (archivo.isFile()) {
            String nombre = archivo.getName();
            if (nombre.endsWith(".txt") || nombre.endsWith(".xml") || nombre.endsWith(".json") || nombre.endsWith(".csv")) {
                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        String[] palabras = linea.split("\\W|\\s+|(?<=\\()|(?=\\))");
                        for (String palabraArchivo : palabras) {
                            System.out.println(
                                    "Palabra: buscada " + palabra + " PalabraArchivo:" + palabraArchivo
                            );
                            if (palabraArchivo.equals(palabra)) {
                                System.out.println("Palabra encontrada");
                                contador++;
                            }
                        }
                    }
                    System.out.println("La palabra " + palabra + " aparece " + contador + " veces en el archivo " + nombre);
                } catch (IOException e) {
                    System.out.println("Error al leer el archivo " + nombre + ": " + e.getMessage());
                }
            }
        }
        Total = Total + contador;
        contador = 0;
    }
    return Total;
}}


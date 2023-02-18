import javax.swing.JOptionPane;

public class interfaz{
    public static void main(String[] args) {
        int bandera = 0;
        while (bandera == 0) {
                String ruta = JOptionPane.showInputDialog("Introduce la ruta de la carpeta donde se encuentran los archivos de textos");
                String palabra = JOptionPane.showInputDialog("Introduce la palabra a buscar");
            try {
                back back = new back(ruta);
                back.setArchivos();
                int Total=back.contarPalabra(palabra);
                JOptionPane.showMessageDialog(null, "La palabra " + palabra + " aparece " + Total + " veces en la carpeta " + ruta);
            } catch (Exception FileNotFoundException) {
                JOptionPane.showMessageDialog(null, "Error: carpeta no encontrada o no existe" + FileNotFoundException);
            }
        bandera = Integer.parseInt(JOptionPane.showInputDialog("¿Desea introducir otra carpeta? 0 = Si, 1 = No"));
        }
        }
}
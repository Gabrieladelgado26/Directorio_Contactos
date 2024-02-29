package Clases;

import Logica.Directorio;
import Servlets.SvAgregar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author Adrian Castillo - Gabriela Delgado - Ana Cristina Mera
 */
public class Persistencia {

    /**
     * Método que escribe un archivo .txx con la lista de contactos
     *
     * @param lista
     * @param context
     * @throws FileNotFoundException
     */
    public void escribirArchivo(Collection<Contacto> lista, ServletContext context) {
        // Ubicación del archivo de datos
        String rutaRelativa = "/data/contactosRegistrados.txt";
        String rutaAbsoluta = context.getRealPath(rutaRelativa);
        File archivo = new File(rutaAbsoluta);

        try (PrintWriter pluma = new PrintWriter(archivo)) {
            // Iterar a través de la lista de contactos y escribir sus datos en el archivo
            for (Contacto contacto : lista) {
                // Formatear los datos del contacto en una línea y escribir en el archivo
                String linea = String.format("%s,%s,%s,%s,%s,%s",
                        contacto.getId(),
                        contacto.getNombre(),
                        contacto.getApellido(),
                        contacto.getDireccion(),
                        contacto.getTelefono(),
                        contacto.getEmail());
                pluma.println(linea);
            }
            System.out.println("contactos escrita exitosamente");
        } catch (FileNotFoundException e) {
            System.err.println("Error: No se pudo encontrar el archivo de datos.");
            e.printStackTrace();  // Imprimir el seguimiento de la pila para facilitar la depuración
        } catch (Exception e) {
            System.err.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    /**
     * Método que permite leer el archivo contactosRegistrados.txt que contiene
     * la lista de contactos
     *
     * @param context
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void leerArchivoYAgregarContactos(ServletContext context, Directorio directorio) throws IOException {
        String rutaRelativa = "/data/contactosRegistrados.txt";
        String rutaAbsoluta = context.getRealPath(rutaRelativa);
        File archivo = new File(rutaAbsoluta);

        try (FileReader fr = new FileReader(archivo); BufferedReader lector = new BufferedReader(fr)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre1 = datos[1].trim();
                String apellido1 = datos[2].trim();
                String direccion1 = datos[3].trim();
                String telefono1 = datos[4].trim();
                String email1 = datos[5].trim();

                directorio.agregarContacto(nombre1, apellido1, direccion1, telefono1, email1);
            }
        } catch (ContactoRepetidoException ex) {
            Logger.getLogger(SvAgregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

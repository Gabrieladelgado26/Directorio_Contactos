package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletContext;

/**
 *
 * @author Gabriela Delgado
 */
public class Persistencia {

    public Persistencia() {
    }

    /**
     * Método que escribe un archivo .txx con la lista de contactos
     * @param lista
     * @param context
     * @throws FileNotFoundException 
     */
    public void escribirArchivo(Collection<Contacto> lista, ServletContext context) throws FileNotFoundException {

        // Ubicación del archivo de datos
        String rutaRelativa = "/data/contactosRegistrados.txt";
        String rutaAbsoluta = context.getRealPath(rutaRelativa);
        File archivo = new File(rutaAbsoluta);

        try (PrintWriter pluma = new PrintWriter(archivo)) {
            // Iterar a través de la lista de usuario y escribir sus datos en el archivo
            for (Contacto contacto : lista) { // Aquí se corrige el nombre de la colección
                // Formatear los datos del alumno en una línea y escribir en el archivo
                String linea = contacto.getId() + "," + contacto.getNombre() + "," + contacto.getApellido() + ","
                        + contacto.getDireccion() + contacto.getTelefono() + contacto.getEmail();
                pluma.println(linea);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo de datos.");
        }
    }

    /**
     * Método que permite leer el archivo contactosRegistrados.txt que contiene la lista de contactos
     * @param context
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Collection<Contacto> leerArchivo(ServletContext context) throws FileNotFoundException, IOException {

        Collection lista = new ArrayList();
        // Ubicación del archivo de datos
        String rutaRelativa = "/data/contactosRegistrados.txt";
        String rutaAbsoluta = context.getRealPath(rutaRelativa);
        File archivo = new File(rutaAbsoluta);

        try (FileReader fr = new FileReader(archivo); BufferedReader lector = new BufferedReader(fr)) {

            String linea;
            // Leer cada línea del archivo y procesar los datos

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");

                String id = datos[0].trim();
                String nombre = datos[1].trim();
                String apellido = datos[2].trim();
                String direccion = datos[3].trim();
                String telefono = datos[4].trim();
                String email = datos[5].trim();

                // Crear un objeto Contacto con los datos leídos y agregarlo a la lista
                Contacto contacto = new Contacto(nombre, apellido, direccion, telefono, email);
                contacto.setId(Integer.parseInt(id));
                lista.add(contacto); // Aquí se corrige el nombre de la colección
                return lista;
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo de datos.");
        } catch (IOException e) {
            System.out.println("Error durante la lectura del archivo.");
        }
        return null;
    }

}
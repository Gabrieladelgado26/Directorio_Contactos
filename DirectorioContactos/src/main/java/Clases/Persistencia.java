package Clases;

import Logica.Directorio;
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
                
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo de datos.");
        } catch (IOException e) {
            System.out.println("Error durante la lectura del archivo.");
        }
        return lista;
    }

}

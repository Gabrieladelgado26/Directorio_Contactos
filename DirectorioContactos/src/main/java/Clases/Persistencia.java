package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletContext;

public class Persistencia {

    /**
     * Guarda la lista de tareas en un archivo de texto.
     *
     * @param tareas La lista de tareas que se va a guardar en el archivo.
     */
    public void guardarContactos(List<Contacto> listaDeContactos, ServletContext context) {
        /**
         * Establecemos la ruta
         */
        String ruta = "/data/listaDeContactos.txt";// Nombramos la carpeta ya creada y el tipo de archivo que queremos crear -Datos conocidos

        String rutaa = context.getRealPath(ruta);
        try (FileWriter fileWriter = new FileWriter(rutaa); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Contacto contacto : listaDeContactos) {
                bufferedWriter.write(contacto.getId() + "," + contacto.getNombre() + "," + contacto.getApellido() + "," + contacto.getDireccion() + "," + contacto.getTelefono()+ "," + contacto.getEmail());
                bufferedWriter.newLine();
            }

            System.out.println("La lista de contactos fue escricta exitosamente");

        } catch (IOException e) {
            System.out.println("No se pudo escrbir en el archivo");
        }
    }
    
    
    
    
        public Collection<Contacto> leerListaContactos(ServletContext context) {
        String ruta = "/data/listaDeContactos.txt";// Nombramos la carpeta ya creada y el tipo de archivo que queremos crear -Datos conocidos

        String rutaa = context.getRealPath(ruta);
        Collection<Contacto> listaDeContactos = new ArrayList<Contacto>();

        try (FileReader fileReader = new FileReader(rutaa); BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 6) {
                    int id = Integer.parseInt(partes[0]);
                    String nombre = partes[1];
                    String apellido = partes[2];
                    String direccion = partes[3];
                    String telefono = partes[4];
                    String email = partes[5];
                    Contacto contacto = new Contacto(nombre, apellido, direccion, telefono, email);
                    contacto.setId(id);
                    listaDeContactos.add(contacto);
                    
                }
            }
            System.out.println("se ha leido el archivo la lista es "+listaDeContactos.isEmpty());
            

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }

        return listaDeContactos;
    }
}

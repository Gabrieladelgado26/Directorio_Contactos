package Servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import Logica.Directorio;
import Clases.Contacto;
import Clases.ContactoRepetidoException;
import Clases.Persistencia;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author Adrian Castillo - Gabriela Delgado - Ana Cristina Mera
 */
@WebServlet(name = "SvAgregar", urlPatterns = {"/SvAgregar"}, loadOnStartup = 1)
public class SvAgregar extends HttpServlet {

    Directorio directorio = new Directorio();
    Persistencia persistencia = new Persistencia();
    boolean contactosAgregados = false;

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();

        // Se lee la lista de contactos desde la persistencia
        Collection<Contacto> listaContactos = persistencia.leerListaContactos(context);

        // Verificar si los contactos ya fueron agregados
        if (!contactosAgregados) {
            directorio.agregarListaContactos(listaContactos);
            System.out.println("Se cargaron los contacto en agregar");
            contactosAgregados = true; // Cambiar el valor de la variable a true después de agregar los contactos
        }

        // Obtener parámetros del formulario
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");

        try {
            // Agregar el nuevo contacto al Directorio
            directorio.agregarContacto(nombres, apellidos, direccion, telefono, correo);

            // Guardar la lista actualizada en la persistencia
            persistencia.guardarContactos((List<Contacto>) directorio.darListaContactos(), context);

            // Redireccionar a la página principal
            response.sendRedirect("index.jsp");

        } catch (ContactoRepetidoException ex) {
            System.out.println("El contacto está repetido: " + nombres);
            // Manejar la excepción de contacto repetido según sea necesario
        }
    }
}

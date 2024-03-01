package Servlets;

import Clases.Contacto;
import Clases.ContactoRepetidoException;
import Clases.Persistencia;
import Logica.Directorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrian Castillo - Gabriela Delgado - Ana Cristina Mera
 */
@WebServlet(name = "SvEliminar", urlPatterns = {"/SvEliminar"})
public class SvEliminar extends HttpServlet {

    private Directorio directorio = new Directorio();
    private Persistencia persistencia = new Persistencia();
    private boolean contactosAgregados = false;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el contexto del servlet
        ServletContext context = getServletContext();

        // Obtener el parámetro 'nombre' desde la solicitud y convertirlo a entero
        String nombre = request.getParameter("nombre");

        Collection<Contacto> listaContactos = persistencia.leerListaContactos(context);

        // Verificar si los contactos ya fueron agregados
        if (!contactosAgregados) {
            directorio.agregarListaContactos(listaContactos);
            System.out.println("Se cargaron los contacto en eliminar");
            contactosAgregados = true; // Cambiar el valor de la variable a true después de agregar los contactos
        }

        // Eliminar el contacto por Nombre
        directorio.eliminarContactoPorNombre(nombre);

        // Escribir la lista actualizada de contactos en el archivo
        persistencia.guardarContactos((List<Contacto>) directorio.darListaContactos(), context);

        // Redirigir a la página principal
        response.sendRedirect("index.jsp");
    }
}

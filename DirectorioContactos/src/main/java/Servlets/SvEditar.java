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
import jdk.internal.logger.BootstrapLogger;

/**
 *
 * @author ADRIAN CASTILLO
 */
@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {

    private Directorio directorio = new Directorio();
    private Persistencia persistencia = new Persistencia();
    private boolean contactosAgregados = false;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();

        // Se lee la lista de contactos desde la persistencia
        Collection<Contacto> listaContactos = persistencia.leerListaContactos(context);

        // Verificar si los contactos ya fueron agregados
        if (!contactosAgregados) {
            directorio.agregarListaContactos(listaContactos);
            System.out.println("Se cargaron los contacto en editar");
            contactosAgregados = true; // Cambiar el valor de la variable a true después de agregar los contactos
        }

        // recibir parametros del formulario
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");

        System.out.println(nombres + "," + apellidos + "," + direccion + "," + telefono + "," + correo);
        Contacto newContacto = new Contacto(nombres, apellidos, direccion, telefono, correo);

        // buscar el conctacto
        directorio.editarContacto(newContacto.getNombre(), newContacto);
        persistencia.guardarContactos((List<Contacto>) directorio.darListaContactos(), context);
        response.sendRedirect("index.jsp");

    }

}

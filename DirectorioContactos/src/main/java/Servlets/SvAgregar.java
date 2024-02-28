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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adrian Castillo - Gabriela Delgado - Ana Cristina Mera
 */
@WebServlet(name = "SvAgregar", urlPatterns = {"/SvAgregar"}, loadOnStartup = 1)
public class SvAgregar extends HttpServlet {

    private Directorio directorio = new Directorio();
    private Persistencia persistencia = new Persistencia();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        ServletContext context = getServletContext();

        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        
        boolean contactoRepetido;
        
        // Se redirige a la página index.jsp dependiendo de si el contacto es repetido o no
        if (contactoRepetido = true) {
            System.out.println("El contacto ya se encuentra en el directorio");
            request.getSession().setAttribute("errorContactoRepetido", true);
            response.sendRedirect("index.jsp");
        } else {
            // Si el contacto no es repetido, se establece un atributo de sesión y se redirige a index.jsp
            HttpSession session = request.getSession();
            session.setAttribute("errorContactoRepetido", false);
            persistencia.leerArchivoYAgregarContactos(context, directorio);
            try {
                directorio.agregarContacto(nombres, apellidos, direccion, telefono, correo);
            } catch (ContactoRepetidoException ex) {
                Logger.getLogger(SvAgregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            persistencia.escribirArchivo(directorio.darListaContactos(), context);
            request.getSession().setAttribute("listaContactos", directorio.darListaContactos());
            response.sendRedirect("index.jsp");
        }
    }
}

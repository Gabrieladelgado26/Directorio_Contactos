package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica.Directorio;
import Clases.Contacto;
import Clases.ContactoRepetidoException;
import Clases.Persistencia;
import java.util.Collection;
import javax.servlet.ServletContext;

/**
 *
 * @author ADRIAN CASTILLO
 */
@WebServlet(name = "SvAgregar", urlPatterns = {"/SvAgregar"})
public class SvAgregar extends HttpServlet {

    Directorio directorio = new Directorio();
    Persistencia persistencia = new Persistencia();

    
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

        // Obtener el contexto del servlet
        ServletContext context = getServletContext();

//        Collection lista = persistencia.leerArchivo(context);

//        try {
//            persistencia = Persistencia.leerArchivo(context);
//            if (persistencia == null) {
//                persistencia = new Contacto();
//            }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SvAgregar.class.getName()).log(Level.SEVERE, null, ex);
//        }

        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");

        //System.out.println(nombres +", "+apellidos+", "+direccion+", "+telefono+", "+correo);
        try {
            directorio.agregarContacto(nombres, apellidos, direccion, telefono, correo);
            Collection<Contacto> listaContactos = directorio.darListaContactos();
            persistencia.escribirArchivo(listaContactos, context);

            request.getSession().setAttribute("listaContactos", listaContactos);

            response.sendRedirect("index.jsp");

        } catch (ContactoRepetidoException ex) {
            System.out.println("El contacto esta repetido");;
        }
    }
}

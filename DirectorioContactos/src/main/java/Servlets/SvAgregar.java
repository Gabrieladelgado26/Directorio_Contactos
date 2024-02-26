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

        try {

            persistencia.leerArchivoYAgregarContactos(context, directorio);

            directorio.agregarContacto(nombres, apellidos, direccion, telefono, correo);

            persistencia.escribirArchivo(directorio.darListaContactos(), context);

            request.getSession().setAttribute("listaContactos", directorio.darListaContactos());

            response.sendRedirect("index.jsp");

        } catch (ContactoRepetidoException ex) {
            System.out.println("El contacto está repetido");
            response.sendRedirect("index.jsp");
            ex.printStackTrace();
        }
    }


}

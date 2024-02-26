/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Clases.Persistencia;
import Logica.Directorio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADRIAN CASTILLO
 */
@WebServlet(name = "SvEliminar", urlPatterns = {"/SvEliminar"})
public class SvEliminar extends HttpServlet {

    private Directorio directorio = new Directorio();
    private Persistencia persistencia = new Persistencia();

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

        // Obtener el parámetro 'nombre' desde la solicitud
        String nombre = request.getParameter("nombre");

        // Leer el archivo y agregar contactos al directorio
        persistencia.leerArchivoYAgregarContactos(context, directorio);

        // Eliminar el contacto por nombre
        directorio.eliminarContactoPorNombre(nombre);

        // Escribir la lista actualizada de contactos en el archivo
        persistencia.escribirArchivo(directorio.darListaContactos(), context);
        
        response.sendRedirect("index.jsp");
    }
}

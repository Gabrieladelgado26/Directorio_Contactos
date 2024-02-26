/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Clases.Contacto;
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
import jdk.internal.logger.BootstrapLogger;

/**
 *
 * @author ADRIAN CASTILLO
 */
@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {

    private Directorio directorio = new Directorio();
    private Persistencia persistencia = new Persistencia();
    private Contacto contacto = new Contacto();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        persistencia.leerArchivoYAgregarContactos(context, directorio);

        // recibir parametros del formulario
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        
        System.out.println(nombres +","+apellidos+","+direccion+","+telefono+","+correo);
        Contacto newContacto = new Contacto(nombres, apellidos, direccion, telefono, correo);
        
        // buscar el conctacto
        directorio.editarContacto(newContacto.getNombre(), newContacto);
        persistencia.escribirArchivo(directorio.darListaContactos(), context);
        response.sendRedirect("index.jsp");
        System.out.println("listo");
        
        

    }

}

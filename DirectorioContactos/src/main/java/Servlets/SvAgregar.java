/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica.DirectorioDeContactos;
import Clases.Contacto;

/**
 *
 * @author ADRIAN CASTILLO
 */
@WebServlet(name = "SvAgregar", urlPatterns = {"/SvAgregar"})
public class SvAgregar extends HttpServlet {

    DirectorioDeContactos directorio = new DirectorioDeContactos();


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
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        
        boolean contactoAgregado = directorio.agregarContacto(new Contacto(id, nombres, apellidos, direccion, telefono, correo));
        if(contactoAgregado==true){
            System.out.println("se ha agregado un nuevo contacto");
            response.sendRedirect("index.jsp");
            request.getSession().setAttribute("ContactoAgregado", true);
        }else{
            System.out.println("no se puedo agregar el contacto");
            response.sendRedirect("index.jsp");
        }
        
        
        
    }

}

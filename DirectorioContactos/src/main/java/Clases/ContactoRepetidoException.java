/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ContactoRepetidoException.java,v 1.5 2006/10/22 02:18:41 da-romer Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n11_contactos
 * Autor: Katalina Marcos - 27/10/2005
 * Autor: Jorge Villalobos - 11/10/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package Clases;

/**
 * Representa la excepci�n asociada con el intento de incluir en el directorio un contacto con el mismo nombre de uno que ya est� presente
 */
public class ContactoRepetidoException extends Exception
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor de la excepci�n
     * @param nombreContacto es el nombre del contacto que se intent� agregar
     */
    public ContactoRepetidoException(String nombreContacto)
    {
        super( "Ya existe un contacto con ese nombre: " + nombreContacto );
    }
}
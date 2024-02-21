/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Clases.Contacto;
import Clases.ContactoRepetidoException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author ADRIAN CASTILLO
 */
public class Directorio {

    private Contacto contactoRaiz;

    private int numContactos;

    public Directorio() {
        this.contactoRaiz = null;
        numContactos = 1;
    }

    /**
     * Agrega un contacto al directorio <br>
     * <b>post: </b>El contacto ha sido agregado al directorio.
     *
     * @param nom nombre del contacto - nom != null
     * @param tel tel�fono del contacto
     * @param dir direcci�n del contacto
     * @param email direcci�n electr�nica del contacto
     * @throws ContactoRepetidoException cuando ya existe un contacto con ese
     * nombre
     */
    public void agregarContacto(String nombre, String apellido, String direccion, String telefono, String email) throws ContactoRepetidoException {
        Contacto c = new Contacto(nombre, apellido, direccion, telefono, email);
        if (contactoRaiz == null) {
            c.setId(numContactos);
            contactoRaiz = c;
        } else {
            c.setId(numContactos);
            contactoRaiz.insertar(c);
            
        }
        numContactos++;
        verificarInvariante();
    }

    // -----------------------------------------------------------------
    // M�todos privados
    // -----------------------------------------------------------------
    /**
     * Retorna la altura del �rbol de contactos
     *
     * @return La altura del �rbol de contactos
     */
    private int darAltura() {
        return contactoRaiz == null ? 0 : contactoRaiz.darAltura();
    }

    /**
     * Retorna el menor contacto del directorio, teniendo en cuenta el orden
     * alfab�tico de los nombres
     *
     * @return El contacto con menor nombre del directorio o null si el
     * directorio es vac�o
     */
    private Contacto darMenor() {
        return contactoRaiz == null ? null : contactoRaiz.darMenor();
    }

    /**
     * Retorna el mayor contacto del directorio, teniendo en cuenta el orden
     * alfab�tico de los nombres
     *
     * @return El contacto con mayor nombre del directorio o null si el
     * directorio es vac�o
     */
    private Contacto darMayor() {
        return contactoRaiz == null ? null : contactoRaiz.darMayor();
    }

    /**
     * Retorna el n�mero de hojas que tiene el �rbol de contactos
     *
     * @return N�mero de hojas que tiene el �rbol de contactos
     */
    private int contarHojas() {
        return contactoRaiz == null ? 0 : contactoRaiz.contarHojas();
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Verifica que en el directorio no haya dos contactos con el mismo nombre
     */
    private boolean sinRepetidos() {
        if (contactoRaiz == null) {
            return true;
        } else {
            Iterator itera = darListaContactos().iterator();
            while (itera.hasNext()) {
                String nombre = (String) itera.next();
                if (contarOcurrencias(nombre) != 1) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Cuenta el n�mero de contactos en el directorio que tienen el nombre dado
     * como par�metro <br>
     * <b>pre: </b> El �rbol de contactos no es vac�o
     *
     * @param nombre nombre del contacto del cual se est� contando el n�mero de
     * ocurrencias
     */
    private int contarOcurrencias(String nombre) {
        return contactoRaiz.contarOcurrencias(nombre);
    }

    /**
     * Verifica que el �rbol binario est� ordenado
     */
    private boolean esOrdenado() {
        return contactoRaiz == null ? true : contactoRaiz.esOrdenado();
    }

    /**
     * Retorna el n�mero de contactos que est�n en el directorio
     *
     * @return n�mero de contactos presentes en el �rbol
     */
    private int darPeso() {
        return contactoRaiz == null ? 0 : contactoRaiz.darPeso();
    }

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv:</b> <br>
     * No hay dos contactos con el mismo nombre en el directorio <br>
     * El �rbol de contactos es un �rbol binario ordenado <br>
     * numContactos es el n�mero de contactos presentes en el directorio
     */
    private void verificarInvariante() {
        assert sinRepetidos() : "Contactos repetidos";
        assert esOrdenado() : "No es un �rbol ordenado";
        assert numContactos == darPeso() : "N�mero incorrecto de contactos";
    }

    /**
     * Retorna una lista ordenada con los nombres de los contactos
     *
     * @return lista de contactos ordenada por orden alfab�tico. Si la lista
     * est� vac�a retorna null
     */
    public Collection darListaContactos() {
        if (contactoRaiz == null) {
            return null;
        } else {
            Collection resp = new ArrayList();
            contactoRaiz.inorden(resp);
            return resp;
        }
    }


}


package Logica;

import Clases.Contacto;
import Clases.ContactoRepetidoException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Adrian Castillo - Gabriela Delgado - Ana Cristina Mera
 */
public class Directorio {

    private Contacto contactoRaiz;

    private int numContactos;

    public Directorio() {
        this.contactoRaiz = null;
        numContactos = 1;
    }

    /**
     *
     * @param nombre Nombre del contacto
     * @param apellido Apellido del contacto
     * @param direccion Dirección del contacto
     * @param telefono Telefono del contacto
     * @param email Email del contacto
     * @throws ContactoRepetidoException
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

    /**
     * Elimina un contacto del directorio por id.
     * Elimina un contacto del directorio por id.
     *
     * @param id id del contacto que se va a eliminar
     */
    public void eliminarContactoPorNombre(String nombre) {
        if (contactoRaiz != null) {
            contactoRaiz = contactoRaiz.eliminar(nombre);
            System.out.println("se ha eliminado un contacto");
            verificarInvariante();
        }
    }

    public void editarContacto(String nombre, Contacto contactoActualizado) {
        Contacto contactoExistente = contactoRaiz.buscarIterativo(nombre);

        if (contactoExistente != null) {
            // Actualizar los campos del contacto existente con los datos del contacto actualizado
            contactoExistente.setNombre(contactoActualizado.getNombre());
            contactoExistente.setApellido(contactoActualizado.getApellido());
            contactoExistente.setDireccion(contactoActualizado.getDireccion());
            contactoExistente.setTelefono(contactoActualizado.getTelefono());
            contactoExistente.setEmail(contactoActualizado.getEmail());
            System.out.println("El contacto a sido editado");
        }
    }

    // -----------------------------------------------------------------
    // Metodos privados
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
    
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv:</b> <br>
     * No hay dos contactos con el mismo nombre en el directorio <br>
     * El �rbol de contactos es un �rbol binario ordenado <br>
     * numContactos es el n�mero de contactos presentes en el directorio
     */
    private void verificarInvariante() {
        assert sinRepetidos() : "Contactos repetidos";
        assert esOrdenado() : "No es un arbol ordenado";
        assert numContactos == darPeso() : "Numero incorrecto de contactos";
    }

    /**
     * Retorna una lista ordenada con los nombres de los contactos
     *
     * @return lista de contactos ordenada por orden alfab�tico. Si la lista
     * est� vac�a retorna null
     */
    public Collection<Contacto> darListaContactos() {
        if (contactoRaiz == null) {
            return null;
        } else {
            Collection resp = new ArrayList();
            contactoRaiz.inorden(resp);
            return resp;
        }
    }

    public boolean agregarListaContactos(Collection<Contacto> listaContactos) {
        if (listaContactos != null && !listaContactos.isEmpty()) {
            for (Contacto contacto : listaContactos) {
                try {
                    // Agregar cada contacto a la instancia de Directorio
                    agregarContacto(contacto.getNombre(), contacto.getApellido(), contacto.getDireccion(), contacto.getTelefono(), contacto.getEmail());
                    
                } catch (ContactoRepetidoException ex) {
                    System.out.println("El contacto está repetido: " + contacto.getNombre());
                }
            }
            return true;
        }
        return false;
    }

}

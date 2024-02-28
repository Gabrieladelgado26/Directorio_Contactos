package Clases;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Adrian Castillo - Gabriela Delgado - Ana Cristina Mera
 */
public class Contacto implements Comparable {

    // Atributos de la clase contacto
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private Contacto izq;
    private Contacto der;

    /**
     * Constructor vacio
     */
    public Contacto() {
    }

    /**
     * Constructor de la clase Contacto.
     *
     * @param id Identificador del contacto.
     * @param nombre Nombre del contacto.
     * @param apellido Apellido del contacto.
     * @param direccion Dirección del contacto.
     * @param telefono Número de teléfono del contacto.
     * @param email Correo electrónico del contacto.
     */
    public Contacto(String nombre, String apellido, String direccion, String telefono, String email) {
        // Inicialización de los atributos con los valores proporcionados

        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.der = null;
        this.izq = null;
    }

    /**
     * GETTERS AND SETTERS
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contacto getHijoIzquierdo() {
        return izq;
    }

    public void setHijoIzquierdo(Contacto hijoIzquierdo) {
        this.izq = hijoIzquierdo;
    }

    public Contacto getHijoDerecho() {
        return der;
    }

    public void setHijoDerecho(Contacto hijoDerecho) {
        this.der = hijoDerecho;
    }

    /**
     * Indica si este nodo es una hoja
     *
     * @return true si este nodo es una hoja y false en caso contrario
     */
    public boolean esHoja() {
        return izq == null && der == null;
    }

    /**
     * Retorna el contacto que alfab�ticamente corresponde al menor contacto del
     * �rbol que parte de este nodo
     *
     * @return contacto con menor nombre
     */
    public Contacto darMenor() {
        return (izq == null) ? this : izq.darMenor();
    }

    /**
     * Retorna el contacto que alfab�ticamente corresponde al mayor contacto del
     * �rbol que parte de este nodo
     *
     * @return contacto con mayor nombre
     */
    public Contacto darMayor() {
        return (der == null) ? this : der.darMayor();
    }

    /**
     * Retorna el n�mero de contactos que hay en el �rbol que comienza en este
     * nodo utilizando un algoritmo iterativo
     *
     * @return n�mero de contactos en el �rbol que comienza en este nodo
     */
    public int darPesoIterativo() {
        int peso = 0;
        ArrayList pila = new ArrayList();
        Contacto p = this;
        while (p != null) {
            peso++;
            if (p.izq != null) {
                // Guarda el sub�rbol derecho en la pila, para recuperarlo m�s tarde
                if (p.der != null) {
                    pila.add(p.der);
                }

                // Baja por la izquierda
                p = p.izq;
            } else if (p.der != null) {
                // Baja por la derecha, puesto que no hay sub�rbol izquierdo
                p = p.der;
            } else if (pila.size() != 0) {
                // Es una hoja, luego debemos sacar de la pila el �ltimo sub�rbol all� almacenado
                p = (Contacto) pila.get(0);
                pila.remove(0);
            } else {
                p = null;
            }
        }
        return peso;
    }

    /**
     * Retorna el n�mero de contactos que hay en el �rbol que comienza en este
     * nodo
     *
     * @return n�mero de contactos en el �rbol que comienza en este nodo
     */
    public int darPeso() {
        int p1 = (izq == null) ? 0 : izq.darPeso();
        int p2 = (der == null) ? 0 : der.darPeso();
        return 1 + p1 + p2;
    }

    /**
     * Retorna el n�mero de hojas que hay en el �rbol que comienza en este nodo
     *
     * @return n�mero de hojas que hay en el �rbol que comienza en este nodo
     */
    public int contarHojas() {
        if (esHoja()) {
            return 1;
        } else {
            int h1 = (izq == null) ? 0 : izq.contarHojas();
            int h2 = (der == null) ? 0 : der.contarHojas();
            return h1 + h2;
        }
    }

    /**
     * Inserta un nuevo contacto al �rbol que comienza en este nodo.
     *
     * @param nuevo el el nuevo contacto que se va a insertar - nuevo != null
     * @throws ContactoRepetidoException se lanza esta excepci�n si el contacto
     * que se quiere agregar ya est� en el directorio
     */
    public void insertar(Contacto nuevo) throws ContactoRepetidoException {
        if (compareTo(nuevo) == 0) {
            throw new ContactoRepetidoException(nuevo.nombre);
        }

        if (compareTo(nuevo) > 0) {
            // Debe agregar el nuevo contacto por el sub�rbol izquierdo
            if (izq == null) {
                izq = nuevo;
            } else {
                izq.insertar(nuevo);
            }
        } else {
            // Debe agregar el nuevo contacto por el sub�rbol derecho
            if (der == null) {
                der = nuevo;
            } else {
                der.insertar(nuevo);
            }
        }
    }

    /**
     * Implementaci�n iterativa para localizar un contacto en el �rbol que
     * comienza en este nodo
     *
     * @param unNombre nombre que se va a buscar - unNombre != null
     * @return contacto asociado al nombre. Si no lo encuentra retorna null;
     */
    public Contacto buscarIterativo(String unNombre) {
        Contacto p = this;
        while (p != null) {
            int comp = p.nombre.compareToIgnoreCase(unNombre);
            if (comp == 0) {
                return p;
            } else if (comp > 0) {
                p = p.izq;
            } else {
                p = p.der;
            }
        }
        return null;
    }

    /**
     * Elimina un contacto del �rbol que comienza en este nodo.
     *
     * @param unNombre nombre del contacto que se va a eliminar - hay un
     * contacto en el �rbol que se llama unNombre
     * @return el �rbol de contactos despu�s de eliminar el contacto indicado
     */
    public Contacto eliminar(int unId) {
        if (esHoja()) {
            return null;
        }
        if (id == unId) { // Compara el id del contacto con el id proporcionado
            if (izq == null) {
                return der;
            }
            if (der == null) {
                return izq;
            }
            // Localiza el menor contacto del subárbol derecho
            Contacto sucesor = der.darMenor();
            // Elimina del subárbol derecho el elemento que acaba de localizar
            der = der.eliminar(sucesor.getId());
            // Deja el elemento localizado en la raíz del árbol de respuesta
            sucesor.izq = izq;
            sucesor.der = der;
            return sucesor;
        } else if (id > unId) {
            izq = izq.eliminar(unId);
        } else {
            der = der.eliminar(unId);
        }
        return this;
    }

    /**
     * Retorna una colecci�n con los nombres de todos los contactos, ordenados
     * alfab�ticamente en orden ascendente
     *
     * @param acumulado colecci�n donde se van agregando los nombres de los
     * contactos ordenadamente
     */
    public void inorden(Collection acumulado) {
        // Recorre en inorden el sub�rbol izquierdo
        if (izq != null) {
            izq.inorden(acumulado);
        }
        // Incluye en el recorrido el contacto de la ra�z
        acumulado.add(this);
        // Recorre en inorden el sub�rbol derecho
        if (der != null) {
            der.inorden(acumulado);
        }
    }

    /**
     * Indica si el �rbol que comienza en este nodo es ordenado
     *
     * @return true si el �rbol que comienza en este nodo es ordenado
     */
    public boolean esOrdenado() {
        if (esHoja()) {
            return true;
        } else if (izq == null) {
            return der.esOrdenado() && nombre.compareTo(der.darMenor().getNombre()) < 0;
        } else if (der == null) {
            return izq.esOrdenado() && nombre.compareTo(izq.darMayor().getNombre()) > 0;
        } else {
            return der.esOrdenado() && nombre.compareTo(der.darMenor().getNombre()) < 0 && izq.esOrdenado() && nombre.compareTo(izq.darMayor().getNombre()) > 0;
        }
    }

    /**
     * Cuenta el n�mero de veces que aparece un contacto con un nombre que se
     * recibe como par�metro
     *
     * @param nombreP nombre del contacto que se est� buscando - nombreP != null
     * @return n�mero de contactos con un nombre dado
     */
    public int contarOcurrencias(String nombreP) {
        int cuantos = 0;
        if (nombre.equals(nombreP)) {
            cuantos++;
        }
        cuantos += (izq == null) ? 0 : izq.contarOcurrencias(nombreP);
        cuantos += (der == null) ? 0 : der.contarOcurrencias(nombreP);
        return cuantos;
    }

    // -----------------------------------------------------------------
    // Trabajo estudiantes
    // -----------------------------------------------------------------
    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Verifica el invariante de la clase. <br>
     * <b>inv:</b> <br>
     * nombre != null.
     */
    public void verificarInvariante() {
        assert nombre != null : "Nombre inv�lido";
    }

    @Override
    public int compareTo(Object o) {
        Contacto otro = (Contacto) o;
        return nombre.compareToIgnoreCase(otro.nombre);
    }
}

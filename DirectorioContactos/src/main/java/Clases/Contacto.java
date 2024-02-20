/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author ADRIAN CASTILLO
 */
public class Contacto {
    // Atributos de la clase contacto
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private Contacto hijoIzquierdo;
    private Contacto hijoDerecho;
    
    /**
     * Constructor de la clase Contacto.
     * 
     * @param id        Identificador del contacto.
     * @param nombre    Nombre del contacto.
     * @param apellido  Apellido del contacto.
     * @param direccion Dirección del contacto.
     * @param telefono  Número de teléfono del contacto.
     * @param email     Correo electrónico del contacto.
     */
    public Contacto(int id, String nombre, String apellido, String direccion, String telefono, String email) {
        // Inicialización de los atributos con los valores proporcionados
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.hijoDerecho= null;
        this.hijoIzquierdo = null;
        
    }

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
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Contacto hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Contacto getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Contacto hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    
    
    
    
}

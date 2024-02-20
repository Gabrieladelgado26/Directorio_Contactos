/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Clases.Contacto;
/**
 *
 * @author ADRIAN CASTILLO
 */
public class DirectorioDeContactos {
    Contacto raiz;

    public DirectorioDeContactos() {
        this.raiz = null;
    }
    
    public boolean agregarContacto(Contacto contacto){
        Contacto nuevoContacto = contacto;
        if(raiz == null){
            raiz = nuevoContacto;
            return true;
        }else{
            Contacto auxiliar=raiz;
            Contacto padre;
            
            while(true){
                padre = auxiliar;
                if(nuevoContacto.getId() < padre.getId()){
                    auxiliar = auxiliar.getHijoIzquierdo();
                    if(auxiliar==null){
                        padre.setHijoIzquierdo(nuevoContacto);
                        return true;
                    }
                }else{
                    auxiliar=auxiliar.getHijoDerecho();
                    if(auxiliar == null){
                        padre.setHijoDerecho(nuevoContacto);
                        return true;
                    }
                }
            }
           
        }
        
    }
    
    
    public Contacto estaVacio(){
        return raiz = null;
    }
     
    
    public void inOrden(Contacto contacto){
        
        if(contacto!=null){
            inOrden(contacto.getHijoIzquierdo());
            System.out.println(contacto);
            inOrden(contacto.getHijoDerecho());
        }
    }
}

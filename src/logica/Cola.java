/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Cola {
    
    private Ticket cabeza;

    Scanner sc = new Scanner(System.in);


    
    public boolean estaVacia() {
        
        return this.cabeza == null;
        
    }
    
    public void encolar(Ticket nuevoNodo){
        
        if(this.estaVacia()){
            
            this.cabeza = nuevoNodo;
            
        }else{
            
            Ticket aux = this.cabeza;
            
            while(aux.getProximoTicket() != null){
                
                aux = aux.getProximoTicket();
            
            }
            
            aux.setProximoTicket(nuevoNodo);
            
        }
        
    }
    
    public Ticket desencolar(){
        
        if(! this.estaVacia()){
            Ticket aux=this.cabeza;
            this.cabeza = this.cabeza.getProximoTicket();
            return aux;
            
        }
         return null;
    }
     
    public Ticket primeroEnCola(){
        
        this.cabeza.presentar();
        return this.cabeza;
    }
    

}

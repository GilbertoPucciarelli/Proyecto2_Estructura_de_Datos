package logica;

import java.util.Scanner;

public class Sala {
    
    //ATRIBUTOS DE LA CLASE
    protected int codigo;
    
    protected int precio;
    
    protected String pelicula;
    
    protected Sala hijoIzq;
    
    protected Sala hijoDer;
    
    Scanner sc = new Scanner(System.in);

    //CONSTRUCTOR DE LA CLASE
    public Sala(int codigo, int precio) {
        
        this.codigo = codigo;
        
        this.precio = precio;
        
        this.hijoIzq = null;
        
        this.hijoDer = null;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Sala getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Sala hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Sala getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Sala hijoDer) {
        this.hijoDer = hijoDer;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPelicula() {
        
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }
    
    //METODO QUE PERMITE PRESENTAR LAS SALAS
    public void presentarSala(){
        
        System.out.println("Sala # "+this.codigo+" Tipo: "+this.getClass().getSimpleName());
    }
    
    //METODO QUE PERMITE MODIFICAR LOS DATOS DE UNA SALA
    public void modificarSalas(Sala aux){
        
        System.out.println("Ingrese el nuevo codigo de la sala");
        int nuevoC = sc.nextInt();
        
        aux.setCodigo(nuevoC);
    }
}

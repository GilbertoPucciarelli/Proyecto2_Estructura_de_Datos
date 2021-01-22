package logica;

import java.util.Scanner;

public class ArbolBB {

    //ATRIBUTOS DE LA CLASE
    private Sucursal raiz;
    
    private Sala raizSalas;
    
    Scanner sc = new Scanner(System.in);

    public Sucursal getRaiz() {

        return this.raiz;

    }

    public void setRaiz(Sucursal raiz) {

        this.raiz = raiz;

    }

    public Sala getRaizSalas() {
        return raizSalas;
    }

    public void setRaizSalas(Sala raizSalas) {
        this.raizSalas = raizSalas;
    }
    
    //METODO QUE COMPRUEBA SI EL ARBOL DE SUCURSALES ESTA VACIO
    public boolean estaVacio() {

        return this.raiz == null;

    }
    
    //METODO QUE COMPRUEBA SI EL ARBOL DE SALAS ESTA VACIO
    public boolean estaVacioSalas(){
        
        return this.raizSalas == null;
    }

    //METODO QUE PERMITE INSERTAR UNA NUEVA SUCURSAL
    public void insertarSucursal(Sucursal aux, Sucursal nuevaSucursal) {

        if (estaVacio()) {

            this.raiz = nuevaSucursal;

        } else if (nuevaSucursal.getCodigo() < aux.getCodigo()) {

            if (aux.getHijoIzq() == null) {

                aux.setHijoIzq(nuevaSucursal);

            } else {

                this.insertarSucursal(aux.getHijoIzq(), nuevaSucursal);

            }

        } else if (nuevaSucursal.getCodigo() > aux.getCodigo()) {

            if (aux.getHijoDer() == null) {

                aux.setHijoDer(nuevaSucursal);

            } else {

                this.insertarSucursal(aux.getHijoDer(), nuevaSucursal);

            }

        } else {

            System.out.println("Dicha sucursal ya se encuentra registrada");

        }
    }

    //METODO QUE MUESTRA LAS SUCURSALES
    public void recorrerEnOrden(Sucursal aux) {

        if (estaVacio()) {

            System.out.println("No hay ninguna sucursal registrada");
        }

        if (aux != null) {

            this.recorrerEnOrden(aux.getHijoIzq());

            aux.presentarSucursal();

            this.recorrerEnOrden(aux.getHijoDer());
        }
    }

    //METODO QUE PERMITE BUSCAR UNA SUCURSAL
    public Sucursal buscarSucursal(Sucursal aux, int codigo) {

        if (aux != null) {

            if (codigo < aux.getCodigo()) {

                return this.buscarSucursal(aux.getHijoIzq(), codigo);

            } else if (codigo > aux.getCodigo()) {

                return this.buscarSucursal(aux.getHijoDer(), codigo);

            } else {

                return aux;

            }
        }
        Sucursal aux2=new Sucursal(0000,"Z");
        return aux2;
    }
    
    //METODO QUE PERMITE MODIFICAR LOS DATOS DE UNA SUCURSAL
    public void modificarSucursal(Sucursal aux){
        
        System.out.println("Ingrese el nuevo codigo de la sucursal");
        int nuevoC = sc.nextInt();
        
        System.out.println("Ingrese la nueva ubicacion de la sucursal");
        String nuevaU = sc.next();
        
        aux.setCodigo(nuevoC);
        aux.setUbicacion(nuevaU);
    }
    
    //METODO QUE PERMITE INSERTAR UNA NUEVA SALA
    public void insertarSala(Sala aux, Sala nuevaSala){
        
        if (estaVacioSalas()) {

            this.raizSalas = nuevaSala;

        } else if (nuevaSala.getCodigo() < aux.getCodigo()) {

            if (aux.getHijoIzq() == null) {

                aux.setHijoIzq(nuevaSala);

            } else {

                this.insertarSala(aux.getHijoIzq(), nuevaSala);

            }

        } else if (nuevaSala.getCodigo() > aux.getCodigo()) {

            if (aux.getHijoDer() == null) {

                aux.setHijoDer(nuevaSala);

            } else {

                this.insertarSala(aux.getHijoDer(), nuevaSala);

            }

        } else {

            System.out.println("Dicha sala ya se encuentra registrada");

        }
    }
    
    //METODO QUE MUESTRA LAS SALAS
    public void recorrerSalas(Sala aux) {

        if (estaVacioSalas()) {

            System.out.println("No hay ninguna sala registrada");
        }

        if (aux != null) {

            this.recorrerSalas(aux.getHijoIzq());

            aux.presentarSala();

            this.recorrerSalas(aux.getHijoDer());
        }
    }
    
    //METODO QUE PERMITE BUSCAR UNA SALA
    public Sala buscarSala(Sala aux, int codigo){
        
        if (aux != null) {

            if (codigo < aux.getCodigo()) {

                return this.buscarSala(aux.getHijoIzq(), codigo);

            } else if (codigo > aux.getCodigo()) {

                return this.buscarSala(aux.getHijoDer(), codigo);

            } else {

                return aux;

            }
        }
        Sala aux2=new Sala(00,0);
        return aux2;
    }   
}

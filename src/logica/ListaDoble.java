package logica;

public class ListaDoble {

    //ATRIBUTOS DE LA CLASE
    private Cliente cabeza;

    private Cliente cola;

    public Cliente getCabeza() {
        return cabeza;
    }

    public Cliente getCola() {
        return cola;
    }
    
    //METODO QUE COMPRUEBA SI LA LISTA ESTA VACIA
    public boolean estaVacio() {

        return this.cabeza == null;
    }
    
    //METODO QUE PERMITE MOSTRAR LOS CLIENTES
    public void recorrerClientes(){
        
        Cliente aux = this.cabeza;
        
        while(aux != null){
            
            aux.presentarCliente();
            
            aux = aux.getProximoCliente();
        }   
    }
    
    //METODO QUE PERMITE INGRESAR NUEVOS CLIENTES
    public void insertarCliente(Cliente nuevoCliente){
        
        if(cola != null){
            nuevoCliente.setAnteriorCliente(cola);
            cola.setProximoCliente(nuevoCliente);
        }
        else{
            cabeza = nuevoCliente;
        }
        cola = nuevoCliente;
    }
    
        public Cliente buscarclienteCI(Cliente aux, int cedula){
            
        if(aux!=null){
                
            while(aux!=null){
            
            if(aux.getCedula()==cedula){
                return aux;
            }
            
            aux=aux.getProximoCliente();
            
            }
                
        }else{
            
            System.out.println("No existe dicho cliente con esa cedula");

        }
        
            Cliente hola=new Cliente("fulanito",99999,999);
            return hola;

        
        
        
    }
}
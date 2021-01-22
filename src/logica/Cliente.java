package logica;

public class Cliente {

    //ATRIBUTOS DE LA CLASE
    private String nombre;
    
    private int telefono;
    
    private int cedula;
    
    private Cliente proximoCliente;
    
    private Cliente anteriorCliente;
    
    //CONSTRUCTOR DE LA CLASE
    public Cliente(String nombre, int telefono, int cedula){
        
        this.nombre = nombre;
        
        this.telefono = telefono;
        
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Cliente getProximoCliente() {
        return proximoCliente;
    }

    public void setProximoCliente(Cliente proximoCliente) {
        this.proximoCliente = proximoCliente;
    }

    public Cliente getAnteriorCliente() {
        return anteriorCliente;
    }

    public void setAnteriorCliente(Cliente anteriorCliente) {
        this.anteriorCliente = anteriorCliente;
    }
      
    //METODO QUE PERMITE MOSTRAR A LOS CLIENTES
    public void presentarCliente(){
        
        System.out.println("Cliente: "+this.nombre+" Teléfono: "+this.telefono+" CI: "+this.cedula);
    }
}

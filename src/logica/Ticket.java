package logica;

public class Ticket {

    //ATRIBUTOS DE LA CLASE

    private int codigo;
    
    private Ticket proximoTicket;

    private Sucursal sucursal;

    private Sala sala;
    
    private String pelicula;

    private int fecha;

    private Cliente info;

    public Ticket(int codigo, Sucursal sucursal, Sala sala, String pelicula, int fecha, Cliente info) {
        this.codigo = codigo;
        this.proximoTicket = null;
        this.sucursal = sucursal;
        this.sala = sala;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.info = info;
    }

    public int getCodigo() {
        return codigo;
    }

    public Ticket getProximoTicket() {
        return proximoTicket;
    }

    public Cliente getInfo() {
        return info;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setProximoTicket(Ticket proximoTicket) {
        this.proximoTicket = proximoTicket;
    }

    public void setInfo(Cliente info) {
        this.info = info;
    }
    
    public void presentar() {
        
        this.info.presentarCliente();
        this.sucursal.presentarSucursal();
        this.sala.presentarSala();
        System.out.println("Pelicula: " + this.pelicula);
        System.out.println("La codigo del Ticket es #" + this.codigo);
        System.out.println("Fecha: " + this.fecha);
        
    }

    

    
    
}
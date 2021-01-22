package logica;

import java.util.Scanner;

public class Sucursal {

    //ATRIBUTOS DE LA CLASE
    private int codigo;

    private String ubicacion;

    private ArbolBB salas;

    private ListaSimple peliculas;

    private Sucursal hijoIzq;

    private Sucursal hijoDer;

    Scanner sc = new Scanner(System.in);

    //CONSTRUCTOR DE LA CLASE
    public Sucursal(int codigo, String ubicacion) {

        this.codigo = codigo;

        this.ubicacion = ubicacion;

        this.hijoIzq = null;

        this.hijoDer = null;

        this.salas = new ArbolBB();

        this.peliculas = new ListaSimple();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArbolBB getSalas() {
        return salas;
    }

    public void setSalas(ArbolBB salas) {
        this.salas = salas;
    }

    public ListaSimple getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ListaSimple peliculas) {
        this.peliculas = peliculas;
    }

    public Sucursal getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Sucursal hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Sucursal getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Sucursal hijoDer) {
        this.hijoDer = hijoDer;
    }

    //METODO QUE PERMITE PRESENTAR LAS SUCURSALES
    public void presentarSucursal() {

        System.out.println("Sucursal #" + this.codigo + " Ubicación: " + this.ubicacion);
    }

    //METODO QUE PERMITE INSERTAR SALAS
    public void insertarSala(Sala aux) {

        this.salas.insertarSala(this.salas.getRaizSalas(), aux);
    }

    //METODO QUE PERMITE BUSCAR SALAS
    public void buscarSalas() {

        this.salas.recorrerSalas(salas.getRaizSalas());
    }

    //METODO QUE PERMITE MODIFICAR SALAS
    public void modificarSalas() {

        if (!this.salas.estaVacioSalas()) {

            this.salas.recorrerSalas(salas.getRaizSalas());
            System.out.println("Ingrese el codigo de la sala la cual desea modificar");
            int n = sc.nextInt();

            if (n == salas.buscarSala(salas.getRaizSalas(), n).getCodigo()) {

                salas.buscarSala(salas.getRaizSalas(), n).modificarSalas(salas.buscarSala(salas.getRaizSalas(), n));

            } else {

                System.out.println("La sala #"+ n +" no ha sido registrada");
            }

        } else {

            System.out.println("No hay ninguna sala registrada");
        }
    }
    
    //METODO QUE DEVUELVE UNA SALA
    public Sala devolverSala(int n){
        
        return this.salas.buscarSala(salas.getRaizSalas(), n);
    }
    
    //METODO QUE DEVUELVE SI, HAY O NO ,SALAS
    public boolean estaVacioSalas(){
        
        return this.salas.estaVacioSalas();
    }

    //METODO QUE PERMITE INSERTAR PELÍCULAS
    public void insertarPelicula(Pelicula aux) {

        this.peliculas.insertarPelicula(aux);
    }

    //METODO QUE PERMITE PRESENTAR PELÍCULAS
    public void mostrarPeliculas() {

        this.peliculas.recorrerPeliculas();
    }
    
    //METODO QUE DEVUELVE UNA PELICULA
    public Pelicula devolverPelicula(String nombre){
        
        return this.peliculas.buscarPelicula(peliculas.getCabeza(), nombre);
    }

    //METODO QUE PERMITE MODIFICAR PELICULAS
    public void modificarPeliculas() {

        if (!this.peliculas.estaVacio()) {

            this.peliculas.recorrerPeliculas();
            System.out.println("Ingrese el nombre de la película la cual desea modificar");
            String n = sc.next();

            if (n.equals(peliculas.buscarPelicula(peliculas.getCabeza(), n).getNombre())) {

                peliculas.modificarPelicula(peliculas.buscarPelicula(peliculas.getCabeza(), n));

            } else {

                System.out.println("El nombre ingresado es incorrecto");
            }

        } else {

            System.out.println("No hay ninguna película registrada");
        }
    }
    
    //METODO QUE RETORNA UNA PELÍCULA SEGÚN EL NOMBRE INGRESADO
    public String buscarPeliculaPorNombre(String nombre){
        
        return this.peliculas.buscarPeliculaPorNombre(peliculas.getCabeza(), nombre);
    }
    
    //METODO QUE RETORNA UNA PELÍCULA SEGÚN EL GÉNERO INGRESADO
    public void buscarPeliculaPorGenero(String genero){
        
        this.peliculas.buscarPeliculaPorGenero(peliculas.getCabeza(), genero);
    }
    
    //METODO QUE RETORNA UNA PELÍCULA SEGÚN EL IDIOMA INGRESADO
    public void buscarPeliculaPorIdioma(String idioma){
        
        this.peliculas.buscarPeliculaPorIdioma(peliculas.getCabeza(), idioma);
    }
    
    public void buscarPeliculaOrdenMayorMenor(){
        
        this.peliculas.buscarPeliculaOrdenMayorMenor(this.peliculas.getCabeza());
    }
    
    public void buscarPeliculaOrdenMenorMayor(){
        
        this.peliculas.buscarPeliculaOrdenMenorMayor(this.peliculas.getCabeza());
    }
}

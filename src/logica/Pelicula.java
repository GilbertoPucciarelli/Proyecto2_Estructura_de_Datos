package logica;

public class Pelicula {

    //ATRIBUTOS DE LA CLASE
    private String nombre;

    private String genero;

    private String idioma;

    private Pelicula proximaPelicula;

    //CONSTRUCTOR DE LA CLASE
    public Pelicula(String nombre, String genero, String idioma) {

        this.nombre = nombre;

        this.genero = genero;

        this.idioma = idioma;

        this.proximaPelicula = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Pelicula getProximaPelicula() {
        return proximaPelicula;
    }

    public void setProximaPelicula(Pelicula proximaPelicula) {
        this.proximaPelicula = proximaPelicula;
    }

    //METODO QUE PERMITE PRESENTAR UNA PELÍCULA
    public void presentarPelicula() {

        System.out.println("Película: " + this.nombre + " Género: " + this.genero + " Idioma: " + this.idioma);
    }
}

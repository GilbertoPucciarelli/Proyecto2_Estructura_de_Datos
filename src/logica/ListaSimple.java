package logica;

import java.util.Scanner;

public class ListaSimple {

    //ATRIBUTOS DE LA CLASE
    private Pelicula cabeza;

    Scanner sc = new Scanner(System.in);

    public Pelicula getCabeza() {

        return cabeza;
    }

    //METODO QUE COMPRUEBA SI LA LISTA ESTA VACIA
    public boolean estaVacio() {

        return this.cabeza == null;
    }

    //METODO QUE MUESTRA LAS PELICULAS
    public void recorrerPeliculas() {

        Pelicula aux = this.cabeza;

        if (estaVacio()) {

            System.out.println("No hay películas registradas");
        } else {

            while (aux != null) {

                aux.presentarPelicula();

                aux = aux.getProximaPelicula();
            }

        }
    }

    //METODO QUE CUENTA CUANTAS PELÍCULAS HAY EN LA LISTA
    public int contar() {

        int cont = 0;

        Pelicula aux = this.cabeza;

        if (estaVacio()) {

            return cont;
        } else {

            while (aux != null) {
                cont++;
                aux = aux.getProximaPelicula();
            }
        }
        return cont;
    }

    //METODO QUE PERMITE INGRESAR UNA NUEVA PELÍCULA
    public void insertarPelicula(Pelicula nuevoPelicula) {

        if (estaVacio()) {

            this.cabeza = nuevoPelicula;

        } else {

            Pelicula aux = this.cabeza;

            while (aux.getProximaPelicula() != null) {

                aux = aux.getProximaPelicula();

            }
            aux.setProximaPelicula(nuevoPelicula);
        }
    }

    //METODO QUE PERMITE BUSCAR UNA PELÍCULA
    public Pelicula buscarPelicula(Pelicula aux, String nombre) {

        if (aux != null) {

            while (aux != null) {

                if (nombre.equals(aux.getNombre())) {

                    return aux;
                } else {

                    aux = aux.getProximaPelicula();
                }
            }
        }
        Pelicula peli=new Pelicula("Te","quiero","mucho");
        return peli;
    }

    //METODO QUE BUSCAR PELICULAS POR NOMBRE
    public String buscarPeliculaPorNombre(Pelicula aux, String nombre) {

        if (aux != null) {

            while (aux != null) {

                if (nombre.equals(aux.getNombre())) {

                    return aux.getNombre();
                } else {

                    aux = aux.getProximaPelicula();
                }
            }
        }

        String aux2 = "Dicha película no se encuentra registrada";
        return aux2;
    }

    //METODO QUE BUSCAR PELICULAS POR GÉNERO
    public void buscarPeliculaPorGenero(Pelicula aux, String genero) {

        int cont = 0;

        if (aux != null) {

            while (aux != null) {

                if (genero.equals(aux.getGenero())) {

                    aux.presentarPelicula();
                    cont++;
                }
                aux = aux.getProximaPelicula();
            }
        }

        if (cont == 0) {

            System.out.println("Dicho género no se encuentra registrado");
        }
    }

    //METODO QUE BUSCAR PELICULAS POR IDIOMA
    public void buscarPeliculaPorIdioma(Pelicula aux, String idioma) {

        int cont = 0;

        if (aux != null) {

            while (aux != null) {

                if (idioma.equals(aux.getIdioma())) {

                    aux.presentarPelicula();
                    cont++;
                }
                aux = aux.getProximaPelicula();
            }
        }

        if (cont == 0) {

            System.out.println("Dicho idioma no se encuentra registrado");
        }
    }

    //METODO QUE ORDENA LAS PELÍCULAS DE MENOR A MAYOR
    public void buscarPeliculaOrdenMayorMenor(Pelicula aux) {

        String[] array = new String[this.contar()];

        if (aux != null) {

            while (aux != null) {

                for (int i = 0; i < this.contar(); i++) {

                    array[i] = aux.getNombre();

                    aux = aux.getProximaPelicula();
                }
            }
        }
        
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                if (array[i].compareToIgnoreCase(array[j]) < 0) {

                    String aux2 = array[i];
                    array[i] = array[j];
                    array[j] = aux2;
                }
            }
        }
        
        for (String array1 : array) {
            System.out.println("Pelicula: " + array1);
        }
    }
    
    //METODO QUE ORDENA LAS PELÍCULAS DE MAYOR A MENOR
    public void buscarPeliculaOrdenMenorMayor(Pelicula aux) {

        String[] array = new String[this.contar()];

        if (aux != null) {

            while (aux != null) {

                for (int i = 0; i < this.contar(); i++) {

                    array[i] = aux.getNombre();

                    aux = aux.getProximaPelicula();
                }
            }
        }
        
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                if (array[i].compareToIgnoreCase(array[j]) > 0) {

                    String aux2 = array[i];
                    array[i] = array[j];
                    array[j] = aux2;
                }
            }
        }
        
        for (String array1 : array) {
            System.out.println("Pelicula: " + array1);
        }
    }

    //METODO QUE PERMITE MODIFICAR LOS DATOS DE UNA PELÍCULA
    public void modificarPelicula(Pelicula aux) {

        System.out.println("Ingrese el nuevo nombre de la película");
        String nuevoN = sc.next();

        System.out.println("Ingrese el nuevo género de la película");
        String nuevoG = sc.next();

        System.out.println("Ingrese el nuevo idioma de la película");
        String nuevoI = sc.next();

        aux.setNombre(nuevoN);
        aux.setGenero(nuevoG);
        aux.setIdioma(nuevoI);
    }
}

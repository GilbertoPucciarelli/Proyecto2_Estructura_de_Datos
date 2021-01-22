package logica;

import java.util.Random;
import java.util.Scanner;

public class Aplicacion {

    //ATRIBUTOS DE LA CLASE
    Scanner sc = new Scanner(System.in); //VARIABLE PARA LEER DATOS

    public static ArbolBB sucursales = new ArbolBB();

    ListaDoble listaClientes = new ListaDoble();

    Cola carlisto = new Cola();

    Cola carporcomprar = new Cola();

    //CONSTRUCTOR DE LA CLASE
    public Aplicacion() {

        this.entrada();
    }

    //MENÚ PRINCIPAL
    public void entrada() {

        boolean salir = false;

        System.out.println("--- MetroCine ---");
        do {
            System.out.println("Seleccione la opción que desea realizar \n 1. Agregar y Modificar Sucursales, Salas y Películas \n 2. Seleccionar las películas que se muestran en cada sala \n 3. Modificar los precios de los tickets por tipo de sala \n 4. Registrar nuevos clientes \n 5. Mostrar Clientes Registrados \n 6. Comprar Entradas \n 7. Mostrar Películas \n 8. Salir");

            switch (sc.nextInt()) {

                case 1:

                    this.opcion1();
                    break;

                case 2:

                    this.opcion2();
                    break;

                case 3:

                    this.opcion3();
                    break;

                case 4:

                    this.opcion4();
                    break;

                case 5:

                    if (!listaClientes.estaVacio()) {

                        listaClientes.recorrerClientes();
                    } else {

                        System.out.println("No hay clientes registrados");
                    }

                    break;

                case 6:

                    this.opcion6();
                    break;

                case 7:

                    this.opcion7();
                    break;

                case 8:

                    salir = true;

                    break;

                default:

                    System.out.println("Comando incorrecto");

                    break;
            }

        } while (salir != true);
    }

    //METODO QUE PERMITE AGREGAR Y MODIFICAR SUCURSALES, SALAS Y PELÍCULAS
    public void opcion1() {

        System.out.println(" 1. Agregar Sucursales \n 2. Modificar Sucursales \n 3. Agregar Salas \n 4. Modificar Salas \n 5. Agregar Películas \n 6. Modificar Películas \n 7. Mostrar Sucursales \n 8. Mostrar Salas");

        switch (sc.nextInt()) {

            //METODO PARA AGREGAR SUCURSALES
            case 1:

                System.out.println("Ingrese el codigo de la sucursal (4 digitos)");
                int codigo = sc.nextInt();

                System.out.println("Ingrese la ubicación de la sucursal");
                String ubicacion = sc.next();

                Sucursal sucursal = new Sucursal(codigo, ubicacion);
                sucursales.insertarSucursal(sucursales.getRaiz(), sucursal);

                break;

            //METODO PARA MODIFICAR SUCURSALES
            case 2:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());
                    System.out.println("Ingrese el numero de la sucursal que desea modificar");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        sucursales.modificarSucursal(sucursales.buscarSucursal(sucursales.getRaiz(), n));

                    } else {

                        System.out.println("La Sucursal #" + n + " no se ha registrado");
                    }

                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO PARA AGREGAR SALAS  
            case 3:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());
                    System.out.println("Ingrese el numero de la sucursal donde desea agregar una sala");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        System.out.println(" 1. Agregar Sala 2D \n 2. Agregar Sala 3D \n 3. Agregar Sala 4DX");

                        switch (sc.nextInt()) {

                            case 1:

                                System.out.println("Ingrese el codigo de la sala");
                                int c = sc.nextInt();
                                Sala2D sala2D = new Sala2D(c, 0);
                                sucursales.buscarSucursal(sucursales.getRaiz(), n).insertarSala(sala2D);

                                break;

                            case 2:

                                System.out.println("Ingrese el codigo de la sala");
                                int d = sc.nextInt();
                                Sala3D sala3D = new Sala3D(d, 0);
                                sucursales.buscarSucursal(sucursales.getRaiz(), n).insertarSala(sala3D);

                                break;

                            case 3:

                                System.out.println("Ingrese el codigo de la sala");
                                int e = sc.nextInt();
                                Sala4DX sala4DX = new Sala4DX(e, 0);
                                sucursales.buscarSucursal(sucursales.getRaiz(), n).insertarSala(sala4DX);

                                break;

                            default:

                                System.out.println("Comando incorrecto");

                                break;
                        }

                    } else {

                        System.out.println("La sucursal #" + n + " no ha sido registrada");
                    }

                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO PARA MODIFICAR SALAS    
            case 4:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());
                    System.out.println("Ingrese el numero de la sucursal donde desea modificar las salas");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        sucursales.buscarSucursal(sucursales.getRaiz(), n).modificarSalas();

                    } else {

                        System.out.println("La sucursal #" + n + " no ha sido registrada");
                    }

                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO PARA AGREGAR PELÍCULAS 
            case 5:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());
                    System.out.println("Ingrese el numero de la sucursal que desea agregar las películas");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        System.out.println("Ingrese el nombre de la película");
                        String nombreP = sc.next();

                        System.out.println("Ingrese el género de la película");
                        String generoP = sc.next();

                        System.out.println("Ingrese el idioma de la película");
                        String idiomaP = sc.next();

                        Pelicula nuevaPelicula = new Pelicula(nombreP, generoP, idiomaP);

                        sucursales.buscarSucursal(sucursales.getRaiz(), n).insertarPelicula(nuevaPelicula);

                    } else {

                        System.out.println("El numero ingresado es incorrecto");
                    }

                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO PARA MODIFICAR PELÍCULAS    
            case 6:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());
                    System.out.println("Ingrese el numero de la sucursal donde desea modificar las salas");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        sucursales.buscarSucursal(sucursales.getRaiz(), n).modificarPeliculas();

                    } else {

                        System.out.println("El numero ingresado es incorrecto");
                    }

                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO PARA MOSTRAR SUCURSALES    
            case 7:

                sucursales.recorrerEnOrden(sucursales.getRaiz());

                break;

            //METODO PARA MOSTRAR SALAS    
            case 8:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());

                    System.out.println("Ingrese el numero de la sucursal de la cual desea ver sus salas");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        sucursales.buscarSucursal(sucursales.getRaiz(), n).buscarSalas();
                    } else {

                        System.out.println("La sucursal #" + n + " no ha sido registrada");
                    }

                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            default:

                System.out.println("Comando incorrecto");

                break;
        }
    }

    //METODO QUE PERMITE SELECCIONAR LA PELÍCULA QUE SE MUESTRA EN UNA SALA
    public void opcion2() {

        if (!sucursales.estaVacio()) {

            sucursales.recorrerEnOrden(sucursales.getRaiz());
            System.out.println("Ingrese el codigo de la sucursal donde desea proyectar la película");
            int n = sc.nextInt();

            if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                if (!sucursales.buscarSucursal(sucursales.getRaiz(), n).estaVacioSalas()) {

                    System.out.println("Salas disponibles:");
                    sucursales.buscarSucursal(sucursales.getRaiz(), n).buscarSalas();
                    System.out.println("Ingrese el numero de la sala donde desea proyectar la película");
                    int m = sc.nextInt();

                    if (m == sucursales.buscarSucursal(sucursales.getRaiz(), n).devolverSala(m).getCodigo()) {

                        System.out.println("Las películas que se encuentran disponibles en este momento son:");
                        sucursales.buscarSucursal(sucursales.getRaiz(), n).mostrarPeliculas();
                        System.out.println("Ingrese el nombre de la película que desea proyectar en la sala");
                        String p = sc.next();

                        if (p.equals(sucursales.buscarSucursal(sucursales.getRaiz(), n).devolverPelicula(p).getNombre())) {

                            sucursales.buscarSucursal(sucursales.getRaiz(), n).devolverSala(m).setPelicula(p);

                        } else {

                            System.out.println("El nombre ingresado es incorrecto");
                        }

                    } else {

                        System.out.println("La sala #" + m + " no ha sido registrada");
                    }
                } else {

                    System.out.println("No hay salas registradas");
                }

            } else {

                System.out.println("La sucursal #" + n + " no ha sido registrada");
            }

        } else {

            System.out.println("No hay ninguna sucursal registrada");
        }
    }

    //METODO QUE PERMITE ESTABLECER EL PRECIO DE LOS TICKETS POR CADA TIPO DE SALA
    public void opcion3() {

        if (!sucursales.estaVacio()) {

            sucursales.recorrerEnOrden(sucursales.getRaiz());
            System.out.println("Ingrese el codigo de la sucursal donde desea establecer el precio de los tickets");
            int n = sc.nextInt();

            if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                if (!sucursales.buscarSucursal(sucursales.getRaiz(), n).estaVacioSalas()) {

                    System.out.println("Salas disponibles:");
                    sucursales.buscarSucursal(sucursales.getRaiz(), n).buscarSalas();
                    System.out.println("Ingrese el numero de la sala donde desea establecer el precio");
                    int m = sc.nextInt();

                    if (m == sucursales.buscarSucursal(sucursales.getRaiz(), n).devolverSala(m).getCodigo()) {

                        System.out.println("Ingrese el precio de la sala");
                        int p = sc.nextInt();
                        sucursales.buscarSucursal(sucursales.getRaiz(), n).devolverSala(m).setPrecio(p);

                    } else {

                        System.out.println("Comando incorrecto");
                    }
                } else {

                    System.out.println("No hay salas registradas");
                }

            } else {

                System.out.println("El codigo ingresado es incorrecto");
            }

        } else {

            System.out.println("No hay ninguna sucursal registrada");
        }
    }

    //METODO QUE PERMITE REGISTRAR NUEVOS CLIENTES
    public void opcion4() {

        System.out.println("Indique el nombre del cliente");
        String nombre = sc.next();

        System.out.println("Indique el numero de telefono del cliente");
        int telefono = sc.nextInt();

        System.out.println("Indique el numero de cédula del cliente");
        int cedula = sc.nextInt();

        Cliente cliente = new Cliente(nombre, telefono, cedula);
        listaClientes.insertarCliente(cliente);
    }

    //METODO QUE PERMITE AÑADIR ENTRADAS A LOS CARRITOS DE LOS CLIENTES
    public void opcion6() {

        if (!listaClientes.estaVacio()) {
            if (!sucursales.estaVacio()) {
                sucursales.recorrerEnOrden(sucursales.getRaiz());
                System.out.println("Ingrese la sucursal donde se compraran los tickets");
                int s = sc.nextInt();
                if (s == sucursales.buscarSucursal(sucursales.getRaiz(), s).getCodigo()) {

                    if (!sucursales.buscarSucursal(sucursales.getRaiz(), s).estaVacioSalas()) {

                        System.out.println("Salas disponibles:");
                        sucursales.buscarSucursal(sucursales.getRaiz(), s).getSalas().recorrerSalas(sucursales.buscarSucursal(sucursales.getRaiz(), s).getSalas().getRaizSalas());
                        System.out.println("Ingrese la sala donde se compraran los tickets");
                        int c = sc.nextInt();
                        if (c == sucursales.buscarSucursal(sucursales.getRaiz(), s).devolverSala(c).getCodigo()) {

                            listaClientes.recorrerClientes();
                            System.out.println("Ingrese la cedula del cliente que desea añadirle entradas a su carrito");
                            int t = sc.nextInt();
                            System.out.println("Ingrese la fecha");
                            int f = sc.nextInt();

                            System.out.println("cliente: " + listaClientes.buscarclienteCI(listaClientes.getCabeza(), t).getNombre());

                            if (!carporcomprar.estaVacia()) {

                                System.out.println("Ticket Guardado");
                                carporcomprar.primeroEnCola();
                                System.out.println("¿Desea comprar el ticket guardado? (1) para si, (2) para no");
                                int z = sc.nextInt();
                                if (z == 1) {

                                    carlisto.encolar(carporcomprar.desencolar());

                                }

                            }

                            Random r = new Random();
                            int ra = (int) (Math.random() * 9999999) + 1111111;
                            Ticket ticket = new Ticket(ra, sucursales.buscarSucursal(sucursales.getRaiz(), s), sucursales.buscarSucursal(sucursales.getRaiz(), s).devolverSala(c), sucursales.buscarSucursal(sucursales.getRaiz(), s).devolverSala(c).getPelicula(), f, listaClientes.buscarclienteCI(listaClientes.getCabeza(), t));

                            System.out.println("¿Desea comprar el ticket? (1) para si, (2) para no");
                            int respuesta = sc.nextInt();

                            if (respuesta == 1) {

                                carlisto.encolar(ticket);

                            } else {

                                carporcomprar.encolar(ticket);

                            }

                        } else {

                            System.out.println("Comando incorrecto");
                        }
                    } else {

                        System.out.println("No hay salas registradas");
                    }

                } else {

                    System.out.println("El codigo ingresado es incorrecto");
                }

            } else {

                System.out.println("NO hay ninguna sucursal");
            }

        } else {

            System.out.println("No hay clientes registrados");
        }

    }

    //METODO QUE PERMITE FILTRAR LAS PELÍCULAS
    public void opcion7() {

        System.out.println(" 1. Filtrar por Género \n 2. Filtrar por Idioma \n 3. Filtrar por Nombre (Menor a Mayor) \n 4. Filtrar por Nombre (Mayor a Menor) \n 5. Filtrar por Sucursal \n 6. Filtrar por Sala \n 7. Buscar");

        switch (sc.nextInt()) {

            //METODO QUE FILTRA PELÍCULAS SEGÚN SU GÉNERO
            case 1:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());

                    System.out.println("Ingrese el numero de la sucursal de la cual desea ver sus películas");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        System.out.println("Ingrese el género de las películas que desea buscar");
                        String genero = sc.next();
                        sucursales.buscarSucursal(sucursales.getRaiz(), n).buscarPeliculaPorGenero(genero);
                    }
                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO QUE FILTRA PELÍCULAS SEGÚN SU IDIOMA
            case 2:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());

                    System.out.println("Ingrese el numero de la sucursal de la cual desea ver sus películas");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        System.out.println("Ingrese el idioma de las películas que desea buscar");
                        String idioma = sc.next();
                        sucursales.buscarSucursal(sucursales.getRaiz(), n).buscarPeliculaPorIdioma(idioma);
                    }
                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO QUE FILTRA PELÍCULAS POR ORDEN  
            case 3:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());

                    System.out.println("Ingrese el numero de la sucursal de la cual desea ver sus películas");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        sucursales.buscarSucursal(sucursales.getRaiz(), n).buscarPeliculaOrdenMayorMenor();
                    }
                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO QUE FILTRA PELÍCULAS POR ORDEN 
            case 4:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());

                    System.out.println("Ingrese el numero de la sucursal de la cual desea ver sus películas");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        sucursales.buscarSucursal(sucursales.getRaiz(), n).buscarPeliculaOrdenMenorMayor();
                    }
                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO QUE FILTRA PELÍCULAS SEGÚN LA SUCURSAL
            case 5:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());

                    System.out.println("Ingrese el numero de la sucursal de la cual desea ver sus películas");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        sucursales.buscarSucursal(sucursales.getRaiz(), n).mostrarPeliculas();
                    }

                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO QUE FILTRA PELÍCULAS SEGÚN LAS SALAS
            case 6:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());

                    System.out.println("Ingrese el numero de la sucursal de la cual desea ver sus películas");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        if (!sucursales.buscarSucursal(sucursales.getRaiz(), n).estaVacioSalas()) {

                            System.out.println("Salas disponibles:");
                            sucursales.buscarSucursal(sucursales.getRaiz(), n).buscarSalas();
                            System.out.println("Ingrese el numero de la sala de la cual desea ver la película");
                            int m = sc.nextInt();

                            if (m == sucursales.buscarSucursal(sucursales.getRaiz(), n).devolverSala(m).getCodigo()) {

                                if (sucursales.buscarSucursal(sucursales.getRaiz(), n).devolverSala(m).getPelicula() != null) {

                                    System.out.println("La película asignada a esta sala es: " + sucursales.buscarSucursal(sucursales.getRaiz(), n).devolverSala(m).getPelicula());
                                } else {

                                    System.out.println("No hay ninguna película asignada a esta sala");
                                }
                            } else {

                                System.out.println("El codigo ingresado es incorrecto");
                            }
                        }
                    }

                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            //METODO QUE BUSCA UNA PELÍCULA
            case 7:

                if (!sucursales.estaVacio()) {

                    sucursales.recorrerEnOrden(sucursales.getRaiz());

                    System.out.println("Ingrese el numero de la sucursal donde desea buscar la película");
                    int n = sc.nextInt();

                    if (n == sucursales.buscarSucursal(sucursales.getRaiz(), n).getCodigo()) {

                        System.out.println("Ingrese el nombre de la película que desea buscar");
                        String nombre = sc.next();

                        if (nombre.equals(sucursales.buscarSucursal(sucursales.getRaiz(), n).buscarPeliculaPorNombre(nombre))) {

                            System.out.println("Dicha película si se encuentra registrada en la sucursal");

                        } else {

                            System.out.println("Dicha película no se encuentra registrada en la sucursal");
                        }
                    }

                } else {

                    System.out.println("No hay ninguna sucursal registrada");
                }

                break;

            default:

                System.out.println("Comando incorrecto");

                break;
        }
    }

    //MAIN
    public static void main(String[] args) {

        Sucursal nuevaSucursal = new Sucursal(1111, "Caracas");
        Sala2D sala = new Sala2D(1, 0);
        Sala2D sala2 = new Sala2D(2, 0);
        Sala2D sala3 = new Sala2D(3, 0);
        Sala2D sala4 = new Sala2D(4, 0);
        Sala2D sala5 = new Sala2D(5, 0);
        Sala3D sala6 = new Sala3D(6,0);
        Sala3D sala7 = new Sala3D(7,0);
        Sala3D sala8 = new Sala3D(8,0);
        Sala3D sala9 = new Sala3D(9,0);
        Sala3D sala10 = new Sala3D(10,0);
        Sala4DX sala11 = new Sala4DX(11,0);
        Sala4DX sala12 = new Sala4DX(12,0);
        Sala4DX sala13 = new Sala4DX(13,0);
        Sala4DX sala14 = new Sala4DX(14,0);
        Sala4DX sala15 = new Sala4DX(15,0);
        Pelicula pelicula = new Pelicula("Jumanji", "Comedia", "Ingles");
        Pelicula pelicula2 = new Pelicula("Baywatch", "Comedia", "Frances");
        Pelicula pelicula3 = new Pelicula("Avengers: Infinity War", "Accion", "Ingles");
        Pelicula pelicula4 = new Pelicula("Capitan America: Civil War", "Accion" , "Español");
        Pelicula pelicula5 = new Pelicula("Black Phanter", "Accion" , "Ingles");
        sucursales.insertarSucursal(sucursales.getRaiz(), nuevaSucursal);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala2);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala3);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala4);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala5);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala6);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala7);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala8);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala9);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala10);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala11);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala12);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala13);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala14);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarSala(sala15);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarPelicula(pelicula);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarPelicula(pelicula2);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarPelicula(pelicula3);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarPelicula(pelicula4);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal.getCodigo()).insertarPelicula(pelicula5);

        Sucursal nuevaSucursal2 = new Sucursal(2222, "Barquisimeto");
        Sala2D sala16 = new Sala2D(1, 0);
        Sala2D sala17 = new Sala2D(2, 0);
        Sala2D sala18 = new Sala2D(3, 0);
        Sala2D sala19 = new Sala2D(4, 0);
        Sala2D sala20 = new Sala2D(5, 0);
        Sala3D sala21 = new Sala3D(6,0);
        Sala3D sala22= new Sala3D(7,0);
        Sala3D sala23 = new Sala3D(8,0);
        Sala3D sala24 = new Sala3D(9,0);
        Sala3D sala25 = new Sala3D(10,0);
        Sala4DX sala26 = new Sala4DX(11,0);
        Sala4DX sala27 = new Sala4DX(12,0);
        Sala4DX sala28 = new Sala4DX(13,0);
        Sala4DX sala29 = new Sala4DX(14,0);
        Sala4DX sala30 = new Sala4DX(15,0);
        Pelicula pelicula6 = new Pelicula("ReadyPlayerOne", "Ficcion", "Ingles");
        Pelicula pelicula7 = new Pelicula("Insidious", "Terror", "Frances");
        Pelicula pelicula8 = new Pelicula("Justice League", "Accion", "Ingles");
        Pelicula pelicula9 = new Pelicula("Aquaman", "Accion" , "Español");
        Pelicula pelicula10 = new Pelicula("TheConjuring", "Terror" , "Ingles");
        sucursales.insertarSucursal(sucursales.getRaiz(), nuevaSucursal2);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala16);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala17);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala18);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala19);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala20);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala21);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala22);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala23);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala24);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala25);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala26);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala27);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala28);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala29);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarSala(sala30);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarPelicula(pelicula6);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarPelicula(pelicula7);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarPelicula(pelicula8);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarPelicula(pelicula9);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal2.getCodigo()).insertarPelicula(pelicula10);

        Sucursal nuevaSucursal3 = new Sucursal(3333, "Maracaibo");
        sucursales.insertarSucursal(sucursales.getRaiz(), nuevaSucursal3);
        Sala2D sala31 = new Sala2D(1, 0);
        Sala2D sala32 = new Sala2D(2, 0);
        Sala2D sala33 = new Sala2D(3, 0);
        Sala2D sala34 = new Sala2D(4, 0);
        Sala2D sala35 = new Sala2D(5, 0);
        Sala3D sala36 = new Sala3D(6,0);
        Sala3D sala37 = new Sala3D(7,0);
        Sala3D sala38 = new Sala3D(8,0);
        Sala3D sala39 = new Sala3D(9,0);
        Sala3D sala40 = new Sala3D(10,0);
        Sala4DX sala41 = new Sala4DX(11,0);
        Sala4DX sala42 = new Sala4DX(12,0);
        Sala4DX sala43 = new Sala4DX(13,0);
        Sala4DX sala44 = new Sala4DX(14,0);
        Sala4DX sala45 = new Sala4DX(15,0);
        Pelicula pelicula11 = new Pelicula("WonderWoman", "Accion", "Ingles");
        Pelicula pelicula12 = new Pelicula("The Incredibles", "Animados", "Frances");
        Pelicula pelicula13 = new Pelicula("Avengers: Infinity War", "Accion", "Ingles");
        Pelicula pelicula14 = new Pelicula("Iron Man", "Accion" , "Español");
        Pelicula pelicula15 = new Pelicula("Thor Ragnarok", "Accion" , "Ingles");
        sucursales.insertarSucursal(sucursales.getRaiz(), nuevaSucursal3);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala31);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala32);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala33);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala34);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala35);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala36);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala37);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala38);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala39);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala40);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala41);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala42);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala43);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala44);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarSala(sala45);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarPelicula(pelicula11);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarPelicula(pelicula12);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarPelicula(pelicula13);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarPelicula(pelicula14);
        sucursales.buscarSucursal(sucursales.getRaiz(), nuevaSucursal3.getCodigo()).insertarPelicula(pelicula15);
        
        Aplicacion app = new Aplicacion();
    }
}
package gonzalez.alexander.tl;

import gonzalez.alexander.bl.entities.Usuario;
import gonzalez.alexander.bl.excepciones.CredencialesInvalidasException;
import gonzalez.alexander.bl.logic.GestorTarea;
import gonzalez.alexander.bl.logic.GestorUsuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controlador {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void registrarUsuario() throws Exception {
        System.out.println("\nIngrese su nombre completo: ");
        String nombre = in.readLine();
        System.out.println("Ingrese su correo: ");
        String correo = in.readLine();
        System.out.println("Ingrese su constraseña: ");
        String password = in.readLine();
        System.out.println(GestorUsuario.registrarUsuario(nombre, correo, password));
    }
    public static Usuario ingresarUsuario() throws Exception {
        System.out.println("\n--- Ingreso como usuario ---");
        while(true){
            try{
                System.out.println("\nIngrese su correo: ");
                String correo = in.readLine();
                System.out.println("\nIngrese su contraseña: ");
                String password = in.readLine();
                return GestorUsuario.ingresarUsuario(correo, password);
            }catch(CredencialesInvalidasException e){
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.out.println("Error leyendo datos.");
            }
        }
    }

    public static void crearTarea(Usuario usuario) throws Exception {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime fechaLimite = null;

        System.out.println("\n------Creación de Tarea------");

        while (fechaLimite==null){
            try{
                System.out.println("\nIngrese la fecha límite para completar la tarea (dd-MM-yyyy HH:mm):");
                fechaLimite = LocalDateTime.parse(in.readLine(), formato);
            }catch (DateTimeException e){
                System.out.println("Formato inválido. Use dd-MM-yyyy HH:mm");
            }
        }
        System.out.println("\nIngrese la descripción de la tarea:");
        String descripcion = in.readLine();
        System.out.println(GestorTarea.crearTarea(usuario, fechaLimite, descripcion));
    }

    public static void editarTarea(Usuario usuario) throws Exception {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime nuevaFechaLimite = null;

                System.out.println("\nIngrese el ID de la Tarea");
        String id = in.readLine().toUpperCase();
        System.out.println("\n---------Edición de Tarea---------");
        System.out.println("\nIngrese la nueva fecha límite para completar la tarea (dd-MM-yyyy HH:mm):");
        while (nuevaFechaLimite==null){
            try{
                nuevaFechaLimite = LocalDateTime.parse(in.readLine(), formato);
            }catch (DateTimeException e){
                System.out.println("Formato inválido. Use dd-MM-yyyy HH:mm");
            }
        }
        System.out.println("\nIngrese la nueva descripción de la tarea:");
        String nuevaDescripcion = in.readLine();
        System.out.println(GestorTarea.editarTarea(usuario, id, nuevaFechaLimite, nuevaDescripcion));
    }

    public static void finalizarTarea(Usuario usuario) throws Exception {
        System.out.println("\nIngrese el ID de la Tarea que desea marcar como completada");
        String id = in.readLine().toUpperCase();
        System.out.println(GestorTarea.finalizarTarea(usuario, id));
    }

    public static void borrarTarea(Usuario usuario) throws Exception {
        System.out.println("\nIngrese el ID de la Tarea que desea eliminar");
        String id = in.readLine().toUpperCase();
        System.out.println(GestorTarea.eliminarTarea(usuario, id));
    }

    public static void verTareas(Usuario usuario) throws Exception {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate inicio = null;
        LocalDate fin = null;

        byte opcion;
        System.out.println("\nSeleccione una opción: ");
        System.out.println("1) Pendientes");
        System.out.println("2) Completadas");
        System.out.println("3) Por Rango de tiempo");
        System.out.println("4) Todas");
        System.out.println("Ingrese su elección: ");
        opcion = Byte.parseByte(in.readLine());

        if (opcion == 1){
            System.out.println("\n---Tareas pendientes---");
            GestorTarea.verTareasPendientes(usuario);
        }else if (opcion == 2){
            System.out.println("\n---Tareas Completadas---");
            GestorTarea.verTareasCompletadas(usuario);
        }else if(opcion == 3){
            while (inicio==null) {
                try {
                    System.out.println("\nIngrese la fecha inical del rango (dd-MM-yyyy): ");
                    inicio = LocalDate.parse(in.readLine(), formato);
                }catch (DateTimeException e){
                    System.out.println("Formato inválido. Use dd-MM-yyyy");
                }
            }
            LocalDateTime fechaInicial = inicio.atStartOfDay();

            while (fin==null) {
                try {
                    System.out.println("\nIngrese la fecha final del rango (dd-MM-yyyy): ");
                    fin = LocalDate.parse(in.readLine(), formato);
                }catch (DateTimeException e){
                    System.out.println("Formato inválido. Use dd-MM-yyyy");
                }
            }
            LocalDateTime fechaFinal = fin.plusDays(1).atStartOfDay();
            System.out.println("\n---Tareas entre " + inicio + " y " + fin + "---");
            GestorTarea.verTareasPorRango(usuario, fechaInicial, fechaFinal);
        }else if(opcion == 4){
            System.out.println("\n---Toda mis tareas---");
            GestorTarea.verTareasPendientes(usuario);
            GestorTarea.verTareasCompletadas(usuario);
        }else{
            System.out.println("Opción inválida.");
        }
    }
}

package gonzalez.alexander.ui;

import gonzalez.alexander.bl.entities.Usuario;
import gonzalez.alexander.tl.Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void menuPrincipal() throws Exception {
        byte opcion;
        while (true) {
            System.out.println("\n--- Menú principal ---");
            System.out.println("1) Registrarse como usuario");
            System.out.println("2) Ingresar como usuario");
            System.out.println("0) Salir");
            System.out.print("Ingrese su elección: ");
            opcion = Byte.parseByte(in.readLine());
            if (opcion == 0) {
                System.out.println("Gracias por utilizar nuestro programa :)");
                break;
            } else if (opcion == 1) Controlador.registrarUsuario();
            else if (opcion == 2) {
                Usuario usuario = Controlador.ingresarUsuario();
                if (usuario == null) {
                    System.out.println("Autenticación inválida.");
                    continue;
                }
                System.out.println("Autenticación válida.");
                menuUsuario(usuario);
            }
            else System.out.println("Opción inválida.");
        }
    }

    private static void menuUsuario(Usuario usuario) throws Exception {
        byte opcion;
        while (true){
            System.out.println("\n--- Menú de Cliente ---");
            System.out.println("1) Crear Tarea");
            System.out.println("2) Editar Tarea");
            System.out.println("3) Marcar Tarea como Completada");
            System.out.println("4) Borrar Tarea");
            System.out.println("5) Ver Tareas");
            System.out.println("0) Salir");
            System.out.println("Ingrese su elección: ");
            opcion = Byte.parseByte(in.readLine());
            if (opcion == 0){
                break;
            }else if(opcion == 1) Controlador.crearTarea(usuario);
            else if(opcion == 2) Controlador.editarTarea(usuario);
            else if(opcion == 3) Controlador.finalizarTarea(usuario);
            else if(opcion == 4) Controlador.borrarTarea(usuario);
            else if(opcion == 5) Controlador.verTareas(usuario);
        }
    }
}

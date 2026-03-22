import gonzalez.alexander.bl.Tarea;
import gonzalez.alexander.bl.Usuario;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws Exception {
        Usuario usuario1 = new Usuario("Alexander Gonzalez", "alex@correo.com", "password1");
        Usuario usuario2 = new Usuario("Roberto Gonzalez", "roberto@correo.com", "password2");




        usuario1.crearTarea(LocalDateTime.of(2026, 3, 22, 23, 59), "Entregar Portafolio 1");
        usuario1.crearTarea(LocalDateTime.of(2026, 3, 30, 23, 59), "Sacar cita doctor");
        usuario1.crearTarea(LocalDateTime.of(2026, 4, 15, 23, 59), "Inscribir en gimnasio");

        usuario2.crearTarea(LocalDateTime.of(2026, 3, 22, 23, 59), "Entregar Portafolio 1");
        usuario2.crearTarea(LocalDateTime.of(2026, 3, 30, 23, 59), "Agendar cancha de tenis");
        usuario2.crearTarea(LocalDateTime.of(2026, 4, 15, 23, 59), "Pagar clases tenis");

        System.out.println("\n" + usuario1);
        System.out.println("Todas las tareas:");
        for (Tarea t : usuario1.verTareas()) {
            System.out.println(t);
        }

        System.out.println("\n" + usuario2);
        System.out.println("Todas las tareas:");
        for (Tarea t : usuario2.verTareas()) {
            System.out.println(t);
        }

        usuario1.tareaCompletada("T-1");
        System.out.println("\nTarea T-1 de " + usuario1.getNombre() + " fue marcada como completada");

        System.out.println("\n" + usuario1);
        System.out.println("Tareas pendientes:");
        for (Tarea t : usuario1.verTareasPendientes()) {
            System.out.println(t);
        }
        System.out.println("Todas las tareas:");
        for (Tarea t : usuario1.verTareas()) {
            System.out.println(t);
        }
        System.out.println("Tareas pendientes entre 01-03-2026 y 30-04-2026:");
        for (Tarea t : usuario1.verTareasPendientesEnRango(LocalDateTime.of(2026, 3, 1, 00, 01),
                LocalDateTime.of(2026, 4, 30, 12, 59))) {
            System.out.println(t);
        }
        System.out.println("Tareas entre 01-03-2026 y 30-04-2026:");
        for (Tarea t : usuario1.verTareasEnRango(LocalDateTime.of(2026, 3, 1, 00, 01),
                LocalDateTime.of(2026, 4, 30, 12, 59))) {
            System.out.println(t);
        }

        usuario2.editarTarea("T-6", "Cancelar clase de Tenis",
                LocalDateTime.of(2026, 4, 1, 23, 59));
        System.out.println("\nTarea T-6 de " + usuario2.getNombre() + " fue actualizada correctamente");
        usuario2.borrarTarea("T-5");
        System.out.println("Tarea T-5 de " + usuario2.getNombre() + " fue eliminada");
        usuario2.tareaCompletada("T-4");
        System.out.println("Tarea T-4 de " + usuario2.getNombre() + " fue marcada como completada");

        System.out.println("\n" + usuario2);
        System.out.println("Tareas pendientes:");
        for (Tarea t : usuario2.verTareasPendientes()) {
            System.out.println(t);
        }
        System.out.println("Todas las tareas:");
        for (Tarea t : usuario2.verTareas()) {
            System.out.println(t);
        }
        System.out.println("Tareas pendientes entre 01-03-2026 y 30-04-2026:");
        for (Tarea t : usuario2.verTareasPendientesEnRango(LocalDateTime.of(2026, 3, 1, 00, 01),
                LocalDateTime.of(2026, 4, 30, 12, 59))) {
            System.out.println(t);
        }
        System.out.println("Tareas entre 01-03-2026 y 30-04-2026:");
        for (Tarea t : usuario2.verTareasEnRango(LocalDateTime.of(2026, 3, 1, 00, 01),
                LocalDateTime.of(2026, 4, 30, 12, 59))) {
            System.out.println(t);
        }

    }
}

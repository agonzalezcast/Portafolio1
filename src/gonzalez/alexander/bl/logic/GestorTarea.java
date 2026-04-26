package gonzalez.alexander.bl.logic;

import gonzalez.alexander.bl.dao.DAOTarea;
import gonzalez.alexander.bl.entities.Tarea;
import gonzalez.alexander.bl.entities.Usuario;

import java.time.LocalDateTime;

public class GestorTarea {
    public static String crearTarea(Usuario usuario, LocalDateTime fechaLimite, String descripcion) throws Exception {
        return DAOTarea.insertarTarea(usuario, new Tarea(fechaLimite, descripcion));
    }

    public static String editarTarea(Usuario usuario, String id, LocalDateTime nuevaFechaLimite, String nuevaDescripcion) throws Exception {
        return DAOTarea.actualizarTarea(usuario, id, nuevaFechaLimite, nuevaDescripcion);
    }

    public static String finalizarTarea(Usuario usuario, String id) throws Exception {
        return DAOTarea.actualizarCompletada(usuario, id);
    }

    public static String eliminarTarea(Usuario usuario, String id) throws Exception {
        return DAOTarea.borrarTarea(usuario, id);
    }

    public static void verTareasPendientes(Usuario usuario) throws Exception {
        DAOTarea.listarTareasPendientes(usuario);
    }

    public static void verTareasCompletadas(Usuario usuario) throws Exception {
        DAOTarea.listarTareasCompletadas(usuario);
    }

    public static void verTareasPorRango(Usuario usuario, LocalDateTime fechaInicial, LocalDateTime fechaFinal) throws Exception {
        DAOTarea.listarTareasEnRango(usuario, fechaInicial, fechaFinal);
    }

}

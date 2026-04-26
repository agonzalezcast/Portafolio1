package gonzalez.alexander.bl.dao;

import gonzalez.alexander.bl.entities.Tarea;
import gonzalez.alexander.bl.entities.Usuario;
import gonzalez.alexander.dl.Conector;

import java.sql.ResultSet;
import java.time.LocalDateTime;

public class DAOTarea {
    private static String statement;
    private static String query;

    public static String insertarTarea(Usuario usuario, Tarea tarea) throws Exception {
        statement = "INSERT INTO t_tareas VALUES ('" + tarea.getiD() + "', '" + tarea.getFechaLimite() +  "', '" + tarea.getDescripcion() +
            "', " + tarea.isCompletada() + ", '" + usuario.getCorreo() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "La Tarea fue creada correctamente";
    }

    public static String actualizarTarea(Usuario usuario, String id, LocalDateTime nuevaFechaLimite, String nuevaDescripcion) throws Exception {
        query = "SELECT * FROM t_tareas WHERE id = ? AND correo_usuario = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, id, usuario.getCorreo());
        if(!resultado.next()){
            System.out.println("El usuario no tiene una tarea con el ID: " + id);
            return null;
        }

        Tarea tareaActualizar = new Tarea(resultado.getString("id"), resultado.getTimestamp("fecha_limite").toLocalDateTime(),
                resultado.getString("descripcion"), resultado.getBoolean("completada"));

        tareaActualizar.actualizarTarea(nuevaFechaLimite, nuevaDescripcion);

        statement = "UPDATE t_tareas SET fecha_limite = ?, descripcion = ? WHERE id = ? AND correo_usuario = ?;";
        Conector.getConexion().ejecutarStatement(statement, tareaActualizar.getFechaLimite(), tareaActualizar.getDescripcion(), id, usuario.getCorreo());
        return "Se ha actualizado la tarea correctamente";
    }

    public static String actualizarCompletada(Usuario usuario, String id) throws Exception {
        query = "SELECT * FROM t_tareas WHERE id = ? AND correo_usuario = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, id, usuario.getCorreo());
        if(!resultado.next()){
            System.out.println("El usuario no tiene una tarea con el ID: " + id);
            return null;
        }
        Tarea tareaActualizar = new Tarea(resultado.getString("id"), resultado.getTimestamp("fecha_limite").toLocalDateTime(),
                resultado.getString("descripcion"), resultado.getBoolean("completada"));

        tareaActualizar.setCompletada(true);

        statement = "UPDATE t_tareas SET completada = ? WHERE id = ? AND correo_usuario = ?;";
        Conector.getConexion().ejecutarStatement(statement, tareaActualizar.isCompletada(), id, usuario.getCorreo());

        return "Tarea marcada como completada";
    }

    public static String borrarTarea(Usuario usuario, String id) throws Exception {
        statement = "DELETE FROM t_tareas WHERE id = ? AND correo_usuario = ?;";
        Conector.getConexion().ejecutarStatement(statement, id, usuario.getCorreo());
        return "La tarea " + id + " fue eliminada correctamente";
    }

    public static void listarTareasPendientes(Usuario usuario) throws Exception {
        query = "SELECT * FROM t_tareas WHERE correo_usuario = ? AND completada = FALSE;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, usuario.getCorreo());
        if (!resultado.next()){
            System.out.println("\n***El cliente no tiene tareas pendientes***");
            return;
        }

        do{
            Tarea tareaPendiente = new Tarea(resultado.getString("id"), resultado.getTimestamp("fecha_limite").toLocalDateTime(),
                resultado.getString("descripcion"), resultado.getBoolean("completada"));

            System.out.println(tareaPendiente);

        }while(resultado.next());

    }

    public static void listarTareasCompletadas(Usuario usuario) throws Exception {
        query = "SELECT * FROM t_tareas WHERE correo_usuario = ? AND completada = TRUE;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, usuario.getCorreo());
        if (!resultado.next()){
            System.out.println("\n***El cliente no tiene tareas pendientes***");
            return;
        }

        do{
            Tarea tareaPendiente = new Tarea(resultado.getString("id"), resultado.getTimestamp("fecha_limite").toLocalDateTime(),
                    resultado.getString("descripcion"), resultado.getBoolean("completada"));

            System.out.println(tareaPendiente);

        }while(resultado.next());
    }

    public static void listarTareasEnRango(Usuario usuario, LocalDateTime fechaInicial, LocalDateTime fechaFinal) throws Exception {
        query = "SELECT * FROM t_tareas WHERE correo_usuario = ? AND fecha_limite BETWEEN ? AND ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, usuario.getCorreo(), fechaInicial, fechaFinal);
        if (!resultado.next()){
            System.out.println("\n***El cliente no tiene tareas en el rango seleccionado***");
            return;
        }

        do{
            Tarea tareaPendiente = new Tarea(resultado.getString("id"), resultado.getTimestamp("fecha_limite").toLocalDateTime(),
                    resultado.getString("descripcion"), resultado.getBoolean("completada"));

            System.out.println(tareaPendiente);

        }while(resultado.next());
    }
}

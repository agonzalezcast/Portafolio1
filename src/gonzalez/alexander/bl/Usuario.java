package gonzalez.alexander.bl;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private String correo;
    private String password;
    private Calendario calendario;

    //Constructor donde cada usuario tiene un calendario propio (composición)
    public Usuario(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.calendario = new Calendario();
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //equals
    public boolean equals(Usuario usuarioComparar){
        return this.correo.equals(usuarioComparar.getCorreo());
    }

    //toString
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + "********" + '\'' +
                '}';
    }

    public void crearTarea(LocalDateTime fechaLimite, String descripcion){
        calendario.registrarTarea(new Tarea(fechaLimite, descripcion));
    }

    public void borrarTarea(String idTarea) throws Exception {
        calendario.eliminarTarea(idTarea);
    }

    public void editarTarea(String idTarea, String nuevaDescripcion, LocalDateTime nuevaFechaFinal) throws Exception {
        calendario.actualizarTarea(idTarea, nuevaDescripcion, nuevaFechaFinal);
    }

    //Completar tarea
    public void tareaCompletada(String idTarea) throws Exception {
        calendario.marcarComoCompletada(idTarea);
    }

    //Obterner lista con todas las tareas (pendientes o completadas)
    public ArrayList<Tarea> verTareas(){
        return calendario.listarTareas();
    }

    //Obterner lista con todas las tareas (pendientes o completadas) dentro de un rango de tiempo
    public ArrayList<Tarea> verTareasEnRango(LocalDateTime inicio, LocalDateTime fin) throws Exception {
        return calendario.buscarPorRango(inicio, fin);
    }

    //Obterner lista con todas las tarea pendientes
    public ArrayList<Tarea> verTareasPendientes(){
        return calendario.listarTareasPendientes();
    }

    //Obterner lista con tareas pendientes dentro de un rango
    public ArrayList<Tarea> verTareasPendientesEnRango(LocalDateTime inicio, LocalDateTime fin) throws Exception {
        return calendario.listarTareasPendientesPorRango(inicio, fin);
    }
}

package gonzalez.alexander.bl.entities;

import gonzalez.alexander.dl.Conector;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarea {

    //Atributos
    private String iD;
    private LocalDateTime fechaLimite;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private String descripcion;
    private boolean completada;

    //Constructores
    public Tarea(LocalDateTime fechaLimite, String descripcion) throws Exception {
        int numeroUltimoID = numeroUltimoID()+1;
        this.fechaLimite = fechaLimite;
        this.descripcion = descripcion;
        this.iD = "T-" + numeroUltimoID;
        this.completada = false;
    }

    public Tarea(String iD, LocalDateTime fechaLimite, String descripcion, boolean completada) {
        this.iD = iD;
        this.fechaLimite = fechaLimite;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    //Getters
    public String getiD() {
        return iD;
    }

    public LocalDateTime getFechaLimite() {
        return fechaLimite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    //Setters
    public void setFechaLimite(LocalDateTime fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    //equals
    public boolean equals(Tarea tareaComparar){
        return this.iD.equals(tareaComparar.getiD());
    }

    //toString
    public String toString() {
        if(!completada){
            return  iD + " | " + fechaLimite.format(formato) + " | " + descripcion + " | Pendiente";
        }
        return iD + " | " + fechaLimite.format(formato) + " | " + descripcion + " | Completada";

    }


    //Verificar si una tarea esta dentro de un rango de tiempo determinado
    public boolean estaEnRango(LocalDateTime inicio, LocalDateTime fin) {
        return !fechaLimite.isBefore(inicio) && !fechaLimite.isAfter(fin);
    }

    //Metodo para que el numero de ID no se reinicie cada vez que se corre el programa
    private static int numeroUltimoID() throws Exception {
        String query = "SELECT * FROM t_tareas ORDER BY id DESC LIMIT 1;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query);
        if(!resultado.next()) return 0;
        String id = resultado.getString("id");
        return Integer.parseInt(id.substring(2));
    }

    //Actualizar datos de fecha limite y descripcion
    public void actualizarTarea(LocalDateTime nuevaFechaLimite, String nuevaDescripcion) throws Exception {
        this.fechaLimite = nuevaFechaLimite;
        this.descripcion = nuevaDescripcion;
    }


}

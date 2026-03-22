package gonzalez.alexander.bl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarea {

    //Atributos
    private String iD;
    private LocalDateTime fechaLimite;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("'Fecha: 'dd-MM-yyyy' | Hora: 'HH:mm");
    private String descripcion;
    private boolean completada;
    private static int contador = 0;

    //Constructor
    public Tarea(LocalDateTime fechaLimite, String descripcion) {
        this.fechaLimite = fechaLimite;
        this.descripcion = descripcion;
        contador++;
        this.iD = "T-" + contador;
        this.completada = false;
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

}

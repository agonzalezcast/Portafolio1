package gonzalez.alexander.bl;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Calendario {

    //Atributos
    private ArrayList<Tarea> listaTareas;


    //Constructor
    public Calendario() {
        listaTareas = new ArrayList<Tarea>();
    }

    //toString
    public String toString() {
        return "Calendario{" +
                "ListaTareas=" + listaTareas +
                '}';
    }

    public void registrarTarea(Tarea nuevaTarea){
        this.listaTareas.add(nuevaTarea);
    }

    public Tarea buscarXID(String idBuscar) throws Exception {
        for (Tarea tareaEncontrar: listaTareas){
            if(idBuscar.equals(tareaEncontrar.getiD())){
                return tareaEncontrar;
            }
        }
        throw new Exception("No se encontró la tarea con el ID proporcionado");
    }

    public void eliminarTarea(String idTarea) throws Exception {
        Tarea tareaEliminar = buscarXID(idTarea);
        this.listaTareas.remove(tareaEliminar);
    }

    //Metodo para buscar y listar tareas dentro de un rango de tiempo
    public ArrayList<Tarea> buscarPorRango(LocalDateTime inicio, LocalDateTime fin) throws Exception {
        if (fin.isBefore(inicio)) {
            throw new Exception("El rango de fechas es inválido");
        }

        ArrayList<Tarea> tareasEnRango = new ArrayList<>();
        for (Tarea tareaBuscar: listaTareas){
            if(tareaBuscar.estaEnRango(inicio, fin)){
                tareasEnRango.add(tareaBuscar);
            }
        }
         return tareasEnRango;
    }

    //Metodo para actualizar una tarea existente
    public void actualizarTarea(String idTarea, String nuevaDescripcion, LocalDateTime nuevaFechaFinal) throws Exception {
        Tarea tareaActualizar = buscarXID(idTarea);
        tareaActualizar.setDescripcion(nuevaDescripcion);
        tareaActualizar.setFechaLimite(nuevaFechaFinal);

    }

    //Metodo para maracar tarea como completada
    public void marcarComoCompletada(String idTarea) throws Exception {
        Tarea tarea = buscarXID(idTarea);
        tarea.setCompletada(true);
    }

    //Metodo para devolver lista de todas la tareas en el calendario
    public ArrayList<Tarea> listarTareas(){
        return new ArrayList<Tarea>(listaTareas);
    }

    //Metodo para devolver todas las tareas pendientes
    public ArrayList<Tarea> listarTareasPendientes(){
        ArrayList<Tarea> tareasPendientes = new ArrayList<>();
        for (Tarea tareaBuscar: listaTareas){
            if(!tareaBuscar.isCompletada()){
                tareasPendientes.add(tareaBuscar);
            }
        }
        return tareasPendientes;
    }

    public ArrayList<Tarea> listarTareasPendientesPorRango(LocalDateTime inicio, LocalDateTime fin) throws Exception {
        if (fin.isBefore(inicio)) {
            throw new Exception("El rango de fechas es inválido");
        }

        ArrayList<Tarea> tareasPendientesEnRango = new ArrayList<>();
        for (Tarea tareaBuscar: listaTareas){
            if(tareaBuscar.estaEnRango(inicio, fin) && !tareaBuscar.isCompletada()){
                tareasPendientesEnRango.add(tareaBuscar);
            }
        }
        return tareasPendientesEnRango;
    }
}

package gonzalez.alexander.bl.entities;


public class Usuario {

    private String nombre;
    private String correo;
    private String password;

    //Constructor
    public Usuario(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
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
}

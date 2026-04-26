package gonzalez.alexander.bl.logic;

import gonzalez.alexander.bl.dao.DAOUsuario;
import gonzalez.alexander.bl.entities.Usuario;
import gonzalez.alexander.bl.excepciones.CredencialesInvalidasException;


public class GestorUsuario {
    public static String registrarUsuario(String nombre, String correo, String password) throws Exception {
        return DAOUsuario.insertarUsuario(new Usuario(nombre, correo, password));
    }

    public static Usuario ingresarUsuario(String correo, String password) throws Exception {
        Usuario u = DAOUsuario.seleccionarUsuario(correo, password);
        if(u==null){
            throw new CredencialesInvalidasException("Credenciales incorrectas");
        }
        return u;
    }

}

package gonzalez.alexander.bl.dao;

import gonzalez.alexander.bl.entities.Usuario;
import gonzalez.alexander.dl.Conector;

import java.sql.ResultSet;

public class DAOUsuario {
    private static String statement;
    private static String query;

    public static String insertarUsuario(Usuario usuario) throws Exception {
        statement = "INSERT INTO t_usuarios VALUES ('" + usuario.getNombre() + "', '" + usuario.getCorreo() + "', '"
                + usuario.getPassword() + "');";
        Conector.getConexion().ejecutarStatement(statement);
        return "El cliente se registró correctamente.";
    }

    public static Usuario seleccionarUsuario (String correo, String password) throws Exception {
        query = "SELECT * FROM t_usuarios WHERE correo = ? AND password = ?;";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, correo, password);
        if (!resultado.next()) return null;
        return new Usuario(resultado.getString("nombre"), resultado.getString("correo"),
                resultado.getString("password"));
    }
}

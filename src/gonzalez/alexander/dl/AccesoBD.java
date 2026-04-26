package gonzalez.alexander.dl;

import java.sql.*;
import java.time.LocalDateTime;

public class AccesoBD {
    private Connection conexion = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement;

    public AccesoBD(String direccion, String usuario, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(direccion, usuario, password);
    }

    public void ejecutarStatement(String statement) throws SQLException {
        this.statement = conexion.createStatement();
        this.statement.executeUpdate(statement);
    }

    public void ejecutarStatement(String statement, LocalDateTime f1, String s1, String s2, String s3) throws SQLException {
        preparedStatement = conexion.prepareStatement(statement);
        preparedStatement.setTimestamp(1, Timestamp.valueOf(f1));
        preparedStatement.setString(2, s1);
        preparedStatement.setString(3, s2);
        preparedStatement.setString(4, s3);
        preparedStatement.executeUpdate();
    }

    public void ejecutarStatement(String statement, boolean b1, String s1, String s2) throws SQLException {
        preparedStatement = conexion.prepareStatement(statement);
        preparedStatement.setBoolean(1, b1);
        preparedStatement.setString(2, s1);
        preparedStatement.setString(3, s2);
        preparedStatement.executeUpdate();
    }

    public void ejecutarStatement(String statement, String s1, String s2) throws SQLException {
        preparedStatement = conexion.prepareStatement(statement);
        preparedStatement.setString(1, s1);
        preparedStatement.setString(2, s2);
        preparedStatement.executeUpdate();
    }

    public ResultSet ejecutarQuery(String query) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public ResultSet ejecutarQuery(String query, String s1, String s2) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        preparedStatement.setString(1, s1);
        preparedStatement.setString(2, s2);
        return preparedStatement.executeQuery();
    }

    public ResultSet ejecutarQuery(String query, String s1) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        preparedStatement.setString(1, s1);
        return preparedStatement.executeQuery();
    }

    public ResultSet ejecutarQuery(String query, String s1, LocalDateTime f1, LocalDateTime f2) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        preparedStatement.setString(1, s1);
        preparedStatement.setTimestamp(2, Timestamp.valueOf(f1));
        preparedStatement.setTimestamp(3, Timestamp.valueOf(f2));
        return preparedStatement.executeQuery();
    }
}

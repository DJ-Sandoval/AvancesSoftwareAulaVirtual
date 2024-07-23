package Conexion;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    Connection con;

    public Connection getConexion() {
        try {
            String conexion = "jdbc:mysql://localhost:3306/aplicacioneducativa";
            con = DriverManager.getConnection(conexion, "root", "");
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;
    }
}

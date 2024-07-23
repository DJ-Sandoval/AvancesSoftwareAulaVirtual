package Modelo;

import java.sql.*;

import javax.swing.JOptionPane;

import Conexion.Conexion;

public class AlumnoDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Método para iniciar sesión
    public Alumno login(String usuario, String clave) {
        String sql = "SELECT * FROM alumnos WHERE usuario = ? AND clave = ?";
        Alumno al = new Alumno();
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            if (rs.next()) {
                al.setId(rs.getInt("id"));
                al.setNombre(rs.getString("nombre"));
                al.setApellido(rs.getString("apellido"));
                al.setUsuario(rs.getString("usuario"));
                al.setClave(rs.getString("clave"));
                al.setPais(rs.getString("pais"));
                al.setSexo(rs.getString("sexo"));
                al.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return al;
    }
}

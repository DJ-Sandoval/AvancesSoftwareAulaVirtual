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

    // Método para registrar alumnos
    public boolean registrar(Alumno al) {
        String sql = "INSERT INTO alumnos (nombre, apellido, usuario, clave, pais, sexo) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, al.getNombre());
            ps.setString(2, al.getApellido());
            ps.setString(3, al.getUsuario());
            ps.setString(4, al.getClave());
            ps.setString(5, al.getPais());
            ps.setString(6, al.getSexo());
            ps.execute();
            return true;
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());
        }
        return false;
    }

    // Método para modificar alumno
    public String modificar(Alumno al) {
        String consulta = "SELECT * FROM alumnos WHERE nombre = ? AND apellido = ? AND pais = ? AND sexo = ? AND id != ?";
        String sql = "UPDATE alumnos SET nombre = ?, apellido = ?, usuario = ?, clave = ?, pais = ?, sexo = ? WHERE id = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(consulta);
            ps.setString(1, al.getNombre());
            ps.setString(2, al.getApellido());
            ps.setString(3, al.getPais());
            ps.setString(4, al.getSexo());
            ps.setInt(5, al.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                return "existe";
            } else {
                ps = con.prepareStatement(sql);
                ps.setString(1, al.getNombre());
                ps.setString(2, al.getApellido());
                ps.setString(3, al.getUsuario());
                ps.setString(4, al.getClave());
                ps.setString(5, al.getPais());
                ps.setString(6, al.getSexo());
                ps.setInt(7, al.getId());
                ps.execute();
                return "modificado";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return "error";
        }
    }
}

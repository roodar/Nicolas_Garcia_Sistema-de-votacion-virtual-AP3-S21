package conectar;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ControlDatosUsuario {

    private Conectar conectar;
    private ModeloDatosUsuario modelo;
    private Connection con;

    public ControlDatosUsuario() {
        conectar = new Conectar();
        modelo = new ModeloDatosUsuario();
    }

    public void insertar(String nombre, String apellido, String email, String contrasena, String rol) {

        PreparedStatement ps;
        String sql;
        modelo.setNombre(nombre);
        modelo.setApellido(apellido);
        modelo.setEmail(email);
        modelo.setContrasena(contrasena);
        modelo.setRol(rol);

        try {
            con = conectar.getConexion();
            sql = "insert into usuario(nombre, apellido, email, contrasena, rol) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, modelo.getNombre());
            ps.setString(2, modelo.getApellido());
            ps.setString(3, modelo.getEmail());
            ps.setString(4, modelo.getContrasena());
            ps.setString(5, modelo.getRol());
            
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

    }
}

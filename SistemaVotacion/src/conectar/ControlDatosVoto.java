package conectar;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ControlDatosVoto {

    private Conectar conectar;
    private ModeloDatosVoto modelo;
    private Connection con;

    public ControlDatosVoto() {
        conectar = new Conectar();
        modelo = new ModeloDatosVoto();
    }

    public void insertar(String email, String nombre_candidato, String nombre_votacion, String fecha_voto) {

        PreparedStatement ps;
        String sql;
        modelo.setEmail(email);
        modelo.setNombre_votacion(nombre_votacion);
        modelo.setNombre_candidato(nombre_candidato);
        modelo.setFecha_voto(fecha_voto);
        try {
            con = conectar.getConexion();
            sql = "insert into voto(email, nombre_candidato, nombre_votacion, fecha_voto) values(?,?,?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, modelo.getEmail());
            ps.setString(2, modelo.getNombre_candidato());
            ps.setString(3, modelo.getNombre_votacion());
            ps.setString(4, modelo.getFecha_voto());
                    
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han insertado los datos correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
}

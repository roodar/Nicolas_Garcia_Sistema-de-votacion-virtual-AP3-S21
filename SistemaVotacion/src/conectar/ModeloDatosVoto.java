package conectar;


public class ModeloDatosVoto {
   private String email;
   private String nombre_votacion;
   private String nombre_candidato;
   private String fecha_voto;

    public String getFecha_voto() {
        return fecha_voto;
    }

    public void setFecha_voto(String fecha_voto) {
        this.fecha_voto = fecha_voto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre_votacion() {
        return nombre_votacion;
    }

    public void setNombre_votacion(String nombre_votacion) {
        this.nombre_votacion = nombre_votacion;
    }

    public String getNombre_candidato() {
        return nombre_candidato;
    }

    public void setNombre_candidato(String nombre_candidato) {
        this.nombre_candidato = nombre_candidato;
    }
   
   
}

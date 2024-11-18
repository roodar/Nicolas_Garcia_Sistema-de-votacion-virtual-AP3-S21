package conectar;

import java.io.Serializable;


public class ModeloDatosCandidato implements Serializable {
  
 
    private String nombre_candidato;
    private String nombre_votacion;

    public String getNombre_candidato() {
        return nombre_candidato;
    }

    public void setNombre_candidato(String nombre_candidato) {
        this.nombre_candidato = nombre_candidato;
    }

    public String getNombre_votacion() {
        return nombre_votacion;
    }

    public void setNombre_votacion(String nombre_votacion) {
        this.nombre_votacion = nombre_votacion;
    }
    
    
}

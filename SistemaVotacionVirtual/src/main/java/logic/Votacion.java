package logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Votacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_votacion;
    private String nombreVotacion;
    private String fecini;
    private String fecfin;
    private boolean estado;
    
    public Votacion() {
    }

    public Votacion(int id_votacion, String nombreVotacion, String fecini, String fecfin, boolean estado) {
        this.id_votacion = id_votacion;
        this.nombreVotacion = nombreVotacion;
        this.fecini = fecini;
        this.fecfin = fecfin;
        this.estado = estado;
    }
    
    
    
    public int getId_votacion() {
        return id_votacion;
    }

    public void setId_votacion(int id_votacion) {
        this.id_votacion = id_votacion;
    }

    public String getNombreVotacion() {
        return nombreVotacion;
    }

    public void setNombreVotacion(String nombreVotacion) {
        this.nombreVotacion = nombreVotacion;
    }

    public String getFecini() {
        return fecini;
    }

    public void setFecini(String fecini) {
        this.fecini = fecini;
    }

    public String getFecfin() {
        return fecfin;
    }

    public void setFecfin(String fecfin) {
        this.fecfin = fecfin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}

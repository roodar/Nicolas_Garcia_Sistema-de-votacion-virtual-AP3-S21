package logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String candidato;
    private String usuario;
    private String votacion;
    private String fecvot;

    public Voto() {
    }

    public Voto(String candidato, String usuario, String votacion, String fecvot) {
        this.candidato = candidato;
        this.usuario = usuario;
        this.votacion = votacion;
        this.fecvot = fecvot;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getVotacion() {
        return votacion;
    }

    public void setVotacion(String votacion) {
        this.votacion = votacion;
    }

    public String getFecvot() {
        return fecvot;
    }

    public void setFecvot(String fecvot) {
        this.fecvot = fecvot;
    }
 }
    

    
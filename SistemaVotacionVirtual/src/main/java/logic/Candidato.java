package logic;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Candidato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_candidato;
    private String nombre;
    private String apellido;
    
    public Candidato() {
    }

    public Candidato(int id_candidato, String nombre, String apellido) {
        this.id_candidato = id_candidato;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    
    public int getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(int id_candidato) {
        this.id_candidato = id_candidato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
}

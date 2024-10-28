package logic;

import persistance.ctrlPersistencia;

public class ctrlLogic {
    
   ctrlPersistencia controlPersis = new ctrlPersistencia();

    public void guardarVoto(String candidato, String votacion, String usuario, String fecha) {
   
        Voto voto = new Voto();
        voto.setCandidato(candidato);
        voto.setUsuario(usuario);
        voto.setVotacion(votacion);
        voto.setFecvot(fecha);
        
      controlPersis.guardar(voto);
    }
    
}

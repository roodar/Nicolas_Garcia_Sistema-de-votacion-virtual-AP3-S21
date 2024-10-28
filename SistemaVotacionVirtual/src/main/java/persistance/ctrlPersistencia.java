package persistance;

import logic.Voto;

public class ctrlPersistencia {
    
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    CandidatoJpaController candidatoJpa = new CandidatoJpaController();
    VotacionJpaController votacionJpa = new VotacionJpaController();
    VotoJpaController votoJpa = new VotoJpaController();

    public void guardar(Voto voto) {
        
        //Creacion de voto en BD
       votoJpa.create(voto);
        
    }
 
}

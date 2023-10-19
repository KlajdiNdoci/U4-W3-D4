package KlajdiNdoci.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {

    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Partecipazione salvata correttamente");
    }

    public Partecipazione getById(long id) {
        return em.find(Partecipazione.class, id);

    }

    public void delete(long id) {
        Partecipazione selectedEv = em.find(Partecipazione.class, id);
        if (selectedEv != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEv);
            transaction.commit();
            System.out.println("La partecipazione é stata correttamente cancellata");
        } else {
            System.err.println("La partecipazione con l'id " + id + " non esiste");
        }
    }


}

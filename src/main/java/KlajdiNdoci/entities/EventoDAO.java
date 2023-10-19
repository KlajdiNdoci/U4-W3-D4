package KlajdiNdoci.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento salvato correttamente");
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);

    }

    public void delete(long id) {
        Evento selectedEv = em.find(Evento.class, id);
        if (selectedEv != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEv);
            transaction.commit();
            System.out.println("L'evento é stato correttamente cancellato");
        } else {
            System.err.println("L'evento con l'id " + id + " non esiste");
        }
    }


}

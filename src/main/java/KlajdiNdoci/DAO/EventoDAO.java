package KlajdiNdoci.DAO;

import KlajdiNdoci.entities.Concerto;
import KlajdiNdoci.entities.Evento;
import KlajdiNdoci.enums.Genere;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Concerto> findInStreaming(boolean trueOrFalse) {
        TypedQuery<Concerto> getAllQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :trueOrFalse", Concerto.class);
        getAllQuery.setParameter("trueOrFalse", trueOrFalse);
        return getAllQuery.getResultList();
    }

    public List<Concerto> findByGenre(Genere genere) {
        TypedQuery<Concerto> getAllQuery = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        getAllQuery.setParameter("genere", genere);
        return getAllQuery.getResultList();
    }
}

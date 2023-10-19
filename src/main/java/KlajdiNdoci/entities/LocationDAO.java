package KlajdiNdoci.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {

    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Location salvata correttamente");
    }

    public Location getById(long id) {
        return em.find(Location.class, id);

    }

    public void delete(long id) {
        Location selectedEv = em.find(Location.class, id);
        if (selectedEv != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEv);
            transaction.commit();
            System.out.println("La location é stata correttamente cancellata");
        } else {
            System.err.println("La location con l'id " + id + " non esiste");
        }
    }


}

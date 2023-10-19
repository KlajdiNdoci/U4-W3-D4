package KlajdiNdoci.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {

    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("Persona salvata correttamente");
    }

    public Persona getById(long id) {
        return em.find(Persona.class, id);

    }

    public void delete(long id) {
        Persona selectedEv = em.find(Persona.class, id);
        if (selectedEv != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(selectedEv);
            transaction.commit();
            System.out.println("La persona é stata correttamente cancellata");
        } else {
            System.err.println("La persona con l'id " + id + " non esiste");
        }
    }


}

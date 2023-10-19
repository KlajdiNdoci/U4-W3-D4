package KlajdiNdoci;

import KlajdiNdoci.DAO.EventoDAO;
import KlajdiNdoci.DAO.LocationDAO;
import KlajdiNdoci.DAO.PartecipazioneDAO;
import KlajdiNdoci.DAO.PersonaDAO;
import KlajdiNdoci.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Application {
    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {
            EventoDAO eventoDAO = new EventoDAO(em);
            PersonaDAO personaDAO = new PersonaDAO(em);
            LocationDAO locationDAO = new LocationDAO(em);
            PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }
}

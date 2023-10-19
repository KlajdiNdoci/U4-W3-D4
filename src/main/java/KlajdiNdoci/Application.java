package KlajdiNdoci;

import KlajdiNdoci.entities.*;
import KlajdiNdoci.enums.Sesso;
import KlajdiNdoci.enums.Stato;
import KlajdiNdoci.enums.TipoEvento;
import KlajdiNdoci.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try {
            EventoDAO eventoDAO = new EventoDAO(em);
            PersonaDAO personaDAO = new PersonaDAO(em);
            LocationDAO locationDAO = new LocationDAO(em);
            PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);


            Persona aldo = new Persona("Aldo", "Baglio", "aldobaglio@gmail.com", LocalDate.of(1970, 12, 4), Sesso.M);
            personaDAO.save(aldo);
            Location milano = new Location("Piazza Duomo", "Milano");
            locationDAO.save(milano);
            Evento evento1 = new Evento("Evento a Milano", LocalDate.of(2022, 12, 5), "ciao", TipoEvento.PUBBLICO, 2000, milano);
            eventoDAO.save(evento1);
            Partecipazione p1 = new Partecipazione(aldo, evento1, Stato.CONFERMATA);
            partecipazioneDAO.save(p1);


            Evento evFromDB = eventoDAO.getById(45);
//            Persona psFromDB = personaDAO.getById(23);
//            System.out.println(psFromDB);
//            Partecipazione paFromDB = partecipazioneDAO.getById(26);
//            System.out.println(paFromDB);
            if (evFromDB != null) {
                System.out.println(evFromDB);
            }
            eventoDAO.delete(45);


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }
}

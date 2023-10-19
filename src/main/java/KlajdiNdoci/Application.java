package KlajdiNdoci;

import KlajdiNdoci.DAO.EventoDAO;
import KlajdiNdoci.DAO.LocationDAO;
import KlajdiNdoci.DAO.PartecipazioneDAO;
import KlajdiNdoci.DAO.PersonaDAO;
import KlajdiNdoci.enums.Genere;
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

//            Location sansiro = new Location("Sar Siro", "Milano");
//            locationDAO.save(sansiro);
//            Persona aldo = new Persona("Aldo", "Baglio", "aldobaglio@gmail.com", LocalDate.of(1970, 12, 4), Sesso.M);
//            Persona giacomo = new Persona("Giacomo", "Poretti", "giacomoporetti@gmail.com", LocalDate.of(1968, 12, 4), Sesso.M);
//            Persona giovanni = new Persona("Giovanni", "Storti", "giovannistorti@gmail.com", LocalDate.of(1965, 12, 4), Sesso.M);
//            personaDAO.save(aldo);
//            personaDAO.save(giacomo);
//            personaDAO.save(giovanni);
//
//            PartitaDiCalcio partita1 = new PartitaDiCalcio("Milan-Inter", LocalDate.of(2023, 5, 5), "derby1", TipoEvento.PUBBLICO, 80000, sansiro, "Milan", "Inter", 1, 5);
//            eventoDAO.save(partita1);
//            PartitaDiCalcio partita2 = new PartitaDiCalcio("Milan-Inter", LocalDate.of(2023, 5, 5), "derby2", TipoEvento.PUBBLICO, 80000, sansiro, "Milan", "Inter", 5, 1);
//            eventoDAO.save(partita2);
//            PartitaDiCalcio partita3 = new PartitaDiCalcio("Inter-Milan", LocalDate.of(2023, 5, 5), "derby3", TipoEvento.PUBBLICO, 80000, sansiro, "Inter", "Milan", 1, 1);
//            eventoDAO.save(partita3);
//
//            Set<Persona> atleti = new HashSet<>();
//            atleti.add(aldo);
//            atleti.add(giovanni);
//            atleti.add(giacomo);
//
//            GaraDiAtletica gara1 = new GaraDiAtletica("Gara di atletica 1", LocalDate.of(2023, 5, 5), "gara delle olimpiadi", TipoEvento.PUBBLICO, 100000, sansiro, aldo, atleti);
//            eventoDAO.save(gara1);
//
//            Concerto concerto1 = new Concerto("Concerto Salmo", LocalDate.of(2023, 5, 5), "Concerto1", TipoEvento.PRIVATO, 100000, sansiro, Genere.ROCK, true);
//            eventoDAO.save(concerto1);
//            Concerto concerto2 = new Concerto("Concerto FabriFibra", LocalDate.of(2023, 5, 5), "Concerto2", TipoEvento.PRIVATO, 100000, sansiro, Genere.POP, false);
//            eventoDAO.save(concerto2);
//            Concerto concerto3 = new Concerto("Concerto Vasco", LocalDate.of(2023, 5, 5), "Concerto3", TipoEvento.PRIVATO, 100000, sansiro, Genere.CLASSICO, false);
//            eventoDAO.save(concerto3);


//            eventoDAO.findInStreaming(true).forEach(System.out::println);
//            eventoDAO.findInStreaming(false).forEach(System.out::println);
//            eventoDAO.findByGenre(Genere.CLASSICO).forEach(System.out::println);
//            eventoDAO.findByGenre(Genere.POP).forEach(System.out::println);
            eventoDAO.findByGenre(Genere.ROCK).forEach(System.out::println);


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            em.close();
            emf.close();
        }

    }
}

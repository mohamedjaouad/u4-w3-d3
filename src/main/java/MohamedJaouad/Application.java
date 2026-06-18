package MohamedJaouad;

import MohamedJaouad.dao.EventoDAO;
import MohamedJaouad.dao.LocationDAO;
import MohamedJaouad.dao.PartecipazioneDAO;
import MohamedJaouad.dao.UserDAO;
import MohamedJaouad.entities.Enum.GenereMusica;
import MohamedJaouad.entities.Enum.Sesso;
import MohamedJaouad.entities.Enum.StatoPartecipazione;
import MohamedJaouad.entities.Enum.TipoEvento;
import MohamedJaouad.entities.Location;
import MohamedJaouad.entities.Partecipazione;
import MohamedJaouad.entities.User;
import MohamedJaouad.entities.d4.Concerto;
import MohamedJaouad.entities.d4.GaraDiAtletica;
import MohamedJaouad.entities.d4.PartitaDiCalcio;
import MohamedJaouad.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Set;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4-w3-d3pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDAO userDAO = new UserDAO(entityManager);
        EventoDAO eventoDAO = new EventoDAO(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);


        Location location = new Location("Stadio Olimpico", "Roma");
//        locationDAO.save(location);

        User mohamed = new User(
                "Mohamed",
                "Jaouad",
                "mohamed@example.com",
                Sesso.M,
                LocalDate.of(2000, 5, 10)
        );
//        userDAO.save(mohamed);

        PartitaDiCalcio partita = new PartitaDiCalcio(
                "Roma vs Lazio",
                LocalDate.of(2026, 7, 20),
                "Derby della Capitale",
                TipoEvento.PUBBLICO,
                location,
                "Roma",
                "Lazio",
                "Roma",
                2,
                1
        );
//        eventoDAO.save(partita);

        Concerto concerto = new Concerto(
                "Concerto Hip-Hop",
                LocalDate.of(2026, 8, 10),
                "Grande concerto estivo",
                TipoEvento.PUBBLICO,
                location,
                GenereMusica.POP,
                true
        );
//        eventoDAO.save(concerto);


        GaraDiAtletica gara = new GaraDiAtletica(
                "100 metri piani",
                LocalDate.of(2026, 9, 5),
                "Gara nazionale",
                TipoEvento.PUBBLICO,
                location,
                Set.of("Usain Bolt", "Andre De Grasse", "Marcell Jacobs"),
                "Marcell Jacobs"
        );
//        eventoDAO.save(gara);

        Partecipazione partecipazione = new Partecipazione(
                mohamed,
                concerto,
                StatoPartecipazione.CONFERMATA
        );
//        partecipazioneDAO.save(partecipazione);

        System.out.println("\npartite vinte in casa");
        eventoDAO.getPartiteVinteInCasa().forEach(System.out::println);

        System.out.println("\npartite vinte in trasferta ");
        eventoDAO.getPartiteVinteInTrasferta().forEach(System.out::println);

        System.out.println("\nconcerti in streaming");
        eventoDAO.getConcertiInStreaming(true).forEach(System.out::println);

        System.out.println("\nconcerti per genere pop");
        eventoDAO.getConcertiPerGenere(GenereMusica.POP).forEach(System.out::println);
    }
}
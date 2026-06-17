package MohamedJaouad;

import MohamedJaouad.dao.EventoDAO;
import MohamedJaouad.dao.LocationDAO;
import MohamedJaouad.dao.PartecipazioneDAO;
import MohamedJaouad.dao.UserDAO;
import MohamedJaouad.entities.Enum.Sesso;
import MohamedJaouad.entities.Enum.StatoPartecipazione;
import MohamedJaouad.entities.Enum.TipoEvento;
import MohamedJaouad.entities.Event;
import MohamedJaouad.entities.Location;
import MohamedJaouad.entities.Partecipazione;
import MohamedJaouad.entities.User;
import MohamedJaouad.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4-w3-d3pu");
    public static void main(String[] args){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        UserDAO userDAO = new UserDAO(entityManager);
        EventoDAO eventoDAO = new EventoDAO(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);
        LocationDAO locationDAO=new LocationDAO(entityManager);
        User mohamed = new User(
                "Mohamed",
                "Jaouad",
                "mohamed@example.com",
                Sesso.M,
                LocalDate.of(2000, 5, 10)
        );
//       userDAO.save(mohamed);
        Location location = new Location("Stadio Olimpico", "Roma");

//locationDAO.save(location);

        Event evento = new Event(
                "Concerto Hip-Hop",
                LocalDate.of(2026, 7, 20),
                "Grande concerto estivo",
                TipoEvento.PUBBLICO,
                location
        );
//        eventoDAO.save(evento);


        Partecipazione partecipazione = new Partecipazione(
                mohamed,
                evento,
                StatoPartecipazione.CONFERMATA
        );

//        partecipazioneDAO.save(partecipazione);

        try {
            User userFromDB = userDAO.findById("31db195d-8061-4376-9680-768db437b980");
            System.out.println("trovato: " + userFromDB);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }


}

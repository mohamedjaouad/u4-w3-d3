package MohamedJaouad.dao;

import MohamedJaouad.entities.Enum.GenereMusica;
import MohamedJaouad.entities.Event;
import MohamedJaouad.entities.d4.Concerto;
import MohamedJaouad.entities.d4.PartitaDiCalcio;
import MohamedJaouad.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Event newEvent) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();

        this.entityManager.persist(newEvent);

        transaction.commit();
        System.out.println(newEvent + " e stato salvato nel db");
    }
    public Event findById(String id) {
        Event fromDB = this.entityManager.find(Event.class, UUID.fromString(id));
        if (fromDB == null) throw new NotFoundException(id);
        return fromDB;
    }
    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery(
                "getPartiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery(
                "getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }
    public List<Concerto> getConcertiInStreaming(boolean streaming) {
        TypedQuery<Concerto> query = entityManager.createQuery(
                "SELECT c FROM Concerto c WHERE c.inStreaming = :streaming",
                Concerto.class
        );
        query.setParameter("streaming", streaming);
        return query.getResultList();
    }
    public List<Concerto> getConcertiPerGenere(GenereMusica genere) {
        TypedQuery<Concerto> query = entityManager.createQuery(
                "SELECT c FROM Concerto c WHERE c.genere = :genere",
                Concerto.class
        );
        query.setParameter("genere", genere);
        return query.getResultList();
    }



}

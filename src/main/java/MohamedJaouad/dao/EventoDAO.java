package MohamedJaouad.dao;

import MohamedJaouad.entities.Event;
import MohamedJaouad.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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


}

package MohamedJaouad.dao;

import MohamedJaouad.entities.Location;
import MohamedJaouad.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Location newLocation) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();

        this.entityManager.persist(newLocation);

        transaction.commit();
        System.out.println(newLocation + " e stata salvata nel DB");

    }
    public Location findById(String id) {
        Location fromDB = this.entityManager.find(Location.class, UUID.fromString(id));
        if (fromDB == null) throw new NotFoundException(id);
        return fromDB;
    }

}

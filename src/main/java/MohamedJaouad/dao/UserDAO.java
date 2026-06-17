package MohamedJaouad.dao;

import MohamedJaouad.entities.User;
import MohamedJaouad.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UserDAO {
    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(User newUser){
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(newUser);
        transaction.commit();
        System.out.println( newUser + " e stato salvato nel db");
    }
    public User findById(String id) {
        User fromDB = this.entityManager.find(User.class, UUID.fromString(id));
        if (fromDB == null) throw new NotFoundException(id);
        return fromDB;
    }


}

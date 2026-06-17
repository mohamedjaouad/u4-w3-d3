package MohamedJaouad.dao;

import MohamedJaouad.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione newPartecipazione) {
        EntityTransaction transaction = this.entityManager.getTransaction();
        transaction.begin();

        this.entityManager.persist(newPartecipazione);

        transaction.commit();
        System.out.println(newPartecipazione + " e stato salvato nel db");
    }


}

package MohamedJaouad.entities;

import MohamedJaouad.entities.Enum.StatoPartecipazione;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    @Column(name = "partecipazione_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event evento;

    @Enumerated(EnumType.STRING)
    private StatoPartecipazione stato;

    public Partecipazione() {}

    public Partecipazione(User user, Event evento, StatoPartecipazione stato) {
        this.user = user;
        this.evento = evento;
        this.stato = stato;
    }

    public UUID getId() { return id; }
    public User getUser() {return user;}
    public Event getEvento() {return evento;}
    public StatoPartecipazione getStato() {return stato;}

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", user=" + user +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}

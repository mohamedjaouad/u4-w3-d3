package MohamedJaouad.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue
    @Column(name="event_id")
    private UUID id;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
}

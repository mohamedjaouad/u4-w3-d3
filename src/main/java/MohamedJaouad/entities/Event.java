package MohamedJaouad.entities;

import MohamedJaouad.entities.Enum.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue
    @Column(name="event_id")
    private UUID id;

    private String titolo;
    @Column(name = "data_evento")
    private LocalDate dataEvento;

    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Event(){}

    public Event(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.location = location;
    }

    public UUID getId() {return id;}
    public String getTitolo() {return titolo;}
    public String getDescrizione() {return descrizione;}
    public LocalDate getDataEvento() {return dataEvento;}
    public TipoEvento getTipoEvento() {return tipoEvento;}

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                '}';
    }
}

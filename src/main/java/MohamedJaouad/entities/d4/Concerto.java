package MohamedJaouad.entities.d4;

import MohamedJaouad.entities.Enum.GenereMusica;
import MohamedJaouad.entities.Enum.TipoEvento;
import MohamedJaouad.entities.Event;
import MohamedJaouad.entities.Location;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
public class Concerto extends Event {

    @Enumerated(EnumType.STRING)
    private GenereMusica genere;

    private boolean inStreaming;

    public Concerto() {}

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                    Location location,
                    GenereMusica genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereMusica getGenere() { return genere; }
    public boolean isInStreaming() { return inStreaming; }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                "} " + super.toString();
    }
}
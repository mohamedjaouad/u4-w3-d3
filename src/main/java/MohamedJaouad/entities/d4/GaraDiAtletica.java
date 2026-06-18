package MohamedJaouad.entities.d4;

import MohamedJaouad.entities.Enum.TipoEvento;
import MohamedJaouad.entities.Event;
import MohamedJaouad.entities.Location;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Event {

    @ElementCollection
    private Set<String> atleti;

    private String vincitore;

    public GaraDiAtletica() {}

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                          Location location,
                          Set<String> atleti, String vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<String> getAtleti() { return atleti; }
    public String getVincitore() { return vincitore; }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore='" + vincitore + '\'' +
                "} " + super.toString();
    }
}
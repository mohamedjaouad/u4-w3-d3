package MohamedJaouad.entities.d4;

import MohamedJaouad.entities.Enum.TipoEvento;
import MohamedJaouad.entities.Event;
import MohamedJaouad.entities.Location;
import jakarta.persistence.Entity;


import java.time.LocalDate;

@Entity
public class PartitaDiCalcio extends Event {
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    public PartitaDiCalcio() {}

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
                           Location location,
                           String squadraDiCasa, String squadraOspite, String squadraVincente,
                           int numeroGolSquadraDiCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }


    public String getSquadraDiCasa() { return squadraDiCasa; }
    public String getSquadraOspite() { return squadraOspite; }
    public String getSquadraVincente() { return squadraVincente; }
    public int getNumeroGolSquadraDiCasa() { return numeroGolSquadraDiCasa; }
    public int getNumeroGolSquadraOspite() { return numeroGolSquadraOspite; }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golCasa=" + numeroGolSquadraDiCasa +
                ", golOspite=" + numeroGolSquadraOspite +
                "} " + super.toString();
    }
}
package MohamedJaouad.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private UUID id;
    private String nome;
    private String citta;

    public Location() {}

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getCitta() { return citta; }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}

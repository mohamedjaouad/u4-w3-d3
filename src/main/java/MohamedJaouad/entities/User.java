package MohamedJaouad.entities;

import MohamedJaouad.entities.Enum.Sesso;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    @Column(name="user_id")
    private UUID id;

    private String name;
    private String surname;
    private String email;

    @Column(name = "data_nascita")
    private LocalDate dataDiNascita;

    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "user")
    private List<Partecipazione> listaPartecipazioni;

    public User(){}

    public User(String name,String surname, String email,Sesso sesso,LocalDate dataDiNascita){
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    public UUID getId() {return id;}
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getEmail() {return email;}
    public LocalDate getDataDiNascita() {return dataDiNascita;}
    public Sesso getSesso() {return sesso;}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
                '}';
    }
}

package MohamedJaouad.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
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
    
    public User(){}
    public User(String name,String surname, String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

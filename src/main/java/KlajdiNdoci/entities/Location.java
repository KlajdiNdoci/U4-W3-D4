package KlajdiNdoci.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")

public class Location {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cittá;

    public Location() {
    }

    public Location(String nome, String cittá) {
        this.nome = nome;
        this.cittá = cittá;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cittá='" + cittá + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCittá() {
        return cittá;
    }

    public void setCittá(String cittá) {
        this.cittá = cittá;
    }
}

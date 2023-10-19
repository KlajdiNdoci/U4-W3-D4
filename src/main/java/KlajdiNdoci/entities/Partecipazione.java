package KlajdiNdoci.entities;

import KlajdiNdoci.enums.Stato;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")

public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }


    public long getId() {
        return id;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}

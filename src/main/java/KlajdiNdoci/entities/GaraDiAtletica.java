package KlajdiNdoci.entities;

import KlajdiNdoci.enums.TipoEvento;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {
    @OneToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;
    @OneToMany
    private Set<Persona> atleti;

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Persona vincitore, Set<Persona> atleti) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.vincitore = vincitore;
        this.atleti = atleti;
    }

    public GaraDiAtletica() {
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }


}
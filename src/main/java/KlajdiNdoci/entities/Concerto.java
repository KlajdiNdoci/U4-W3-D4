package KlajdiNdoci.entities;

import KlajdiNdoci.enums.Genere;
import KlajdiNdoci.enums.TipoEvento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Concerto")
public class Concerto extends Evento {
    private Genere genere;
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                ", titolo=" + getTitolo() +
                ", inStreaming=" + inStreaming +
                ", titolo='" + getTitolo() + '\'' +
                ", dataEvento=" + getDataEvento() +
                ", descrizione='" + getDescrizione() + '\'' +
                ", tipoEvento=" + getTipoEvento() +
                ", numeroMassimoPartecipanti=" + getNumeroMassimoPartecipanti() +
                ", listaPartecipazioni=" + getListaPartecipazioni() +
                ", location=" + getLocation() +
                '}';
    }
}

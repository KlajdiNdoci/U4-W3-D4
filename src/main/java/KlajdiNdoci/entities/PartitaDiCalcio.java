package KlajdiNdoci.entities;

import KlajdiNdoci.enums.TipoEvento;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Partita di calcio")
public class PartitaDiCalcio extends Evento {
    private String squadraDiCasa;
    private String squadraOspite;

    private String squadraVincente;
    private int golCasa;
    private int golOspite;

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite, int golCasa, int golOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.golCasa = golCasa;
        this.golOspite = golOspite;
        if (golCasa > golOspite) {
            this.squadraVincente = squadraDiCasa;
        } else if (golOspite > golCasa) {
            this.squadraVincente = squadraOspite;
        } else {
            this.squadraVincente = "Pareggio";
        }
    }

    public PartitaDiCalcio() {
    }


    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golCasa=" + golCasa +
                ", golOspite=" + golOspite +
                ", titolo='" + getTitolo() + '\'' +
                ", dataEvento=" + getDataEvento() +
                ", descrizione='" + getDescrizione() + '\'' +
                ", tipoEvento=" + getTipoEvento() +
                ", numeroMassimoPartecipanti=" + getNumeroMassimoPartecipanti() +
                ", listaPartecipazioni=" + getListaPartecipazioni() +
                ", location=" + getLocation() +
                '}';
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }


}


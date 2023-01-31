package com.howtodoinjava.example.movie.beans;

import java.util.Date;

public class film {

    private String titre;
    private String realisateur;
    private String datesortie;
    private acteur acteurprincipal;

    public film(String titre, String realisateur, String datesortie, acteur acteurprincipal) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.datesortie = datesortie;
        this.acteurprincipal = acteurprincipal;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getDatesortie() {
        return datesortie;
    }

    public void setDatesortie(String datesortie) {
        this.datesortie = datesortie;
    }

    public acteur getActeurprincipal() {
        return acteurprincipal;
    }

    public void setActeurprincipal(acteur acteurprincipal) {
        this.acteurprincipal = acteurprincipal;
    }

    @Override
    public String toString() {
        return "film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", datesortie=" + datesortie +
                ", acteurprincipal=" + acteurprincipal +
                '}';
    }
}

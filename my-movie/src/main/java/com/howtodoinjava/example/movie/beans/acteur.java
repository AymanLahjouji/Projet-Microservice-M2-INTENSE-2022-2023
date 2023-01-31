package com.howtodoinjava.example.movie.beans;

import java.util.Date;

public class acteur {

    private String nom;
    private String prenom;
    private String datenaissance;
    private String film;

    public acteur(String nom, String prenom, String datenaissance, String film) {
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.film = film;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "acteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", datenaissance=" + datenaissance +
                ", film=" + film +
                '}';
    }
}

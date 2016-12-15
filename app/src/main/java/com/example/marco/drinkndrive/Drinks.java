package com.example.marco.drinkndrive;

/**
 * Created by Marco on 16/12/2016.
 */

public class Drinks {
    private long id;
    private String nom;
    private int volume;
    private int centilitre;
    private int heure;

    public Drinks(long id, String nom, int volume) {
        this.id = id;
        this.nom = nom;
        this.volume = volume;
    }

    public Drinks(long id, String nom, int volume, int centilitre, int heure) {

        this.id = id;
        this.nom = nom;
        this.volume = volume;
        this.centilitre = centilitre;
        this.heure = heure;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCentilitre() {
        return centilitre;
    }

    public void setCentilitre(int centilitre) {
        this.centilitre = centilitre;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }
}

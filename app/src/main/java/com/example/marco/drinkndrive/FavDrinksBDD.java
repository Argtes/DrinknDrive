package com.example.marco.drinkndrive;

/**
 * Created by Marco on 15/12/2016.
 */

public class FavDrinksBDD {
    private long id;
    private String nom;
    private int volume;

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

    public String toString() {
        return nom+ " à "+ volume+"%";
    }
}

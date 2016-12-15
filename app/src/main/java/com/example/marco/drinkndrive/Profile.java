package com.example.marco.drinkndrive;

/**
 * Created by Marco on 15/12/2016.
 */

public class Profile {
    private long id;
    private String nom;
    private int poids;
    private boolean sexe;//0=>M 1=>F
    private boolean permis; //0=> A 1=> pas A
    private double taille;

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public boolean isPermis() {
        return permis;
    }

    public void setPermis(boolean permis) {
        this.permis = permis;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
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

    // Sera utilisée par ArrayAdapter dans la ListView
    @Override
    public String toString() {
        return nom;
    }

}

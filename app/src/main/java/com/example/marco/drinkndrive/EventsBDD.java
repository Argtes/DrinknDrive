package com.example.marco.drinkndrive;

/**
 * Created by Marco on 15/12/2016.
 */

public class EventsBDD {
    private long id;

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String drinks;


    public String toString() {
        return drinks;
    }
}

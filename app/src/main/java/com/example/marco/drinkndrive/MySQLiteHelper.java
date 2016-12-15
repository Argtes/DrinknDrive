package com.example.marco.drinkndrive;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Marco on 15/12/2016.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_EVENTS = "events";
    public static final String COLUMN_IDEVENTS = "_id";
    public static final String COLUMN_DRINKS = "drinks";

    private static final String DATABASE_NAME = "events.db";
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATEVENTS = "create table "
            + TABLE_EVENTS + "(" + COLUMN_IDEVENTS
            + " integer primary key autoincrement, " + COLUMN_DRINKS
            + " text not null);";

//creation table FAV

    public static final String TABLE_FAV = "fav";
    public static final String COLUMN_IDFAV = "_id";
    public static final String COLUMN_NAME = "nom";
    public static final String COLUMN_ALCOOL = "alcool";

    private static final String DATABASE_CREATEFAV = "create table "
            + TABLE_FAV + "(" + COLUMN_IDFAV
            + " integer primary key autoincrement, " + COLUMN_NAME+" text not null, "+ COLUMN_ALCOOL
            + " integer);";

    //creation table profile

    public static final String TABLE_PRO = "pro";
    public static final String COLUMN_IDPRO = "_id";
    public static final String COLUMN_NAMEP = "nom";
    public static final String COLUMN_SEXE = "sexe";
    public static final String COLUMN_TAILLE = "taille";
    public static final String COLUMN_POIDS = "poids";
    public static final String COLUMN_PERMIS = "permis";



    private static final String DATABASE_CREATEPRO = "create table "
            + TABLE_PRO + "(" + COLUMN_IDPRO
            + " integer primary key autoincrement, " + COLUMN_NAMEP+" text not null, "+ COLUMN_SEXE
            + " integer, "+ COLUMN_TAILLE+ " integer, " + COLUMN_POIDS+ "integer, "+ COLUMN_PERMIS + "boolean, );";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATEVENTS);
        database.execSQL(DATABASE_CREATEFAV);
        database.execSQL(DATABASE_CREATEPRO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAV);
        onCreate(db);
    }
}
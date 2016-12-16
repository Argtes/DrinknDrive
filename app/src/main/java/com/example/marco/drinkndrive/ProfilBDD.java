package com.example.marco.drinkndrive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 16/12/2016.
 */

public class ProfilBDD {
    // Champs de la base de données
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_IDPRO,
            MySQLiteHelper.COLUMN_NAMEP, MySQLiteHelper.COLUMN_SEXE, MySQLiteHelper.COLUMN_TAILLE, "poids", "permis" };

    public ProfilBDD(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void createProfile(ProfileObj user){
        ContentValues values = new ContentValues();

        values.put(MySQLiteHelper.COLUMN_NAMEP, user.getNom());
        values.put(MySQLiteHelper.COLUMN_SEXE, user.isSexe());
        values.put(MySQLiteHelper.COLUMN_TAILLE, user.getTaille());
        values.put(MySQLiteHelper.COLUMN_POIDS, user.getPoids());
        values.put(MySQLiteHelper.COLUMN_PERMIS, user.isPermis());


        long insertId = database.insert(MySQLiteHelper.TABLE_PRO, null,
                values);

        Cursor cursor = database.query(MySQLiteHelper.TABLE_PRO,
                allColumns, MySQLiteHelper.COLUMN_IDPRO + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        cursor.close();

    }

    public List<ProfileObj> getAllUsersName(){

        List<ProfileObj> users = new ArrayList<ProfileObj>();
        Cursor cursor = database.query(MySQLiteHelper.TABLE_PRO,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ProfileObj user = cursorToProfile(cursor);
            users.add(user);
            cursor.moveToNext();
        }
        cursor.close();
        return users;
    }


    //test
    public String getTestName(){
        String test = "";
        Cursor cursor = database.rawQuery("select nom from pro where _id = 0", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ProfileObj util = cursorToProfile(cursor);
            test= util.getNom();
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return test;
    }

    private ProfileObj cursorToProfile(Cursor cursor) {
        ProfileObj user = new ProfileObj(null);
        user.setId(cursor.getLong(0));
        user.setNom(cursor.getString(1));
        user.setSexe(Boolean.parseBoolean(cursor.getString(2)));
        user.setTaille(Integer.parseInt(cursor.getString(3)));
        user.setPoids(Integer.parseInt(cursor.getString(4)));
        user.setPermis(Boolean.parseBoolean(cursor.getString(5)));
        return user;
    }

}


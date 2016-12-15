package com.example.marco.drinkndrive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CreateProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
    }

    public void onClick(View view) {
        //faire les ajouts bdd

        //retour à l'activité de base

        Toast.makeText(getBaseContext(), "Profil ajouté", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(CreateProfile.this, ProfileSelection.class);
        startActivity(intent);

    }
}

package com.example.marco.drinkndrive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static java.lang.Integer.parseInt;

public class CreateProfile extends AppCompatActivity {

    private ProfilBDD dataPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        dataPro = new ProfilBDD(this);
        dataPro.open();

    }

    public void onClick(View view) {

        ProfileObj user= new ProfileObj("");

        boolean texteSexe;
        boolean textePermis;
        String texteNom="";
        int texteTaille;
        int textePoids;

        Switch sexe = (Switch) findViewById(R.id.homme);
        Switch permis = (Switch) findViewById(R.id.permis);

        //faire les ajouts bdd

        TextView tvNom = null;
        tvNom = (TextView) findViewById(R.id.tvnom);
        texteNom=tvNom.getText()+"";
        user.setNom(texteNom);

        TextView tvTaille = null;
        tvTaille = (TextView) findViewById(R.id.tvtaille);
        texteTaille=Integer.parseInt(tvTaille.getText()+"");
        user.setTaille(texteTaille);

        TextView tvPoids = null;
        tvPoids = (TextView) findViewById(R.id.tvpoids);
        textePoids=parseInt(tvPoids.getText()+"");
        user.setPoids(textePoids);

        if(sexe.isChecked()) {
            texteSexe=false;
        } else {
            texteSexe=true;
        }
        user.setSexe(texteSexe);

        if(permis.isChecked()) {
            textePermis=false;
        } else {
            textePermis=true;
        }
        user.setPermis(textePermis);

        dataPro.createProfile(user);


        //test bdd

        ArrayList<ProfileObj> test= new ArrayList<ProfileObj>(dataPro.getAllUsersName());
        String tempo;
        for(int i=0; i<test.size(); i++){
            tempo = test.get(i).getNom();
            Toast.makeText(getBaseContext(), tempo+" : est le "+i+" utilisateur", Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(CreateProfile.this, ProfileSelection.class);
        startActivity(intent);


    }
}

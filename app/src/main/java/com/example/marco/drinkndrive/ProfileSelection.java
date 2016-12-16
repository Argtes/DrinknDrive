package com.example.marco.drinkndrive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProfileSelection extends AppCompatActivity {

    private ProfilBDD dataPro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_selection);
/*
        ListView listV =(ListView) findViewById(android.R.id.list);
        ArrayList<ProfileObj> values= new ArrayList<ProfileObj>(dataPro.getAllUsersName());
        final ArrayAdapter<ProfileObj> adapter = new ArrayAdapter<ProfileObj>(this,
                android.R.layout.simple_list_item_1, values);
       // setListAdapter(adapter);
*/
    }


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add:
                Intent intent = new Intent(ProfileSelection.this, CreateProfile.class);
                startActivity(intent);
                break;
            case R.id.modif:
                Toast.makeText(getBaseContext(), "En cours de construction", Toast.LENGTH_LONG).show();
                break;
        }

    }

}

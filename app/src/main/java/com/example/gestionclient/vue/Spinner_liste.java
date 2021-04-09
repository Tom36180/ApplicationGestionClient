package com.example.gestionclient.vue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gestionclient.R;
import com.example.gestionclient.controleur.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Spinner_liste extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;

    Spinner spinner_statut;
    RecyclerView recycler_liste;
    ArrayList<String> liste_statut ;
    boolean bool_statut;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String idtosendrecieved= Acceuil.getIdtosend();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_liste);

        //données pour populer la liste
        ArrayList<String> nom_clients = new ArrayList<>();
        nom_clients.add("deprogeeeeeeeeeeeeeeeeee");
        nom_clients.add("michel");
        nom_clients.add("forever");
        nom_clients.add("tonight");
        nom_clients.add("oui");
        nom_clients.add("c'est");
        nom_clients.add("moi");
        nom_clients.add("michel");
        nom_clients.add("forever");



        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_liste);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //adapter = new MyRecyclerViewAdapter(this, nom_clients);
        //adapter.
        //recyclerView.setAdapter(adapter);




        // on initialise et on remplie la liste du spinner.
        liste_statut = new ArrayList<>();
        liste_statut.add("Non achevé");
        liste_statut.add("Achevé");

        spinner_statut = (Spinner) findViewById(R.id.spinner_statut);

        // rempli le spinner grace a un adapter simple fournis dans android studio.
        loadSpinnerData(liste_statut);

        spinner_statut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                // quand le spinner a le premier terme sois "Non achevé " de selectionné, mettre bool_statut a false.
                if(spinner_statut.getSelectedItemPosition() == 0){
                    bool_statut = false;
                }
                // quand le spinner a le 2eme terme sois "Achevé " de selectionné, mettre bool_statut a true.

                if (spinner_statut.getSelectedItemPosition() == 1 ){
                    bool_statut = true;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // le code ici s'executerat quand on a aucun item selectionné dans le spinner.
            }

        });


    }




    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }

    private void loadSpinnerData(ArrayList<String> liste_statut) {
        spinner_statut.setAdapter(new ArrayAdapter<String>(Spinner_liste.this, android.R.layout.simple_spinner_dropdown_item,liste_statut));
    }

}

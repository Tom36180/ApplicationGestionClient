package com.example.gestionclient.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.gestionclient.R;
import com.example.gestionclient.controleur.Client;
//import com.example.gestionclient.modèle.ClientAdapter;

import java.util.ArrayList;
//import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button finished;
    private ArrayList<Client> mesClients;
    private ListView mListeLV;
   // private ClientAdapter clientAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        finished = (Button) findViewById(R.id.finished);
        finished.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivity2();
            }
        });

      // mListeLV = (ListView)findViewById(R.id.maListe);
      // clientAdapter=new ClientAdapter(getApplicationContext(),0);
      // mesClients=new ArrayList<>();

      // mesClients.add(new Client("Gavaud",1));
      // mesClients.add(new Client("Kurth",5));

      // mListeLV.setAdapter(clientAdapter);
      // clientAdapter.addAll(mesClients);

    }

    public void openActivity2(){
        Intent intent= new Intent(this, Spinner_liste.class);
        startActivity(intent );
    }


}

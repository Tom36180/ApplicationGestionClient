package com.example.gestionclient.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestionclient.R;
import com.example.gestionclient.controleur.PutData;

import org.json.JSONArray;
import org.json.JSONObject;


public class Acceuil extends AppCompatActivity {

    private static String idtosend;
    EditText et_operateur ;

    public static String getIdtosend() {
        return idtosend;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        et_operateur = findViewById(R.id.et_operateur);


            // permet au click du button de se login et de passer a l'activity avec le spinner.
            login();

    }


    public void login(){
        Button btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testlogbdd(et_operateur.getText().toString());

            }
        });
    }

    //fonction récupération data
    public void testlogbdd(final String id){
        //Log.d("TAGnjkfdhgjdf", "receptionData: fjdsfkblncxbgbsdfbd");
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {//Démarrer l'écriture et la lecture des données avec l'URL
                String[] field = new String[2];//Création d'un tableau pour les paramètres
                field[0] = "num_Personnel";
                field[1] = "tableName";

                String[] data = new String[2];//Création d un tableau pour les données
                data[0] =id;
                data[1] = "personnel";
                PutData putData = new PutData("http://bdgestionclient.mr-raphael.fr/java/reception.php", "POST", field, data);

                if (putData.startPut()) {//envoie de l id et autre paramètre

                    if (putData.onComplete()) {//si toute les donnée sont acquise

                        String result = putData.getResult();//recupere le resultat cad le echo du php donc toute les données
                        Log.d("TAGTAGTAGTAGTAG", "run: "+result);
                        try {
                            JSONArray array = new JSONArray(result);//Met les donées dans un tableau
                            Log.d("TAG", "run: *********"+array);
                            for (int i = 0; i<array.length(); i++){//Va jusqu a la derniere donnée de la bdd
                                final JSONObject object = array.getJSONObject(i);
                                Log.d("TAGTAGTAGTAGTAGTAGTAG", "run: "+object);
                                if(object.length()>0){
                                    //connexion
                                    Toast.makeText(getApplicationContext(),"Il y a un utilisateur associé à l'id",Toast.LENGTH_SHORT).show();
                                    idtosend=id;
                                    Intent intent = new Intent(Acceuil.this, Spinner_liste.class);
                                    startActivity(intent);
                                }

                            }
                            if(array.length()==0){
                                Toast.makeText(getApplicationContext(),"pas d'utilisateur associé à l'id",Toast.LENGTH_SHORT).show();
                            }

                        }catch (Exception e){
                            //Toast.makeText(getApplicationContext(), "échec de la réception des données", Toast.LENGTH_SHORT).show();
                            Log.d("receptionData", "run: échec de la réception des données");
                        }
                    } else {
                        //Toast.makeText(getApplicationContext(), "échec", Toast.LENGTH_SHORT).show();
                        Log.d("receptionData", "run: échec");
                    }
                }
            }
        });
    }
}



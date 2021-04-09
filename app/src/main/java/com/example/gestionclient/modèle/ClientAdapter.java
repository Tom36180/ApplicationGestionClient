//package com.example.gestionclient.modèle;

//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;

//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;

//import com.example.gestionclient.R;
//import com.example.gestionclient.controleur.Client;

//public class ClientAdapter extends ArrayAdapter<Client> {

//    public ClientAdapter(@NonNull Context context, int resource) {
//        super(context, resource);
//    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View v;

//        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        v= layoutInflater.inflate(R.layout.client_cell,null);

//        Client currentClient= getItem(position);

//        TextView nomClient=(TextView)v.findViewById(R.id.nomClient);
//        TextView numClient=(TextView)v.findViewById(R.id.numClient);

//        nomClient.setText(currentClient.getNomClient());
//        numClient.setText(currentClient.getNumClient());

//        return v;
//    }
//}

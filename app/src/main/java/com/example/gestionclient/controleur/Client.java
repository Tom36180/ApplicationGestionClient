package com.example.gestionclient.controleur;

public class Client {
    private String nomClient;
    private int numClient;

    public Client(String nomClient, int numClient) {
        this.nomClient = nomClient;
        this.numClient = numClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public int getNumClient() {
        return numClient;
    }
}


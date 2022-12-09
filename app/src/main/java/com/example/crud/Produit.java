package com.example.crud;

public class Produit {
    int id ;

    public Produit(int id, String name, double prix) {
        this.id = id;
        this.name = name;
        this.prix = prix;
    }

    public Produit(String name, double prix) {
        this.name = name;
        this.prix = prix;
    }

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    String name ;
    double prix ;



}

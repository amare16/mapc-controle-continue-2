package org.example.metier.impl;

import org.example.metier.api.Query;

import java.util.List;
import java.util.Set;

public class Person {
    private String nom;
    private int age;
    private double salaire;

    public Person(String nom, int age, double salaire) {
        this.nom = nom;
        this.age = age;
        this.salaire = salaire;
    }



    public String getNom() { return nom; }
    public int getAge() { return age; }
    public double getSalaire() { return salaire; }

    @Override
    public String toString() {
        String formattedSalary = (salaire == (int) salaire) ? String.valueOf((int) salaire) : String.valueOf(salaire);
        return "(" + nom + ", " + age + ", " + formattedSalary + ")";
    }
}

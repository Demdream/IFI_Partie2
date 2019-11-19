
package Modele;

import java.util.ArrayList;

// On définit la classe Produit 
public class Produit {
    
    private int ref;
    private String nom;
    private double prix;
    private int quantite;
    private String image;
    
   // méthode 
    public Produit(int ref, String nom, double prix, int quantite, String image, String panier) {
        this.ref = ref; // variable de classe = variable en paramètre du constructeur
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.image = image;
    }

    
    
    
    @Override
    public String toString() {
        return "Produit{" + "ref=" + ref + ", nom=" + nom + ", prix=" + prix + ", quantite=" + quantite + ", image=" + image + '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    } 

public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    } 
}

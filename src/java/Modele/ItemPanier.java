
package Modele;

// Cette classe va nous permettre de représenter un produit dans le panier  
//avec sa référence ( indiqué dans le tableau )et la quantité que l'utilisateur veut 
//acheter ( si il appuie une seule fois sur ajouter pannier du coup la quantité va être 1
// si 2 fois la quantité va être 2 et ainsi de suite


public class ItemPanier {
    
    private int ref;
    private int quantite;

    public ItemPanier(int ref, int quantite) {
        this.ref = ref;
        this.quantite = quantite;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "ItemPanier{" + "ref=" + ref + ", quantite=" + quantite + '}';
    }
    
    
}

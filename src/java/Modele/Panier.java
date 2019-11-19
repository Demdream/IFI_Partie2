
package Modele;
import java.util.ArrayList;

public class Panier {
    
     ArrayList<ItemPanier> items ; 
     

    public Panier() {
        items = new ArrayList<>();  
        
    }
  
    public void ajouterAuPanier(int ref){
     
        // Une boucle pour parcourir le tableau initial si la référence du produit 
        // existe dans le panier , il va incrémenter la quantité
        // et modifier le itempanier avec la nouvelle quantité compté 
        // si la référence n'existe pas il va me créeer un nouveau itempanier
        // avec la bonne référence et quantité 1
        
        
        Boolean existe = false;
        for(int i = 0; i < this.getItems().size(); i++){ 
            ItemPanier item = this.getItems().get(i);
            if (item.getRef() == ref){
                existe = true;
                item.setQuantite(item.getQuantite() + 1);
                this.getItems().set(i, item);
            }
        }
           
        if (!existe) {
            this.getItems().add(new ItemPanier(ref, 1));
        }
        
    }

    @Override
    public String toString() {
        
        String result = ""; 
        
        if (this.getItems().size() > 0) {
            result += "Le Panier contient: ";
        }
        
        for(ItemPanier item : this.getItems()) {
            result += item.toString() + "\n;";
        }
        
        return result;
    }
    
    
       public ArrayList<ItemPanier> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemPanier> items) {
        this.items = items;
    } 
    
}

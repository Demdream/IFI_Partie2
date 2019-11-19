
package Modele;
import java.util.ArrayList;

public class Stock {
    
     ArrayList<Produit> listeProduit ;
     

    public Stock() {
    listeProduit = new ArrayList<>();  
    listeProduit.add( new Produit( 14 , "Samsung Galaxy S10+", 1000, 20, "Samsung.jpg" , "Ajouter au panier" )); 
    listeProduit.add( new Produit( 20 , "Apple iPhone X", 899, 20, "iphone.jpg", "Ajouter au panier" ));
    listeProduit.add( new Produit( 35 , "Huawei P30 Pro", 649, 20, "Huawei.jpg", "Ajouter au panier" )); 
        
    }
      
     public Produit trouverProduit(int ref){
        
        for(int i = 0; i < this.getListeProduit().size(); i++){ 
            Produit prod = this.getListeProduit().get(i);
            if (prod.getRef() == ref){             
                return prod;
            }
        }
        
      return null;  
    } 
     
    public void modifierStock (Panier panier){
          
        for (int i = 0; i < panier.getItems().size(); i++){
            ItemPanier item = panier.getItems().get(i);
            Produit produitCorrespondant = this.trouverProduit(item.getRef());
            int indexProduitCorrespondant = this.listeProduit.indexOf(produitCorrespondant);
            produitCorrespondant.setQuantite(produitCorrespondant.getQuantite() - item.getQuantite());
            this.listeProduit.set(indexProduitCorrespondant, produitCorrespondant);
           // il parcourt le panier récupère le item panier qui contient la référance
            //et la quantité, il cherche ensuite dans le tableau le prodduit 
            //qui a la même référence grâce à la méthode trouver panier
           // il récupére la quantité de l'item , il prend la quantité déja présente 
           //dans le produit correspondant il déduit d'elle la quantité du panier 
        }
        
    }
    
    

    
       public ArrayList<Produit> getListeProduit() {
        return listeProduit;
    }

       public void setListeProduit(ArrayList<Produit> listeProduit) {
        this.listeProduit = listeProduit;
    }
      
}

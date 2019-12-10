/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Entity.Mobilephones;
import java.util.*;
/**
 *
 * @author PSDT0769
 */
public class Panier {
    
    List<ItemPanier> items;
    int numberOfItems;
    double total;

    public Panier() {
        items = new ArrayList<ItemPanier>();
        numberOfItems = 0;
        total = 0;
    }

    /**
     * Ajouter <code>ItemPanier</code> à <code>Panier</code>
     * <code>items</code> list. Si item <code>mobilephones</code>
     * existe déjà dans le Panier, la quantité de cet item est incrémenté
     *
     * @param mobilephones <code>Mobilephones</code> définit le type de l'item du Panier
     * @see ItemPanier
     */
    public synchronized void addItem(Mobilephones mobilephones) {

        boolean newItem = true;

        for (ItemPanier mItem : items) {

            if (mItem.getMobilephones().getId() == mobilephones.getId()) {

                newItem = false;
                mItem.incrementQuantity();
            }
        }

        if (newItem) {
            ItemPanier mItem = new ItemPanier (mobilephones);
            items.add(mItem);
        }
    }

   /**
     * Ajout <code>ItemPanier</code> à
     * <code>mobilephones</code> à la quantité spécifiée. Si '<code>0</code>'
     * quantité, l' <code>ItemPanier</code> est supprimé
     * du <code>Panier</code>'s <code>items</code> list.
     *
     * @param mobilephones  <code>Mobilephones</code> qui définit le type de phone item
     * @param quantity le nombre de <code>ItemPanier</code> est ajouté à
     * @see ItemPanier
     */
    public synchronized void ajout(Mobilephones mobilephones, String quantity) {

        short qty = -1;

        // cast quantity as short
        qty = Short.parseShort(quantity);

        if (qty >= 0) {

            ItemPanier item = null;

            for (ItemPanier mItem : items) {

                if (mItem.getMobilephones().getId() == mobilephones.getId()) {

                    if (qty != 0) {
                        // set item quantity to new value
                        mItem.setQuantity(qty);
                    } else {
                        // if quantity equals 0, save item and break
                        item = mItem;
                        break;
                    }
                }
            }

            if (item != null) {
                // remove from phone
                items.remove(item);
            }
        }
    }


    /**
     * Returns the list of <code>ItemPanier</code>.
     *
     * @return the <code>items</code> list
     * @see ItemPanier
     */
    public synchronized List<ItemPanier> getItems() {

        return items;
    }

    /**
     * Returns the sum of quantities for all items maintained in Panier
     * <code>items</code> list.
     *
     * @return the number of items in Panier
     * @see ItemPanier
     */
    public synchronized int getNumberOfItems() {

        numberOfItems = 0;

        for (ItemPanier mItem : items) {

            numberOfItems += mItem.getQuantity();
        }

        return numberOfItems;
    }

    /**
     * Returns the sum of the mobilephones price multiplied by the quantity for all
     * items in Panier list. This is the total cost excluding the frais.
     *
     * @return the cost of all items times their quantities
     * @see ItemPanier
     */
    public synchronized double getSubtotal() {

        double amount = 0;

        for (ItemPanier mItem : items) {

            Mobilephones mobilephones = (Mobilephones) mItem.getMobilephones();
            amount += (mItem.getQuantity() * mobilephones.getPrix().doubleValue());
        }

        return amount;
    }

    /**
     * Calculates the total cost of the order. This method adds the subtotal to
     * the designated frais and sets the <code>total</code> instance variable
     * with the result.
     *
     * @param frais the designated frais for all orders
     * @see ItemPanier
     */
    public synchronized void calculateTotal(String frais) {

        double amount = 0;
   
        // cast surcharge as double
        double s = Double.parseDouble(frais);

        amount = this.getSubtotal();
        amount += s;

        total = amount;
    }

    /**
     * Returns the total cost of the order for the given
     * <code>Panier</code> instance.
     *
     * @return the cost of all items times their quantities plus frais
     */
    public synchronized double getTotal() {

        return total;
    }

    /**
     * Empties the Panier. All items are removed from the Panier
     * <code>items</code> list, <code>numberOfItems</code> and
     * <code>total</code> are reset to '<code>0</code>'.
     *
     * @see ItemPanier
     */
    public synchronized void clear() {
        items.clear();
        numberOfItems = 0;
        total = 0;
    }
    
}

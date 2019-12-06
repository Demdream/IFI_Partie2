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
     * Adds a <code>ItemPanier</code> to the <code>Panier</code>'s
     * <code>items</code> list. If item of the specified <code>mobilephones</code>
     * already exists in Panier list, the quantity of that item is
     * incremented.
     *
     * @param mobilephones the <code>Mobilephones</code> that defines the type of Panier item
     * @see ItemPanier
     */
    public synchronized void addItem(Mobilephones mobilephones) {

        boolean newItem = true;

        for (ItemPanier scItem : items) {

            if (scItem.getMobilephones().getId() == mobilephones.getId()) {

                newItem = false;
                scItem.incrementQuantity();
            }
        }

        if (newItem) {
            ItemPanier scItem = new ItemPanier (mobilephones);
            items.add(scItem);
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

        for (ItemPanier scItem : items) {

            numberOfItems += scItem.getQuantity();
        }

        return numberOfItems;
    }

    /**
     * Returns the sum of the mobilephones price multiplied by the quantity for all
     * items in Panier list. This is the total cost excluding the surcharge.
     *
     * @return the cost of all items times their quantities
     * @see ItemPanier
     */
    public synchronized double getSubtotal() {

        double amount = 0;

        for (ItemPanier scItem : items) {

            Mobilephones mobilephones = (Mobilephones) scItem.getMobilephones();
            amount += (scItem.getQuantity() * mobilephones.getPrix().doubleValue());
        }

        return amount;
    }

    /**
     * Calculates the total cost of the order. This method adds the subtotal to
     * the designated surcharge and sets the <code>total</code> instance variable
     * with the result.
     *
     * @param surcharge the designated surcharge for all orders
     * @see ItemPanier
     */
    public synchronized void calculateTotal(String surcharge) {

        double amount = 0;
   
        // cast surcharge as double
        double s = Double.parseDouble(surcharge);

        amount = this.getSubtotal();
        amount += s;

        total = amount;
    }

    /**
     * Returns the total cost of the order for the given
     * <code>Panier</code> instance.
     *
     * @return the cost of all items times their quantities plus surcharge
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

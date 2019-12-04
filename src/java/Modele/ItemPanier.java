/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Entity.Mobilephones;

/**
 *
 * @author PSDT0769
 */
public class ItemPanier {
    Mobilephones mobilephones;
    short quantity;

    public ItemPanier(Mobilephones mobilephones) {
        this.mobilephones = mobilephones;
        quantity = 1;
    }

    public Mobilephones getMobilephones() {
        return mobilephones;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * mobilephones.getPrix().doubleValue());
        return amount;
    }

}

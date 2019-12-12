/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PSDT0769
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {

    @PersistenceContext(unitName = "IFIPU")
    private EntityManager em;

    
    Product P1 = new Product();
    Product P2 = new Product();
    Product P3 = new Product();
    
    
    public void init(){
        P1.setId(1);
        P1.setName("test");
        P1.setPrix(100);
        P1.setQuantity(10);
        em.persist(P1);
        
        P2.setId(2);
        P2.setName("test2");
        P2.setPrix(200);
        P2.setQuantity(20);
        em.persist(P2);
        
        P3.setId(3);
        P3.setName("test3");
        P3.setPrix(300);
        P3.setQuantity(30);
        em.persist(P3);
}
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Mobilephones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PSDT0769
 */
@Stateless
public class MobilephonesFacade extends AbstractFacade<Mobilephones> {

    @PersistenceContext(unitName = "IFIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MobilephonesFacade() {
        super(Mobilephones.class);
    }
    
}

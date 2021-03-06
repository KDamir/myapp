/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.myapp.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kz.app.myapp.entity.SprOtdel;

/**
 *
 * @author Дамир
 */
@Stateless
public class SprOtdelFacade extends AbstractFacade<SprOtdel> {
    @PersistenceContext(unitName = "kz.app_myapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SprOtdelFacade() {
        super(SprOtdel.class);
    }
    
}
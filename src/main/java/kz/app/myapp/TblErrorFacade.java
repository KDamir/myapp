/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.myapp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kz.app.myapp.entity.TblError;

/**
 *
 * @author damir.keldibekov
 */
@Stateless
public class TblErrorFacade extends AbstractFacade<TblError> {
    @PersistenceContext(unitName = "kz.app_myapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblErrorFacade() {
        super(TblError.class);
    }
    
}

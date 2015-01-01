/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.myapp.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kz.app.myapp.entity.Employer;

/**
 *
 * @author damir.keldibekov
 */
@Stateless
public class EmployerFacade extends AbstractFacade<Employer> {
    @PersistenceContext(unitName = "kz.app_myapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployerFacade() {
        super(Employer.class);
    }
    
}

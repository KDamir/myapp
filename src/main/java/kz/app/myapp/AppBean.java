/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.myapp;

import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kz.app.myapp.entity.TblError;
import org.eclipse.persistence.internal.jpa.rs.metadata.model.Query;

/**
 *
 * @author damir.keldibekov
 */
@Named
@Dependent
public class AppBean {
    @PersistenceContext(unitName = "kz.app_myapp_war_1.0PU")
    private EntityManager manager;
    
    
    public String getMessage() {
        return "Hello from bean!";
    }
    
    public List<TblError> getErrors() {
        List<TblError> list = manager.createNamedQuery("TblError.findAll").getResultList();
        return list;
    }
}

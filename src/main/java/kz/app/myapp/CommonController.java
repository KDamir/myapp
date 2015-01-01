/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.myapp;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import kz.app.myapp.entity.LevelError;
import kz.app.myapp.entity.Project;
import kz.app.myapp.entity.SprOtdel;
import kz.app.myapp.entity.StatusError;

/**
 *
 * @author Дамир
 */
@Named("commonController")
@SessionScoped
public class CommonController implements Serializable{

    @EJB
    private StatusErrorFacade statusErrorFacade;
    
    @EJB
    private ProjectFacade projectFacade;
    
    @EJB
    private LevelErrorFacade levelErrorFacade;
    
    @EJB
    private SprOtdelFacade sprOtdelFacade;
    
    public List<StatusError> getItemsStatusError() {
        return getStatusErrorFacade().findAll();
    }
    
    public List<SprOtdel> getItemsSprOtdel() {
        return getSprOtdelFacade().findAll();
    }
    
    public List<Project> getItemsProject() {
        return getProjectFacade().findAll();
    }
    
    public List<LevelError> getItemsLevelError() {
        return getLevelErrorFacade().findAll();
    }

    //<editor-fold defaultstate="collapsed" desc="getters">
    public StatusErrorFacade getStatusErrorFacade() {
        return statusErrorFacade;
    }
    
    public ProjectFacade getProjectFacade() {
        return projectFacade;
    }
    
    public LevelErrorFacade getLevelErrorFacade() {
        return levelErrorFacade;
    }
    
    public SprOtdelFacade getSprOtdelFacade() {
        return sprOtdelFacade;
    }
//</editor-fold>
    
}

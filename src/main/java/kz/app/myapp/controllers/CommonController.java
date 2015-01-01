/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.myapp.controllers;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import kz.app.myapp.facade.LevelErrorFacade;
import kz.app.myapp.facade.ProjectFacade;
import kz.app.myapp.facade.SprOtdelFacade;
import kz.app.myapp.facade.StatusErrorFacade;
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

    @Inject
    private StatusErrorFacade statusErrorFacade;
    
    @Inject
    private ProjectFacade projectFacade;
    
    @Inject
    private LevelErrorFacade levelErrorFacade;
    
    @Inject
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
    
    public LevelError getLevelError(java.lang.Integer id) {
        return getLevelErrorFacade().find(id);
    }
    
    public Project getProject(java.lang.Integer id) {
        return getProjectFacade().find(id);
    }
    
    public StatusError getStatusError(java.lang.Integer id) {
        return getStatusErrorFacade().find(id);
    }
    
    public SprOtdel getSprOtdel(java.lang.Integer id) {
        return getSprOtdelFacade().find(id);
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

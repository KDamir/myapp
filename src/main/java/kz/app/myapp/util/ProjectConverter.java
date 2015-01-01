/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.myapp.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import kz.app.myapp.CommonController;
import kz.app.myapp.entity.Project;

/**
 *
 * @author Дамир
 */
@FacesConverter(forClass = Project.class,value = "projectConv")
public class ProjectConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
                return null;
            }
            CommonController controller = (CommonController) context.getApplication().getELResolver().
                    getValue(context.getELContext(), null, "commonController");
            return controller.getProject(getKey(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Project) {
            Project o = (Project) value;
            return getStringKey(o.getIdproject());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{value, value.getClass().getName(), Project.class.getName()});
            return null;
        }
    }
    
    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }
    
}

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
import kz.app.myapp.controllers.CommonController;
import kz.app.myapp.entity.LevelError;

/**
 *
 * @author Дамир
 */
@FacesConverter(forClass = LevelError.class)
public class LevelErrorConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        CommonController controller = (CommonController) context.getApplication().getELResolver().
                getValue(context.getELContext(), null, "commonController");
        return controller.getLevelError(getKey(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof LevelError) {
            LevelError o = (LevelError) value;
            return getStringKey(o.getIdlevelError());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{value, value.getClass().getName(), LevelError.class.getName()});
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

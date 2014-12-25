/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.myapp;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 *
 * @author damir.keldibekov
 */
@Named
@Dependent
public class AppBean {
    public String getMessage() {
        return "Hello from bean!";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.myapp.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author damir.keldibekov
 */
@Entity
@Table(name = "sprOtdel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SprOtdel.findAll", query = "SELECT s FROM SprOtdel s"),
    @NamedQuery(name = "SprOtdel.findByKod", query = "SELECT s FROM SprOtdel s WHERE s.kod = :kod"),
    @NamedQuery(name = "SprOtdel.findByName", query = "SELECT s FROM SprOtdel s WHERE s.name = :name"),
    @NamedQuery(name = "SprOtdel.findById", query = "SELECT s FROM SprOtdel s WHERE s.id = :id")})
public class SprOtdel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "kod")
    private String kod;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "cOtdel")
    private Collection<Employer> employerCollection;

    public SprOtdel() {
    }

    public SprOtdel(Integer id) {
        this.id = id;
    }

    public SprOtdel(Integer id, String kod) {
        this.id = id;
        this.kod = kod;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Employer> getEmployerCollection() {
        return employerCollection;
    }

    public void setEmployerCollection(Collection<Employer> employerCollection) {
        this.employerCollection = employerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SprOtdel)) {
            return false;
        }
        SprOtdel other = (SprOtdel) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "kz.app.myapp.entity.SprOtdel[ id=" + id + " ]";
    }
    
}

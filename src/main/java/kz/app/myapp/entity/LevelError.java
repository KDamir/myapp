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
@Table(name = "levelError")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LevelError.findAll", query = "SELECT l FROM LevelError l"),
    @NamedQuery(name = "LevelError.findByIdlevelError", query = "SELECT l FROM LevelError l WHERE l.idlevelError = :idlevelError"),
    @NamedQuery(name = "LevelError.findByName", query = "SELECT l FROM LevelError l WHERE l.name = :name")})
public class LevelError implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlevelError")
    private Integer idlevelError;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "cLevel")
    private Collection<TblError> tblErrorCollection;

    public LevelError() {
    }

    public LevelError(Integer idlevelError) {
        this.idlevelError = idlevelError;
    }

    public Integer getIdlevelError() {
        return idlevelError;
    }

    public void setIdlevelError(Integer idlevelError) {
        this.idlevelError = idlevelError;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<TblError> getTblErrorCollection() {
        return tblErrorCollection;
    }

    public void setTblErrorCollection(Collection<TblError> tblErrorCollection) {
        this.tblErrorCollection = tblErrorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlevelError != null ? idlevelError.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LevelError)) {
            return false;
        }
        LevelError other = (LevelError) object;
        return !((this.idlevelError == null && other.idlevelError != null) || (this.idlevelError != null && !this.idlevelError.equals(other.idlevelError)));
    }

    @Override
    public String toString() {
        return "kz.app.myapp.entity.LevelError[ idlevelError=" + idlevelError + " ]";
    }
    
}

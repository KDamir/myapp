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
@Table(name = "statusError")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusError.findAll", query = "SELECT s FROM StatusError s"),
    @NamedQuery(name = "StatusError.findByIdstatusError", query = "SELECT s FROM StatusError s WHERE s.idstatusError = :idstatusError"),
    @NamedQuery(name = "StatusError.findByName", query = "SELECT s FROM StatusError s WHERE s.name = :name")})
public class StatusError implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstatusError")
    private Integer idstatusError;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "cStatus")
    private Collection<TblError> tblErrorCollection;

    public StatusError() {
    }

    public StatusError(Integer idstatusError) {
        this.idstatusError = idstatusError;
    }

    public Integer getIdstatusError() {
        return idstatusError;
    }

    public void setIdstatusError(Integer idstatusError) {
        this.idstatusError = idstatusError;
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
        hash += (idstatusError != null ? idstatusError.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusError)) {
            return false;
        }
        StatusError other = (StatusError) object;
        return !((this.idstatusError == null && other.idstatusError != null) || (this.idstatusError != null && !this.idstatusError.equals(other.idstatusError)));
    }

    @Override
    public String toString() {
        return "kz.app.myapp.entity.StatusError[ idstatusError=" + idstatusError + " ]";
    }
    
}

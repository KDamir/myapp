/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.app.myapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author damir.keldibekov
 */
@Entity
@Table(name = "tblError")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblError.findAll", query = "SELECT t FROM TblError t"),
    @NamedQuery(name = "TblError.findById", query = "SELECT t FROM TblError t WHERE t.id = :id"),
    @NamedQuery(name = "TblError.findByDateReg", query = "SELECT t FROM TblError t WHERE t.dateReg = :dateReg"),
    @NamedQuery(name = "TblError.findByDescription", query = "SELECT t FROM TblError t WHERE t.description = :description")})
public class TblError implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateReg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReg;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "cEmployer", referencedColumnName = "id")
    @ManyToOne
    private Employer cEmployer;
    @JoinColumn(name = "cLevel", referencedColumnName = "idlevelError")
    @ManyToOne
    private LevelError cLevel;
    @JoinColumn(name = "cProject", referencedColumnName = "idproject")
    @ManyToOne
    private Project cProject;
    @JoinColumn(name = "cStatus", referencedColumnName = "idstatusError")
    @ManyToOne
    private StatusError cStatus;

    public TblError() {
    }

    public TblError(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employer getCEmployer() {
        return cEmployer;
    }

    public void setCEmployer(Employer cEmployer) {
        this.cEmployer = cEmployer;
    }

    public LevelError getCLevel() {
        return cLevel;
    }

    public void setCLevel(LevelError cLevel) {
        this.cLevel = cLevel;
    }

    public Project getCProject() {
        return cProject;
    }

    public void setCProject(Project cProject) {
        this.cProject = cProject;
    }

    public StatusError getCStatus() {
        return cStatus;
    }

    public void setCStatus(StatusError cStatus) {
        this.cStatus = cStatus;
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
        if (!(object instanceof TblError)) {
            return false;
        }
        TblError other = (TblError) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "kz.app.myapp.entity.TblError[ id=" + id + " ]";
    }
    
}

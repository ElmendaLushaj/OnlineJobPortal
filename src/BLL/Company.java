/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "Company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByCompanyID", query = "SELECT c FROM Company c WHERE c.companyID = :companyID"),
    @NamedQuery(name = "Company.findByCName", query = "SELECT c FROM Company c WHERE c.cName = :cName"),
    @NamedQuery(name = "Company.findByCAddresse", query = "SELECT c FROM Company c WHERE c.cAddresse = :cAddresse"),
    @NamedQuery(name = "Company.findByCEmail", query = "SELECT c FROM Company c WHERE c.cEmail = :cEmail"),
    @NamedQuery(name = "Company.findByCContact", query = "SELECT c FROM Company c WHERE c.cContact = :cContact")})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Company_ID")
    private Integer companyID;
    @Basic(optional = false)
    @Column(name = "C_Name")
    private String cName;
    @Basic(optional = false)
    @Column(name = "C_Addresse")
    private String cAddresse;
    @Basic(optional = false)
    @Column(name = "C_Email")
    private String cEmail;
    @Basic(optional = false)
    @Column(name = "C_Contact")
    private int cContact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyID")
    private Collection<Job> jobCollection;

    public Company() {
    }

    public Company(Integer companyID) {
        this.companyID = companyID;
    }

    public Company(Integer companyID, String cName, String cAddresse, String cEmail, int cContact) {
        this.companyID = companyID;
        this.cName = cName;
        this.cAddresse = cAddresse;
        this.cEmail = cEmail;
        this.cContact = cContact;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCAddresse() {
        return cAddresse;
    }

    public void setCAddresse(String cAddresse) {
        this.cAddresse = cAddresse;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public int getCContact() {
        return cContact;
    }

    public void setCContact(int cContact) {
        this.cContact = cContact;
    }

    @XmlTransient
    public Collection<Job> getJobCollection() {
        return jobCollection;
    }

    public void setJobCollection(Collection<Job> jobCollection) {
        this.jobCollection = jobCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyID != null ? companyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyID == null && other.companyID != null) || (this.companyID != null && !this.companyID.equals(other.companyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Company[ companyID=" + companyID + " ]";
    }
    
}

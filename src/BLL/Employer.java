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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "Employer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employer.findAll", query = "SELECT e FROM Employer e"),
    @NamedQuery(name = "Employer.findByEmployerID", query = "SELECT e FROM Employer e WHERE e.employerID = :employerID"),
    @NamedQuery(name = "Employer.findByEName", query = "SELECT e FROM Employer e WHERE e.eName = :eName"),
    @NamedQuery(name = "Employer.findByEContact", query = "SELECT e FROM Employer e WHERE e.eContact = :eContact"),
    @NamedQuery(name = "Employer.findByEEmail", query = "SELECT e FROM Employer e WHERE e.eEmail = :eEmail")})
public class Employer implements Serializable {
    @Column(name = "Img")
    private String img;
    
    
  
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Employer_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer employerID;
    @Basic(optional = false)
    @Column(name = "E_Name")
    private String eName;
    @Basic(optional = false)
    @Column(name = "E_Contact")
    private int eContact;
    @Basic(optional = false)
    @Column(name = "E_Email")
    private String eEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employerID")
    private Collection<JobCategory> jobCategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employerID")
    private Collection<Location> locationCollection;

    public Employer() {
    }

    public Employer(Integer employerID) {
        this.employerID = employerID;
    }

    public Employer(Integer employerID, String eName, int eContact, String eEmail) {
        this.employerID = employerID;
        this.eName = eName;
        this.eContact = eContact;
        this.eEmail = eEmail;
    }

    public Integer getEmployerID() {
        return employerID;
    }

    public void setEmployerID(Integer employerID) {
        this.employerID = employerID;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public int getEContact() {
        return eContact;
    }

    public void setEContact(int eContact) {
        this.eContact = eContact;
    }

    public String getEEmail() {
        return eEmail;
    }

    public void setEEmail(String eEmail) {
        this.eEmail = eEmail;
    }

    @XmlTransient
    public Collection<JobCategory> getJobCategoryCollection() {
        return jobCategoryCollection;
    }

    public void setJobCategoryCollection(Collection<JobCategory> jobCategoryCollection) {
        this.jobCategoryCollection = jobCategoryCollection;
    }

    @XmlTransient
    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employerID != null ? employerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employer)) {
            return false;
        }
        Employer other = (Employer) object;
        if ((this.employerID == null && other.employerID != null) || (this.employerID != null && !this.employerID.equals(other.employerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  employerID+(": ")+eName ;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}

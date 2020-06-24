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
@Table(name = "Applicant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Applicant.findAll", query = "SELECT a FROM Applicant a"),
    @NamedQuery(name = "Applicant.findByApplicantID", query = "SELECT a FROM Applicant a WHERE a.applicantID = :applicantID"),
    @NamedQuery(name = "Applicant.findByAName", query = "SELECT a FROM Applicant a WHERE a.aName = :aName"),
    @NamedQuery(name = "Applicant.findByGender", query = "SELECT a FROM Applicant a WHERE a.gender = :gender"),
    @NamedQuery(name = "Applicant.findByAEmail", query = "SELECT a FROM Applicant a WHERE a.aEmail = :aEmail"),
    @NamedQuery(name = "Applicant.findByAContact", query = "SELECT a FROM Applicant a WHERE a.aContact = :aContact"),
    @NamedQuery(name = "Applicant.findByProfessionalSummary", query = "SELECT a FROM Applicant a WHERE a.professionalSummary = :professionalSummary")})
public class Applicant implements Serializable {
    @Column(name = "Img")
    private String img;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Applicant_ID")
        @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer applicantID;
    @Basic(optional = false)
    @Column(name = "A_Name")
    private String aName;
    @Basic(optional = false)
    @Column(name = "Gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "A_Email")
    private String aEmail;
    @Basic(optional = false)
    @Column(name = "A_Contact")
    private int aContact;
    @Basic(optional = false)
    @Column(name = "Professional_Summary")
    private String professionalSummary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicantID")
    private Collection<ApplicationDetails> applicationDetailsCollection;

    public Applicant() {
    }

    public Applicant(Integer applicantID) {
        this.applicantID = applicantID;
    }

    public Applicant(Integer applicantID, String aName, String gender, String aEmail, int aContact, String professionalSummary) {
        this.applicantID = applicantID;
        this.aName = aName;
        this.gender = gender;
        this.aEmail = aEmail;
        this.aContact = aContact;
        this.professionalSummary = professionalSummary;
    }

    public Integer getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Integer applicantID) {
        this.applicantID = applicantID;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAEmail() {
        return aEmail;
    }

    public void setAEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    public int getAContact() {
        return aContact;
    }

    public void setAContact(int aContact) {
        this.aContact = aContact;
    }

    public String getProfessionalSummary() {
        return professionalSummary;
    }

    public void setProfessionalSummary(String professionalSummary) {
        this.professionalSummary = professionalSummary;
    }

    @XmlTransient
    public Collection<ApplicationDetails> getApplicationDetailsCollection() {
        return applicationDetailsCollection;
    }

    public void setApplicationDetailsCollection(Collection<ApplicationDetails> applicationDetailsCollection) {
        this.applicationDetailsCollection = applicationDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicantID != null ? applicantID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Applicant)) {
            return false;
        }
        Applicant other = (Applicant) object;
        if ((this.applicantID == null && other.applicantID != null) || (this.applicantID != null && !this.applicantID.equals(other.applicantID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return applicantID +(": ")+aName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}

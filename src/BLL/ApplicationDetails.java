/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ApplicationDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicationDetails.findAll", query = "SELECT a FROM ApplicationDetails a"),
    @NamedQuery(name = "ApplicationDetails.findByApplicationID", query = "SELECT a FROM ApplicationDetails a WHERE a.applicationID = :applicationID")})
public class ApplicationDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Application_ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer applicationID;
    @JoinColumn(name = "Applicant_ID", referencedColumnName = "Applicant_ID")
    @ManyToOne(optional = false)
    private Applicant applicantID;
    @JoinColumn(name = "Job_ID", referencedColumnName = "Job_ID")
    @ManyToOne(optional = false)
    private Job jobID;

    public ApplicationDetails() {
    }

    public ApplicationDetails(Integer applicationID) {
        this.applicationID = applicationID;
    }

    public Integer getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(Integer applicationID) {
        this.applicationID = applicationID;
    }

    public Applicant getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Applicant applicantID) {
        this.applicantID = applicantID;
    }

    public Job getJobID() {
        return jobID;
    }

    public void setJobID(Job jobID) {
        this.jobID = jobID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicationID != null ? applicationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApplicationDetails)) {
            return false;
        }
        ApplicationDetails other = (ApplicationDetails) object;
        if ((this.applicationID == null && other.applicationID != null) || (this.applicationID != null && !this.applicationID.equals(other.applicationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.ApplicationDetails[ applicationID=" + applicationID + " ]";
    }
    
}

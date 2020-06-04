/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "Job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.findByJobID", query = "SELECT j FROM Job j WHERE j.jobID = :jobID"),
    @NamedQuery(name = "Job.findByJobTitle", query = "SELECT j FROM Job j WHERE j.jobTitle = :jobTitle"),
    @NamedQuery(name = "Job.findByJobDescription", query = "SELECT j FROM Job j WHERE j.jobDescription = :jobDescription"),
    @NamedQuery(name = "Job.findByJobType", query = "SELECT j FROM Job j WHERE j.jobType = :jobType"),
    @NamedQuery(name = "Job.findByJobSalary", query = "SELECT j FROM Job j WHERE j.jobSalary = :jobSalary"),
    @NamedQuery(name = "Job.findByPostingDate", query = "SELECT j FROM Job j WHERE j.postingDate = :postingDate")})
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Job_ID")
    private Integer jobID;
    @Basic(optional = false)
    @Column(name = "Job_Title")
    private String jobTitle;
    @Basic(optional = false)
    @Column(name = "Job_Description")
    private String jobDescription;
    @Basic(optional = false)
    @Column(name = "Job_Type")
    private String jobType;
    @Basic(optional = false)
    @Column(name = "Job_Salary")
    private double jobSalary;
    @Basic(optional = false)
    @Column(name = "Posting_Date")
    @Temporal(TemporalType.DATE)
    private Date postingDate;
    @JoinColumn(name = "Company_ID", referencedColumnName = "Company_ID")
    @ManyToOne(optional = false)
    private Company companyID;
    @JoinColumn(name = "Category_ID", referencedColumnName = "Category_ID")
    @ManyToOne(optional = false)
    private JobCategory categoryID;
    @JoinColumn(name = "Location_ID", referencedColumnName = "Location_ID")
    @ManyToOne(optional = false)
    private Location locationID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobID")
    private Collection<ApplicationDetails> applicationDetailsCollection;

    public Job() {
    }

    public Job(Integer jobID) {
        this.jobID = jobID;
    }

    public Job(Integer jobID, String jobTitle, String jobDescription, String jobType, double jobSalary, Date postingDate) {
        this.jobID = jobID;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobType = jobType;
        this.jobSalary = jobSalary;
        this.postingDate = postingDate;
    }

    public Integer getJobID() {
        return jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public double getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(double jobSalary) {
        this.jobSalary = jobSalary;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }

    public Company getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    public JobCategory getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(JobCategory categoryID) {
        this.categoryID = categoryID;
    }

    public Location getLocationID() {
        return locationID;
    }

    public void setLocationID(Location locationID) {
        this.locationID = locationID;
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
        hash += (jobID != null ? jobID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.jobID == null && other.jobID != null) || (this.jobID != null && !this.jobID.equals(other.jobID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  jobID+(": ")+jobTitle;
    }
    
}

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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "JobCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobCategory.findAll", query = "SELECT j FROM JobCategory j"),
    @NamedQuery(name = "JobCategory.findByCategoryID", query = "SELECT j FROM JobCategory j WHERE j.categoryID = :categoryID"),
    @NamedQuery(name = "JobCategory.findByCategoryName", query = "SELECT j FROM JobCategory j WHERE j.categoryName = :categoryName")})
public class JobCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Category_ID")
    private Integer categoryID;
    @Basic(optional = false)
    @Column(name = "Category_Name")
    private String categoryName;
    @JoinColumn(name = "Employer_ID", referencedColumnName = "Employer_ID")
    @ManyToOne(optional = false)
    private Employer employerID;

    public JobCategory() {
    }

    public JobCategory(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public JobCategory(Integer categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Employer getEmployerID() {
        return employerID;
    }

    public void setEmployerID(Employer employerID) {
        this.employerID = employerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryID != null ? categoryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobCategory)) {
            return false;
        }
        JobCategory other = (JobCategory) object;
        if ((this.categoryID == null && other.categoryID != null) || (this.categoryID != null && !this.categoryID.equals(other.categoryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return categoryID + ":"+getCategoryName();
    }
    
}

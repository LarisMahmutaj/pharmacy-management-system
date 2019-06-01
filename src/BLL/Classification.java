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
 * @author Laris
 */
@Entity
@Table(name = "Classification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classification.findAll", query = "SELECT c FROM Classification c")
    , @NamedQuery(name = "Classification.findByClassificationID", query = "SELECT c FROM Classification c WHERE c.classificationID = :classificationID")
    , @NamedQuery(name = "Classification.findByClassificationName", query = "SELECT c FROM Classification c WHERE c.classificationName = :classificationName")})
public class Classification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ClassificationID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer classificationID;
    @Basic(optional = false)
    @Column(name = "ClassificationName")
    private String classificationName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classificationID")
    private Collection<Medicine> medicineCollection;

    public Classification() {
    }

    public Classification(Integer classificationID) {
        this.classificationID = classificationID;
    }

    public Classification(Integer classificationID, String classificationName) {
        this.classificationID = classificationID;
        this.classificationName = classificationName;
    }

    public Integer getClassificationID() {
        return classificationID;
    }

    public void setClassificationID(Integer classificationID) {
        this.classificationID = classificationID;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    @XmlTransient
    public Collection<Medicine> getMedicineCollection() {
        return medicineCollection;
    }

    public void setMedicineCollection(Collection<Medicine> medicineCollection) {
        this.medicineCollection = medicineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classificationID != null ? classificationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classification)) {
            return false;
        }
        Classification other = (Classification) object;
        if ((this.classificationID == null && other.classificationID != null) || (this.classificationID != null && !this.classificationID.equals(other.classificationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return classificationName;
    }
    
}

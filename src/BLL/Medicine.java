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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Medicine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicine.findAll", query = "SELECT m FROM Medicine m")
    , @NamedQuery(name = "Medicine.findByMedicineID", query = "SELECT m FROM Medicine m WHERE m.medicineID = :medicineID")
    , @NamedQuery(name = "Medicine.findByBrandName", query = "SELECT m FROM Medicine m WHERE m.brandName = :brandName")
    , @NamedQuery(name = "Medicine.findByGenericName", query = "SELECT m FROM Medicine m WHERE m.genericName = :genericName")
    , @NamedQuery(name = "Medicine.findByPrice", query = "SELECT m FROM Medicine m WHERE m.price = :price")})
public class Medicine implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineID")
    private Collection<Orders> ordersCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineID")
    private Collection<Item> itemCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineID")
    private Collection<Stock> stockCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MedicineID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer medicineID;
    @Basic(optional = false)
    @Column(name = "BrandName")
    private String brandName;
    @Basic(optional = false)
    @Column(name = "GenericName")
    private String genericName;
    @Basic(optional = false)
    @Column(name = "Price")
    private double price;
    @JoinColumn(name = "ClassificationID", referencedColumnName = "ClassificationID")
    @ManyToOne(optional = false)
    private Classification classificationID;

    public Medicine() {
    }

    public Medicine(Integer medicineID) {
        this.medicineID = medicineID;
    }

    public Medicine(Integer medicineID, String brandName, String genericName, double price) {
        this.medicineID = medicineID;
        this.brandName = brandName;
        this.genericName = genericName;
        this.price = price;
    }

    public Integer getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(Integer medicineID) {
        this.medicineID = medicineID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Classification getClassificationID() {
        return classificationID;
    }

    public void setClassificationID(Classification classificationID) {
        this.classificationID = classificationID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicineID != null ? medicineID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicine)) {
            return false;
        }
        Medicine other = (Medicine) object;
        if ((this.medicineID == null && other.medicineID != null) || (this.medicineID != null && !this.medicineID.equals(other.medicineID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return brandName + " - " + genericName;
    }

    @XmlTransient
    public Collection<Stock> getStockCollection() {
        return stockCollection;
    }

    public void setStockCollection(Collection<Stock> stockCollection) {
        this.stockCollection = stockCollection;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    
}

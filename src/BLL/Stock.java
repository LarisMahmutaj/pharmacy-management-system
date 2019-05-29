/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laris
 */
@Entity
@Table(name = "Stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findBySupplyDate", query = "SELECT s FROM Stock s WHERE s.supplyDate = :supplyDate")
    , @NamedQuery(name = "Stock.findByIssuedDate", query = "SELECT s FROM Stock s WHERE s.issuedDate = :issuedDate")
    , @NamedQuery(name = "Stock.findByExpiryDate", query = "SELECT s FROM Stock s WHERE s.expiryDate = :expiryDate")
    , @NamedQuery(name = "Stock.findByQuantity", query = "SELECT s FROM Stock s WHERE s.quantity = :quantity")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SupplyDate")
    @Temporal(TemporalType.DATE)
    private Date supplyDate;
    @Basic(optional = false)
    @Column(name = "IssuedDate")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    @Basic(optional = false)
    @Column(name = "ExpiryDate")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "MedicineID", referencedColumnName = "MedicineID")
    @ManyToOne(optional = false)
    private Medicine medicineID;
    @JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
    @ManyToOne(optional = false)
    private Status statusID;
    @JoinColumn(name = "SupplierID", referencedColumnName = "SupplierID")
    @ManyToOne(optional = false)
    private Supplier supplierID;

    public Stock() {
    }

    public Stock(Date supplyDate) {
        this.supplyDate = supplyDate;
    }

    public Stock(Date supplyDate, Date issuedDate, Date expiryDate, int quantity) {
        this.supplyDate = supplyDate;
        this.issuedDate = issuedDate;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
    }

    public Date getSupplyDate() {
        return supplyDate;
    }

    public void setSupplyDate(Date supplyDate) {
        this.supplyDate = supplyDate;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Medicine getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(Medicine medicineID) {
        this.medicineID = medicineID;
    }

    public Status getStatusID() {
        return statusID;
    }

    public void setStatusID(Status statusID) {
        this.statusID = statusID;
    }

    public Supplier getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Supplier supplierID) {
        this.supplierID = supplierID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplyDate != null ? supplyDate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.supplyDate == null && other.supplyDate != null) || (this.supplyDate != null && !this.supplyDate.equals(other.supplyDate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Stock[ supplyDate=" + supplyDate + " ]";
    }
    
}

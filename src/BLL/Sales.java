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
 * @author Laris
 */
@Entity
@Table(name = "Sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s")
    , @NamedQuery(name = "Sales.findBySaleID", query = "SELECT s FROM Sales s WHERE s.saleID = :saleID")
    , @NamedQuery(name = "Sales.findByValueSold", query = "SELECT s FROM Sales s WHERE s.valueSold = :valueSold")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SaleID")
    private Integer saleID;
    @Basic(optional = false)
    @Column(name = "ValueSold")
    private double valueSold;
    @JoinColumn(name = "InvoiceID", referencedColumnName = "InvoiceID")
    @ManyToOne(optional = false)
    private Invoice invoiceID;

    public Sales() {
    }

    public Sales(Integer saleID) {
        this.saleID = saleID;
    }

    public Sales(Integer saleID, double valueSold) {
        this.saleID = saleID;
        this.valueSold = valueSold;
    }

    public Integer getSaleID() {
        return saleID;
    }

    public void setSaleID(Integer saleID) {
        this.saleID = saleID;
    }

    public double getValueSold() {
        return valueSold;
    }

    public void setValueSold(double valueSold) {
        this.valueSold = valueSold;
    }

    public Invoice getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(Invoice invoiceID) {
        this.invoiceID = invoiceID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleID != null ? saleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.saleID == null && other.saleID != null) || (this.saleID != null && !this.saleID.equals(other.saleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sale ID: "+ saleID + "         Invoice ID: "+ invoiceID.getInvoiceID() + "         Value Sold: " + valueSold + "€";
    }
    
}

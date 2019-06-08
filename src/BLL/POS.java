/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Agon
 */
public class POS {
    String brandName,genericName;
    int quantity;
    double price;
    Date expiryDate;

    public POS(String brandName, String genericName, int quantity, double price, Date expiryDate) {
        this.brandName = brandName;
        this.genericName = genericName;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final POS other = (POS) obj;
        if (!Objects.equals(this.brandName, other.brandName)) {
            return false;
        }
        if (!Objects.equals(this.genericName, other.genericName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POS{" + "brandName=" + brandName + ", genericName=" + genericName + ", quantity=" + quantity + ", price=" + price + ", expiryDate=" + expiryDate + '}';
    }
    
    
}

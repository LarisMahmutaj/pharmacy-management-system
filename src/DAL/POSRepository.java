/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Status;
import BLL.Stock;
import BLL.POS;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agon
 */
public class POSRepository extends EntMngClass implements POSInterface{

    @Override
    public void delete(POS s) throws PharmacyException {
        try {
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new PharmacyException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<POS> findAll() throws PharmacyException {
        
        try {
            List<POS> posList=null;
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "sa","sa");
            java.sql.Statement stmt = conn.createStatement();
            String exec = "use PharmacyManagement select BrandName,GenericName,s.ExpiryDate,Quantity,Price from stock s inner join medicine m on s.MedicineID=m.MedicineID";
            ResultSet rset = stmt.executeQuery(exec);
            POS pos;
        while(rset.next()){
//            public POS(String brandName, String genericName, int quantity, double price, Date expiryDate) {
            pos=new POS(rset.getString("brandname"),rset.getString("genericName"),rset.getInt("quantity"),rset.getDouble("price"),rset.getDate("expirydate"));
                boolean add = posList.add(pos);
                
        }
        System.out.print(posList.size());
            return posList;
        } catch (Exception e) {
            throw new PharmacyException("\nMsg! \n" + e);
        }
    }

    @Override
    public Stock findByID(Integer ID) throws PharmacyException {
        return null;
    }

    @Override
    public List<POS> findByName(String name) throws PharmacyException {
//        Query q = em.createQuery("select * from stock s inner join medicine m on s.MedicineID=m.MedicineID inner join class c on m.ClassID=c.ClassID where m.BrandName=':name'");
        List<POS> posList = null;
        try{
            
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "sa","sa");
            java.sql.Statement stmt = conn.createStatement();
            String exec = "use PharmacyManagement select BrandName,GenericName,s.ExpiryDate,Quantity,Price from stock s inner join medicine m on s.MedicineID=m.MedicineID where m.brandname='"+name+"'";
            ResultSet rset = stmt.executeQuery(exec);
        
        POS pos;
        while(rset.next()){
//            public POS(String brandName, String genericName, int quantity, double price, Date expiryDate) {
            pos=new POS(rset.getString("brandname"),rset.getString("genericName"),rset.getInt("quantity"),rset.getDouble("price"),rset.getDate("expirydate"));
            posList.add(pos);
            int a = rset.getInt("price");
        System.out.print(a);
        }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return posList;
    }
    
    

   
}

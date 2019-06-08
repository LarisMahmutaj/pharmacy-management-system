/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Model;
import BLL.POS;
import java.util.List;
import BLL.Stock;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Agon
 */
    
public class POSTableModel extends AbstractTableModel {

    List<POS> list;
    String[] cols = {"Brand name", "Generic name", "Expiry date", "Quanity","Price"};
    
    public POSTableModel(List<POS> list) {
        this.list = list;
    }

    public POSTableModel() {
        
        }
    public void addList(List<POS> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        if(list!=null)
            return list.size();
        else return 0;
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
    
    public void remove(int row) {
        list.remove(row);
    }
    
    public POS getPOS(int index) {
        return list.get(index);
    }
    
    @Override
    public String getColumnName(int col) {
        return cols[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        POS p = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getBrandName();
            case 1:
                return p.getGenericName();
            case 2:
                return p.getExpiryDate();
            case 3:
                return p.getQuantity();
            case 4:
                return p.getPrice();
            default:
                return null;
        }
    }
    
}

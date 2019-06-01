/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Stock;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laris
 */
public class StockTableModel extends AbstractTableModel {

    List<Stock> list;
    String[] cols = {"Supply Date", "Medicine ID", "Supplier ID", "Issued Date", "Expiry Date", "Quantity", "Status ID"};

    public StockTableModel(List<Stock> list) {
        this.list = list;
    }

    public StockTableModel() {

    }

    public void addList(List<Stock> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
    @Override
    public String getColumnName(int col) {
        return cols[col];
    }

    public void remove(int row) {
        list.remove(row);
    }

    public Stock getStock(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stock p = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getSimpleSupplyDate();
            case 1:
                return p.getMedicineID();
            case 2:
                return p.getSupplierID();
            case 3:
                return p.getSimpleIssuedDate();
            case 4:
                return p.getSimpleExpiryDate();
            case 5:
                return p.getQuantity();
            case 6:
                return p.getStatusID();
            default:
                return null;
        }
    }

}

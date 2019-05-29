/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Supplier;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laris
 */
public class SupplierTableModel extends AbstractTableModel {

    List<Supplier> list;
    String[] cols = {"Supplier ID", "Name", "Address", "Phone Number", "Email"};

    public SupplierTableModel(List<Supplier> list) {
        this.list = list;
    }

    public SupplierTableModel() {

    }

    public void addList(List<Supplier> list) {
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

    public Supplier getSupplier(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Supplier p = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getSupplierID();
            case 1:
                return p.getName();
            case 2:
                return p.getAddress();
            case 3:
                return p.getPhoneNumber();
            case 4:
                return p.getEmail();
            default:
                return null;
        }
    }

}

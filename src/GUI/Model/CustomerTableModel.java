/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Customer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laris
 */
public class CustomerTableModel extends AbstractTableModel {

    List<Customer> list;
    String[] cols = {"Customer ID", "Name", "Phone Number", "Address"};

    public CustomerTableModel(List<Customer> list) {
        this.list = list;
    }

    public CustomerTableModel() {

    }

    public void addList(List<Customer> list) {
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

    public Customer getCustomer(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer p = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getCustomerID();
            case 1:
                return p.getName();
            case 2:
                return p.getPhoneNumber();
            case 3:
                return p.getAddress();
            default:
                return null;
        }
    }
}

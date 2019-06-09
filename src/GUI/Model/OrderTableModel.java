/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Orders;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laris
 */
public class OrderTableModel extends AbstractTableModel {

    List<Orders> list;
    String[] cols = {"Order ID", "Supplier", "Medicine", "Quantity", "Price"};

    public OrderTableModel(List<Orders> list) {
        this.list = list;
    }

    public OrderTableModel() {

    }

    public void addList(List<Orders> list) {
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

    public Orders getOrders(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Orders p = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getOrderID();
            case 1:
                return p.getSupplierID();
            case 2:
                return p.getMedicineID();
            case 3:
                return p.getQuantity();
            case 4:
                return p.getPrice();
            default:
                return null;
        }
    }

}

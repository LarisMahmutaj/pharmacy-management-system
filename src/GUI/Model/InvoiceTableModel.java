/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Invoice;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laris
 */
public class InvoiceTableModel extends AbstractTableModel {

    List<Invoice> list;
    String[] cols = {"Invoice ID", "Customer", "Date"};

    public InvoiceTableModel(List<Invoice> list) {
        this.list = list;
    }

    public InvoiceTableModel() {

    }

    public void addList(List<Invoice> list) {
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

    public Invoice getInvoice(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice p = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getInvoiceID();
            case 1:
                return p.getCustomerID();
            case 2:
                return p.getSimpleDate();
            default:
                return null;
        }
    }
}

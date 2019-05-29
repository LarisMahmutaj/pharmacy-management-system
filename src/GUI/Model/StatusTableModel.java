/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Status;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laris
 */
public class StatusTableModel extends AbstractTableModel {

    List<Status> list;
    String[] cols = {"Status ID", "Status Name"};

    public StatusTableModel(List<Status> list) {
        this.list = list;
    }

    public StatusTableModel() {

    }

    public void addList(List<Status> list) {
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

    public Status getStatus(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Status p = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getStatusID();
            case 1:
                return p.getStatusName();
            default:
                return null;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Perdoruesi;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laris
 */
public class PerdoruesiTableModel extends AbstractTableModel {

    List<Perdoruesi> list;
    String[] cols = {"UserID", "UserName", "Password", "Role"};

    public PerdoruesiTableModel(List<Perdoruesi> list) {
        this.list = list;
    }

    public PerdoruesiTableModel() {

    }

    public void addList(List<Perdoruesi> list) {
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

    public Perdoruesi getPerdoruesi(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Perdoruesi p = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getUserID();
            case 1:
                return p.getUserName();
            case 2:
                return p.getPassword();
            case 3:
                return p.getRoleID();
            default:
                return null;
        }
    }

}

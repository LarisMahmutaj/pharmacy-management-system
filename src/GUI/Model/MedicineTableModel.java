/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Medicine;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laris
 */
public class MedicineTableModel extends AbstractTableModel {

    List<Medicine> list;
    String[] cols = {"UserID", "UserName", "Password", "Classification", "Price"};

    public MedicineTableModel(List<Medicine> list) {
        this.list = list;
    }

    public MedicineTableModel() {

    }

    public void addList(List<Medicine> list) {
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

    public Medicine getMedicine(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Medicine p = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getMedicineID();
            case 1:
                return p.getBrandName();
            case 2:
                return p.getGenericName();
            case 3:
                return p.getClassificationID();
            case 4:
                return p.getPrice();
            default:
                return null;
        }
    }

}

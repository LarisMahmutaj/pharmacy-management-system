/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Classification;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Laris
 */
public class ClassificationTableModel extends AbstractTableModel {

    List<Classification> list;
    String[] cols = {"Classification ID", "Classification Name"};

    public ClassificationTableModel(List<Classification> list) {
        this.list = list;
    }

    public ClassificationTableModel() {

    }

    public void addList(List<Classification> list) {
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

    public Classification getClassification(int index) {
        return list.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Classification p = list.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getClassificationID();
            case 1:
                return p.getClassificationName();
            default:
                return null;
        }
    }

}

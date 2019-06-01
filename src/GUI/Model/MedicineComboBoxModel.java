/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Medicine;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Laris
 */
public class MedicineComboBoxModel extends AbstractListModel<Medicine> implements ComboBoxModel<Medicine>{

    private Medicine selectedItem;
    private List<Medicine> data;
    
    public MedicineComboBoxModel(List<Medicine> data){
        this.data = data;
    }
    
    public MedicineComboBoxModel(){
        
    }
    
    public void add(List<Medicine> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Medicine getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Medicine)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

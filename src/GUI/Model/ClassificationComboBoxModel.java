/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Classification;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Laris
 */
public class ClassificationComboBoxModel extends AbstractListModel<Classification> implements ComboBoxModel<Classification>{

    private Classification selectedItem;
    private List<Classification> data;
    
    public ClassificationComboBoxModel(List<Classification> data){
        this.data = data;
    }
    
    public ClassificationComboBoxModel(){
        
    }
    
    public void add(List<Classification> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Classification getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Classification)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

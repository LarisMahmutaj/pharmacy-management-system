/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Status;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Laris
 */
public class StatusComboBoxModel extends AbstractListModel<Status> implements ComboBoxModel<Status>{

    private Status selectedItem;
    private List<Status> data;
    
    public StatusComboBoxModel(List<Status> data){
        this.data = data;
    }
    
    public StatusComboBoxModel(){
        
    }
    
    public void add(List<Status> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Status getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Status)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

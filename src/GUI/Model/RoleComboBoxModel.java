/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Role;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Laris
 */
public class RoleComboBoxModel extends AbstractListModel<Role> implements ComboBoxModel<Role>{

    private Role selectedItem;
    private List<Role> data;
    
    public RoleComboBoxModel(List<Role> data){
        this.data = data;
    }
    
    public RoleComboBoxModel(){
        
    }
    
    public void add(List<Role> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Role getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Role)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

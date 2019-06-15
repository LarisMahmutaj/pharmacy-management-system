/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Customer;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Laris
 */
public class CustomerComboBoxModel extends AbstractListModel<Customer> implements ComboBoxModel<Customer>{

    private Customer selectedItem;
    private List<Customer> data;
    
    public CustomerComboBoxModel(List<Customer> data){
        this.data = data;
    }
    
    public CustomerComboBoxModel(){
        
    }
    
    public void add(List<Customer> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Customer getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Customer)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

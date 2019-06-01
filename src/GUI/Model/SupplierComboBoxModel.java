/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Model;

import BLL.Supplier;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Laris
 */
public class SupplierComboBoxModel extends AbstractListModel<Supplier> implements ComboBoxModel<Supplier>{

    private Supplier selectedItem;
    private List<Supplier> data;
    
    public SupplierComboBoxModel(List<Supplier> data){
        this.data = data;
    }
    
    public SupplierComboBoxModel(){
        
    }
    
    public void add(List<Supplier> data){
        this.data = data;
    }
    
    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Supplier getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Supplier)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Medicine;
import BLL.Stock;
import BLL.Supplier;
import DAL.MedicineRepository;
import DAL.PharmacyException;
import DAL.StatusRepository;
import DAL.StockRepository;
import DAL.SupplierRepository;
import gui.Model.MedicineComboBoxModel;
import gui.Model.StockTableModel;
import gui.Model.SupplierComboBoxModel;
import java.beans.PropertyVetoException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Laris
 */
public class StockForm extends javax.swing.JInternalFrame {

    StockRepository sr = new StockRepository();
    StockTableModel stm = new StockTableModel();

    MedicineRepository mr = new MedicineRepository();
    MedicineComboBoxModel mcbm;

    SupplierRepository supr = new SupplierRepository();
    SupplierComboBoxModel supcbm;

    StatusRepository statr = new StatusRepository();
//    StatusComboBoxModel statcbm;

    private static boolean exists = false;

    public static boolean isExists() {
        return exists;
    }

    public static void setExists(boolean exists) {
        StockForm.exists = exists;
    }

    /**
     * Creates new form StockForm
     */
    public StockForm() {
        initComponents();
        loadTable();
        tableSelectedIndexChange();
        loadComboBoxes();
        exists = true;
    }

    public void loadTable() {
        try {
            List<Stock> list = sr.findAll();
            stm.addList(list);
            table.setModel(stm);
            stm.fireTableDataChanged();
        } catch (PharmacyException pe) {
            Logger.getLogger(StockForm.class.getName()).log(Level.SEVERE, null, pe);
        }
    }

    public void tableSelectedIndexChange() {
        final ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (lse.getValueIsAdjusting()) {
                    return;
                }

                ListSelectionModel rowSM = (ListSelectionModel) lse.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Stock p = stm.getStock(selectedIndex);
                    supplyDateTxt.setText(p.getSimpleSupplyDate());
                    issuedDateChooser.setDate(p.getIssuedDate());
                    expiryDateChooser.setDate(p.getExpiryDate());
                    medicineComboBox.setSelectedItem(p.getMedicineID());
                    medicineComboBox.repaint();
                    supplierComboBox.setSelectedItem(p.getSupplierID());
                    supplierComboBox.repaint();
                    quantityTxt.setText(p.getQuantity() + "");
                    statusTxt.setText(p.getStatusID().getStatusName());
//                    statusComboBox.setSelectedItem(p.getStatusID());
//                    statusComboBox.repaint();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        issuedDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        expiryDateChooser = new com.toedter.calendar.JDateChooser();
        quantityTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        medicineComboBox = new javax.swing.JComboBox();
        supplierComboBox = new javax.swing.JComboBox();
        supplyDateTxt = new javax.swing.JTextField();
        statusTxt = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Stock Form");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Supplier ID");

        jLabel2.setText("Medicine ID");

        jLabel6.setText("Issued Date");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        saveBtn.setBackground(new java.awt.Color(0, 102, 255));
        saveBtn.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 0, 0));
        deleteBtn.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Supply Date");

        issuedDateChooser.setDateFormatString("dd.MM.yyyy");
        issuedDateChooser.setMaxSelectableDate(new java.util.Date(2524608106000L));
        issuedDateChooser.setMinSelectableDate(new java.util.Date(946684906000L));

        jLabel7.setText("Expiry Date");

        expiryDateChooser.setDateFormatString("dd.MM.yyyy");
        expiryDateChooser.setMaxSelectableDate(new java.util.Date(4102444870000L));
        expiryDateChooser.setMinSelectableDate(new java.util.Date(946684870000L));

        jLabel5.setText("Quantity");

        jLabel8.setText("Status");

        medicineComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        supplierComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        supplyDateTxt.setEditable(false);
        supplyDateTxt.setBackground(new java.awt.Color(204, 204, 204));

        statusTxt.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(supplyDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(419, 419, 419)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(medicineComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expiryDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(issuedDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(statusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(issuedDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(medicineComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(supplyDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(statusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expiryDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBtn)
                        .addGap(86, 86, 86)
                        .addComponent(deleteBtn)
                        .addGap(86, 86, 86)
                        .addComponent(cancelBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clear();
    }//GEN-LAST:event_cancelBtnActionPerformed

    public boolean isInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int row = table.getSelectedRow();
        if (!(supplyDateTxt.getText() == null || medicineComboBox.getSelectedItem() == null
                || supplierComboBox.getSelectedItem() == null || issuedDateChooser.getDate() == null
                || expiryDateChooser.getDate() == null || quantityTxt.getText().trim().equals("")
                || statusTxt == null)) {
            if (row == -1) {
                Stock p = new Stock();
                
                try {
                    Date currentDate = Date.valueOf(LocalDate.now());
                    p.setSupplyDate(currentDate);
                    p.setMedicineID((Medicine) medicineComboBox.getSelectedItem());
                    p.setSupplierID((Supplier) supplierComboBox.getSelectedItem());
                    p.setIssuedDate(issuedDateChooser.getDate());
                    p.setExpiryDate(expiryDateChooser.getDate());
                    if(quantityTxt.getText().matches("^[1-9]\\d*$")){
                        p.setQuantity(Integer.parseInt(quantityTxt.getText()));
                    }else{
                        JOptionPane.showMessageDialog(this, "Please enter a valid quantity!");
                        return;
                    }
                    if (expiryDateChooser.getDate().before(Date.valueOf(LocalDate.now()))) {
                        p.setStatusID(statr.findByID(2));
                    } else {
                        p.setStatusID(statr.findByID(1));
                    }
//                p.setStatusID((Status) statusComboBox.getSelectedItem());
                    sr.create(p);
                } catch (PharmacyException pe) {
                    //JOptionPane.showMessageDialog(this, "MSG: " + pe.getMessage());
                    return;
                }
            } else {
                Stock p = stm.getStock(row);
//                p.setSupplyDate(Date.valueOf(LocalDate.now()));
                try {
                    p.setMedicineID((Medicine) medicineComboBox.getSelectedItem());
                    p.setSupplierID((Supplier) supplierComboBox.getSelectedItem());
                    p.setIssuedDate(issuedDateChooser.getDate());
                    p.setExpiryDate(expiryDateChooser.getDate());
                    if(quantityTxt.getText().matches("^[1-9]\\d*$")){
                        p.setQuantity(Integer.parseInt(quantityTxt.getText()));
                    }else{
                        JOptionPane.showMessageDialog(this, "Please enter a valid quantity!");
                        return;
                    }
                    if (expiryDateChooser.getDate().before(Date.valueOf(LocalDate.now()))) {
                        p.setStatusID(statr.findByID(2));
                    } else {
                        p.setStatusID(statr.findByID(1));
                    }
//                  p.setStatusID((Status) statusComboBox.getSelectedItem());
                    sr.edit(p);
                } catch (PharmacyException pe) {
                    //JOptionPane.showMessageDialog(this, "MSG: " + pe.getMessage());
                    return;
                }
            }
            loadTable();
            clear();
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in required fields!");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = table.getSelectedRow();
        if (row > -1) {
            Object[] obj = {"Yes", "No"};
            int i = JOptionPane.showOptionDialog(this, "Do you want to delete stock?", "Delete",
                    JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, obj, obj[0]);
            if (i == 0) {
                try {
                    Stock p = stm.getStock(row);
                    sr.delete(p);
                    clear();
                    loadTable();
                } catch (PharmacyException pe) {
                    JOptionPane.showMessageDialog(this, "MSG: " + pe.getMessage());
                }
            } else {
                clear();
            }
        } else {
            JOptionPane.showMessageDialog(this, "You havent selected anything to delete");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        exists = false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (evt.getClickCount() > 0) {
            try {
                this.setSelected(true);
                this.toFront();
            } catch (PropertyVetoException ex) {
                Logger.getLogger(StockForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formMouseClicked

    public void clear() {
        medicineComboBox.setSelectedIndex(-1);
        medicineComboBox.repaint();
        supplierComboBox.setSelectedIndex(-1);
        supplierComboBox.repaint();
        statusTxt.setText("");
//        statusComboBox.setSelectedIndex(-1);
        quantityTxt.setText("");
        table.clearSelection();
    }

    public void loadComboBoxes() {
        try {
            List<Medicine> medlist = mr.findAll();
            mcbm = new MedicineComboBoxModel(medlist);
            medicineComboBox.setModel(mcbm);
            medicineComboBox.repaint();

            List<Supplier> supList = supr.findAll();
            supcbm = new SupplierComboBoxModel(supList);
            supplierComboBox.setModel(supcbm);
            supplierComboBox.repaint();

//            List<Status> statList = statr.findAll();
//            statcbm = new StatusComboBoxModel(statList);
//            statusComboBox.setModel(statcbm);
//            statusComboBox.repaint();
        } catch (PharmacyException ce) {
            Logger.getLogger(StockForm.class.getName()).log(Level.SEVERE, null, ce);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private com.toedter.calendar.JDateChooser expiryDateChooser;
    private com.toedter.calendar.JDateChooser issuedDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox medicineComboBox;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField statusTxt;
    private javax.swing.JComboBox supplierComboBox;
    private javax.swing.JTextField supplyDateTxt;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

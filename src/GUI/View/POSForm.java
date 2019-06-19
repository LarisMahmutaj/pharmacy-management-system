/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Customer;
import BLL.POS;
import DAL.CustomerRepository;
import DAL.POSRepository;
import DAL.PharmacyException;
import GUI.Model.POSTableModel;
import gui.Model.CustomerComboBoxModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agon
 */
public class POSForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form POSForm
     */
    private static boolean exists = false;
    POSTableModel ptm = new POSTableModel();
    POSRepository pr = new POSRepository();

    CustomerRepository cr = new CustomerRepository();
    CustomerComboBoxModel ccbm;

    public static boolean isExists() {
        return exists;
    }

    public static void setExists(boolean exists) {
        POSForm.exists = exists;
    }

    public POSForm() throws PharmacyException, SQLException {
        initComponents();
//        loadTable();
        createTable();
        loadComboBox();
    }

//    public void loadTable() {
//        try {
//            List<POS> list = pr.findAll();
//            ptm.addList(list);
//            jTable.setModel(ptm);
//            ptm.fireTableDataChanged();
//            System.out.print(list);
//        } catch (PharmacyException pe) {
////            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, pe);
//            System.out.println(pe.getMessage());
//        }
//    }

    public void loadComboBox() {
        try {
            List<Customer> list = cr.findAll();
            ccbm = new CustomerComboBoxModel(list);
            customerComboBox.setModel(ccbm);
            customerComboBox.setSelectedIndex(0);
            customerComboBox.repaint();

        } catch (PharmacyException ce) {
            Logger.getLogger(POSForm.class.getName()).log(Level.SEVERE, null, ce);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quantityTxt = new javax.swing.JTextField();
        sellBtn = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableList = new javax.swing.JTable();
        removeBtn = new javax.swing.JButton();
        customerComboBox = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Point Of Sale");
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

        quantityTxt.setText("1");

        sellBtn.setText("Sell");
        sellBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellBtnActionPerformed(evt);
            }
        });

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Brand name", "Generic name", "Expiry date", "Quantity", "Supply date", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jLabel1.setText("Quantity:");

        jLabel2.setText("Customer");

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jTableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Brand name", "Generic name", "Expiry date", "Quantity", "Supply date", "Price", "Quantity sold"
            }
        ));
        jScrollPane2.setViewportView(jTableList);

        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        customerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(sellBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(customerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sellBtn)
                    .addComponent(addBtn)
                    .addComponent(removeBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        exists = false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
//        String src = searchTextField.getText();
//        List<POS> s;
//        try{
//        s=pr.findByName(src);
//        ptm.addList(s);
//        jTable.setModel(ptm);
//        ptm.fireTableDataChanged();
//        }
//        catch(PharmacyException p){
//            System.out.println(p.getMessage());
//        }
        searchByName(searchTextField.getText());

    }//GEN-LAST:event_searchButtonActionPerformed

    private void sellBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellBtnActionPerformed
        // TODO add your handling code here:
        //int row = jTable.getSelectedRow();
        if (jTable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Please select items to sell!");
        } else {
            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "sa", "sa");
                java.sql.Statement stmt = conn.createStatement();
                int total = 0;

                //String cTxt=customerTxt.getText();
                int cTxt;
                if (customerComboBox.getSelectedIndex() > -1) {
                    cTxt = ((Customer) customerComboBox.getSelectedItem()).getCustomerID();
                } else {
                    //ID 3 is Guest customer in database
                    cTxt = 3;
                }
                String invoice = "use PharmacyManagement insert into invoice values('" + cTxt + "','" + java.time.LocalDate.now() + "')";
                stmt.execute(invoice);

                String invoiceIn = "select top 1 * from invoice i order by i.InvoiceID desc";
                ResultSet invoiceRset = stmt.executeQuery(invoiceIn);
                invoiceRset.next();
                int invoiceId = invoiceRset.getInt("InvoiceID");
                DefaultTableModel model = (DefaultTableModel) jTableList.getModel();

                //Stock decrement start
                int rowCount = jTableList.getRowCount();
                for (int currentRow = 0; currentRow < rowCount; currentRow++) {
//        System.out.println("Current row:"+currentRow+", rowCount:"+rowCount);
                    int qq = Integer.parseInt(jTableList.getValueAt(0, 4).toString()) - Integer.parseInt(jTableList.getValueAt(0, 7).toString());
                    String date = jTableList.getValueAt(0, 5).toString();
                    String exec = "use PharmacyManagement update stock set quantity=" + qq + " where supplyDate='" + date + "'";
                    stmt.executeUpdate(exec);
//        jTable.setValueAt(qq, row, 3);

                    //Item creation
                    String itemC = "use PharmacyManagement insert into item values(" + invoiceId + "," + jTableList.getValueAt(0, 0) + "," + jTableList.getValueAt(0, 7) + ")";
                    stmt.execute(itemC);

                    total += Float.parseFloat(jTableList.getValueAt(0, 6).toString()) * Float.parseFloat(jTableList.getValueAt(0, 7).toString());

                    model.removeRow(0);
                }
                String salesC = "use PharmacyManagement insert into sales values(" + invoiceId + "," + total + ")";
                stmt.execute(salesC);

                int rc = jTable.getRowCount();
                System.out.println("rc=" + rc);
                for (int i = 0; i < rc; i++) {
                    System.out.println(Integer.parseInt(jTable.getValueAt(i, 4).toString()));
                    if (Integer.parseInt(jTable.getValueAt(i, 4).toString()) == 0) {
                        String execDel = "delete stock where supplyDate='" + jTable.getValueAt(i, 5).toString() + "'";
                        System.out.println(execDel);
                        stmt.execute(execDel);
                    }
                }
                searchByName(searchTextField.getText());
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        }
    }//GEN-LAST:event_sellBtnActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        int row = jTable.getSelectedRow();
        int qq = Integer.parseInt(jTable.getValueAt(row, 4).toString()) - Integer.parseInt(quantityTxt.getText());
        if (qq < 0) {
            JOptionPane.showMessageDialog(rootPane, "Not enough in stock");
        } else {
            DefaultTableModel model = (DefaultTableModel) jTableList.getModel();

            DefaultTableModel firstModel = (DefaultTableModel) jTable.getModel();

            Object[] sRow = new Object[8];

            sRow[0] = jTable.getValueAt(row, 0);
            sRow[1] = jTable.getValueAt(row, 1);
            sRow[2] = jTable.getValueAt(row, 2);
            sRow[3] = jTable.getValueAt(row, 3);
            sRow[4] = jTable.getValueAt(row, 4);
            sRow[5] = jTable.getValueAt(row, 5);
            sRow[6] = jTable.getValueAt(row, 6);
            sRow[7] = quantityTxt.getText();
            model.addRow(sRow);
            firstModel.setValueAt(Integer.parseInt(jTable.getValueAt(row, 4).toString()) - Integer.parseInt(quantityTxt.getText()), row, 4);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        // TODO add your handling code here:
        int row = jTableList.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTableList.getModel();
        model.removeRow(row);

    }//GEN-LAST:event_removeBtnActionPerformed

    private void customerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerComboBoxActionPerformed

    public void createTable() throws SQLException, PharmacyException {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "sa", "sa");
            java.sql.Statement stmt = conn.createStatement();
            String exec = "use PharmacyManagement select BrandName,GenericName,s.ExpiryDate,Quantity,s.supplydate,Price,m.medicineId from stock s inner join medicine m on s.MedicineID=m.MedicineID order by s.ExpiryDate asc";
            ResultSet rset = stmt.executeQuery(exec);
            model.setRowCount(0);
            while (rset.next()) {
//            public POS(String brandName, String genericName, int quantity, double price, Date expiryDate) {
//            pos=new POS(rset.getString("brandname"),rset.getString("genericName"),rset.getInt("quantity"),rset.getDouble("price"),rset.getDate("expirydate"));
//            ArrayList<Room_1> list = roomList();

                Object[] row = new Object[7];

                row[0] = rset.getInt("medicineId");
                row[1] = rset.getString("brandname");
                row[2] = rset.getString("genericName");
                row[3] = rset.getDate("expirydate");
                row[4] = rset.getInt("quantity");
                row[5] = rset.getString("supplydate");
                row[6] = rset.getDouble("price");
                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    private void searchByName(String name) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "sa", "sa");
            java.sql.Statement stmt = conn.createStatement();
            String exec = "use PharmacyManagement select BrandName,GenericName,s.ExpiryDate,Quantity,s.supplydate,Price,m.medicineId from stock s inner join medicine m on s.MedicineID=m.MedicineID where m.BrandName like '%" + name + "%' order by s.ExpiryDate asc";
            ResultSet rset = stmt.executeQuery(exec);
            model.setRowCount(0);
            while (rset.next()) {
                Object[] row = new Object[7];

                row[0] = rset.getInt("medicineId");
                row[1] = rset.getString("brandname");
                row[2] = rset.getString("genericName");
                row[3] = rset.getDate("expirydate");
                row[4] = rset.getInt("quantity");
                row[5] = rset.getString("supplydate");
                row[6] = rset.getDouble("price");

                model.addRow(row);
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JComboBox customerComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTableList;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton sellBtn;
    // End of variables declaration//GEN-END:variables
}

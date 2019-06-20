/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Invoice;
import BLL.Item;
import DAL.ItemRepository;
import DAL.PharmacyException;
import gui.Model.InvoiceTableModel;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import DAL.InvoiceRepository;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Laris
 */
public class SalesForm extends javax.swing.JInternalFrame {

    private static boolean exists = false;
    InvoiceTableModel itm = new InvoiceTableModel();
    InvoiceRepository ir = new InvoiceRepository();
    ItemRepository itemr = new ItemRepository();
    

    /**
     * Creates new form InvoiceForm
     */
    public SalesForm() {
        initComponents();
        loadTable();
        loadListOnInvoiceSelect();
        exists = true;
    }

    public static boolean isExists() {
        return exists;
    }

    public static void setExists(boolean exists) {
        SalesForm.exists = exists;
    }

    public void loadTable() {
        try {
            List<Invoice> list = ir.findAll();
            itm.addList(list);
            invoiceTable.setModel(itm);
            itm.fireTableDataChanged();
        } catch (PharmacyException pe) {
            Logger.getLogger(SalesForm.class.getName()).log(Level.SEVERE, null, pe);
        }
    }

    public void loadListOnInvoiceSelect() {
        final ListSelectionModel rowSM = invoiceTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (lse.getValueIsAdjusting()) {
                    return;
                }

                ListSelectionModel rowSM = (ListSelectionModel) lse.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Invoice i = (Invoice) itm.getInvoice(selectedIndex);
                    String str = "";
                    double total = 0;
                    try {
                        List<Item> items = itemr.findByInvoiceID(i);
                        Iterator it = items.iterator();
                        for (int x = 0; x < items.size(); x++) {
                            Item item = (Item) it.next();
                            str += (x + 1) + ":        " + item + "\n";
                            total += item.getMedicineID().getPrice();
                        }

                        textArea.setText("Pharmacy Management System \n"
                                + "Invoice:" + i.getInvoiceID() + "\n"
                                + "-------------------------------------------------------\n"
                                + str
                                + "-------------------------------------------------------\n"
                                + "Total:   " + total + "€"
                                + "\nArticles: " + items.size()
                                + "\nDate: " + i.getSimpleDate() + "\n");

                    } catch (PharmacyException ex) {
                        Logger.getLogger(SalesForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

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

        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setClosable(true);
        setTitle("Sales");
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

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(invoiceTable);

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textArea.setRows(5);
        jScrollPane2.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        exists = false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (evt.getClickCount() > 0) {
            try {
                this.setSelected(true);
                this.toFront();
            } catch (PropertyVetoException ex) {
                Logger.getLogger(SalesForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable invoiceTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}

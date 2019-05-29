/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.View;

import BLL.Role;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Laris
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);

    }

    public MainForm(Role role) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        if (role.getRoleID() != 1) {
            addUserBtn.setVisible(false);
            addClassificationBtn.setVisible(false);
            addMedicineBtn.setVisible(false);
            supplierBtn.setVisible(false);
        }
        logOut();

    }

    public void logOut() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
                Object[] ob = {"Yes", "No"};
                int i = JOptionPane.showOptionDialog(MainForm.this, "Do you want to log out?",
                        "Log Out", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[0]);
                if (i == 0) {
                    new LoginForm().setVisible(true);
                    MainForm.this.setVisible(false);
                }
            }
        });
    }

    @Override
    public synchronized void addWindowListener(WindowListener l) {
        super.addWindowListener(l); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        posBtn1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addMedicineBtn = new javax.swing.JButton();
        orderBtn = new javax.swing.JButton();
        addUserBtn = new javax.swing.JButton();
        addToStockBtn = new javax.swing.JButton();
        addCostumerBtn = new javax.swing.JButton();
        addClassificationBtn = new javax.swing.JButton();
        salesBtn = new javax.swing.JButton();
        supplierBtn = new javax.swing.JButton();
        mainPanel = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setPreferredSize(new java.awt.Dimension(682, 83));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(36, 36, 36));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pharmacy Management System");

        logOutBtn.setBackground(new java.awt.Color(0, 0, 0));
        logOutBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        logOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logOutBtn.setText("Log Out");
        logOutBtn.setBorder(null);
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 849, Short.MAX_VALUE)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        posBtn1.setBackground(new java.awt.Color(0, 0, 0));
        posBtn1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        posBtn1.setForeground(new java.awt.Color(255, 255, 255));
        posBtn1.setText("POS");
        posBtn1.setToolTipText("Poin Of Sale");
        posBtn1.setBorder(null);
        posBtn1.setDefaultCapable(false);
        posBtn1.setFocusPainted(false);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(LoginForm.getUsername());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        addMedicineBtn.setBackground(new java.awt.Color(0, 0, 0));
        addMedicineBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        addMedicineBtn.setForeground(new java.awt.Color(255, 255, 255));
        addMedicineBtn.setText("Medicine");
        addMedicineBtn.setBorder(null);
        addMedicineBtn.setDefaultCapable(false);
        addMedicineBtn.setFocusPainted(false);
        addMedicineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMedicineBtnActionPerformed(evt);
            }
        });

        orderBtn.setBackground(new java.awt.Color(0, 0, 0));
        orderBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        orderBtn.setForeground(new java.awt.Color(255, 255, 255));
        orderBtn.setText("Order");
        orderBtn.setBorder(null);
        orderBtn.setDefaultCapable(false);
        orderBtn.setFocusPainted(false);

        addUserBtn.setBackground(new java.awt.Color(0, 0, 0));
        addUserBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        addUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        addUserBtn.setText("Users");
        addUserBtn.setBorder(null);
        addUserBtn.setDefaultCapable(false);
        addUserBtn.setFocusPainted(false);
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        addToStockBtn.setBackground(new java.awt.Color(0, 0, 0));
        addToStockBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        addToStockBtn.setForeground(new java.awt.Color(255, 255, 255));
        addToStockBtn.setText("Stock");
        addToStockBtn.setBorder(null);
        addToStockBtn.setDefaultCapable(false);
        addToStockBtn.setFocusPainted(false);
        addToStockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToStockBtnActionPerformed(evt);
            }
        });

        addCostumerBtn.setBackground(new java.awt.Color(0, 0, 0));
        addCostumerBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        addCostumerBtn.setForeground(new java.awt.Color(255, 255, 255));
        addCostumerBtn.setText("Customers");
        addCostumerBtn.setBorder(null);
        addCostumerBtn.setDefaultCapable(false);
        addCostumerBtn.setFocusPainted(false);
        addCostumerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCostumerBtnActionPerformed(evt);
            }
        });

        addClassificationBtn.setBackground(new java.awt.Color(0, 0, 0));
        addClassificationBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        addClassificationBtn.setForeground(new java.awt.Color(255, 255, 255));
        addClassificationBtn.setText("Classifications");
        addClassificationBtn.setBorder(null);
        addClassificationBtn.setDefaultCapable(false);
        addClassificationBtn.setFocusPainted(false);
        addClassificationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassificationBtnActionPerformed(evt);
            }
        });

        salesBtn.setBackground(new java.awt.Color(0, 0, 0));
        salesBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        salesBtn.setForeground(new java.awt.Color(255, 255, 255));
        salesBtn.setText("Sales");
        salesBtn.setBorder(null);
        salesBtn.setDefaultCapable(false);
        salesBtn.setFocusPainted(false);
        salesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesBtnActionPerformed(evt);
            }
        });

        supplierBtn.setBackground(new java.awt.Color(0, 0, 0));
        supplierBtn.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        supplierBtn.setForeground(new java.awt.Color(255, 255, 255));
        supplierBtn.setText("Suppliers");
        supplierBtn.setBorder(null);
        supplierBtn.setDefaultCapable(false);
        supplierBtn.setFocusPainted(false);
        supplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(orderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addMedicineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(posBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addToStockBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addCostumerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addClassificationBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplierBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(posBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addCostumerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addToStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMedicineBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addClassificationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supplierBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1230, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/View/Images/background.png"))); // NOI18N

        mainPanel.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1597, Short.MAX_VALUE)
                    .addComponent(mainPanel)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        UserForm uf = new UserForm();
        mainPanel.add(uf);
        uf.show();
    }//GEN-LAST:event_addUserBtnActionPerformed

    private void addToStockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToStockBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addToStockBtnActionPerformed

    private void addCostumerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCostumerBtnActionPerformed
        CustomerForm cf = new CustomerForm();
        mainPanel.add(cf);
        cf.show();
    }//GEN-LAST:event_addCostumerBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        Object[] ob = {"Yes", "No"};
        int i = JOptionPane.showOptionDialog(this, "Do you want to log out?",
                "Log Out", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[0]);
        if (i == 0) {
            new LoginForm().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void addClassificationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassificationBtnActionPerformed
        ClassificationForm cf = new ClassificationForm();
        mainPanel.add(cf);
        cf.show();
    }//GEN-LAST:event_addClassificationBtnActionPerformed

    private void salesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salesBtnActionPerformed

    private void addMedicineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMedicineBtnActionPerformed
        MedicineForm mf = new MedicineForm();
        mainPanel.add(mf);
        mf.show();
    }//GEN-LAST:event_addMedicineBtnActionPerformed

    private void supplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierBtnActionPerformed
        SupplierForm sf = new SupplierForm();
        mainPanel.add(sf);
        sf.show();
    }//GEN-LAST:event_supplierBtnActionPerformed


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClassificationBtn;
    private javax.swing.JButton addCostumerBtn;
    private javax.swing.JButton addMedicineBtn;
    private javax.swing.JButton addToStockBtn;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JLayeredPane mainPanel;
    private javax.swing.JButton orderBtn;
    private javax.swing.JButton posBtn1;
    private javax.swing.JButton salesBtn;
    private javax.swing.JButton supplierBtn;
    // End of variables declaration//GEN-END:variables

}

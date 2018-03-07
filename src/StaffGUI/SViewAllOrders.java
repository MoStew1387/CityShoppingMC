/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StaffGUI;

import Classes.*;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mcarr
 */
public class SViewAllOrders extends javax.swing.JFrame {

    DBManager db = new DBManager();
    HashMap <Integer,Order> orders = new HashMap<>();
    Customer cust = new Customer();
    GUI gui = new GUI();
    String action = "";
    String error = "EMPTY1971";
    Order order = new Order();
    /**
     * Creates new form SViewAllOrders
     */
    public SViewAllOrders() {
        initComponents();
        orders = db.loadAllOrders();
        DefaultTableModel dtm = (DefaultTableModel)tblSOrders.getModel();
        String[] data = new String[5];
        gui.populateOrders(data, orders, dtm, tblSOrders);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnStaffHome = new javax.swing.JButton();
        ViewOrderLine = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSOrders = new javax.swing.JTable();
        lblResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnStaffHome.setText("Return to Staff Home");
        btnStaffHome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnStaffHomeActionPerformed(evt);
            }
        });

        ViewOrderLine.setText("View Orderlines");
        ViewOrderLine.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ViewOrderLineActionPerformed(evt);
            }
        });

        tblSOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Username", "Order ID", "Date", "OrderTotal", "Status"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSOrders);

        lblResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnStaffHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ViewOrderLine)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblResult, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStaffHome)
                    .addComponent(ViewOrderLine))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResult, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewOrderLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewOrderLineActionPerformed

            order = gui.findOrder(tblSOrders);
            action = "viewed";
            if(order.getOrderDate().equals(error))
            {
                gui.warning(lblResult,order, action);
            }
            else
            {
              SViewOrderLines svol = new SViewOrderLines(order);
              this.dispose();
              svol.setVisible(true);  
            }
            
    }//GEN-LAST:event_ViewOrderLineActionPerformed

    private void btnStaffHomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnStaffHomeActionPerformed
    {//GEN-HEADEREND:event_btnStaffHomeActionPerformed
        // TODO add your handling code here:
        SHomeGUI sHome = new SHomeGUI();
        this.dispose();
        sHome.setVisible(true);
    }//GEN-LAST:event_btnStaffHomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SViewAllOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SViewAllOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SViewAllOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SViewAllOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SViewAllOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewOrderLine;
    private javax.swing.JButton btnStaffHome;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTable tblSOrders;
    // End of variables declaration//GEN-END:variables
}


package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class Item extends javax.swing.JFrame {

    
    public Item() {
        initComponents();
        setLocationRelativeTo(null);
        Connect();
        AutoID();
        Item_table();
        
        
    }

   
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() 
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/nmchospital", "root", "");
      
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null,ex );
        }
    }
    
    
   public void AutoID() 
           
   {
        try {
            Statement s = con.createStatement();
            rs = s.executeQuery("Select MAX(itemid) from item");
            rs.next();
            rs.getString("MAX(itemid)");
            
            if(rs.getString("MAX(itemid)") == null)
            {
                
                lblitemid.setText("IU001");
                
            } else {
                
                
                long id = Long.parseLong(rs.getString("MAX(itemid)").substring(2,rs.getString("MAX(itemid)").length()));
                id++; 
                
                lblitemid.setText("IU"+String.format("%03d", id));
            }
                
              
            
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   }
   
   
   public void Item_table() {
       
        try {
            pst = con.prepareStatement("select * from item");
            rs = pst.executeQuery();
            ResultSetMetaData Rsm = rs.getMetaData();
            int c;   
            c = Rsm.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            
            while (rs.next()) {
                Vector v2 = new Vector();
                
                for(int i = 1; i<=c; i++){
                
                v2.add(rs.getString("itemid"));
                v2.add(rs.getString("itemname"));
                v2.add(rs.getString("description"));
                v2.add(rs.getString("sellprice"));
                v2.add(rs.getString("buyprice"));
                v2.add(rs.getString("qty"));
                } 
                
                df.addRow(v2);
            } 
   
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
  
   }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lblitemid = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtdes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtsellprice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtbprice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 100, 40));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 100, 40));

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 100, 40));

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 100, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item No.", "Item Name", "Description", "Sell Price", "Buy Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 680, 240));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(145, 90, 63));
        jLabel5.setText("Create Item");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 240, 40));

        lblitemid.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        lblitemid.setForeground(new java.awt.Color(51, 51, 51));
        lblitemid.setText("jLabel5");
        jPanel1.add(lblitemid, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 152, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(145, 90, 63));
        jLabel1.setText("Item ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(145, 90, 63));
        jLabel2.setText("Item Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, -1));

        txtname.setBackground(new java.awt.Color(221, 221, 221));
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 170, 29));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(145, 90, 63));
        jLabel6.setText("Description");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        txtdes.setBackground(new java.awt.Color(221, 221, 221));
        jPanel1.add(txtdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 209, 29));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(145, 90, 63));
        jLabel4.setText("Sell Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, -1, -1));

        txtsellprice.setBackground(new java.awt.Color(221, 221, 221));
        jPanel1.add(txtsellprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 190, 90, 29));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(145, 90, 63));
        jLabel7.setText("Buy Price");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, -1, -1));

        txtbprice.setBackground(new java.awt.Color(221, 221, 221));
        jPanel1.add(txtbprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 110, 29));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(145, 90, 63));
        jLabel8.setText("Quantity");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));

        txtqty.setBackground(new java.awt.Color(221, 221, 221));
        jPanel1.add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 120, 29));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Create Itemm.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//add
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String itemno = lblitemid.getText();
        String itemname = txtname.getText();
        String itemdes = txtdes.getText();
        String sellprice = txtsellprice.getText();
        String buyprice = txtbprice.getText();
        String quantity = txtqty.getText();
       
        
        
        
        try {
            pst = con.prepareStatement("insert into item(itemid, itemname,description,sellprice, buyprice, qty)values(?,?,?,?,?,?)");
            
            pst.setString(1, itemno);
            pst.setString(2, itemname);
            pst.setString(3, itemdes);
            pst.setString(4, sellprice);
            pst.setString(5, buyprice);
            pst.setString(6, quantity);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Item Inserted.");
            
            AutoID();
            txtname.setText("");
            txtqty.setText("");
            txtsellprice.setText("");
            txtbprice.setText("");
            txtqty.setText("");
            
            txtname.requestFocus();
            
            Item_table();
       
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();
        
        lblitemid.setText(d1.getValueAt(SelectIndex, 0).toString());
        txtname.setText(d1.getValueAt(SelectIndex, 1).toString());
        txtdes.setText(d1.getValueAt(SelectIndex, 2).toString());
        txtsellprice.setText(d1.getValueAt(SelectIndex, 3).toString());
        txtbprice.setText(d1.getValueAt(SelectIndex, 4).toString());
        txtqty.setText(d1.getValueAt(SelectIndex, 5).toString());
       
        
        jButton1.setEnabled(false);
        
        
    }//GEN-LAST:event_jTable1MouseClicked
//update
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
        String itemname = txtname.getText();
        String itemdes = txtdes.getText();
        String sellprice = txtsellprice.getText();
        String buyprice = txtbprice.getText();
        String quantity = txtqty.getText();
        String itemno = lblitemid.getText();
        
        try {
            pst = con.prepareStatement("update item set itemname = ?, description = ?, sellprice = ?, buyprice = ?, qty = ? where itemid = ?");
            
            pst.setString(1, itemname);
            pst.setString(2, itemdes);
            pst.setString(3, sellprice);
            pst.setString(4, buyprice);
            pst.setString(5, quantity);
            pst.setString(6, itemno);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Item Updated.");
            
            AutoID();
            txtname.setText("");
            txtqty.setText("");
            txtsellprice.setText("");
            txtbprice.setText("");
            txtqty.setText("");
            
            txtname.requestFocus();
            
            Item_table();
            } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_jButton3ActionPerformed
//delete
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           
        
            String itemno = lblitemid.getText();
        
        try {
            pst = con.prepareStatement("delete from item where itemid = ?");
          
            
            pst.setString(1, itemno);
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Item Deleted.");
            
            AutoID();
            txtname.setText("");
            txtqty.setText("");
            txtsellprice.setText("");
            txtbprice.setText("");
            txtqty.setText("");
            
            Item_table();
           
            } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Item().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblitemid;
    private javax.swing.JTextField txtbprice;
    private javax.swing.JTextField txtdes;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtsellprice;
    // End of variables declaration//GEN-END:variables
}

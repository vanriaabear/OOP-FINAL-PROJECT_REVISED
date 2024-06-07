
package GUI;


import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;


public class Inventory extends javax.swing.JFrame {

    
    public Inventory() {
        initComponents();
    }
    String pnoo;
    String npno;
    
    public Inventory(String pno) {
        initComponents();
        Connect();
        this.pnoo = pno;
        
        npno = pnoo;
        
        lblpid.setText(npno);
        
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
    
    
    
    public void sales()
    {
        
        
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String date = d.format(now);
        
        
        String subtot = txtcost.getText();
        String pay = txtpay.getText();
        String balance = txtbal.getText();
        
        int lastinsertedid = 0;
        
        String query = "insert into sales (date, subtotal, pay, balance) values (?,?,?,?)";
        
        try {
            pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, date);
            pst.setString(2, subtot);
            pst.setString(3, pay);
            pst.setString(4, balance);
            
            pst.executeUpdate();
            
            rs = pst.getGeneratedKeys();
            
            if (rs.next()) {
                
                lastinsertedid = rs.getInt(1);
                
            }
            
            int rows = jTable1.getColumnCount();
            
            String query1 = "insert into sale_product(sales_id, prod_id, sellprice, qty, total) values (?,?,?,?,?)";
            pst = con.prepareStatement(query1);
            String pres_id;
            String item_id;
            String item_name;
            int price;
            String qty;
            
            int total = 0;
            
            for (int i = 0; i<jTable1.getRowCount();i++) {
                
                pres_id = (String) jTable1.getValueAt(i, 0);
                item_id = (String) jTable1.getValueAt(i, 1);
                
                
                qty = jTable1.getValueAt(i, 3).toString();
                int qty1 = Integer.parseInt(qty);
                
                price = (int) jTable1.getValueAt(i, 4);
                total = (int) jTable1.getValueAt(i, 5);

                
                pst.setInt(1, lastinsertedid);
                pst.setString(2, item_id);
                pst.setInt(3, price);
                pst.setInt(4, qty1);
                pst.setInt(5, total);
                
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Record Saved.");

            }
            
            

        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        update = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblpid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtqty = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txtcost = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtpay = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtbal = new javax.swing.JTextField();
        backbutton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Sales");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Presciption ID", "Drug Code", "Drug Name", "Quantity", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 860, 230));

        update.setBackground(new java.awt.Color(204, 204, 204));
        update.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        update.setText("Sales Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 39));

        add.setBackground(new java.awt.Color(51, 102, 255));
        add.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, -1, 31));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Prescription ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        lblpid.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblpid.setForeground(new java.awt.Color(0, 0, 102));
        lblpid.setText("jLabel6");
        jPanel1.add(lblpid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Drug Code");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        txtcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodeKeyPressed(evt);
            }
        });
        jPanel1.add(txtcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 182, 31));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Drug Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 180, 31));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Quantity");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, -1, -1));
        jPanel1.add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 120, 31));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Total Cost");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));
        jPanel1.add(txtcost, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 182, 31));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Pay");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));
        jPanel1.add(txtpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 100, 31));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 204));
        jLabel9.setText("Balance");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, -1, -1));
        jPanel1.add(txtbal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 110, 31));

        backbutton.setBackground(new java.awt.Color(153, 153, 153));
        backbutton.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        backbutton.setForeground(new java.awt.Color(255, 255, 255));
        backbutton.setText("Back");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(backbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, -1, 31));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/NAMOCATSCATS (928 x 502 px).png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodeKeyPressed
       
      if (evt.getKeyCode() == KeyEvent.VK_ENTER ) {
          
       String dcode = txtcode.getText();
       
          try {
              pst = con.prepareStatement("SELECT * from item where itemid = ?");
              pst.setString(1, dcode);
              rs = pst.executeQuery();
              
              if(rs.next() == false) {
                  
                  
                  JOptionPane.showMessageDialog(this, "Drug not found");  
              } else {
                  
                  String dname = rs.getString("itemname");
                  txtname.setText(dname.trim());
                  txtqty.requestFocus();
                  
              }
          } catch (SQLException ex) {
              Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
          }
      
      }
    
    }//GEN-LAST:event_txtcodeKeyPressed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        
        String dcode = txtcode.getText();
        try {
            pst = con.prepareStatement("Select * from item where itemid = ?");
            pst.setString(1, dcode);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                
                int currentqty;
                int sellprice;
                int qty;
                
                currentqty = rs.getInt("qty");
                sellprice = rs.getInt("sellprice");
                
                qty = Integer.parseInt(txtqty.getValue().toString());
                
                int tot = sellprice* qty;
                
                
                
                
                
                if (qty >= currentqty) {
                    JOptionPane.showMessageDialog(this, "Available Item." + currentqty);
                    JOptionPane.showMessageDialog(this, "Quantity not enough.");

                } else {
                    
                    DefaultTableModel DF = (DefaultTableModel)jTable1.getModel();
                    DF.addRow(new Object [] {
                        
                        lblpid.getText(),
                        txtcode.getText(),
                        txtname.getText(),
                        txtqty.getValue().toString(),
                        sellprice,
                        
                      
                        tot,
                        
                    });
                    int sum = 0;
                    
                    for(int i = 0; i <jTable1.getRowCount(); i++){
                        
                        
                        sum = sum + Integer.parseInt(jTable1.getValueAt(i, 5).toString());
                     
                    }
                    
                    txtcost.setText(Integer.toString(sum));
                    txtcode.setText("");
                    txtname.setText("");
                    txtqty.setValue(0);
                    txtcode.requestFocus();
    
                    
                }

            }
          

        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
        
        int pay = (Integer.parseInt(txtpay.getText()));
        int totcost = (Integer.parseInt(txtcost.getText()));
        
        int bal = pay - totcost;
        
        txtbal.setText(String.valueOf(bal));
        
        sales();
        
        
    }//GEN-LAST:event_updateActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        
    }//GEN-LAST:event_backbuttonActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton backbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblpid;
    private javax.swing.JTextField txtbal;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtcost;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpay;
    private javax.swing.JSpinner txtqty;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

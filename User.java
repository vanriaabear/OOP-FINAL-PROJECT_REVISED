
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;


public class User extends javax.swing.JFrame {

    
    public User() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    Connection con;
    PreparedStatement pst;
    
    public void Connect() 
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/nmchospital", "root", "");
      
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null,ex );
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        txtusertype = new javax.swing.JComboBox<>();
        cancelbutton = new javax.swing.JButton();
        jButton_create = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("User Type");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 70, -1));

        txtname.setBackground(new java.awt.Color(226, 226, 226));
        txtname.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 274, 33));

        txtusername.setBackground(new java.awt.Color(226, 226, 226));
        txtusername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 274, 33));

        txtpassword.setBackground(new java.awt.Color(226, 226, 226));
        txtpassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 274, 33));

        txtusertype.setBackground(new java.awt.Color(226, 226, 226));
        txtusertype.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtusertype.setForeground(new java.awt.Color(0, 153, 255));
        txtusertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pharmacist", "Doctor", "Receptionist" }));
        txtusertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusertypeActionPerformed(evt);
            }
        });
        jPanel1.add(txtusertype, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 274, 33));

        cancelbutton.setBackground(new java.awt.Color(255, 102, 102));
        cancelbutton.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        cancelbutton.setForeground(new java.awt.Color(255, 255, 255));
        cancelbutton.setText("Cancel");
        cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 110, 38));

        jButton_create.setBackground(new java.awt.Color(38, 132, 226));
        jButton_create.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton_create.setForeground(new java.awt.Color(255, 255, 255));
        jButton_create.setText("Create");
        jButton_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_createActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_create, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 110, 38));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(31, 102, 208));
        jLabel1.setText("Create Account");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 200, 32));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Backgroundd  (995 x 524 px) (940 x 500 px) (1014 x 510 px).png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jButton_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_createActionPerformed
        
        String name = txtname.getText();
        String username = txtusername.getText();
        String password = txtpassword.getText();
        String usertype = txtusertype.getSelectedItem().toString();
        
        Connect();
        
        try {
            pst = con.prepareStatement("insert into user(name, username, password,usertype)values(?,?,?,?)");
       
        pst.setString(1, name );
        pst.setString(2, username );
        pst.setString(3, password );
        pst.setString(4, usertype);
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "User Inserted.");
        
        txtname.setText("");
        txtusername.setText("");
        txtpassword.setText("");
        txtusertype.setSelectedIndex(-1);
        txtname.requestFocus();
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
    }//GEN-LAST:event_jButton_createActionPerformed

    private void cancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbuttonActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_cancelbuttonActionPerformed

    private void txtusertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusertypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusertypeActionPerformed

    
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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbutton;
    private javax.swing.JButton jButton_create;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    private javax.swing.JComboBox<String> txtusertype;
    // End of variables declaration//GEN-END:variables
}

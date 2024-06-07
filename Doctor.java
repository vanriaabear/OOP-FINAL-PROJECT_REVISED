
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


public class Doctor extends javax.swing.JFrame {

    
    public Doctor() {
        initComponents();
        setLocationRelativeTo(null);
        
        
        
    }
    int id;
    String uctype;
    
    int newid;
    
    public Doctor(int id, String utype) {
        initComponents();
        
        this.id = id;
        this.uctype = utype;
        
        newid = id;
        
      
        
        Connect();
        AutoID();
        
        Doctor_table();
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
            rs = s.executeQuery("Select MAX(doctorlicenseno) from doctor");
            rs.next();
            rs.getString("MAX(doctorlicenseno)");
            
            if(rs.getString("MAX(doctorlicenseno)") == null)
            {
                
                lbldno.setText("MD000001");
                
            } else {
                
                
                long id = Long.parseLong(rs.getString("MAX(doctorlicenseno)").substring(2,rs.getString("MAX(doctorlicenseno)").length()));
                id++; 
                
                lbldno.setText("MD"+String.format("%03d", id));
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
  
   }
   
   
   public void Doctor_table() {
       
        try {
            pst = con.prepareStatement("select * from doctor where log_id = ?");
            pst.setInt(1, newid);
            rs = pst.executeQuery();
            ResultSetMetaData Rsm = rs.getMetaData();
            int c;   
            c = Rsm.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            
            while (rs.next()) {
                Vector v2 = new Vector();
                
                for(int i = 1; i<=c; i++){
                
                v2.add(rs.getString("doctorno"));
                v2.add(rs.getString("name"));
                v2.add(rs.getString("special"));
                v2.add(rs.getString("qualification"));
                v2.add(rs.getString("channelfee"));
                v2.add(rs.getString("phone"));
                v2.add(rs.getString("room"));
                } 
                
                df.addRow(v2);
            } 

        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        lbldno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtdname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtspl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtqul = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtchfee = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtroom = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(24, 110, 194));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, -1, 31));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 220, -1, 31));

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, -1, 31));

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, -1, 31));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DoctorNo.", "Doctor Name", "Specialization", "Qualification", "Channel fee", "Phone", "Room No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 930, 200));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Doctor Registration");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 180, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(47, 79, 177));
        jLabel1.setText("Doctor License No.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        lbldno.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        lbldno.setForeground(new java.awt.Color(47, 79, 177));
        lbldno.setText("jLabel5");
        jPanel1.add(lbldno, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 152, 24));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(47, 79, 177));
        jLabel2.setText("Doctor Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));
        jPanel1.add(txtdname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 209, 31));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(47, 79, 177));
        jLabel4.setText("Specialization");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));
        jPanel1.add(txtspl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 209, 31));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(47, 79, 177));
        jLabel6.setText("Qualification");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, -1));
        jPanel1.add(txtqul, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 209, 31));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(47, 79, 177));
        jLabel7.setText("Channel Fee");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));
        jPanel1.add(txtchfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 209, 31));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(47, 79, 177));
        jLabel3.setText("Phone");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, -1, -1));
        jPanel1.add(txtphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 209, 31));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(47, 79, 177));
        jLabel8.setText("Room No.");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, -1, -1));
        jPanel1.add(txtroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, -1, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Backgroundd (1074 x 547 px) (1).png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -3, -1, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//add
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String dno = lbldno.getText();
        String dname = txtdname.getText();
        String spl = txtspl.getText();
        String qul = txtqul.getText();
        String chfee = txtchfee.getText();
        String phone = txtphone.getText();
        String room = txtroom.getValue().toString();
       
        
          if (!phone.matches("\\d{11}"))
           
       {
           
           JOptionPane.showMessageDialog(this, "Please enter 11-digit numeric phone number", "Phone Number Error", JOptionPane.WARNING_MESSAGE);
           return;
           
       }
        
         try {
            pst = con.prepareStatement("insert into doctor(doctorno, name, special, qualification, channelfee, phone, room, log_id)values(?,?,?,?,?,?,?,?)");
            
            pst.setString(1, dno);
            pst.setString(2, dname);
            pst.setString(3, spl);
            pst.setString(4, qul);
            pst.setString(5, chfee);
            pst.setString(6, phone);
            pst.setString(7, room);
            pst.setInt(8, newid);
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this,"Doctor Inserted.");
            
            AutoID();
            txtdname.setText("");
            txtspl.setText("");
            txtqul.setText("");
            txtchfee.setText("");
            txtphone.setText("");
            txtroom.setValue(0);
            txtdname.requestFocus();
            Doctor_table();
    
            
        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();
        
        lbldno.setText(d1.getValueAt(SelectIndex, 0).toString());
        txtdname.setText(d1.getValueAt(SelectIndex, 1).toString());
        txtspl.setText(d1.getValueAt(SelectIndex, 2).toString());
        txtqul.setText(d1.getValueAt(SelectIndex, 3).toString());
        txtchfee.setText(d1.getValueAt(SelectIndex, 4).toString());
        txtphone.setText(d1.getValueAt(SelectIndex, 5).toString());
        txtroom.setValue(Integer.parseInt(d1.getValueAt(SelectIndex, 6).toString()));
        
        
        jButton1.setEnabled(false);
        
        
    }//GEN-LAST:event_jTable1MouseClicked
//update
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String dno = lbldno.getText();
        String dname = txtdname.getText();
        String spl = txtspl.getText();
        String qul = txtqul.getText();
        String chfee = txtchfee.getText();
        String phone = txtphone.getText();
        String room = txtroom.getValue().toString();
       
        
          if (!phone.matches("\\d{11}"))
           
       {
           
           JOptionPane.showMessageDialog(this, "Please enter 11-digit numeric phone number", "Phone Number Error", JOptionPane.WARNING_MESSAGE);
           return;
           
       }
        
         try {
            pst = con.prepareStatement("update doctor set name = ?,special = ?, qualification = ?,channelfee=?, phone = ?, room = ? where doctorno = ?");
            
            pst.setString(1, dname);
            pst.setString(2, spl);
            pst.setString(3, qul);
            pst.setString(4, chfee);
            pst.setString(5, phone);
            pst.setString(6, room);
            pst.setString(7, dno);
            
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this,"Doctor Updated.");
            
            AutoID();
            txtdname.setText("");
            txtspl.setText("");
            txtqul.setText("");
            txtchfee.setText("");
            txtphone.setText("");
            txtroom.setValue(0);
            txtdname.requestFocus();
            Doctor_table();
            jButton1.setEnabled(true);
             
            } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
//delete
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String dno = lbldno.getText();
       
       
       
        
         try {
            pst = con.prepareStatement("delete from doctor where doctorno = ?");
            pst.setString(1, dno);
            
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this,"Doctor information deleted.");
            
            AutoID();
            txtdname.setText("");
            txtspl.setText("");
            txtqul.setText("");
            txtchfee.setText("");
            txtphone.setText("");
            txtroom.setValue(0);
            txtdname.requestFocus();
            Doctor_table();
            jButton1.setEnabled(true);
             
            } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbldno;
    private javax.swing.JTextField txtchfee;
    private javax.swing.JTextField txtdname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtqul;
    private javax.swing.JSpinner txtroom;
    private javax.swing.JTextField txtspl;
    // End of variables declaration//GEN-END:variables
}

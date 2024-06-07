
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Channel extends javax.swing.JFrame {

    
    public Channel() {
        initComponents();
        Connect();
        AutoID();
        LoadDoctor();
        LoadPatient ();
        Channel_table();
        
      
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String chno;
    
    
    public class Doctor {
        String id;
        String name;
        
     
    public Doctor (String id, String name)  {
        
        this.id = id;
        this.name = name;
    }
    
    public String toString() {
        return name;
     }    
    }
  
    
    public class Patient {
        String id;
        String name;
        
     
    public Patient (String id, String name)  {
        
        this.id = id;
        this.name = name;
    }
    
    public String toString() {
        return name;
     }    
    }
  
    
    public void LoadPatient () {
        
        try {
            pst = con.prepareStatement("Select * from patient");
            rs = pst.executeQuery();
            txtpatient.removeAll();
            
            
            while (rs.next()) {
                
                txtpatient.addItem(new Patient(rs.getString(1),rs.getString(2)));
    
            }
       
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null,ex );
        }
        
        
    }
   
    
    public void LoadDoctor () {
        
        try {
            pst = con.prepareStatement("Select * from Doctor");
            rs = pst.executeQuery();
            txtdoctor.removeAll();
            
            
            while (rs.next()) {
                
                txtdoctor.addItem(new Doctor(rs.getString(1),rs.getString(2)));
           
            }
       
            
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null,ex );
        }
        
        
    }
  
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
    
    
   public void AutoID() {
   try {
            Statement s = con.createStatement();
            rs = s.executeQuery("Select MAX(channelno) from newestchannel");
            rs.next();
            rs.getString("MAX(channelno)");
            
            if(rs.getString("MAX(channelno)") == null)
            {
                
                lblchno.setText("CH001");
                
            } else {
                
                
                long id = Long.parseLong(rs.getString("MAX(channelno)").substring(2,rs.getString("MAX(channelno)").length()));
                id++; 
                
                lblchno.setText("CH"+String.format("%03d", id));
            }
                
              
            
        } catch (SQLException ex) {
            Logger.getLogger(GUI.Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   }
   
   
   public void patient_table() {
       
        try {
            pst = con.prepareStatement("select * from patient");
            rs = pst.executeQuery();
            ResultSetMetaData Rsm = rs.getMetaData();
            int c;   
            c = Rsm.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            
            while (rs.next()) {
                Vector v2 = new Vector();
                
                for(int i = 1; i<=c; i++){
                
                v2.add(rs.getString("patientno"));
                 v2.add(rs.getString("name"));
                  v2.add(rs.getString("phone"));
                   v2.add(rs.getString("address"));
                } 
                
                df.addRow(v2);
            } 
      
        } catch (SQLException ex) {
            Logger.getLogger(GUI.Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public void Channel_table() {
       
        try {
            pst = con.prepareStatement("select * from newestchannel");
            
            rs = pst.executeQuery();
            ResultSetMetaData Rsm = rs.getMetaData();
            int c;   
            c = Rsm.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            
            
            while (rs.next()) {
                Vector v2 = new Vector();
                
                for(int i = 1; i<=c; i++){
                
                v2.add(rs.getString("channelno"));
                v2.add(rs.getString("doctorname"));
                v2.add(rs.getString("patientname"));
                v2.add(rs.getString("roomno"));
                v2.add(rs.getString("date"));
                
                } 
                
                df.addRow(v2);
            } 
          
        } catch (SQLException ex) {
            Logger.getLogger(GUI.Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
   }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblchno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtdoctor = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtpatient = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtroom = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        createbutton = new javax.swing.JButton();
        cancelbutton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        backbutton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 51, 0)));
        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Channel No.", "Doctor Name", "Patient Name", "Room No.", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 400, 400));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(108, 71, 54));
        jLabel1.setText("Channel No.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        lblchno.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        lblchno.setForeground(new java.awt.Color(108, 71, 54));
        lblchno.setText("jLabel6");
        jPanel1.add(lblchno, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 75, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(108, 71, 54));
        jLabel2.setText("Doctor Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, -1, -1));

        txtdoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdoctorActionPerformed(evt);
            }
        });
        jPanel1.add(txtdoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 176, 38));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(108, 71, 54));
        jLabel3.setText("Patient Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, -1, -1));

        txtpatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpatientActionPerformed(evt);
            }
        });
        jPanel1.add(txtpatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 182, 38));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(108, 71, 54));
        jLabel5.setText("Room No.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, -1));
        jPanel1.add(txtroom, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 176, 38));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(108, 71, 54));
        jLabel4.setText("Channel Date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, -1));
        jPanel1.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 176, 38));

        createbutton.setBackground(new java.awt.Color(115, 87, 67));
        createbutton.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        createbutton.setForeground(new java.awt.Color(255, 255, 255));
        createbutton.setText("Create");
        createbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(createbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, -1, 30));

        cancelbutton.setBackground(new java.awt.Color(255, 102, 0));
        cancelbutton.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        cancelbutton.setForeground(new java.awt.Color(255, 255, 255));
        cancelbutton.setText("Cancel");
        cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, -1, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(108, 71, 54));
        jLabel6.setText("Schedule Registration");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 240, 30));

        backbutton.setBackground(new java.awt.Color(153, 153, 153));
        backbutton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        backbutton.setForeground(new java.awt.Color(255, 255, 255));
        backbutton.setText("Back");
        backbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(backbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, -1, 30));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Backgroundd (967 x 530 px) (3).png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
//create
    private void createbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createbuttonActionPerformed
       
        String chno = lblchno.getText();
        
        Doctor d = (Doctor) txtdoctor.getSelectedItem();
        Patient p  = (Patient) txtpatient.getSelectedItem();
        String room = txtroom.getValue().toString();
        
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateformat.format(txtdate.getDate());
   
        
         try {
            pst = con.prepareStatement("insert into newestchannel(channelno, doctorname, patientname, roomno, date)values(?,?,?,?,?)");
            
            pst.setString(1, chno);
            pst.setString(2, d.id);
            pst.setString(3, p.id);
            pst.setString(4, room);
            pst.setString(5, date);
            
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this,"Channel Created.");
            
            AutoID();
            lblchno.setText("");
            txtdoctor.setSelectedIndex(-1);
            txtpatient.setSelectedIndex(-1);
            txtroom.setValue(0);
            
            Channel_table();
            
      
        } catch (SQLException ex) {
            Logger.getLogger(GUI.Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_createbuttonActionPerformed
//cancel
    private void cancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbuttonActionPerformed
     
     try {
            pst = con.prepareStatement("delete from newestchannel where channelno = ?");
            
            pst.setString(1, chno);
           
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this,"Channel Deleted.");
            
            AutoID();
            lblchno.setText("");
            txtdoctor.setSelectedIndex(-1);
            txtpatient.setSelectedIndex(-1);
            txtroom.setValue(0);
            
            Channel_table();
            
         
        } catch (SQLException ex) {
            Logger.getLogger(GUI.Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }   
   
        
    }//GEN-LAST:event_cancelbuttonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        chno = d1.getValueAt(selectIndex, 0).toString();
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtdoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdoctorActionPerformed
      
    }//GEN-LAST:event_txtdoctorActionPerformed

    private void txtpatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpatientActionPerformed

    private void backbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbuttonActionPerformed
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
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Channel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Channel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backbutton;
    private javax.swing.JButton cancelbutton;
    private javax.swing.JButton createbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblchno;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JComboBox txtdoctor;
    private javax.swing.JComboBox txtpatient;
    private javax.swing.JSpinner txtroom;
    // End of variables declaration//GEN-END:variables

}

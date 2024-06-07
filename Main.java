package GUI;


public class Main extends javax.swing.JFrame {

   
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
      
    }
    
    int idd;
    
    String uctype;
    int newid;
    String uname;
    String usertype;
    
    public Main(int id, String username, String usertype) {
        initComponents();
        
        this.uname = username;
        jLabel5.setText(uname);
        
        this.usertype = usertype;
        jLabel6.setText(usertype);
        
        this.newid = id;
        
        idd = newid;
        
        
         uctype = jLabel6.getText();
        
        if (uctype.equals("Doctor"))
        {
         jButton_patient.setEnabled(false);
         jButton_createChannel.setEnabled(false);
         
          jButton_createItem.setEnabled(false);
          jButton_createUser.setEnabled(false);
          reports.setVisible(true);
          jButton_doctor.setEnabled(true);
         }
        else if(uctype.equals("Receptionist")) {
            jButton_doctor.setEnabled(false);
            jButton_viewPrescription.setEnabled(false);
            reports.setEnabled(false);
            jButton_createChannel.setEnabled(true);

        }
     else if(uctype.equals("Pharmacist")){
                jButton_patient.setEnabled(false);
                jButton_doctor.setEnabled(false);
                jButton_createChannel.setEnabled(false);
                jButton_viewChannel.setEnabled(false);
                jButton_createUser.setEnabled(false);
                reports.setEnabled(true);

     }
}
            
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_doctor = new javax.swing.JButton();
        jButton_patient = new javax.swing.JButton();
        jButton_createChannel = new javax.swing.JButton();
        jButton_viewChannel = new javax.swing.JButton();
        jButton_viewPrescription = new javax.swing.JButton();
        jButton_createItem = new javax.swing.JButton();
        jButton_createUser = new javax.swing.JButton();
        jButton_viewDoctor = new javax.swing.JButton();
        jButton_LogOut = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        reports = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(776, 141, -1, -1));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(794, 108, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 90, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 100, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 255));
        jLabel3.setText("username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 80, 20));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("user type");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 73, 20));

        jButton_doctor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_doctor.setText("Doctor");
        jButton_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_doctorActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 130, 40));

        jButton_patient.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_patient.setText("Patient");
        jButton_patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_patientActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 130, 40));

        jButton_createChannel.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jButton_createChannel.setText("Create Schedule");
        jButton_createChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_createChannelActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_createChannel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 130, 40));

        jButton_viewChannel.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton_viewChannel.setText("View Schedule");
        jButton_viewChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_viewChannelActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_viewChannel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 130, 40));

        jButton_viewPrescription.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton_viewPrescription.setText("View Prescription");
        jButton_viewPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_viewPrescriptionActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_viewPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 140, 40));

        jButton_createItem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_createItem.setText("Create Item");
        jButton_createItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_createItemActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_createItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 130, 40));

        jButton_createUser.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_createUser.setText("Create User");
        jButton_createUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_createUserActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_createUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 130, 40));

        jButton_viewDoctor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_viewDoctor.setText("View Doctor");
        jButton_viewDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_viewDoctorActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_viewDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 130, 40));

        jButton_LogOut.setBackground(new java.awt.Color(204, 204, 204));
        jButton_LogOut.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jButton_LogOut.setText("Log Out");
        jButton_LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LogOutActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 510, 100, 40));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 102, -1, -1));

        reports.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        reports.setText("Reports");
        reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportsActionPerformed(evt);
            }
        });
        jPanel1.add(reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 240, 130, 40));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/MAIN FINAL.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LogOutActionPerformed

        Login l = new Login();
        this.setVisible(false);
        l.setVisible(true);
    }//GEN-LAST:event_jButton_LogOutActionPerformed

    private void jButton_viewPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_viewPrescriptionActionPerformed

        viewPrescription v = new viewPrescription();
        v.setVisible(true);
    }//GEN-LAST:event_jButton_viewPrescriptionActionPerformed

    private void jButton_createUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_createUserActionPerformed

        User u = new User();
        u.setVisible(true);
    }//GEN-LAST:event_jButton_createUserActionPerformed

    private void jButton_createItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_createItemActionPerformed

        Item i = new Item();

        i.setVisible(true);
    }//GEN-LAST:event_jButton_createItemActionPerformed

    private void jButton_viewChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_viewChannelActionPerformed

        new viewChannel (idd).setVisible(true);
    }//GEN-LAST:event_jButton_viewChannelActionPerformed

    private void jButton_createChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_createChannelActionPerformed
            Channel ch = new Channel();
            ch.setVisible(true);
        
    }//GEN-LAST:event_jButton_createChannelActionPerformed

    private void jButton_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_doctorActionPerformed

        if(uctype.equals("Doctor")) {

            new Doctor(idd,uctype).setVisible(true);

        }
    }//GEN-LAST:event_jButton_doctorActionPerformed

    private void jButton_patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_patientActionPerformed
        Patient p = new Patient();
        p.setVisible(true);
    }//GEN-LAST:event_jButton_patientActionPerformed

    private void reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsActionPerformed
        Report r = new Report();
        r.setVisible(true);
        
        
    }//GEN-LAST:event_reportsActionPerformed

    private void jButton_viewDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_viewDoctorActionPerformed
        viewDoctor vd = new viewDoctor();
        vd.setVisible(true);
    }//GEN-LAST:event_jButton_viewDoctorActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_LogOut;
    private javax.swing.JButton jButton_createChannel;
    private javax.swing.JButton jButton_createItem;
    private javax.swing.JButton jButton_createUser;
    private javax.swing.JButton jButton_doctor;
    private javax.swing.JButton jButton_patient;
    private javax.swing.JButton jButton_viewChannel;
    private javax.swing.JButton jButton_viewDoctor;
    private javax.swing.JButton jButton_viewPrescription;
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
    private javax.swing.JButton reports;
    // End of variables declaration//GEN-END:variables
}

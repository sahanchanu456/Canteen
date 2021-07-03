/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.User;
import sesion.HibernateUtil;
import sesion.HibernateUtil1;

/**
 *
 * @author G I U S Chamika
 */
public class upemailotpvali extends javax.swing.JFrame {

    int userid=0;
    String uemail=null;
    public upemailotpvali(int uid, String email ) {
        initComponents();
        this.userid=uid;
        this.uemail=email;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2kk = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17hy = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        error7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(78, 148, 148));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Check You Email And Enter Otp");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 390, 30));

        jTextField2kk.setBackground(new java.awt.Color(78, 148, 148));
        jTextField2kk.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jTextField2kk.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2kk.setBorder(null);
        jTextField2kk.setOpaque(false);
        jPanel6.add(jTextField2kk, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 410, 30));
        jPanel6.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 400, 10));

        jLabel14.setBackground(new java.awt.Color(102, 102, 102));
        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jLabel14.setText("Team");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 90, 30));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Copyright ©2021 All rights reserved | This Design is made by ");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 330, 30));

        jLabel17hy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17hy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nowlog.png"))); // NOI18N
        jLabel17hy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17hyMouseClicked(evt);
            }
        });
        jPanel6.add(jLabel17hy, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 150, 60));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Otp:");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 140, 30));

        error7.setBackground(new java.awt.Color(0, 204, 204));
        error7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        error7.setForeground(new java.awt.Color(255, 0, 0));
        jPanel6.add(error7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 400, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel17hyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17hyMouseClicked
        Session session=null;
        int otpstate=0;
        String otp = jTextField2kk.getText();
        if(!otp.isEmpty()){
            
            session=HibernateUtil1.getSessionFactory().openSession();
            Transaction tx=session.beginTransaction();
            String user_sql="FROM User";
            Query user_quary=session.createQuery(user_sql);

            java.util.List <User>userList=user_quary.list();
                for(Iterator<User> userIterator=userList.iterator();userIterator.hasNext();){
                    User user=userIterator.next();
                    if(user.getUserId().equals(userid)){
                        if(user.getUserOtp().equals(otp)){
                            user.setUserEmail(uemail);
                            session.save(user);
                            tx.commit();
                            session.close();
                            this.setVisible(false);
                            Profile pro=new Profile();
                            
                        }else{
                            otpstate=1;
                        }
                    }
                }
            if(otpstate==1){
                error7.setText("wrong Otp !");
            }
        }else{
            error7.setText("Otp is Emty !");
        }
  
    }//GEN-LAST:event_jLabel17hyMouseClicked

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
            java.util.logging.Logger.getLogger(upemailotpvali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(upemailotpvali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(upemailotpvali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(upemailotpvali.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new upemailotpvali(0,"No").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error7;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17hy;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField2kk;
    // End of variables declaration//GEN-END:variables
}

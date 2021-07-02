/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Random;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Reglist;
import pojo.User;
import sesion.HibernateUtil;


/**
 *
 * @author G I U S Chamika
 */
public class LogReg2 extends javax.swing.JFrame {

    /**
     * Creates new form LogReg
     */
    static Session session=null;
    static Session session2=null;
    static Session session3=null;
    
    public LogReg2() {
        initComponents();
    }
    //email validate
    static boolean isValid(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        uname = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        emailtext = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        pwds = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/set02.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/set01.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/set03.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(78, 148, 148));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/up.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 151, 60));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/in.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, 60));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 140, 30));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registration No");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 140, 30));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 140, 30));

        jTextField1.setBackground(new java.awt.Color(78, 148, 148));
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 204, 204));
        jTextField1.setText("Enter TG Number");
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 410, 30));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 400, 10));

        uname.setBackground(new java.awt.Color(78, 148, 148));
        uname.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        uname.setForeground(new java.awt.Color(204, 204, 204));
        uname.setText("Enter Username");
        uname.setBorder(null);
        uname.setOpaque(false);
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        jPanel4.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 410, 30));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 400, 10));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 400, 10));

        emailtext.setBackground(new java.awt.Color(78, 148, 148));
        emailtext.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        emailtext.setForeground(new java.awt.Color(204, 204, 204));
        emailtext.setText("Enter Email");
        emailtext.setBorder(null);
        emailtext.setOpaque(false);
        emailtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtextActionPerformed(evt);
            }
        });
        jPanel4.add(emailtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 410, 30));
        jPanel4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 400, 10));

        pwds.setBackground(new java.awt.Color(78, 148, 148));
        pwds.setForeground(new java.awt.Color(204, 204, 204));
        pwds.setText("8 character");
        pwds.setBorder(null);
        pwds.setOpaque(false);
        pwds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdsActionPerformed(evt);
            }
        });
        jPanel4.add(pwds, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 400, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Password");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 140, 30));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Already have a");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 90, 30));

        jLabel14.setBackground(new java.awt.Color(102, 102, 102));
        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jLabel14.setText("Team");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 90, 30));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Account?");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 90, 30));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 3, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Copyright ©2021 All rights reserved | This Design is made by ");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 330, 30));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reg.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 150, 60));

        error.setBackground(new java.awt.Color(0, 204, 204));
        error.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 84, 410, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

    private void emailtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtextActionPerformed

    private void pwdsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdsActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.setVisible(false);
         new LogReg("No").setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        this.setVisible(false);
         new LogReg("No").setVisible(true);
    }//GEN-LAST:event_jLabel15MouseClicked
   
    //user register 
    public static void regUser(User e){
        session3=HibernateUtil.getSessionFactory().openSession();
        Transaction tx3=session3.beginTransaction();
        session3.save(e);
        tx3.commit();
        session3.close();
    }
    
    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        String error_note=null;
        String regNo=null;
        String regNane=null;
        String regadd=null;
        String regstate=null;
        int regval=0;
        int usenreguse=0;
        
        String reno=jTextField1.getText();
        String un=uname.getText();
        String emails=emailtext.getText();
        String pass=pwds.getText();
        //emty
        if((!reno.isEmpty() && !reno.equals("Enter Tg Number")) && (!un.isEmpty() && !un.equals("Enter Username")) && (!emails.isEmpty() && !emails.equals("Enter Email")) && (!pass.isEmpty() && !pass.equals("8 character"))){
            //regno validate real one use reglist tabel
            session=HibernateUtil.getSessionFactory().openSession();
            Transaction tx=session.beginTransaction();
            String reglist_sql="FROM Reglist";
            Query reglist_quary=session.createQuery(reglist_sql);
            
            java.util.List <Reglist>regNumList=reglist_quary.list();
            for(Iterator<Reglist> regIterator=regNumList.iterator();regIterator.hasNext();){
                Reglist reglist=regIterator.next();
                
                if (reglist.getReglistRgId().equals(jTextField1.getText())){
                      regval=1;
                      regNo=reglist.getReglistRgId();
                      regNane=reglist.getReglistName();
                      regadd=reglist.getReglistAddress();
                      regstate=reglist.getReglistState();
                }
             }           
            //username an regNo validate
            session2=HibernateUtil.getSessionFactory().openSession();
            Transaction tx2=session2.beginTransaction();
            String user_sql="FROM User";
            Query user_quary=session2.createQuery(user_sql);

            java.util.List <User>userList=user_quary.list();
              for(Iterator<User> userIterator=userList.iterator();userIterator.hasNext();){
               User user=userIterator.next();

                  if (user.getUserName().equals(uname.getText()) || (user.getUserReg().equals(jTextField1.getText()))){
                      usenreguse=1;
                  }
               }
            // up validation check 
            if(regval==1){
                if(usenreguse==0){
                    //validate email
                    String email = emailtext.getText();
                    boolean frt=true;                   
                    if (frt == isValid(email)){ 
                        //validate pass
                        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
                        boolean pwdval=pwds.getText().matches(pattern);
                        if (pwdval == true){
                            //encrip pwd
                            String generatedPassword = null;
                            try {

                                MessageDigest md = MessageDigest.getInstance("MD5");
                                md.update(pwds.getText().getBytes());
                                byte[] bytes = md.digest();
                                StringBuilder sb = new StringBuilder();
                                for(int i=0; i< bytes.length ;i++)
                                {
                                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                                }
                                generatedPassword = sb.toString();
                            } 
                            catch (NoSuchAlgorithmException e) 
                            {
                                e.printStackTrace();
                            }
                            //otp maker
                            String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));
                            //add user
                            User e=new User(regNo, regNane, uname.getText(), generatedPassword, emailtext.getText(), regadd, regstate, otp, "No", "No");
                            regUser(e);
                            
                            this.setVisible(false);
                            new EmailValidate(regNo).setVisible(true);
                        }else{
                          error_note="Password Invalid (set strong one)!";
                        }
                    }else{
                      error_note="Email is Invalid !";
                    }
                }else{
                    error_note="You'r Uasrname or Registration number Already use !";
                }  
            }else{
                error_note="Invalid Registration Number !";
            }
              
            tx.commit();
            session.close();
            tx2.commit();
            session2.close();
        }else{
            error_note="Some Field/s Empty !";
        }
        error.setText(error_note);
    }//GEN-LAST:event_jLabel17MouseClicked

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
            java.util.logging.Logger.getLogger(LogReg2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogReg2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogReg2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogReg2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogReg2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailtext;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField pwds;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}

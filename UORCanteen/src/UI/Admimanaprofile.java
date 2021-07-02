/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.mysql.jdbc.CallableStatement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.User;
import sesion.HibernateUtil;

/**
 *
 * @author G I U S Chamika
 */
public class Admimanaprofile extends javax.swing.JInternalFrame {

    /**
     * Creates new form adhome
     */
    int loguser;
    String selectregid;
    String selectitemidu =null;
    public Admimanaprofile() {
        initComponents();
        
        loguser=Adminlog.adminLlogid;
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
       Session session=null;
        session=HibernateUtil.getSessionFactory().openSession();
        final AtomicReference<ResultSet> itemid=new AtomicReference<>();
        session.doWork(connection->{
            try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call getusedata(?)}")){
                cst.setInt(1, loguser);
                cst.execute();
                itemid.set(cst.getResultSet());
                try(ResultSet rs =cst.getResultSet()){
                    while(rs.next()){
                        String fname=rs.getString("user_full_name");
                        jLabel7.setText(fname);
                        String regno=rs.getString("user_reg");
                        jLabel4.setText(regno);
                        String email=rs.getString("user_email");
                        jLabel6.setText(email);
                        String tno=rs.getString("user_tel");
                        jLabel5.setText(tno);
                        edittel.setText(tno);
                        String un=rs.getString("user_name");
                        fnamer.setText(un);
                        unameedit.setText(un);
                    }
                }
            }
        });
            
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
        jLabel2 = new javax.swing.JLabel();
        fnamer = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fnamer1uyi = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        unameedit = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        passc1 = new javax.swing.JPasswordField();
        passw2 = new javax.swing.JPasswordField();
        eroorlod56 = new javax.swing.JLabel();
        eroorlod5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        edittel = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 102));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(867, 526));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 234, 230, 20));

        fnamer.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        fnamer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fnamer.setText("G I U S Chamika");
        fnamer.setFocusable(false);
        fnamer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fnamer.setIconTextGap(2);
        fnamer.setInheritsPopupMenu(false);
        jPanel1.add(fnamer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 270, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/male_user.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 118, 108));

        jLabel4.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TG/2017/262");
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setIconTextGap(2);
        jLabel4.setInheritsPopupMenu(false);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 270, 30));

        jLabel5.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("0770609547");
        jLabel5.setFocusable(false);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setIconTextGap(2);
        jLabel5.setInheritsPopupMenu(false);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 270, 20));

        jLabel6.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Email@gmail.com");
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setIconTextGap(2);
        jLabel6.setInheritsPopupMenu(false);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 270, 30));

        jLabel7.setFont(new java.awt.Font("Lucida Console", 1, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Username");
        jLabel7.setFocusable(false);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setIconTextGap(2);
        jLabel7.setInheritsPopupMenu(false);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 270, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/userdetails.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 460));

        fnamer1uyi.setBackground(new java.awt.Color(51, 255, 204));
        fnamer1uyi.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        fnamer1uyi.setForeground(new java.awt.Color(0, 204, 204));
        fnamer1uyi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fnamer1uyi.setText("Update User Details");
        fnamer1uyi.setFocusable(false);
        fnamer1uyi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fnamer1uyi.setIconTextGap(2);
        fnamer1uyi.setInheritsPopupMenu(false);
        jPanel1.add(fnamer1uyi, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 270, 30));

        jLabel18.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("User name :");
        jLabel18.setFocusable(false);
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel18.setIconTextGap(2);
        jLabel18.setInheritsPopupMenu(false);
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 120, 20));

        unameedit.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        unameedit.setForeground(new java.awt.Color(204, 204, 204));
        unameedit.setText("Enter Username");
        unameedit.setBorder(null);
        unameedit.setOpaque(false);
        unameedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameeditActionPerformed(evt);
            }
        });
        jPanel1.add(unameedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 350, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 340, 10));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/submit.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, 30, 30));

        passc1.setForeground(new java.awt.Color(204, 204, 204));
        passc1.setBorder(null);
        jPanel1.add(passc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 340, 20));

        passw2.setForeground(new java.awt.Color(204, 204, 204));
        passw2.setBorder(null);
        jPanel1.add(passw2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 284, 340, -1));

        eroorlod56.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        eroorlod56.setForeground(new java.awt.Color(255, 51, 0));
        eroorlod56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        eroorlod56.setFocusable(false);
        eroorlod56.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eroorlod56.setIconTextGap(2);
        eroorlod56.setInheritsPopupMenu(false);
        jPanel1.add(eroorlod56, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 370, 10));

        eroorlod5.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        eroorlod5.setForeground(new java.awt.Color(51, 204, 0));
        eroorlod5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        eroorlod5.setFocusable(false);
        eroorlod5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eroorlod5.setIconTextGap(2);
        eroorlod5.setInheritsPopupMenu(false);
        jPanel1.add(eroorlod5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 370, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 340, 10));

        jLabel14.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Password (Conform):");
        jLabel14.setFocusable(false);
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.setIconTextGap(2);
        jLabel14.setInheritsPopupMenu(false);
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 200, 20));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 340, 10));

        jLabel12.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("TelNo :");
        jLabel12.setFocusable(false);
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setIconTextGap(2);
        jLabel12.setInheritsPopupMenu(false);
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 110, 20));

        edittel.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        edittel.setForeground(new java.awt.Color(204, 204, 204));
        edittel.setText("xxx-xxxxxxx");
        edittel.setBorder(null);
        edittel.setOpaque(false);
        edittel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edittelActionPerformed(evt);
            }
        });
        jPanel1.add(edittel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 350, 30));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 340, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/submit.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 30, 30));

        jLabel13.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Password (New):");
        jLabel13.setFocusable(false);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel13.setIconTextGap(2);
        jLabel13.setInheritsPopupMenu(false);
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 120, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edituser.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 450, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unameeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameeditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameeditActionPerformed

    private void edittelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edittelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edittelActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Session session2 =null;
        String upun=unameedit.getText();
        String uptel=edittel.getText();
        if(upun.isEmpty() && uptel.isEmpty()){
            eroorlod56.setText("Both of filds emty Not Update !");
        }else{
            if(!upun.isEmpty()){
               if(!uptel.isEmpty()){
                    String regex="\\d{3}-\\d{7}";
                    if(uptel.matches(regex)==true && !uptel.equals("000-0000000")){ 
                        int unupstate=0;
                        //username an regNo validate
                         session2=HibernateUtil.getSessionFactory().openSession();
                         Transaction tx2=session2.beginTransaction();
                         String user_sql="FROM User";
                         Query user_quary=session2.createQuery(user_sql);

                         java.util.List <User>userList=user_quary.list();
                           for(Iterator<User> userIterator=userList.iterator();userIterator.hasNext();){
                            User user=userIterator.next();

                               if (!user.getUserName().equals(upun)){


                               }else{
                                   unupstate=1;
                               }
                            }
                         if(unupstate==1){
                             eroorlod56.setText("Sorry User name Already use !");
                             eroorlod5.setText("");
                         }else{
                             Session session3=null;
                             session3=HibernateUtil.getSessionFactory().openSession();
                             final AtomicReference<ResultSet> itemid=new AtomicReference<>();
                             session3.doWork(connection->{
                                  try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call updateud1(?,?,?)}")){
                                      cst.setInt(1, loguser);
                                      cst.setString(2, upun); 
                                      cst.setString(3, uptel);
                                      cst.execute();
                                      eroorlod5.setText("Update Successful..");
                                      eroorlod56.setText("");
                                  }
                              });
                             
                             Session session=null;
                                session=HibernateUtil.getSessionFactory().openSession();
                                final AtomicReference<ResultSet> itemid5=new AtomicReference<>();
                                session.doWork(connection->{
                                    try(CallableStatement cst5=(CallableStatement) connection.prepareCall("{call getusedata(?)}")){
                                        cst5.setInt(1, loguser);
                                        cst5.execute();
                                        itemid.set(cst5.getResultSet());
                                        try(ResultSet rs5 =cst5.getResultSet()){
                                            while(rs5.next()){
                                                String fname=rs5.getString("user_full_name");
                                                jLabel7.setText(fname);
                                                String regno=rs5.getString("user_reg");
                                                jLabel4.setText(regno);
                                                String email=rs5.getString("user_email");
                                                jLabel6.setText(email);
                                                String tno=rs5.getString("user_tel");
                                                jLabel5.setText(tno);
                                                edittel.setText(tno);
                                                String un=rs5.getString("user_name");
                                                fnamer.setText(un);
                                                unameedit.setText(un);
                                            }
                                        }
                                    }
                                });
                         }
                    }else{
                        eroorlod56.setText("Invalid Tel NO !");
                        eroorlod5.setText("");
                    } 
                }else{
                    eroorlod56.setText("User Tel NO is empty Not Update !");
                    eroorlod5.setText("");
                } 
            }else{
                eroorlod56.setText("User name is empty Not Update !");
                eroorlod5.setText("");
            }
        }

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        
        String pass=passc1.getText();
        String passc=passw2.getText();
        
        if(!pass.isEmpty() && !passc.isEmpty()){
            String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
            boolean pwdval1=pass.matches(pattern);
            boolean pwdval2=passc.matches(pattern);
            if (pwdval1 == true && pwdval2 == true){
                if (pass.equals(passc)){
                    //encrip pwd
                    String generatedPassword2 = null;
                        try {

                            MessageDigest md = MessageDigest.getInstance("MD5");
                            md.update(pass.getBytes());
                            byte[] bytes = md.digest();
                            StringBuilder sb = new StringBuilder();
                            for(int i=0; i< bytes.length ;i++){
                                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                            }
                            generatedPassword2 = sb.toString();
                        } 
                           catch (NoSuchAlgorithmException e) 
                        {
                            e.printStackTrace();
                        }
                           
                            Session session4=null;
                            session4=HibernateUtil.getSessionFactory().openSession();
                            Transaction tx=session4.beginTransaction();
                            String reglist_sql="FROM User";
                            Query reglist_quary=session4.createQuery(reglist_sql);

                            java.util.List <User>regNumList=reglist_quary.list();
                            for(Iterator<User> regIterator=regNumList.iterator();regIterator.hasNext();){
                                User user=regIterator.next();

                                if(user.getUserId()== loguser){
                                        
                                        user.setUserPassword(generatedPassword2);
                                        session4.save(user);
                                        tx.commit();
                                        session4.close();

                                       eroorlod56.setText("");
                                       eroorlod5.setText("Password update Successful");
                                }
                            }        
                            
                }else{
                    eroorlod56.setText("conform password is incorect !");
                    eroorlod5.setText("");
                }        
            }else{
                eroorlod56.setText("Passwors Invalid (set srtong one) !");
                eroorlod5.setText("");
            }                
        }else{
            eroorlod56.setText("Field/s Empty fill two pssword fields !");
            eroorlod5.setText("");
        }
        
    }//GEN-LAST:event_jLabel17MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField edittel;
    private javax.swing.JLabel eroorlod5;
    private javax.swing.JLabel eroorlod56;
    private javax.swing.JLabel fnamer;
    private javax.swing.JLabel fnamer1uyi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPasswordField passc1;
    private javax.swing.JPasswordField passw2;
    private javax.swing.JTextField unameedit;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ClassSet.EmailSend;
import static UI.LogReg2.isValid;
import com.mysql.jdbc.CallableStatement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
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
public class feedback extends javax.swing.JInternalFrame {

   int loguser=LogReg.Lloguserid;
   
    public feedback() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        Session session=null;
        session=HibernateUtil1.getSessionFactory().openSession();
        final AtomicReference<ResultSet> itemid=new AtomicReference<>();
        session.doWork(connection->{
            try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call getusedata(?)}")){
                cst.setInt(1, loguser);
                cst.execute();
                itemid.set(cst.getResultSet());
                try(ResultSet rs =cst.getResultSet()){
                    while(rs.next()){
                        fnamer.setText(rs.getString("user_full_name"));
                        jLabel4.setText(rs.getString("user_reg"));
                        
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

        jPanel4 = new javax.swing.JPanel();
        eroorlod57 = new javax.swing.JLabel();
        eroorlod56 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        fnamer4 = new javax.swing.JLabel();
        fnamer3 = new javax.swing.JLabel();
        fnamer2 = new javax.swing.JLabel();
        fnamer1 = new javax.swing.JLabel();
        fnamer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(819, 526));
        setPreferredSize(new java.awt.Dimension(819, 526));

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eroorlod57.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        eroorlod57.setForeground(new java.awt.Color(51, 204, 0));
        eroorlod57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eroorlod57.setFocusable(false);
        eroorlod57.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eroorlod57.setIconTextGap(2);
        eroorlod57.setInheritsPopupMenu(false);
        jPanel4.add(eroorlod57, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 710, 20));

        eroorlod56.setFont(new java.awt.Font("Lucida Console", 0, 11)); // NOI18N
        eroorlod56.setForeground(new java.awt.Color(255, 51, 0));
        eroorlod56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        eroorlod56.setFocusable(false);
        eroorlod56.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eroorlod56.setIconTextGap(2);
        eroorlod56.setInheritsPopupMenu(false);
        jPanel4.add(eroorlod56, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 710, 10));

        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setSelectionColor(new java.awt.Color(0, 153, 153));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 540, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setSelectionColor(new java.awt.Color(0, 153, 153));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 540, 150));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/submit.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 30, 30));

        fnamer4.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        fnamer4.setText("Feedback :");
        fnamer4.setFocusable(false);
        fnamer4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fnamer4.setIconTextGap(2);
        fnamer4.setInheritsPopupMenu(false);
        jPanel4.add(fnamer4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 90, 30));

        fnamer3.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        fnamer3.setText("Title :");
        fnamer3.setFocusable(false);
        fnamer3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fnamer3.setIconTextGap(2);
        fnamer3.setInheritsPopupMenu(false);
        jPanel4.add(fnamer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 90, 30));

        fnamer2.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        fnamer2.setText("User :");
        fnamer2.setFocusable(false);
        fnamer2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fnamer2.setIconTextGap(2);
        fnamer2.setInheritsPopupMenu(false);
        jPanel4.add(fnamer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 90, 30));

        fnamer1.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        fnamer1.setForeground(new java.awt.Color(0, 204, 204));
        fnamer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fnamer1.setText("Feedback");
        fnamer1.setFocusable(false);
        fnamer1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fnamer1.setIconTextGap(2);
        fnamer1.setInheritsPopupMenu(false);
        jPanel4.add(fnamer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 270, 30));

        fnamer.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        fnamer.setText("G I U S Chamika");
        fnamer.setFocusable(false);
        fnamer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fnamer.setIconTextGap(2);
        fnamer.setInheritsPopupMenu(false);
        jPanel4.add(fnamer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 530, 30));

        jLabel4.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        jLabel4.setText("TG/2017/262");
        jLabel4.setFocusable(false);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setIconTextGap(2);
        jLabel4.setInheritsPopupMenu(false);
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 530, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/feedall.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 770, 460));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/feedall.png"))); // NOI18N
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 770, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        String feedtitle = jTextField1.getText();
        String Feednote = jTextArea1.getText();
        
        if(!feedtitle.isEmpty() && !Feednote.isEmpty()){
                Session session5=null;
                session5=HibernateUtil1.getSessionFactory().openSession();
                final AtomicReference<ResultSet> feed=new AtomicReference<>();
                session5.doWork(connection->{
                  try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call addfeed(?,?,?)}")){
                    cst.setInt(1, loguser);
                    cst.setString(2, feedtitle); 
                    cst.setString(3, Feednote);
                    cst.execute();
                    
                    eroorlod57.setText("Feedback Successful send !");
                    eroorlod56.setText("");
                  }
                });  
        }else{
            eroorlod56.setText("Some fields Empty !");
            eroorlod57.setText("");
        }
        
    }//GEN-LAST:event_jLabel15MouseClicked

   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eroorlod56;
    private javax.swing.JLabel eroorlod57;
    private javax.swing.JLabel fnamer;
    private javax.swing.JLabel fnamer1;
    private javax.swing.JLabel fnamer2;
    private javax.swing.JLabel fnamer3;
    private javax.swing.JLabel fnamer4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

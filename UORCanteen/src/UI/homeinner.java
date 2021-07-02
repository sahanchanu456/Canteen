/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static UI.LogReg2.isValid;
import com.mysql.jdbc.CallableStatement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.User;
import sesion.HibernateUtil;

/**
 *
 * @author G I U S Chamika
 */
public class homeinner extends javax.swing.JInternalFrame {

   int loguser=LogReg.Lloguserid;
   String nowhover=null;
   int orderitemId =0;
    public homeinner() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        Date thisDate=new Date();
        SimpleDateFormat hover=new SimpleDateFormat("hh a");
        nowhover=hover.format(thisDate);
        
        if(nowhover.equals("06 AM") || nowhover.equals("07 AM") || nowhover.equals("08 AM") || nowhover.equals("09 AM") || nowhover.equals("10 AM")){
            String itemcatatype="Breakfast";
            Session session=null;
            session=HibernateUtil.getSessionFactory().openSession();
            final AtomicReference<ResultSet> catagory=new AtomicReference<>();
            session.doWork(connection->{
                try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call gethomemaim(?)}")){
                    cst.setString(1, itemcatatype);
                    cst.execute();
                    catagory.set(cst.getResultSet());
                    try(ResultSet rs =cst.getResultSet()){
                        while(rs.next()){
                            jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource(rs.getString("item_img"))));
                            jLabel9.setText(rs.getString("item_catagory")+" NOW Available");
                            jLabel10.setText("Rs: "+rs.getString("item_price")+"/-");
                            orderitemId=rs.getInt("item_id");
                           
                        }
                    }
                }
            });
    
            
        }else{
            if(nowhover.equals("11 AM") || nowhover.equals("12 PM") || nowhover.equals("01 PM") ||nowhover.equals("02 PM") || nowhover.equals("03 PM")){
                String itemcatatype="Lunch";
                Session session=null;
                session=HibernateUtil.getSessionFactory().openSession();
                final AtomicReference<ResultSet> catagory=new AtomicReference<>();
                session.doWork(connection->{
                    try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call gethomemaim(?)}")){
                        cst.setString(1, itemcatatype);
                        cst.execute();
                        catagory.set(cst.getResultSet());
                        try(ResultSet rs =cst.getResultSet()){
                            while(rs.next()){
                                jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource(rs.getString("item_img"))));
                                jLabel9.setText(rs.getString("item_catagory")+" NOW Available");
                                jLabel10.setText("Rs: "+rs.getString("item_price")+"/-");
                                orderitemId=rs.getInt("item_id");

                            }
                        }
                    }
                });
            }else{
             if(nowhover.equals("05 PM") || nowhover.equals("06 PM") || nowhover.equals("07 PM") ||nowhover.equals("08 PM")){
                String itemcatatype="Dinner";
                Session session=null;
                session=HibernateUtil.getSessionFactory().openSession();
                final AtomicReference<ResultSet> catagory=new AtomicReference<>();
                session.doWork(connection->{
                    try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call gethomemaim(?)}")){
                        cst.setString(1, itemcatatype);
                        cst.execute();
                        catagory.set(cst.getResultSet());
                        try(ResultSet rs =cst.getResultSet()){
                            while(rs.next()){
                                jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource(rs.getString("item_img"))));
                                jLabel9.setText(rs.getString("item_catagory")+" NOW Avaliable");
                                jLabel10.setText("Rs: "+rs.getString("item_price")+"/-");
                                orderitemId=rs.getInt("item_id");

                            }
                        }
                    }
                });
             }else{
                 jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menulunchimg.png")));
                 jLabel9.setText("Not Available NOW");
                 jLabel10.setText("Rs: 000/-");
                 orderitemId=0;
             }
            }
        }
        
        
        
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel201 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(819, 526));
        setPreferredSize(new java.awt.Dimension(819, 526));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, 480));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fotlogo.png"))); // NOI18N
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 130, 80));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ruhlogo.png"))); // NOI18N
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 200, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/info.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, 40));

        jLabel6.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hometext.png"))); // NOI18N
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setIconTextGap(2);
        jLabel6.setInheritsPopupMenu(false);
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 510, 210));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homeimg.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 340, 220));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/set03.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 520, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/homeleft.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 530, 510));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 530));

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel201.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(255, 0, 0));
        jLabel201.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel201.setFocusable(false);
        jLabel201.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel201.setIconTextGap(2);
        jLabel201.setInheritsPopupMenu(false);
        jPanel4.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 80));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enter.png"))); // NOI18N
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 80, 80));

        jLabel125.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(0, 204, 204));
        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel125.setText("Order Now");
        jLabel125.setFocusable(false);
        jLabel125.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel125.setIconTextGap(2);
        jLabel125.setInheritsPopupMenu(false);
        jPanel4.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 80));

        jLabel10.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 204, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Rs: 100.00");
        jLabel10.setFocusable(false);
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setIconTextGap(2);
        jLabel10.setInheritsPopupMenu(false);
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 170, 30));

        jLabel9.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Lunch NOW Available");
        jLabel9.setFocusable(false);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setIconTextGap(2);
        jLabel9.setInheritsPopupMenu(false);
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 240, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menulunchimg.png"))); // NOI18N
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 120));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menulunchup.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 210));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menulunchdown.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 250, 80));

        jLabel11.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Lunch NOW Avalabel");
        jLabel11.setFocusable(false);
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setIconTextGap(2);
        jLabel11.setInheritsPopupMenu(false);
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 170, 20));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 280, 320));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/enter2.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 80, 50));

        jLabel16.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Go Canteen");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 50));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addcanteen.png"))); // NOI18N
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, 90));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addcanteenback.png"))); // NOI18N
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 170));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 280, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        
        if(orderitemId!=0){
            new orderform(orderitemId).setVisible(true);
        }else{
            jLabel125.setText("");
            jLabel201.setText("Sorry No Item");
        }
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
         
       
    }//GEN-LAST:event_jLabel17MouseClicked

    //email validate
    static boolean isValid(String email) {
      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
      return email.matches(regex);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}

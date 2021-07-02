/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ClassSet.EmailSend;
import static UI.LogReg.session;
import com.mysql.jdbc.CallableStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableColumnModel;
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
public class ordersumm extends javax.swing.JInternalFrame {

   int loguser= LogReg.Lloguserid;
   int count =0;
   String selectorderid =null;
    public ordersumm() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        Session session=null;
            session=HibernateUtil.getSessionFactory().openSession();
            final AtomicReference<ResultSet> order=new AtomicReference<>();
            session.doWork(connection->{
                try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call summorbill(?)}")){
                    cst.setInt(1, loguser);
                    cst.execute();
                    order.set(cst.getResultSet());
                    try(ResultSet rs =cst.getResultSet()){
                        while(rs.next()){
                            count=count+1;
                            String id = rs.getString("neworder_id");
                            String date=rs.getString("neworder_date");
                            String food=rs.getString("item_name");
                            String quntit=rs.getString("neworder_quntity");
                            String price=rs.getString("item_price");
                            String deli=rs.getString("deliver_name");
                            String dlitel=rs.getString("neworder_state");
                            String countSrt=String.valueOf(count);
                            String tbData[] = {countSrt,food,date,quntit,price,deli,dlitel,id};
                            DefaultTableModel tblm = (DefaultTableModel) jTable45.getModel();
                            tblm.addRow(tbData);
                           
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable45 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(819, 526));
        setPreferredSize(new java.awt.Dimension(819, 526));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, 480));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(0, 255, 255));

        jTable45.setBackground(new java.awt.Color(115, 204, 204));
        jTable45.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTable45.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Item", "Date", "Quantity", "Price", "Deliver", "Order State", "ord num"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable45.setGridColor(new java.awt.Color(0, 204, 204));
        jTable45.setSelectionBackground(new java.awt.Color(0, 153, 153));
        jTable45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable45MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable45);
        if (jTable45.getColumnModel().getColumnCount() > 0) {
            jTable45.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable45.getColumnModel().getColumn(7).setMinWidth(0);
            jTable45.getColumnModel().getColumn(7).setPreferredWidth(0);
            jTable45.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 780, 260));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 760, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 760, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Date ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 190, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Total ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 200, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Item ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 200, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Date :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 40, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Total :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Item :");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/summord.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 780, 200));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 780, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int Total = 0;
     int Total2 = 0;
    private void jTable45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable45MouseClicked
        
      DefaultTableModel dmodel = (DefaultTableModel) jTable45.getModel();
      int selectindex = jTable45.getSelectedRow();
      
       selectorderid = dmodel.getValueAt(selectindex, 7).toString();
       Session session2=null;
            session2=HibernateUtil.getSessionFactory().openSession();
            final AtomicReference<ResultSet> selordr=new AtomicReference<>();
            session2.doWork(connection->{
                try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call selectbilldata(?)}")){
                    cst.setString(1, selectorderid);
                    cst.execute();
                    selordr.set(cst.getResultSet());
                    try(ResultSet rs =cst.getResultSet()){
                        while(rs.next()){
                            
                            jLabel3.setText(rs.getString("item_name"));
                            jLabel1.setText(rs.getString("neworder_date"));
                            int price =rs.getInt("item_price");
                            int qun =rs.getInt("neworder_quntity");
                            Total = (price * qun);
                            jLabel2.setText("Rs: "+Total+"/-");
                            if(rs.getString("neworder_state").equals("Reseve")){
                                jLabel9.setText(rs.getString("neworder_state"));
                                jLabel7.setText("");
                            }else{
                                jLabel7.setText(rs.getString("neworder_state"));
                                jLabel9.setText("");
                            }
                        }
                    }
                }
            });
    }//GEN-LAST:event_jTable45MouseClicked
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable45;
    // End of variables declaration//GEN-END:variables
}

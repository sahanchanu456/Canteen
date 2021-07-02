/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.mysql.jdbc.CallableStatement;
import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import sesion.HibernateUtil;

/**
 *
 * @author G I U S Chamika
 */
public class Adhome extends javax.swing.JInternalFrame {

    /**
     * Creates new form adhome
     */
    public Adhome() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        Session session4=null;
            session4=HibernateUtil.getSessionFactory().openSession();
            final AtomicReference<ResultSet> order2=new AtomicReference<>();
            session4.doWork(connection->{
                try(CallableStatement cst2=(CallableStatement) connection.prepareCall("{call getitemdaly(?)}")){
                    cst2.setString(1, "dayc");
                    cst2.execute();
                    order2.set(cst2.getResultSet());
                    try(ResultSet rs2 =cst2.getResultSet()){
                        while(rs2.next()){
                            if(rs2.getString("SUM(total)")==null){
                                jLabel13.setText("RS: 0.00/-");
                            }else{
                                jLabel13.setText("RS: "+rs2.getString("SUM(total)")+"/-");
                            }
                           
                        }
                    }
                }
            });
            
            Session session5=null;
            session5=HibernateUtil.getSessionFactory().openSession();
            final AtomicReference<ResultSet> order3=new AtomicReference<>();
            session5.doWork(connection->{
                try(CallableStatement cst4=(CallableStatement) connection.prepareCall("{call getitemdaly(?)}")){
                    cst4.setString(1, "monc");
                    cst4.execute();
                    order3.set(cst4.getResultSet());
                    try(ResultSet rs4 =cst4.getResultSet()){
                        while(rs4.next()){
                           if(rs4.getString("SUM(total)")==null){
                               jLabel10.setText("RS: 0.00/-");
                           }else{ 
                                jLabel10.setText("RS: "+rs4.getString("SUM(total)")+"/-");
                           }
                        }
                    }
                }
            });
            
            Session session6=null;
            session6=HibernateUtil.getSessionFactory().openSession();
            final AtomicReference<ResultSet> order6=new AtomicReference<>();
            session6.doWork(connection->{
                try(CallableStatement cst6=(CallableStatement) connection.prepareCall("{call getordercount()}")){
                    cst6.execute();
                    order6.set(cst6.getResultSet());
                    try(ResultSet rs6 =cst6.getResultSet()){
                        while(rs6.next()){
                            
                           jLabel16.setText(rs6.getString("COUNT(neworder_id)")+" Items");
                           
                        }
                    }
                }
            });
        
        
        Session session=null;
            session=HibernateUtil.getSessionFactory().openSession();
            final AtomicReference<ResultSet> order=new AtomicReference<>();
            session.doWork(connection->{
                try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call getitemdaly(?)}")){
                    cst.setString(1, "day");
                    cst.execute();
                    order.set(cst.getResultSet());
                    try(ResultSet rs =cst.getResultSet()){
                        while(rs.next()){
                            
                            String name = rs.getString("item_name");
                            String catagory=rs.getString("item_catagory");
                            String price=rs.getString("item_price");
                            String quntity=rs.getString("sold qun");
                            String total=rs.getString("total");
                            
                            
                            String tbData[] = {name, catagory, price, quntity, total};
                            DefaultTableModel tblm = (DefaultTableModel) jTable62.getModel();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable62 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 102));
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(867, 526));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/set03.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 760, 60));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adhomeup.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 850, 80));

        jTable62.setBackground(new java.awt.Color(0, 204, 204));
        jTable62.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Item Catagory", "Price", "Quntity", "Total"
            }
        ));
        jTable62.setGridColor(new java.awt.Color(0, 204, 204));
        jTable62.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jScrollPane1.setViewportView(jTable62);
        if (jTable62.getColumnModel().getColumnCount() > 0) {
            jTable62.getColumnModel().getColumn(2).setMinWidth(100);
            jTable62.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable62.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable62.getColumnModel().getColumn(3).setMinWidth(100);
            jTable62.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable62.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable62.getColumnModel().getColumn(4).setMinWidth(100);
            jTable62.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable62.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 831, 226));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delivery_63px.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 78, 118));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("New Order");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 130, 23));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 110, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendar_2_65px.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 78, 118));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Daly Revenue");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 130, 23));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 120, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 120, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Monthly Revenue");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 28, 130, 23));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/important_month_70px.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 11, 78, 118));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adhomedown.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 11, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adhomedown.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 11, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/adhomedown.png"))); // NOI18N
        jLabel5.setText("jLabel2");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 11, 212, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 850, 140));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("Month By");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 50, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setText("Day By");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 40, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
//       jTable62.setModel(new DefaultTableModel(null,new String[]{"Item Name", "Item Catagory", "Price", "Quntity", "Total"}));
        jTable62.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Item Catagory", "Price", "Quntity", "Total"
            }
        ));
        if (jTable62.getColumnModel().getColumnCount() > 0) {
            jTable62.getColumnModel().getColumn(2).setMinWidth(100);
            jTable62.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable62.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable62.getColumnModel().getColumn(3).setMinWidth(100);
            jTable62.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable62.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable62.getColumnModel().getColumn(4).setMinWidth(100);
            jTable62.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable62.getColumnModel().getColumn(4).setMaxWidth(100);
        }
        Session session1=null;
            session1=HibernateUtil.getSessionFactory().openSession();
            final AtomicReference<ResultSet> order=new AtomicReference<>();
            session1.doWork(connection->{
                try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call getitemdaly(?)}")){
                    cst.setString(1, "day");
                    cst.execute();
                    order.set(cst.getResultSet());
                    try(ResultSet rs =cst.getResultSet()){
                        while(rs.next()){
                            
                            String name = rs.getString("item_name");
                            String catagory=rs.getString("item_catagory");
                            String price=rs.getString("item_price");
                            String quntity=rs.getString("sold qun");
                            String total=rs.getString("total");
                            
                            
                            String tbData[] = {name, catagory, price, quntity, total};
                            DefaultTableModel tblm = (DefaultTableModel) jTable62.getModel();
                            tblm.addRow(tbData);
                           
                        }
                    }
                }
            });
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        
        jTable62.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Item Catagory", "Price", "Quntity", "Total"
            }
        ));
        if (jTable62.getColumnModel().getColumnCount() > 0) {
            jTable62.getColumnModel().getColumn(2).setMinWidth(100);
            jTable62.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable62.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable62.getColumnModel().getColumn(3).setMinWidth(100);
            jTable62.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable62.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable62.getColumnModel().getColumn(4).setMinWidth(100);
            jTable62.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable62.getColumnModel().getColumn(4).setMaxWidth(100);
        }
        Session session2=null;
            session2=HibernateUtil.getSessionFactory().openSession();
            final AtomicReference<ResultSet> order=new AtomicReference<>();
            session2.doWork(connection->{
                try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call getitemdaly(?)}")){
                    cst.setString(1, "mon");
                    cst.execute();
                    order.set(cst.getResultSet());
                    try(ResultSet rs =cst.getResultSet()){
                        while(rs.next()){
                            
                            String name = rs.getString("item_name");
                            String catagory=rs.getString("item_catagory");
                            String price=rs.getString("item_price");
                            String quntity=rs.getString("SUM(`sold qun`)");
                            String total=rs.getString("SUM(`total`)");
                            
                            
                            String tbData[] = {name, catagory, price, quntity, total};
                            DefaultTableModel tblm = (DefaultTableModel) jTable62.getModel();
                            tblm.addRow(tbData);
                           
                        }
                    }
                }
            });
        
    }//GEN-LAST:event_jLabel6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable62;
    // End of variables declaration//GEN-END:variables
}

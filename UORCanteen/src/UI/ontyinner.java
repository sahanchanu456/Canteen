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
import sesion.HibernateUtil1;



/**
 *
 * @author G I U S Chamika
 */
public class ontyinner extends javax.swing.JInternalFrame {

   int loguser= LogReg.Lloguserid;
   int count =0;
   
    public ontyinner() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        Session session=null;
            session=HibernateUtil1.getSessionFactory().openSession();
            final AtomicReference<ResultSet> order=new AtomicReference<>();
            session.doWork(connection->{
                try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call notydetails(?)}")){
                    cst.setInt(1, loguser);
                    cst.execute();
                    order.set(cst.getResultSet());
                    try(ResultSet rs =cst.getResultSet()){
                        while(rs.next()){
                            count=count+1;
                            
                            String title = rs.getString("notify_tital");
                            String date=rs.getString("notify_date");
                            String sate=rs.getString("notify_state");
                            String note=rs.getString("notify_note");
                            String id=rs.getString("notify_id");
                            
                            
                            String countSrt=String.valueOf(count);
                            String tbData[] = {countSrt,date,title,sate,note,id};
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
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(819, 526));
        setPreferredSize(new java.awt.Dimension(819, 526));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, 480));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(0, 255, 255));

        jTable45.setBackground(new java.awt.Color(181, 222, 222));
        jTable45.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTable45.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Date", "Title", "State", "note", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
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
            jTable45.getColumnModel().getColumn(0).setMinWidth(50);
            jTable45.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable45.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable45.getColumnModel().getColumn(1).setMinWidth(200);
            jTable45.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable45.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable45.getColumnModel().getColumn(3).setMinWidth(100);
            jTable45.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable45.getColumnModel().getColumn(3).setMaxWidth(100);
            jTable45.getColumnModel().getColumn(4).setMinWidth(0);
            jTable45.getColumnModel().getColumn(4).setPreferredWidth(0);
            jTable45.getColumnModel().getColumn(4).setMaxWidth(0);
            jTable45.getColumnModel().getColumn(5).setMinWidth(0);
            jTable45.getColumnModel().getColumn(5).setPreferredWidth(0);
            jTable45.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 780, 260));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 760, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 760, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 730, 120));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/summord.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 800, 200));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 780, 180));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int Total = 0;
    int Total2 = 0;
    private void jTable45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable45MouseClicked
        
      DefaultTableModel dmodel = (DefaultTableModel) jTable45.getModel();
      int selectindex = jTable45.getSelectedRow();
      
       String note = dmodel.getValueAt(selectindex, 4).toString();
       String notyid = dmodel.getValueAt(selectindex, 5).toString();
       jLabel8.setText(note);
       
       Session session2=null;
            session2=HibernateUtil1.getSessionFactory().openSession();
            final AtomicReference<ResultSet> selordr=new AtomicReference<>();
            session2.doWork(connection->{
                try(CallableStatement cst=(CallableStatement) connection.prepareCall("{call upnotystate(?)}")){
                    cst.setString(1, notyid);
                    cst.execute();
                    
                }
            });
    }//GEN-LAST:event_jTable45MouseClicked
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
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

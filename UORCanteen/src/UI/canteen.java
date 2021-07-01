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
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Item;
import pojo.User;
import sesion.HibernateUtil;



/**
 *
 * @author G I U S Chamika
 */
public class canteen extends javax.swing.JInternalFrame {

   int loguser= LogReg.Lloguserid;
   int count =0;
   String selectorderid =null;
    public canteen() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        session=HibernateUtil.getSessionFactory().openSession();
            Transaction tx=session.beginTransaction();
            String item_sql="FROM Item";
            Query item_quary=session.createQuery(item_sql);
            java.util.List <Item>itemList=item_quary.list();
                int count =0;
                int Labelelef = 10;
                int Labeldlef = 140;
                int Labelclef = 30;
                int Labelblef = 20;
                int Labelalef = 10;
                int Labelfalef = 60;
                
                int Labeletop = 10;
                int Labeldtop = 180;
                int Labelctop = 180;
                int Labelbtop = 150;
                int Labelatop = 20;
                int Labelfatop = 170;
                
                for(Iterator<Item> itemIterator=itemList.iterator();itemIterator.hasNext();){
                    Item item=itemIterator.next();
                    
                    if(count!=0 && count!=1 && count!=2 &&(count%3 == 0)){
                       Labeletop = Labeletop + 240;
                       Labeldtop = Labeldtop + 240;
                       Labelctop = Labelctop + 240;
                       Labelbtop = Labelbtop + 240;
                       Labelatop = Labelatop + 240;
                       Labelfatop = Labelfatop + 240;
                       
                        Labelelef = 10;
                        Labeldlef = 140;
                        Labelclef = 30;
                        Labelblef = 20;
                        Labelalef = 10;
                        Labelfalef = 60;
                    }
                    
                    int qun=item.getItemQuntity();
                    String state=item.getItemState();
                    if(qun != 0 && state.equals("Yes")){
                        JLabel jLabelfa = new JLabel();
                        JLabel jLabela = new JLabel();
                        JLabel jLabelb = new JLabel();
                        JLabel jLabelc = new JLabel();
                        JLabel jLabeld = new JLabel();
                        JLabel jLabele = new JLabel();

                        String itemid =String.valueOf(item.getItemId());

                         jLabelfa.setText(itemid);
                         jPanel3.add(jLabelfa, new org.netbeans.lib.awtextra.AbsoluteConstraints(Labelfalef, Labelfatop, 110, -1));
                         jLabelfa.setVisible(false);

                        jLabela.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        jLabela.setIcon(new javax.swing.ImageIcon(getClass().getResource(item.getItemImg()))); 
                        jPanel3.add(jLabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(Labelalef, Labelatop, 250, 120));

                        jLabelb.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
                        jLabelb.setForeground(new java.awt.Color(0, 204, 204));
                        jLabelb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        jLabelb.setText(item.getItemName()+"("+item.getItemCatagory()+")");
                        jLabelb.setFocusable(false);
                        jLabelb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                        jLabelb.setIconTextGap(2);
                        jLabelb.setInheritsPopupMenu(false);
                        jPanel3.add(jLabelb, new org.netbeans.lib.awtextra.AbsoluteConstraints(Labelblef, Labelbtop, 230, 20));

                        jLabelc.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
                        jLabelc.setForeground(new java.awt.Color(0, 204, 204));
                        jLabelc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        jLabelc.setText("Rs:"+item.getItemPrice());
                        jLabelc.setFocusable(false);
                        jLabelc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                        jLabelc.setIconTextGap(2);
                        jLabelc.setInheritsPopupMenu(false);
                        jPanel3.add(jLabelc, new org.netbeans.lib.awtextra.AbsoluteConstraints(Labelclef, Labelctop, 100, 30));

                        jLabeld.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
                        jLabeld.setForeground(new java.awt.Color(0, 204, 204));
                        jLabeld.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        jLabeld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/order btt.png"))); // NOI18N
                        jLabeld.setFocusable(false);
                        jLabeld.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                        jLabeld.setIconTextGap(2);
                        jLabeld.setInheritsPopupMenu(false);
                        jLabeld.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                               int itemseleid = Integer.parseInt(jLabelfa.getText());
                               new orderform(itemseleid).setVisible(true);
                            }
                        });
                        jPanel3.add(jLabeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(Labeldlef, Labeldtop, 100, 30));

                        jLabele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menulunchup.png"))); // NOI18N
                        jPanel3.add(jLabele, new org.netbeans.lib.awtextra.AbsoluteConstraints(Labelelef, Labeletop, 250, 210));

                        Labelelef = Labelelef + 260;
                        Labeldlef = Labeldlef + 260;
                        Labelclef = Labelclef + 260;
                        Labelblef = Labelblef + 260;
                        Labelalef = Labelalef + 260;
                        Labelfalef = Labelfalef + 260;
                        
                        
                        
                        count = count+1;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(819, 526));
        setPreferredSize(new java.awt.Dimension(819, 526));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanel3);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

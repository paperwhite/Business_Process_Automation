/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project1;

import java.awt.Label;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class StudentForms extends javax.swing.JFrame {

    
     String username;
    Connection c1;
     Statement stmt1;
     List<String> ids =new ArrayList<String>();
    /**
     * Creates new form StudentForms
     */
    public StudentForms() {
        initComponents();
    }
    
    
    public  void setVal(Connection c,String s)
    {
    username = s;
    c1 = c;
    System.out.println(username);
   DisplayValue();
    }
   Statement stmt2;
    public void DisplayValue()
          {
              
               try {
              stmt2=c1.createStatement();
               stmt2.executeQuery("use process");
                stmt1=c1.createStatement();
                 String q = "select access_a1.form_id as FORMS, form_a1.subject as SUBJECT from access_a1 JOIN form_a1 ON access_a1.form_id=form_a1.form_id where access_a1.access_id="+"'"+username+"';";
                 System.out.println(q);
                 ResultSet r1 = stmt1.executeQuery(q);
            int i=20,j=60;
                jTextArea1.append("FORMS    SUBJECT \n ");
                jTextArea1.append("\n"); 
            while(r1.next())
            {
                
                     System.out.println(username);
               
                String formid = r1.getString("FORMS");
                ids.add(formid);
                String subject = r1.getString("SUBJECT");
                jTextArea1.append(formid+":        "+subject);
                jTextArea1.append("\n");
                jTextArea1.setEditable(false);
                /*JLabel form=new JLabel(formid);
                JLabel sub = new JLabel(subject);
                form.setText(formid);
                sub.setText(subject);
                form.setLocation(i,j);
               sub.setLocation(i+100,j);
                form.setVisible(true);
                sub.setVisible(true);
                getContentPane().add(form);
                getContentPane().add(sub);
                getContentPane().setSize(230,230);
               
                j=j+100; */
                System.out.println(formid+ "" +subject);
            }
            stmt1.close();
        } catch (SQLException e) {
            System.out.println(e);
            // TODO add your handling code here:
    }  
          }    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

       
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("BACK");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                       ))
                .addComponent(jButton2)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>                        

    
                                         

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
        LoggedIn li = new LoggedIn();
        li.setVal(c1,username);
        li.setVisible(true);
        this.dispose();
        
        // TODO add your handling code here:
    }                                     

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
            java.util.logging.Logger.getLogger(StudentForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentForms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   

    
}
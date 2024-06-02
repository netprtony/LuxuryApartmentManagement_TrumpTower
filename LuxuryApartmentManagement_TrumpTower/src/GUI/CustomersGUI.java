/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.ApartmentDAO;
import DAO.CustomerDAO;
import MODEL.ApartmentModel;
import MODEL.CustomerModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author netprtony
 */
public class CustomersGUI extends javax.swing.JFrame {
    CustomerDAO cusDAO = new CustomerDAO();
    List<CustomerModel> lst = new ArrayList<>();
    DefaultTableModel tblModel  = new DefaultTableModel();
    int index = 0;
    public CustomersGUI() {
        initComponents();
        FillTableData();
    }

    public void FillTableData() {
        lst = cusDAO.readAll();
        tblModel = (DefaultTableModel) tbl_customer.getModel();
        tblModel.setRowCount(0);
        for (CustomerModel c : lst) {
            Object[] r = new Object[]{
                c.getId(),
                c.getName(),
                c.getBirth(),
                c.getHomeTower(),
                c.getGender(),
                c.getPhoneNumber(),
                c.getMail(),
                c.getNote(),
            };
            tblModel.addRow(r);                 
        }
        tbl_customer.setModel(tblModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tb_birth = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        tb_name = new javax.swing.JTextField();
        tb_hometower = new javax.swing.JTextField();
        cb_gender = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        tb_phone = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        tb_email = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_note = new javax.swing.JTextArea();
        bt_delete = new javax.swing.JButton();
        bt_add = new javax.swing.JButton();
        bt_change = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tb_id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_customer = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Properties"));

        jLabel1.setText("Name:");

        jLabel2.setText("Birth:");

        tb_birth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yyyy"))));

        jLabel3.setText("HomeTower:");

        cb_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", " " }));

        jLabel4.setText("Gender:");

        jLabel61.setText("Phone:");

        tb_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb_phoneActionPerformed(evt);
            }
        });

        jLabel62.setText("Email:");

        tb_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb_emailActionPerformed(evt);
            }
        });

        jLabel63.setText("Note:");

        tb_note.setColumns(20);
        tb_note.setRows(5);
        jScrollPane2.setViewportView(tb_note);

        bt_delete.setText("Xóa");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        bt_add.setText("Thêm");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });

        bt_change.setText("Sửa");
        bt_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_changeActionPerformed(evt);
            }
        });

        jLabel5.setText("ID:");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(bt_add)
                        .addGap(18, 18, 18)
                        .addComponent(bt_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_change))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel62)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel61))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tb_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tb_hometower)))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tb_id, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addComponent(tb_birth, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addComponent(tb_name, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tb_email)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tb_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tb_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tb_birth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tb_hometower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tb_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tb_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_add)
                    .addComponent(bt_delete)
                    .addComponent(bt_change))
                .addContainerGap())
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Customers"));

        tbl_customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Birth", "HomeTower", "Gender", "Phone", "Email", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_customerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_customer);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1317, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 33, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 34, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_phoneActionPerformed

    private void tb_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_emailActionPerformed
    public void clearForm(){
        tb_name.setText("");
        tb_birth.setText("");
        tb_hometower.setText("");
        tb_email.setText("");
        tb_phone.setText("");
        tb_note.setText("");
        tb_id.setText("");
    }
    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        CustomerModel c = new CustomerModel();
        c.setName(tb_name.getText());
        c.setBirth(tb_birth.getText());
        c.setHomeTower(tb_hometower.getText());
        c.setGender(cb_gender.getSelectedItem() + "");
        c.setMail(tb_email.getText());
        c.setPhoneNumber(tb_phone.getText());
        c.setNote(tb_note.getText());
        c.setId(tb_id.getText());
        int x = cusDAO.add(c);
        if(x > 0){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            clearForm();
            FillTableData();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
        
    }//GEN-LAST:event_bt_addActionPerformed
    void showForm(){
        index = tbl_customer.getSelectedRow();
        if(index  < 0 ){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn 1 dòng trên bảng này!");
        }else{
            CustomerModel c = new CustomerModel();
            c = lst.get(index);
            tb_id.setText(c.getId());
            tb_name.setText(c.getName());
            tb_birth.setText(c.getBirth());
            tb_email.setText(c.getMail());
            tb_hometower.setText(c.getHomeTower());
            tb_note.setText(c.getNote());
            tb_phone.setText(c.getPhoneNumber());
            tb_note.setText(c.getNote());
            cb_gender.setSelectedIndex("Nam".equals(c.getGender()) ? 0 : 1);
        }
    }
    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        if(cusDAO.delete(tb_id.getText()) > 0){
            JOptionPane.showMessageDialog(this, "Đã xóa thành công");
            clearForm();
            FillTableData();
        }else{
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_changeActionPerformed
        CustomerModel c = new CustomerModel();
        c.setId(tb_id.getText());
        c.setName(tb_name.getText());
        c.setBirth(tb_birth.getText());
        c.setGender(cb_gender.getSelectedItem() + "");
        c.setHomeTower(tb_hometower.getText());
        c.setMail(tb_email.getText());
        c.setNote(tb_note.getText());
        c.setPhoneNumber(tb_phone.getText());
        if(cusDAO.update(c) > 0){
            JOptionPane.showMessageDialog(this, "Đã sửa thành công");
            clearForm();
            FillTableData();
        }else{
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_bt_changeActionPerformed

    private void tbl_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customerMouseClicked
       showForm();
    }//GEN-LAST:event_tbl_customerMouseClicked

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
            java.util.logging.Logger.getLogger(CustomersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomersGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_change;
    private javax.swing.JButton bt_delete;
    private javax.swing.JComboBox<String> cb_gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField tb_birth;
    private javax.swing.JTextField tb_email;
    private javax.swing.JTextField tb_hometower;
    private javax.swing.JTextField tb_id;
    private javax.swing.JTextField tb_name;
    private javax.swing.JTextArea tb_note;
    private javax.swing.JTextField tb_phone;
    private javax.swing.JTable tbl_customer;
    // End of variables declaration//GEN-END:variables
}

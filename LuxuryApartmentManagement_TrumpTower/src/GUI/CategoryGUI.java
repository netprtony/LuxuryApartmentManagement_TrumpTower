
package GUI;
import DAO.CategoryApartmentDAO;
import DAO.CategoryContractDAO;
import MODEL.CategoryApartmentModel;
import MODEL.CategoryContractModel;
import MODEL.CustomerModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author netprtony
 */
public class CategoryGUI extends javax.swing.JInternalFrame {
    CategoryApartmentDAO cateApDAO = new CategoryApartmentDAO();
    CategoryContractDAO cateConDAO = new CategoryContractDAO();
    List<CategoryApartmentModel> lstCateAp = new ArrayList<>();
    List<CategoryContractModel> lstCateCon = new ArrayList<>();
    DefaultTableModel tblModel  = new DefaultTableModel();
    int index = 0;
    public CategoryGUI() {
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        initComponents();
        FillTableDataCateApartment();
        FillTableDataCateContract();
    }

    void showFormAparment(){
        index = tbl_cateApart.getSelectedRow();
        if(index < 0){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn 1 dòng trên bảng này!");
        }else{
           CategoryApartmentModel a = new CategoryApartmentModel();
           a = lstCateAp.get(index);
           tf_NameCateApr.setText(a.getName());
           tf_explication.setText(a.getExp());
        }
    }
    void showFormContract(){
        index = tbl_contractCate.getSelectedRow();
        if(index < 0){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn 1 dòng trên bảng này!");
        }else{
           CategoryContractModel c = new CategoryContractModel();
           c = lstCateCon.get(index);
           tf_NameCateCon.setText(c.getName());
        }
    }
    public void FillTableDataCateApartment() {
        lstCateAp = cateApDAO.readAll();
        tblModel = (DefaultTableModel) tbl_cateApart.getModel();
        tblModel.setRowCount(0);
        for (CategoryApartmentModel c : lstCateAp) {
            Object[] r = new Object[]{
                c.getId(),
                c.getName(),
                c.getExp()
            };
            tblModel.addRow(r);                 
        }
        tbl_cateApart.setModel(tblModel);
    }
    public void FillTableDataCateContract() {
        lstCateCon = cateConDAO.readAll();
        tblModel = (DefaultTableModel) tbl_contractCate.getModel();
        tblModel.setRowCount(0);
        for (CategoryApartmentModel c : lstCateAp) {
            Object[] r = new Object[]{
                c.getId(),
                c.getName(),
            };
            tblModel.addRow(r);                 
        }
        tbl_contractCate.setModel(tblModel);
    }
    void clearForm(){
        tf_NameCateApr.setText("");
        tf_NameCateCon.setText("");
        tf_explication.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cateApart = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_NameCateApr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_explication = new javax.swing.JTextArea();
        btn_addApart = new javax.swing.JButton();
        btn_updateApart = new javax.swing.JButton();
        btn_delApart = new javax.swing.JButton();
        btn_newApart = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tf_NameCateCon = new javax.swing.JTextField();
        btn_addCon = new javax.swing.JButton();
        btn_updateCon = new javax.swing.JButton();
        btn_delCon = new javax.swing.JButton();
        btn_newCon = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_contractCate = new javax.swing.JTable();

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Category Apartment"));

        tbl_cateApart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Explication"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_cateApart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cateApartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cateApart);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Properties"));

        jLabel1.setText("Name");

        jLabel2.setText("Explication");

        tf_explication.setColumns(20);
        tf_explication.setRows(5);
        jScrollPane2.setViewportView(tf_explication);

        btn_addApart.setText("Add");
        btn_addApart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addApartActionPerformed(evt);
            }
        });

        btn_updateApart.setText("Update");
        btn_updateApart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateApartActionPerformed(evt);
            }
        });

        btn_delApart.setText("Delete");
        btn_delApart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delApartActionPerformed(evt);
            }
        });

        btn_newApart.setText("New");
        btn_newApart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newApartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tf_NameCateApr))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_delApart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_newApart))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_addApart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_updateApart)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_NameCateApr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_updateApart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_addApart, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delApart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_newApart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Category Apartment", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Properties"));

        jLabel3.setText("Name");

        btn_addCon.setText("Add");
        btn_addCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addConActionPerformed(evt);
            }
        });

        btn_updateCon.setText("Update");
        btn_updateCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateConActionPerformed(evt);
            }
        });

        btn_delCon.setText("Delete");
        btn_delCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delConActionPerformed(evt);
            }
        });

        btn_newCon.setText("New");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_delCon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_newCon))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_addCon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_updateCon))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_NameCateCon, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_NameCateCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_updateCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_addCon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delCon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_newCon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        tbl_contractCate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_contractCate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_contractCateMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_contractCate);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Category Contract", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_cateApartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cateApartMouseClicked
        showFormAparment();
    }//GEN-LAST:event_tbl_cateApartMouseClicked

    private void btn_addApartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addApartActionPerformed
        CategoryApartmentModel a = new CategoryApartmentModel();
        a.setName(tf_NameCateApr.getText());
        a.setExp(tf_explication.getText());
        int x = cateApDAO.add(a);
        if(x > 0){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            clearForm();
            FillTableDataCateApartment();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btn_addApartActionPerformed

    private void btn_updateApartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateApartActionPerformed
        CategoryApartmentModel a = new CategoryApartmentModel();
        a = lstCateAp.get(index);
        a.setName(tf_NameCateApr.getText());
        a.setExp(tf_explication.getText());
        if(cateApDAO.update(a)>0){
            JOptionPane.showMessageDialog(this, "Đã sửa thành công");
            clearForm();
            FillTableDataCateApartment();
        }else{
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btn_updateApartActionPerformed

    private void btn_delApartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delApartActionPerformed
        CategoryApartmentModel a = new CategoryApartmentModel();
        a = lstCateAp.get(index);
        if(cateApDAO.delete(a.getId()) > 0){
            JOptionPane.showMessageDialog(this, "Đã xóa thành công");
            clearForm();
            FillTableDataCateApartment();
        }else{
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btn_delApartActionPerformed

    private void btn_newApartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newApartActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_newApartActionPerformed

    private void btn_addConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addConActionPerformed
        CategoryContractModel c = new CategoryContractModel();
        c.setName(tf_NameCateCon.getText());
        int x = cateConDAO.add(c);
        if(x > 0){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            clearForm();
            FillTableDataCateApartment();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btn_addConActionPerformed

    private void btn_updateConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateConActionPerformed
        CategoryContractModel c = new CategoryContractModel();
        c = lstCateCon.get(index);
        c.setName(tf_NameCateCon.getText());
        if(cateConDAO.update(c)>0){
            JOptionPane.showMessageDialog(this, "Đã sửa thành công");
            clearForm();
            FillTableDataCateApartment();
        }else{
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btn_updateConActionPerformed

    private void btn_delConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delConActionPerformed
        CategoryContractModel c = new CategoryContractModel();
        c = lstCateCon.get(index);
        if(cateConDAO.delete(c.getId()) > 0){
            JOptionPane.showMessageDialog(this, "Đã xóa thành công");
            clearForm();
            FillTableDataCateApartment();
        }else{
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btn_delConActionPerformed

    private void tbl_contractCateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_contractCateMouseClicked
        showFormContract();
    }//GEN-LAST:event_tbl_contractCateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addApart;
    private javax.swing.JButton btn_addCon;
    private javax.swing.JButton btn_delApart;
    private javax.swing.JButton btn_delCon;
    private javax.swing.JButton btn_newApart;
    private javax.swing.JButton btn_newCon;
    private javax.swing.JButton btn_updateApart;
    private javax.swing.JButton btn_updateCon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_cateApart;
    private javax.swing.JTable tbl_contractCate;
    private javax.swing.JTextField tf_NameCateApr;
    private javax.swing.JTextField tf_NameCateCon;
    private javax.swing.JTextArea tf_explication;
    // End of variables declaration//GEN-END:variables
}

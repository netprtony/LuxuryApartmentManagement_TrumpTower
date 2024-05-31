/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.ApartmentDAO;
import DAO.CategoryContractDAO;
import DAO.ContractDAO;
import DAO.CustomerDAO;
import DAO.DetailContractDAO;
import DAO.ServiceDAO;
import MODEL.ApartmentModel;
import MODEL.CategoryContractModel;
import MODEL.ComboBoxItem;
import MODEL.ContractModel;
import MODEL.CustomerModel;
import MODEL.DetailContractModel;
import MODEL.ServiceModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author netprtony
 */
public final class ContractGUI extends javax.swing.JFrame {
    int index = 0;
    
    DefaultTableModel tblModel = new DefaultTableModel();
    ContractDAO daoCon = new ContractDAO();
    DetailContractDAO daoDetail = new DetailContractDAO();
    CategoryContractDAO daoCateCon = new CategoryContractDAO();
    ServiceDAO daoService = new ServiceDAO();
    ApartmentDAO daoAp = new ApartmentDAO();
    CustomerDAO daoCus = new CustomerDAO();
    List<ContractModel> lstGet = new ArrayList<>();
    List<DetailContractModel> lstCateGet = new ArrayList<>();
    
    
    public ContractGUI() {
        initComponents();
        loadCboCateContract();
        loadCboService();
        loadCboApartmentNumber();
        loadCboCustomer();
        FillTableDataContract();
    }
    public String returnIdComboBox(JComboBox cbo){
       ComboBoxItem sel = (ComboBoxItem) cbo.getSelectedItem();
       return sel != null ? sel.getId() :  "";
    }
    public void loadCboCateContract(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_cate.getModel();
        List<CategoryContractModel> lst = daoCateCon.readAll();
        model.removeAllElements();
        for (CategoryContractModel cate : lst) {
            model.addElement(new ComboBoxItem(cate.getId() + "", cate.getName()));      
        }
    }
    public void loadCboCustomer(){
      DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_customer.getModel();
       List<CustomerModel> lst = daoCus.readAll();
       model.removeAllElements();
        for (CustomerModel c : lst) {
            model.addElement(new ComboBoxItem(c.getId(), c.getName()));      
        }
    }
    public void loadCboService(){
       List<ServiceModel> lst = daoService.readAll();
       DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_SerID.getModel();
       model.removeAllElements();
        for (ServiceModel s : lst) {
            model.addElement(new ComboBoxItem(s.getId() + "", s.getName()));      
        }
    }
    public void loadCboApartmentNumber(){
       List<ApartmentModel>  lst = daoAp.readAll();
       DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_SerID.getModel();
       model.removeAllElements();
        for (ApartmentModel a : lst) {
            model.addElement(a);      
        }
    }
    public void clearForm(){
        tf_ConId.setText("");
        tf_conDate.setText("");
        cbo_customer.setSelectedItem(null);
        cbo_Apartment.setSelectedItem(null);
        cbo_SerID.setSelectedItem(null);
        cbo_cate.setSelectedItem(null);
    }
    public void FillTableDataContract() {
        
        List<ContractModel> lst = daoCon.readAll();
        tblModel = (DefaultTableModel) tbl_Contract.getModel();
        tblModel.setRowCount(0);
        for (ContractModel con : lst) {
            Object[] r = new Object[]{
               con.getId(),
               con.getDate(),
               con.isStatus(),
               con.getCateName(),
               con.getNameCus(),
               con.getNumberApart(),
               con.getServiceInUser(),
            };
            tblModel.addRow(r);                 
        }
        tbl_Contract.setModel(tblModel);
    }
     public void FillDetailContractByIdContract(int id) {
         
        List<DetailContractModel> lst = daoDetail.readAllByIdContract(id);
        tblModel = (DefaultTableModel) tbl_DetailContract.getModel();
        tblModel.setRowCount(0);
        for (DetailContractModel de : lst) {
            Object[] r = new Object[]{
               de.getSerID(),
               de.getQuantity()
            };
            tblModel.addRow(r);                 
        }
        tbl_DetailContract.setModel(tblModel);
    }
    void showFromContract(){
        index = tbl_Contract.getSelectedRow();
        if(index < 0){
            JOptionPane.showMessageDialog(this, "Please select random row in this table!");
        }else{
            
            ContractModel con = new ContractModel();
            con = lstGet.get(index);
            tf_ConId.setText(con.getId() + "");
            selectItemByName(cbo_Apartment, con.getNumberApart());
            selectItemByName(cbo_customer, con.getIdCus());
            tf_conDate.setText(con.getDate());
            selectItemByName(cbo_cate, con.getCateName());
        }
        
    }
    void showFromDetail(){
        index = tbl_DetailContract.getSelectedRow();
        if(index < 0){
            JOptionPane.showMessageDialog(this, "Please select random row in this table!");
        }else{
            DetailContractModel de = new DetailContractModel();
            de = lstCateGet.get(index);
            selectItemByID(cbo_SerID, de.getSerID() + "");
            tf_quantity.setValue(de.getQuantity());
        }
    }
    public void selectItemByName(JComboBox cbo, String name){
        DefaultComboBoxModel<ComboBoxItem> model = (DefaultComboBoxModel<ComboBoxItem>) cbo.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            ComboBoxItem item = model.getElementAt(i);
            if (item.getName().equals(name)) {
                cbo.setSelectedItem(item);
                break;
            }
        }
    }
    public void selectItemByID(JComboBox cbo, String id){
        DefaultComboBoxModel<ComboBoxItem> model = (DefaultComboBoxModel<ComboBoxItem>) cbo.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            ComboBoxItem item = model.getElementAt(i);
            if (item.getId().equals(id)) {
                cbo.setSelectedItem(item);
                break;
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_ConId = new javax.swing.JTextField();
        btn_conAdd = new javax.swing.JButton();
        btn_conUpdate = new javax.swing.JButton();
        btn_conDelete = new javax.swing.JButton();
        tf_conDate = new javax.swing.JFormattedTextField();
        ck_status = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbo_cate = new javax.swing.JComboBox<>();
        cbo_customer = new javax.swing.JComboBox<>();
        cbo_Apartment = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Contract = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        tf_searchIDContract = new javax.swing.JTextField();
        btn_bui_search = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_DetailContract = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_detailAdd = new javax.swing.JButton();
        btn_detailUpdate = new javax.swing.JButton();
        btn_detailDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbo_SerID = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tf_quantity = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 0)), "Contract", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(102, 0, 0))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Properties"));

        jLabel1.setText("ID");

        jLabel2.setText("Date");

        jLabel3.setText("Customer");

        tf_ConId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 0, 0)));
        tf_ConId.setCaretColor(new java.awt.Color(102, 0, 0));

        btn_conAdd.setBackground(new java.awt.Color(102, 0, 0));
        btn_conAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_conAdd.setForeground(new java.awt.Color(204, 153, 0));
        btn_conAdd.setText("Add");
        btn_conAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_conAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conAddActionPerformed(evt);
            }
        });

        btn_conUpdate.setBackground(new java.awt.Color(102, 0, 0));
        btn_conUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_conUpdate.setForeground(new java.awt.Color(204, 153, 0));
        btn_conUpdate.setText("Change");
        btn_conUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_conUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conUpdateActionPerformed(evt);
            }
        });

        btn_conDelete.setBackground(new java.awt.Color(102, 0, 0));
        btn_conDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_conDelete.setForeground(new java.awt.Color(204, 153, 0));
        btn_conDelete.setText("Delete");
        btn_conDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_conDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_conDeleteActionPerformed(evt);
            }
        });

        tf_conDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 0, 0)));
        tf_conDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/MM/yyyy"))));

        ck_status.setText("Status");

        jLabel5.setText("Apartment Number");

        jLabel4.setText("Category");

        cbo_cate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_cate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 0, 0)));

        cbo_customer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_customer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 0, 0)));

        cbo_Apartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_Apartment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_Apartment, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ck_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_cate, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_conAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_conUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_conDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbo_customer, javax.swing.GroupLayout.Alignment.LEADING, 0, 260, Short.MAX_VALUE)
                        .addComponent(tf_ConId, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tf_conDate, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_ConId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(tf_conDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbo_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbo_Apartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(ck_status)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbo_cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_conAdd)
                    .addComponent(btn_conUpdate)
                    .addComponent(btn_conDelete))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "All contract"));

        tbl_Contract.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tbl_Contract.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Status", "Category", "Customer", "Apartment", "Service in user"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_Contract.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ContractMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Contract);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search"));

        tf_searchIDContract.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tf_searchIDContract.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 0, 0)));
        tf_searchIDContract.setCaretColor(new java.awt.Color(102, 0, 0));

        btn_bui_search.setBackground(new java.awt.Color(102, 0, 0));
        btn_bui_search.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_bui_search.setForeground(new java.awt.Color(204, 153, 0));
        btn_bui_search.setText("Search");
        btn_bui_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_bui_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bui_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_searchIDContract)
                .addGap(18, 18, 18)
                .addComponent(btn_bui_search, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_searchIDContract, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_bui_search))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail contract"));

        tbl_DetailContract.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tbl_DetailContract.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ServiceID", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_DetailContract.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DetailContractMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_DetailContract);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_detailAdd.setBackground(new java.awt.Color(102, 0, 0));
        btn_detailAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_detailAdd.setForeground(new java.awt.Color(204, 153, 0));
        btn_detailAdd.setText("Add");
        btn_detailAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_detailAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detailAddActionPerformed(evt);
            }
        });

        btn_detailUpdate.setBackground(new java.awt.Color(102, 0, 0));
        btn_detailUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_detailUpdate.setForeground(new java.awt.Color(204, 153, 0));
        btn_detailUpdate.setText("Change");
        btn_detailUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_detailUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detailUpdateActionPerformed(evt);
            }
        });

        btn_detailDelete.setBackground(new java.awt.Color(102, 0, 0));
        btn_detailDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_detailDelete.setForeground(new java.awt.Color(204, 153, 0));
        btn_detailDelete.setText("Delete");
        btn_detailDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_detailDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detailDeleteActionPerformed(evt);
            }
        });

        jLabel7.setText("ServiceID");

        cbo_SerID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_SerID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 0, 0)));

        jLabel6.setText("Quantity");

        tf_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btn_detailAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_detailUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_SerID, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_quantity))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_detailDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_SerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_detailAdd)
                    .addComponent(btn_detailUpdate)
                    .addComponent(btn_detailDelete))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contract", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_conAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conAddActionPerformed
        ContractModel c = new ContractModel();
        c.setDate(tf_conDate.getText());
        c.setIdAprt(Integer.parseInt(returnIdComboBox(cbo_Apartment)));
        c.setIdCate(Integer.parseInt(returnIdComboBox(cbo_cate)));
        c.setStatus(ck_status.isSelected());
        c.setIdCus(returnIdComboBox(cbo_customer));
        if(daoCon.add(c) > 0){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            FillTableDataContract();
            clearForm();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btn_conAddActionPerformed

    private void btn_conUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conUpdateActionPerformed
        ContractModel c = new  ContractModel();
        c.setDate(tf_conDate.getText());
        c.setIdAprt(Integer.parseInt(returnIdComboBox(cbo_Apartment)));
        c.setIdCate(Integer.parseInt(returnIdComboBox(cbo_cate)));
        c.setStatus(ck_status.isSelected());
        c.setIdCus(returnIdComboBox(cbo_customer));
        if(daoCon.update(c) > 0){
            JOptionPane.showMessageDialog(this, "Sua thành công");
            FillTableDataContract();
            clearForm();
        }else{
            JOptionPane.showMessageDialog(this, "Sua thất bại");
        }
    }//GEN-LAST:event_btn_conUpdateActionPerformed

    private void btn_conDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_conDeleteActionPerformed
       ContractModel c = new ContractModel();
       if(daoCon.delete(Integer.parseInt(tf_ConId.getText())) > 0){
            FillTableDataContract();
            JOptionPane.showMessageDialog(this, "Đã xóa thành công");
            clearForm();
        }else{
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btn_conDeleteActionPerformed

    private void tbl_ContractMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ContractMouseClicked
        showFromContract();
        index = tbl_Contract.getSelectedRow();
        FillDetailContractByIdContract(index);
    }//GEN-LAST:event_tbl_ContractMouseClicked

    private void btn_bui_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bui_searchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_bui_searchActionPerformed

    private void btn_detailAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detailAddActionPerformed
        DetailContractModel de = new DetailContractModel();
        de.setContrID(Integer.parseInt(tf_ConId.getText()));
        de.setSerID(Integer.parseInt(returnIdComboBox(cbo_SerID)));
        de.setQuantity(Integer.parseInt(tf_quantity.getValue().toString()));
        if(daoDetail.add(de) > 0){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            FillDetailContractByIdContract(index);
            clearForm();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
        
    }//GEN-LAST:event_btn_detailAddActionPerformed

    private void btn_detailUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detailUpdateActionPerformed
        DetailContractModel de = new DetailContractModel();
        de.setContrID(Integer.parseInt(tf_ConId.getText()));
        de.setSerID(Integer.parseInt(returnIdComboBox(cbo_SerID)));
        de.setQuantity(Integer.parseInt(tf_quantity.getValue().toString()));
        if(daoDetail.update(de) > 0){
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            FillDetailContractByIdContract(index);
            clearForm();
        }else{
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btn_detailUpdateActionPerformed

    private void btn_detailDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detailDeleteActionPerformed
        DetailContractModel d = new DetailContractModel();
       if(daoDetail.delete(Integer.parseInt(tf_ConId.getText()), Integer.parseInt(returnIdComboBox(cbo_SerID))) > 0){
            FillDetailContractByIdContract(index);
            JOptionPane.showMessageDialog(this, "Đã xóa thành công");
            clearForm();
        }else{
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btn_detailDeleteActionPerformed

    private void tbl_DetailContractMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DetailContractMouseClicked
        showFromDetail();
    }//GEN-LAST:event_tbl_DetailContractMouseClicked

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
            java.util.logging.Logger.getLogger(ContractGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContractGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContractGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContractGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContractGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bui_search;
    private javax.swing.JButton btn_conAdd;
    private javax.swing.JButton btn_conDelete;
    private javax.swing.JButton btn_conUpdate;
    private javax.swing.JButton btn_detailAdd;
    private javax.swing.JButton btn_detailDelete;
    private javax.swing.JButton btn_detailUpdate;
    private javax.swing.JComboBox<String> cbo_Apartment;
    private javax.swing.JComboBox<String> cbo_SerID;
    private javax.swing.JComboBox<String> cbo_cate;
    private javax.swing.JComboBox<String> cbo_customer;
    private javax.swing.JCheckBox ck_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_Contract;
    private javax.swing.JTable tbl_DetailContract;
    private javax.swing.JTextField tf_ConId;
    private javax.swing.JFormattedTextField tf_conDate;
    private javax.swing.JSpinner tf_quantity;
    private javax.swing.JTextField tf_searchIDContract;
    // End of variables declaration//GEN-END:variables
}

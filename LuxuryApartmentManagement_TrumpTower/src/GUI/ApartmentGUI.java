package GUI;
import DAO.ApartmentDAO;
import DAO.BuildingDAO;
import DAO.CategoryApartmentDAO;
import MODEL.ApartmentModel;
import MODEL.BuildingModel;
import MODEL.CategoryApartmentModel;
import MODEL.ComboBoxItem;
import MODEL.DialogMessage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author netprtony
 */
public class ApartmentGUI extends javax.swing.JInternalFrame {
    List<ApartmentModel> lst = new ArrayList<>();
    DefaultTableModel tblModel  = new DefaultTableModel();
    
    BuildingDAO daoBui = new BuildingDAO();
    ApartmentDAO apdao = new ApartmentDAO();
    CategoryApartmentDAO cateDapo = new CategoryApartmentDAO();
    int index = 0;
    public ApartmentGUI() {
        initComponents();
        loadCboBuildDetail();
        FillTableData();
        loadCboCateDetail();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
    }

    public String returnIdComboBox(JComboBox cbo){
       ComboBoxItem sel = (ComboBoxItem) cbo.getSelectedItem();
       return sel != null ? sel.getId() :  null;
    }
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
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
    public void showForm(){
        index = tbl_apartmentDetail.getSelectedRow();
        
        if(index  < 0 ){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn 1 dòng trên bảng này!");
        }else{
            ApartmentModel a = new ApartmentModel();
            a = lst.get(index);
            tf_detailAcrage.setText(a.getAcreage());
            tf_detailDes.setText(a.getDescribe());
            tf_detailFloor.setText(a.getFloor() + "");
            tf_detailNumber.setText(a.getNumber());
            tf_detailPrice.setText(a.getPrice() +  "");
            ck_isViewDetail.setSelected(a.isView());
            ck_isvailableDetail1.setSelected(a.isAvaialbe());
            selectItemByID(cbo_detailBuild, a.getIdBuild());
            selectItemByName(cbo_detailCateAp, a.getNameCate());
        }
    }
    public void FillTableData() {
        ApartmentDAO dao = new ApartmentDAO();
        lst = dao.readAll();
        tblModel = (DefaultTableModel) tbl_apartmentDetail.getModel();
        tblModel.setRowCount(0);
        for (ApartmentModel apr : lst) {
            Object[] r = new Object[]{
                apr.getNumber(),
                apr.getFloor(),
                apr.isView(),
                apr.getAcreage(),
                apr.getPrice(),
                apr.getDescribe(),
                apr.isAvaialbe(),
                apr.getNameCate(),
                apr.getIdBuild(),
            };
            tblModel.addRow(r);                 
        }
        tbl_apartmentDetail.setModel(tblModel);
    }
    public void clearForm(){
        tf_detailAcrage.setText("");
        tf_detailDes.setText("");
        tf_detailFloor.setText("");
        tf_detailNumber.setText("");
        ck_IsCusNumber.setSelected(false);
        tf_detailPrice.setText("");
    }
                
     
  
  
    public void loadCboBuildDetail(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_detailBuild.getModel();
        List<BuildingModel> lstBUi = daoBui.readAll();
        model.removeAllElements();
        for (BuildingModel bui : lstBUi) {
            model.addElement(new ComboBoxItem(bui.getId(), bui.getName()));
        }
    }
    public void loadCboCateDetail(){
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_detailCateAp.getModel();
        List<CategoryApartmentModel> lstcateAp = cateDapo.readAll();
        model.removeAllElements();
        for (CategoryApartmentModel cate : lstcateAp) {
            model.addElement(new ComboBoxItem(cate.getId() + "", cate.getName()));
        }
    }
     public String getSelectedBuildingId() {
        ComboBoxItem selectedItem = (ComboBoxItem) cbo_detailBuild.getSelectedItem();
        return selectedItem != null ? selectedItem.getId() : null;
    }      

    public int findLargestValue(List<ApartmentModel> lst){
        int largestValue = 0;
        if(lst == null) return 0;
        for (ApartmentModel a : lst) {
            if (a instanceof ApartmentModel) {
                int str = a.getId();
                if (largestValue == 0 || str > 0) {
                    largestValue = str;
                }
            }
        }
        return largestValue;
    }
    
    public String create_apartment_number(){
        String resultID = "";
        String bui = String.valueOf(cbo_detailBuild.getSelectedItem());
        String lastChar = String.valueOf(bui.charAt(bui.length() - 1));
        String floor = tf_detailFloor.getText();
        lst = apdao.readAll();
        int newID = findLargestValue(lst);
        if(newID == 0){
            resultID = lastChar + floor + "0";
        }else {
            if(newID <= 9) 
                resultID = lastChar + floor + "0" + newID;
            else
                resultID = lastChar + floor + newID;
        }
        return resultID;
    }    
    public double CurrencyConverter(double amount, String currency){
        double VND_TO_USD_RATE = 0.00003929;
        return currency.equals("USD") ? (amount / VND_TO_USD_RATE): amount;
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_detailAcrage = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tf_detailPrice = new javax.swing.JTextField();
        ck_isViewDetail = new javax.swing.JCheckBox();
        cbo_detailBuild = new javax.swing.JComboBox<>();
        cbo_detailCateAp = new javax.swing.JComboBox<>();
        cbo_exchange = new javax.swing.JComboBox<>();
        cbo_km = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tf_detailDes = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        tf_detailNumber = new javax.swing.JTextField();
        btn_createNumberApr = new javax.swing.JButton();
        ck_IsCusNumber = new javax.swing.JCheckBox();
        tf_detailFloor = new javax.swing.JTextField();
        ck_isvailableDetail1 = new javax.swing.JCheckBox();
        btn_del = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbl_apartmentDetail = new javax.swing.JTable();

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Edit"));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Block:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Category:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Floor:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Acreage:");

        tf_detailAcrage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Price:");

        tf_detailPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 0, 0)));

        ck_isViewDetail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ck_isViewDetail.setSelected(true);
        ck_isViewDetail.setText("View");

        cbo_detailBuild.setBackground(new java.awt.Color(102, 0, 0));
        cbo_detailBuild.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbo_detailBuild.setForeground(new java.awt.Color(204, 153, 0));
        cbo_detailBuild.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_detailBuild.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 0)));

        cbo_detailCateAp.setBackground(new java.awt.Color(102, 0, 0));
        cbo_detailCateAp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbo_detailCateAp.setForeground(new java.awt.Color(204, 153, 0));
        cbo_detailCateAp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_detailCateAp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 0)));

        cbo_exchange.setBackground(new java.awt.Color(102, 0, 0));
        cbo_exchange.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbo_exchange.setForeground(new java.awt.Color(204, 153, 0));
        cbo_exchange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VND", "USD" }));

        cbo_km.setBackground(new java.awt.Color(102, 0, 0));
        cbo_km.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbo_km.setForeground(new java.awt.Color(204, 153, 0));
        cbo_km.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre ", "m²", "bigha", "tsubo" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Describe:");

        tf_detailDes.setColumns(20);
        tf_detailDes.setRows(5);
        tf_detailDes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 0)));
        jScrollPane8.setViewportView(tf_detailDes);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Number:");

        tf_detailNumber.setEditable(false);
        tf_detailNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 0, 0)));
        tf_detailNumber.setEnabled(false);
        tf_detailNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_detailNumberFocusLost(evt);
            }
        });

        btn_createNumberApr.setBackground(new java.awt.Color(102, 0, 0));
        btn_createNumberApr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_createNumberApr.setForeground(new java.awt.Color(204, 153, 0));
        btn_createNumberApr.setText("Create");
        btn_createNumberApr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createNumberAprActionPerformed(evt);
            }
        });

        ck_IsCusNumber.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ck_IsCusNumber.setText("Custom");
        ck_IsCusNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ck_IsCusNumberMouseClicked(evt);
            }
        });
        ck_IsCusNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ck_IsCusNumberActionPerformed(evt);
            }
        });

        tf_detailFloor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 0, 0)));
        tf_detailFloor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_detailFloorFocusLost(evt);
            }
        });

        ck_isvailableDetail1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ck_isvailableDetail1.setSelected(true);
        ck_isvailableDetail1.setText("Available");

        btn_del.setBackground(new java.awt.Color(102, 0, 0));
        btn_del.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_del.setForeground(new java.awt.Color(204, 153, 0));
        btn_del.setText("Delete");
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(102, 0, 0));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_update.setForeground(new java.awt.Color(204, 153, 0));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(102, 0, 0));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_add.setForeground(new java.awt.Color(204, 153, 0));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_new.setBackground(new java.awt.Color(102, 0, 0));
        btn_new.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_new.setForeground(new java.awt.Color(204, 153, 0));
        btn_new.setText("New");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ck_IsCusNumber)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_createNumberApr)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(tf_detailPrice))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(tf_detailNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ck_isvailableDetail1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)
                                        .addGap(30, 30, 30)
                                        .addComponent(tf_detailFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(20, 20, 20)
                                        .addComponent(tf_detailAcrage, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(cbo_exchange, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbo_km, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btn_add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_del)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_new)
                        .addContainerGap())
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ck_isViewDetail)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbo_detailCateAp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(42, 42, 42)
                                .addComponent(cbo_detailBuild, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbo_detailBuild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbo_detailCateAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tf_detailFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ck_isvailableDetail1))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tf_detailAcrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_km, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_detailPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(cbo_exchange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(tf_detailNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ck_isViewDetail)
                    .addComponent(ck_IsCusNumber)
                    .addComponent(btn_createNumberApr))
                .addGap(21, 21, 21)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_update)
                    .addComponent(btn_del)
                    .addComponent(btn_new))
                .addGap(44, 44, 44))
        );

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Apartments"));

        tbl_apartmentDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Number", "Floor", "View", "Acreage", "Price", "Describe", "Available", "Category", "Build"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_apartmentDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_apartmentDetailMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tbl_apartmentDetail);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Detail", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_apartmentDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_apartmentDetailMouseClicked
        showForm();
    }//GEN-LAST:event_tbl_apartmentDetailMouseClicked

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        ApartmentModel a = new ApartmentModel();
        a.setAcreage(tf_detailAcrage.getText() + " " + cbo_km.getSelectedItem().toString());
        a.setAvaialbe(ck_isViewDetail.isSelected());
        a.setDescribe(tf_detailDes.getText());
        a.setFloor(Integer.parseInt(tf_detailFloor.getText()));
        a.setIdBuild(returnIdComboBox(cbo_detailBuild));
        a.setIdCate(Integer.parseInt(returnIdComboBox(cbo_detailCateAp)));
        a.setNumber(tf_detailNumber.getText());
        a.setPrice(CurrencyConverter(Double.parseDouble(tf_detailPrice.getText()), cbo_exchange.getSelectedItem().toString()));
        a.setView(ck_isViewDetail.isSelected());
        DialogMessage.confirm(jPanel12, "Bạn có muốn thêm phòng không");
        int x = apdao.add(a);
        if(x > 0){
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            FillTableData();
        }else{
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        ApartmentModel a = new ApartmentModel();
        a.setAcreage(tf_detailAcrage.getText() + " " + cbo_km.getSelectedItem().toString());
        a.setAvaialbe(ck_isViewDetail.isSelected());
        a.setDescribe(tf_detailDes.getText());
        a.setFloor(Integer.parseInt(tf_detailFloor.getText()));
        a.setIdBuild(returnIdComboBox(cbo_detailBuild));
        a.setIdCate(Integer.parseInt(returnIdComboBox(cbo_detailCateAp)));
        a.setNumber(tf_detailNumber.getText());
        a.setPrice(CurrencyConverter(Double.parseDouble(tf_detailPrice.getText()), cbo_exchange.getSelectedItem().toString()));
        a.setView(ck_isViewDetail.isSelected());
        int x = apdao.update(a);
        if(x > 0){
            JOptionPane.showMessageDialog(this, "Đã sửa thành công");
            FillTableData();
        }else{
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        int x = apdao.delete(tf_detailNumber.getText());
        if(x > 0){
            FillTableData();
            JOptionPane.showMessageDialog(this, "Đã xóa thành công");
            clearForm();
        }else{
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btn_delActionPerformed

    private void tf_detailFloorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_detailFloorFocusLost
        if(!isNumeric(tf_detailFloor.getText())){
            JOptionPane.showMessageDialog(rootPane, "Phải là ký tự số cho số lầu");
            tf_detailFloor.requestFocus();
        }
    }//GEN-LAST:event_tf_detailFloorFocusLost

    private void ck_IsCusNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ck_IsCusNumberActionPerformed
        if(ck_IsCusNumber.isSelected() == true){
            tf_detailNumber.setEnabled(true);
            btn_createNumberApr.setEnabled(false);
        }
        else{
            tf_detailNumber.setEnabled(false);
            btn_createNumberApr.setEnabled(true);
        }
    }//GEN-LAST:event_ck_IsCusNumberActionPerformed

    private void ck_IsCusNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ck_IsCusNumberMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ck_IsCusNumberMouseClicked

    private void btn_createNumberAprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createNumberAprActionPerformed
        if(tf_detailNumber == null) tf_detailNumber.setText("");
        tf_detailNumber.setText(create_apartment_number());
    }//GEN-LAST:event_btn_createNumberAprActionPerformed

    private void tf_detailNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_detailNumberFocusLost
        if(ck_IsCusNumber.isSelected() == true){
            String number = tf_detailNumber.getText();
            String reg = "^[A-Z][0-9]+$";
            if(number.length() > 0){
                if(!number.matches(reg)){
                    JOptionPane.showMessageDialog(rootPane, "Số phòng không cho phép, sai định dạng \n VD: A101, B123");
                    tf_detailNumber.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Không được trống số phòng\n Tự động tạo số phòng bên dưới");
                tf_detailNumber.requestFocus();
            }
        }
    }//GEN-LAST:event_tf_detailNumberFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_createNumberApr;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cbo_detailBuild;
    private javax.swing.JComboBox<String> cbo_detailCateAp;
    private javax.swing.JComboBox<String> cbo_exchange;
    private javax.swing.JComboBox<String> cbo_km;
    private javax.swing.JCheckBox ck_IsCusNumber;
    private javax.swing.JCheckBox ck_isViewDetail;
    private javax.swing.JCheckBox ck_isvailableDetail1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable tbl_apartmentDetail;
    private javax.swing.JTextField tf_detailAcrage;
    private javax.swing.JTextArea tf_detailDes;
    private javax.swing.JTextField tf_detailFloor;
    private javax.swing.JTextField tf_detailNumber;
    private javax.swing.JTextField tf_detailPrice;
    // End of variables declaration//GEN-END:variables
}

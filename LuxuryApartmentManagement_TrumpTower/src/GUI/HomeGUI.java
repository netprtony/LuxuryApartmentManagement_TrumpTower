/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;
import DAO.BuildingDAO;
import DAO.ApartmentDAO;
import DAO.CustomerDAO;
import DAO.ProblemsDAO;
import MODEL.ProblemModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author netprtony
 */
public class HomeGUI extends javax.swing.JInternalFrame {
    ProblemsDAO daoPro = new ProblemsDAO();
    BuildingDAO daoBui = new BuildingDAO();
    ApartmentDAO daoAp = new ApartmentDAO();
    CustomerDAO daoCus = new CustomerDAO();
    DefaultTableModel tblModel  = new DefaultTableModel();
    int index = 0;
    public HomeGUI() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        fillDataTableProblem();
        fillAllLable();
    }

    public void fillDataTableProblem(){
        List<ProblemModel> lst = new ArrayList<>();
        lst = daoPro.readAll();
        tblModel = (DefaultTableModel) tbl_problem.getModel();
        tblModel.setRowCount(0);
        for(ProblemModel p : lst){
            Object[] r = new Object[]{
                p.getNumberApart(),
                p.getNote(),
                p.getDescribe(),
                p.getStatus(),
                p.getDateOccur()
            };
            tblModel.addRow(r);
        }
        tbl_problem.setModel(tblModel);
    }
    public void fillAllLable(){
        lb_apartment.setText(daoAp.SumAvaialbe() + "");
        lb_emptyApart.setText(daoAp.SumEmpty() + "");
        lb_customer.setText(daoCus.Sum() + "");
        lb_building.setText(daoBui.Sum() + "");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_building = new javax.swing.JLabel();
        lb_apartment = new javax.swing.JLabel();
        lb_customer = new javax.swing.JLabel();
        lb_emptyApart = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_problem = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));

        jLabel1.setFont(new java.awt.Font("Sitka Heading", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("HOME");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(547, 547, 547))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon("D:\\Work_space\\JavaTech\\LuxuryApartmentManagement\\LuxuryApartmentManagement_TrumpTower\\LuxuryApartmentManagement_TrumpTower\\src\\GUI\\icon\\building-solid.png")); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon("D:\\Work_space\\JavaTech\\LuxuryApartmentManagement\\LuxuryApartmentManagement_TrumpTower\\LuxuryApartmentManagement_TrumpTower\\src\\GUI\\icon\\customerHome.png")); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon("D:\\Work_space\\JavaTech\\LuxuryApartmentManagement\\LuxuryApartmentManagement_TrumpTower\\LuxuryApartmentManagement_TrumpTower\\src\\GUI\\icon\\apartmentHome.png")); // NOI18N

        lb_building.setFont(new java.awt.Font("Sitka Heading", 0, 24)); // NOI18N
        lb_building.setForeground(new java.awt.Color(0, 0, 255));
        lb_building.setText("Building: 10");

        lb_apartment.setFont(new java.awt.Font("Sitka Heading", 0, 24)); // NOI18N
        lb_apartment.setForeground(new java.awt.Color(0, 0, 255));
        lb_apartment.setText("Apartment: 10");

        lb_customer.setFont(new java.awt.Font("Sitka Heading", 0, 24)); // NOI18N
        lb_customer.setForeground(new java.awt.Color(0, 0, 255));
        lb_customer.setText("Customer: 10");

        lb_emptyApart.setFont(new java.awt.Font("Sitka Heading", 0, 24)); // NOI18N
        lb_emptyApart.setForeground(new java.awt.Color(0, 0, 255));
        lb_emptyApart.setText("Empty Apartment: 10");

        jLabel12.setIcon(new javax.swing.ImageIcon("D:\\Work_space\\JavaTech\\LuxuryApartmentManagement\\LuxuryApartmentManagement_TrumpTower\\LuxuryApartmentManagement_TrumpTower\\src\\GUI\\icon\\apartmentHome.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lb_building)
                        .addGap(158, 158, 158)
                        .addComponent(lb_customer))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel3)
                        .addGap(256, 256, 256)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_apartment)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(134, 134, 134)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(212, 212, 212))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_emptyApart)
                        .addGap(131, 131, 131))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_emptyApart))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_customer)
                                    .addComponent(lb_building))))
                        .addGap(74, 74, 74)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_apartment))))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("All Problems"));

        tbl_problem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Apartment", "Note", "Describe", "Status", "Date occur"
            }
        ));
        jScrollPane1.setViewportView(tbl_problem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_apartment;
    private javax.swing.JLabel lb_building;
    private javax.swing.JLabel lb_customer;
    private javax.swing.JLabel lb_emptyApart;
    private javax.swing.JTable tbl_problem;
    // End of variables declaration//GEN-END:variables
}

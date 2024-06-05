/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import MODEL.Auth;
import MODEL.DialogMessage;

public class MainGUI extends javax.swing.JFrame {
    HomeGUI home;
    ApartmentGUI apartment;
    BuildingGUI building;
    ContractGUI contract;
    LoginGUI login;
    ServiceGUI service;
    CustomerGUI customer;
    CategoryGUI category;
    ProblemGUI problem;
    ChangePasswordGUI changpass;
    Color Default, Click;
    public MainGUI() {
        initComponents();
        lb_userCurrent.setText("Welcome " + Auth.user.getName());
        setLocationRelativeTo(null);
        Default = new Color(153,102,0);
        Click = new Color(255,204,102);
        pnlApartment.setBackground(Default);
        pnlBuilding.setBackground(Default);
        pnlCategory.setBackground(Default);
        pnlContract.setBackground(Default);
        pnlCustomer.setBackground(Default);
        pnlHome.setBackground(Default);
        pnlLogout.setBackground(Default);
        pnlProblem.setBackground(Default);
        pnlSercurity.setBackground(Default);
        pnlService.setBackground(Default);
        openHome();
        
    }
    public void openHome(){
        home = new HomeGUI();
        home.setBounds(0, 0, 1030, 720);
        desktop.removeAll();
        desktop.add(home).setVisible(true);
    }
    public void openLogin(){
        login = new LoginGUI();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null); 
        this.dispose();
    }
    public void openBuiding(){
        building = new BuildingGUI();
        building.setBounds(0, 0, 1030, 720);
        desktop.removeAll();
        desktop.add(building).setVisible(true);
    }
    public void openCategory(){
        category = new CategoryGUI();
        category.setBounds(0, 0, 1030, 720);
        desktop.removeAll();
        desktop.add(category);
    }
    public void openContract(){
        contract = new ContractGUI();
        contract.setBounds(0, 0, 1030, 720);
        desktop.removeAll();
        desktop.add(contract).setVisible(true);
    }
    public void openCustomer(){
        customer = new CustomerGUI();
        customer.setBounds(0, 0, 1030, 720);
        desktop.removeAll();
        desktop.add(customer).setVisible(true);
    }
    
    public void openProblem(){
        problem = new ProblemGUI();
        problem.setBounds(0, 0, 1030, 720);
        desktop.removeAll();
        desktop.add(problem).setVisible(true);
    }
    public void openService(){
        service = new ServiceGUI();
        service.setBounds(0, 0, 1030, 720);
        desktop.removeAll();
        desktop.add(service).setVisible(true);
    }
    public void openApartment(){
        apartment = new ApartmentGUI();
        apartment.setBounds(0, 0, 1030, 720);
        desktop.removeAll();
        desktop.add(apartment).setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_menu = new javax.swing.JPanel();
        lb_userCurrent = new javax.swing.JLabel();
        pnlHome = new javax.swing.JPanel();
        lb_Home = new javax.swing.JLabel();
        pnlBuilding = new javax.swing.JPanel();
        lb_Building = new javax.swing.JLabel();
        pnlApartment = new javax.swing.JPanel();
        lb_Apartment = new javax.swing.JLabel();
        pnlContract = new javax.swing.JPanel();
        lb_contract = new javax.swing.JLabel();
        pnlCustomer = new javax.swing.JPanel();
        lb_customer = new javax.swing.JLabel();
        pnlCategory = new javax.swing.JPanel();
        lb_cate = new javax.swing.JLabel();
        pnlService = new javax.swing.JPanel();
        lb_service = new javax.swing.JLabel();
        pnlProblem = new javax.swing.JPanel();
        lb_problem = new javax.swing.JLabel();
        pnlSercurity = new javax.swing.JPanel();
        lb_sercurity = new javax.swing.JLabel();
        pnlLogout = new javax.swing.JPanel();
        lb_logout = new javax.swing.JLabel();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnl_menu.setBackground(new java.awt.Color(153, 102, 0));

        lb_userCurrent.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_userCurrent.setForeground(new java.awt.Color(255, 255, 255));
        lb_userCurrent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_userCurrent.setText("NULL");
        lb_userCurrent.setToolTipText("");
        lb_userCurrent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_userCurrent.setFocusable(false);
        lb_userCurrent.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_userCurrent.setName(""); // NOI18N
        lb_userCurrent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnl_menu.add(lb_userCurrent);

        pnlHome.setBackground(new java.awt.Color(153, 102, 0));
        pnlHome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 204)));
        pnlHome.setForeground(new java.awt.Color(255, 255, 204));
        pnlHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHomeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHomeMousePressed(evt);
            }
        });

        lb_Home.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_Home.setForeground(new java.awt.Color(255, 255, 255));
        lb_Home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Home.setText("Home");
        lb_Home.setToolTipText("");
        lb_Home.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_Home.setFocusable(false);
        lb_Home.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_Home.setName(""); // NOI18N
        lb_Home.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lb_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Home, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );

        pnl_menu.add(pnlHome);

        pnlBuilding.setBackground(new java.awt.Color(153, 102, 0));
        pnlBuilding.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 204)));
        pnlBuilding.setForeground(new java.awt.Color(255, 255, 204));
        pnlBuilding.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBuildingMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBuildingMousePressed(evt);
            }
        });

        lb_Building.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_Building.setForeground(new java.awt.Color(255, 255, 255));
        lb_Building.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Building.setText("Buildings");
        lb_Building.setToolTipText("");
        lb_Building.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_Building.setFocusable(false);
        lb_Building.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_Building.setName(""); // NOI18N
        lb_Building.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlBuildingLayout = new javax.swing.GroupLayout(pnlBuilding);
        pnlBuilding.setLayout(pnlBuildingLayout);
        pnlBuildingLayout.setHorizontalGroup(
            pnlBuildingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuildingLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lb_Building, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlBuildingLayout.setVerticalGroup(
            pnlBuildingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_Building, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_menu.add(pnlBuilding);

        pnlApartment.setBackground(new java.awt.Color(153, 102, 0));
        pnlApartment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 204)));
        pnlApartment.setForeground(new java.awt.Color(255, 255, 204));
        pnlApartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlApartmentMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlApartmentMousePressed(evt);
            }
        });

        lb_Apartment.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_Apartment.setForeground(new java.awt.Color(255, 255, 255));
        lb_Apartment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Apartment.setText("Apartments");
        lb_Apartment.setToolTipText("");
        lb_Apartment.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_Apartment.setFocusable(false);
        lb_Apartment.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_Apartment.setName(""); // NOI18N
        lb_Apartment.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlApartmentLayout = new javax.swing.GroupLayout(pnlApartment);
        pnlApartment.setLayout(pnlApartmentLayout);
        pnlApartmentLayout.setHorizontalGroup(
            pnlApartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApartmentLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lb_Apartment)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        pnlApartmentLayout.setVerticalGroup(
            pnlApartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_Apartment, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_menu.add(pnlApartment);

        pnlContract.setBackground(new java.awt.Color(153, 102, 0));
        pnlContract.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 204)));
        pnlContract.setForeground(new java.awt.Color(255, 255, 204));
        pnlContract.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlContractMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlContractMousePressed(evt);
            }
        });

        lb_contract.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_contract.setForeground(new java.awt.Color(255, 255, 255));
        lb_contract.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_contract.setText("Contracts");
        lb_contract.setToolTipText("");
        lb_contract.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_contract.setFocusable(false);
        lb_contract.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_contract.setName(""); // NOI18N
        lb_contract.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlContractLayout = new javax.swing.GroupLayout(pnlContract);
        pnlContract.setLayout(pnlContractLayout);
        pnlContractLayout.setHorizontalGroup(
            pnlContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContractLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lb_contract, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlContractLayout.setVerticalGroup(
            pnlContractLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_contract, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_menu.add(pnlContract);

        pnlCustomer.setBackground(new java.awt.Color(153, 102, 0));
        pnlCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 204)));
        pnlCustomer.setForeground(new java.awt.Color(255, 255, 204));
        pnlCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCustomerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlCustomerMousePressed(evt);
            }
        });

        lb_customer.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_customer.setForeground(new java.awt.Color(255, 255, 255));
        lb_customer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_customer.setText("Customers");
        lb_customer.setToolTipText("");
        lb_customer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_customer.setFocusable(false);
        lb_customer.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_customer.setName(""); // NOI18N
        lb_customer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlCustomerLayout = new javax.swing.GroupLayout(pnlCustomer);
        pnlCustomer.setLayout(pnlCustomerLayout);
        pnlCustomerLayout.setHorizontalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lb_customer)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnlCustomerLayout.setVerticalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_customer, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_menu.add(pnlCustomer);

        pnlCategory.setBackground(new java.awt.Color(153, 102, 0));
        pnlCategory.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 204)));
        pnlCategory.setForeground(new java.awt.Color(255, 255, 204));
        pnlCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCategoryMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlCategoryMousePressed(evt);
            }
        });

        lb_cate.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_cate.setForeground(new java.awt.Color(255, 255, 255));
        lb_cate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_cate.setText("Categories");
        lb_cate.setToolTipText("");
        lb_cate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_cate.setFocusable(false);
        lb_cate.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_cate.setName(""); // NOI18N
        lb_cate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlCategoryLayout = new javax.swing.GroupLayout(pnlCategory);
        pnlCategory.setLayout(pnlCategoryLayout);
        pnlCategoryLayout.setHorizontalGroup(
            pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCategoryLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lb_cate)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        pnlCategoryLayout.setVerticalGroup(
            pnlCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_cate, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_menu.add(pnlCategory);

        pnlService.setBackground(new java.awt.Color(153, 102, 0));
        pnlService.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 204)));
        pnlService.setForeground(new java.awt.Color(255, 255, 204));
        pnlService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlServiceMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlServiceMousePressed(evt);
            }
        });

        lb_service.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_service.setForeground(new java.awt.Color(255, 255, 255));
        lb_service.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_service.setText("Services");
        lb_service.setToolTipText("");
        lb_service.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_service.setFocusable(false);
        lb_service.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_service.setName(""); // NOI18N
        lb_service.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlServiceLayout = new javax.swing.GroupLayout(pnlService);
        pnlService.setLayout(pnlServiceLayout);
        pnlServiceLayout.setHorizontalGroup(
            pnlServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServiceLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lb_service, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlServiceLayout.setVerticalGroup(
            pnlServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_service, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_menu.add(pnlService);

        pnlProblem.setBackground(new java.awt.Color(153, 102, 0));
        pnlProblem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 204)));
        pnlProblem.setForeground(new java.awt.Color(255, 255, 204));
        pnlProblem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlProblemMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlProblemMousePressed(evt);
            }
        });

        lb_problem.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_problem.setForeground(new java.awt.Color(255, 255, 255));
        lb_problem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_problem.setText("Problems");
        lb_problem.setToolTipText("");
        lb_problem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_problem.setFocusable(false);
        lb_problem.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_problem.setName(""); // NOI18N
        lb_problem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlProblemLayout = new javax.swing.GroupLayout(pnlProblem);
        pnlProblem.setLayout(pnlProblemLayout);
        pnlProblemLayout.setHorizontalGroup(
            pnlProblemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProblemLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lb_problem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlProblemLayout.setVerticalGroup(
            pnlProblemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_problem, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_menu.add(pnlProblem);

        pnlSercurity.setBackground(new java.awt.Color(153, 102, 0));
        pnlSercurity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 204)));
        pnlSercurity.setForeground(new java.awt.Color(255, 255, 204));
        pnlSercurity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSercurityMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlSercurityMousePressed(evt);
            }
        });

        lb_sercurity.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_sercurity.setForeground(new java.awt.Color(255, 255, 255));
        lb_sercurity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_sercurity.setText("Sercurity");
        lb_sercurity.setToolTipText("");
        lb_sercurity.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_sercurity.setFocusable(false);
        lb_sercurity.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_sercurity.setName(""); // NOI18N
        lb_sercurity.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlSercurityLayout = new javax.swing.GroupLayout(pnlSercurity);
        pnlSercurity.setLayout(pnlSercurityLayout);
        pnlSercurityLayout.setHorizontalGroup(
            pnlSercurityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSercurityLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lb_sercurity, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlSercurityLayout.setVerticalGroup(
            pnlSercurityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_sercurity, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_menu.add(pnlSercurity);

        pnlLogout.setBackground(new java.awt.Color(153, 102, 0));
        pnlLogout.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 204)));
        pnlLogout.setForeground(new java.awt.Color(255, 255, 204));
        pnlLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLogoutMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlLogoutMousePressed(evt);
            }
        });

        lb_logout.setFont(new java.awt.Font("Sitka Heading", 1, 24)); // NOI18N
        lb_logout.setForeground(new java.awt.Color(255, 255, 255));
        lb_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_logout.setText("Log out");
        lb_logout.setToolTipText("");
        lb_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb_logout.setFocusable(false);
        lb_logout.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lb_logout.setName(""); // NOI18N
        lb_logout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout pnlLogoutLayout = new javax.swing.GroupLayout(pnlLogout);
        pnlLogout.setLayout(pnlLogoutLayout);
        pnlLogoutLayout.setHorizontalGroup(
            pnlLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoutLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lb_logout, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        pnlLogoutLayout.setVerticalGroup(
            pnlLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnl_menu.add(pnlLogout);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1021, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
        );

        jMenu2.setText("File");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desktop)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnl_menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlLogoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLogoutMousePressed
        pnlApartment.setBackground(Default);
        pnlBuilding.setBackground(Default);
        pnlCategory.setBackground(Default);
        pnlContract.setBackground(Default);
        pnlCustomer.setBackground(Default);
        pnlHome.setBackground(Default);
        pnlLogout.setBackground(Click);
        pnlProblem.setBackground(Default);
        pnlSercurity.setBackground(Default);
        pnlService.setBackground(Default);
    }//GEN-LAST:event_pnlLogoutMousePressed

    private void pnlLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLogoutMouseClicked
        if(DialogMessage.confirm(apartment, "Bạn có muốn đăng xuất không?")){
            Auth.user.setName("");
            openLogin();
        }
    }//GEN-LAST:event_pnlLogoutMouseClicked

    private void pnlSercurityMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSercurityMousePressed
        pnlApartment.setBackground(Default);
        pnlBuilding.setBackground(Default);
        pnlCategory.setBackground(Default);
        pnlContract.setBackground(Default);
        pnlCustomer.setBackground(Default);
        pnlHome.setBackground(Default);
        pnlLogout.setBackground(Default);
        pnlProblem.setBackground(Default);
        pnlSercurity.setBackground(Click);
        pnlService.setBackground(Default);
    }//GEN-LAST:event_pnlSercurityMousePressed

    private void pnlSercurityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSercurityMouseClicked
        new ChangePasswordGUI(this, true).setVisible(true);
    }//GEN-LAST:event_pnlSercurityMouseClicked

    private void pnlProblemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlProblemMousePressed
        pnlApartment.setBackground(Default);
        pnlBuilding.setBackground(Default);
        pnlCategory.setBackground(Default);
        pnlContract.setBackground(Default);
        pnlCustomer.setBackground(Default);
        pnlHome.setBackground(Default);
        pnlLogout.setBackground(Default);
        pnlProblem.setBackground(Click);
        pnlSercurity.setBackground(Default);
        pnlService.setBackground(Default);
    }//GEN-LAST:event_pnlProblemMousePressed

    private void pnlProblemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlProblemMouseClicked
        openProblem();
    }//GEN-LAST:event_pnlProblemMouseClicked

    private void pnlServiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlServiceMousePressed
        pnlApartment.setBackground(Default);
        pnlBuilding.setBackground(Default);
        pnlCategory.setBackground(Default);
        pnlContract.setBackground(Default);
        pnlCustomer.setBackground(Default);
        pnlHome.setBackground(Default);
        pnlLogout.setBackground(Default);
        pnlProblem.setBackground(Default);
        pnlSercurity.setBackground(Default);
        pnlService.setBackground(Click);
    }//GEN-LAST:event_pnlServiceMousePressed

    private void pnlServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlServiceMouseClicked
        openService();
    }//GEN-LAST:event_pnlServiceMouseClicked

    private void pnlCategoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCategoryMousePressed
        pnlApartment.setBackground(Default);
        pnlBuilding.setBackground(Default);
        pnlCategory.setBackground(Click);
        pnlContract.setBackground(Default);
        pnlCustomer.setBackground(Default);
        pnlHome.setBackground(Default);
        pnlLogout.setBackground(Default);
        pnlProblem.setBackground(Default);
        pnlSercurity.setBackground(Default);
        pnlService.setBackground(Default);
    }//GEN-LAST:event_pnlCategoryMousePressed

    private void pnlCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCategoryMouseClicked
        openCategory();
    }//GEN-LAST:event_pnlCategoryMouseClicked

    private void pnlCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCustomerMousePressed
        pnlApartment.setBackground(Default);
        pnlBuilding.setBackground(Default);
        pnlCategory.setBackground(Default);
        pnlContract.setBackground(Default);
        pnlCustomer.setBackground(Click);
        pnlHome.setBackground(Default);
        pnlLogout.setBackground(Default);
        pnlProblem.setBackground(Default);
        pnlSercurity.setBackground(Default);
        pnlService.setBackground(Default);
    }//GEN-LAST:event_pnlCustomerMousePressed

    private void pnlCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCustomerMouseClicked
        openCustomer();
    }//GEN-LAST:event_pnlCustomerMouseClicked

    private void pnlContractMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlContractMousePressed
        pnlApartment.setBackground(Default);
        pnlBuilding.setBackground(Default);
        pnlCategory.setBackground(Default);
        pnlContract.setBackground(Click);
        pnlCustomer.setBackground(Default);
        pnlHome.setBackground(Default);
        pnlLogout.setBackground(Default);
        pnlProblem.setBackground(Default);
        pnlSercurity.setBackground(Default);
        pnlService.setBackground(Default);
    }//GEN-LAST:event_pnlContractMousePressed

    private void pnlContractMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlContractMouseClicked
        openContract();
    }//GEN-LAST:event_pnlContractMouseClicked

    private void pnlApartmentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlApartmentMousePressed
        pnlApartment.setBackground(Click);
        pnlBuilding.setBackground(Default);
        pnlCategory.setBackground(Default);
        pnlContract.setBackground(Default);
        pnlCustomer.setBackground(Default);
        pnlHome.setBackground(Default);
        pnlLogout.setBackground(Default);
        pnlProblem.setBackground(Default);
        pnlSercurity.setBackground(Default);
        pnlService.setBackground(Default);
    }//GEN-LAST:event_pnlApartmentMousePressed

    private void pnlApartmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlApartmentMouseClicked
        openApartment();
    }//GEN-LAST:event_pnlApartmentMouseClicked

    private void pnlBuildingMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuildingMousePressed
        pnlApartment.setBackground(Default);
        pnlBuilding.setBackground(Click);
        pnlCategory.setBackground(Default);
        pnlContract.setBackground(Default);
        pnlCustomer.setBackground(Default);
        pnlHome.setBackground(Default);
        pnlLogout.setBackground(Default);
        pnlProblem.setBackground(Default);
        pnlSercurity.setBackground(Default);
        pnlService.setBackground(Default);
    }//GEN-LAST:event_pnlBuildingMousePressed

    private void pnlBuildingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBuildingMouseClicked
        openBuiding();
    }//GEN-LAST:event_pnlBuildingMouseClicked

    private void pnlHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHomeMousePressed
        pnlApartment.setBackground(Default);
        pnlBuilding.setBackground(Default);
        pnlCategory.setBackground(Default);
        pnlContract.setBackground(Default);
        pnlCustomer.setBackground(Default);
        pnlHome.setBackground(Click);
        pnlLogout.setBackground(Default);
        pnlProblem.setBackground(Default);
        pnlSercurity.setBackground(Default);
        pnlService.setBackground(Default);
    }//GEN-LAST:event_pnlHomeMousePressed

    private void pnlHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHomeMouseClicked
        openHome();
    }//GEN-LAST:event_pnlHomeMouseClicked

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
       
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
       openLogin();
    }//GEN-LAST:event_jMenu2MouseClicked

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lb_Apartment;
    private javax.swing.JLabel lb_Building;
    private javax.swing.JLabel lb_Home;
    private javax.swing.JLabel lb_cate;
    private javax.swing.JLabel lb_contract;
    private javax.swing.JLabel lb_customer;
    private javax.swing.JLabel lb_logout;
    private javax.swing.JLabel lb_problem;
    private javax.swing.JLabel lb_sercurity;
    private javax.swing.JLabel lb_service;
    private javax.swing.JLabel lb_userCurrent;
    private javax.swing.JPanel pnlApartment;
    private javax.swing.JPanel pnlBuilding;
    private javax.swing.JPanel pnlCategory;
    private javax.swing.JPanel pnlContract;
    private javax.swing.JPanel pnlCustomer;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlProblem;
    private javax.swing.JPanel pnlSercurity;
    private javax.swing.JPanel pnlService;
    private javax.swing.JPanel pnl_menu;
    // End of variables declaration//GEN-END:variables
}

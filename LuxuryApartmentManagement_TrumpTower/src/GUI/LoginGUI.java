
package GUI;

import DAO.AccountDAO;
import MODEL.Auth;
import javax.swing.JOptionPane;


public class LoginGUI extends javax.swing.JFrame {

    String name = "";
    public LoginGUI() {
        initComponents();
        lb_promptPass.setVisible(false);
        lb_promptUserName.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_signUp = new javax.swing.JButton();
        tf_username = new javax.swing.JTextField();
        pf_pass = new javax.swing.JPasswordField();
        lb_promptUserName = new javax.swing.JLabel();
        lb_promptPass = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 102, 0));
        jLabel1.setText("LOGIN");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 102, 0));
        jLabel2.setText("Email or username");

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        btn_login.setBackground(new java.awt.Color(153, 102, 0));
        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 204));
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        jLabel4.setText("I don't have an account");

        btn_signUp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_signUp.setForeground(new java.awt.Color(153, 102, 0));
        btn_signUp.setText("Sign Up");
        btn_signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signUpActionPerformed(evt);
            }
        });

        tf_username.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tf_username.setText("netprtony");
        tf_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tf_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_usernameFocusLost(evt);
            }
        });

        pf_pass.setForeground(new java.awt.Color(51, 0, 0));
        pf_pass.setText("123");
        pf_pass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pf_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pf_passFocusLost(evt);
            }
        });
        pf_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_passActionPerformed(evt);
            }
        });

        lb_promptUserName.setForeground(new java.awt.Color(255, 0, 0));
        lb_promptUserName.setText("You can't be left email or username blank!");

        lb_promptPass.setForeground(new java.awt.Color(255, 0, 0));
        lb_promptPass.setText("You can't be left password blank!");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel1))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_promptUserName)
                            .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(tf_username, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                .addComponent(pf_pass)
                                .addComponent(btn_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(LeftLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_signUp)))
                            .addComponent(lb_promptPass))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lb_promptUserName)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_promptPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btn_signUp))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel1.add(Left);
        Left.setBounds(400, 0, 400, 500);

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 204));
        jLabel9.setText("copyright © company name All rights reserved");

        jLabel6.setFont(new java.awt.Font("SimSun-ExtB", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Trump Tower");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel8)))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 118, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signUpActionPerformed
        SignUp SignUpFrame = new SignUp();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_btn_signUpActionPerformed

    private void pf_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_passActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        AccountDAO ac = new AccountDAO();
        String username = tf_username.getText();
        String pass = String.valueOf(pf_pass.getPassword());
        Auth.user = ac.Login(username, pass);
        if(Auth.user == null){
            JOptionPane.showMessageDialog(null, "Nhập tài khoản hoặc mật khẩu không đúng");
        }else{
            name = Auth.user.getName();
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
            MainGUI show = new MainGUI();
            show.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void tf_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_usernameFocusLost
        if(tf_username.getText().equals("")){
            lb_promptUserName.setVisible(true);
        }else{
            lb_promptUserName.setVisible(false);
        }
    }//GEN-LAST:event_tf_usernameFocusLost

    private void pf_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pf_passFocusLost
        if(pf_pass.getPassword().equals("")){
            lb_promptPass.setVisible(true);
        }else{
            lb_promptPass.setVisible(false);
        }
    }//GEN-LAST:event_pf_passFocusLost

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_promptPass;
    private javax.swing.JLabel lb_promptUserName;
    private javax.swing.JPasswordField pf_pass;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}

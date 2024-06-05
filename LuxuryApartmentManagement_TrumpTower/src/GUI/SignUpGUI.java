
package GUI;

import DAO.AccountDAO;
import MODEL.AccountModel;
import MODEL.DialogMessage;
import java.awt.Dialog;
import javax.swing.JOptionPane;


public class SignUpGUI extends javax.swing.JFrame {
     AccountDAO dao = new AccountDAO();
    public SignUpGUI() {
        initComponents();
        lb_promprRepass.setVisible(false);
        lb_promptFullname.setVisible(false);
        lb_promptPass.setVisible(false);
        lb_promptUserName.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_signUp = new javax.swing.JButton();
        btn_Login = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        pf_pass = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        pf_pass2 = new javax.swing.JPasswordField();
        lb_promptUserName = new javax.swing.JLabel();
        lb_promprRepass = new javax.swing.JLabel();
        lb_promptFullname = new javax.swing.JLabel();
        lb_promptPass = new javax.swing.JLabel();
        tf_fullname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 204));
        jLabel3.setText("copyright © company name All rights reserved");

        jLabel6.setFont(new java.awt.Font("SimSun-ExtB", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Trump Tower");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/donald-trump2.png"))); // NOI18N
        jLabel2.setToolTipText("");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/icon/pngwing.com.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel6)
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 500);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 102, 0));
        jLabel4.setText("SIGN UP");

        jLabel8.setText("I've an account");

        btn_signUp.setBackground(new java.awt.Color(153, 102, 0));
        btn_signUp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_signUp.setForeground(new java.awt.Color(255, 255, 204));
        btn_signUp.setText("Sign Up");
        btn_signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signUpActionPerformed(evt);
            }
        });

        btn_Login.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Login.setForeground(new java.awt.Color(153, 102, 0));
        btn_Login.setText("Login");
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(102, 102, 102));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 102, 0));
        jLabel9.setText("Full name");

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 102, 0));
        jLabel10.setText("Email or username");

        jLabel11.setBackground(new java.awt.Color(102, 102, 102));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 102, 0));
        jLabel11.setText("Password");

        tf_username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tf_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tf_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_usernameFocusLost(evt);
            }
        });
        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });

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

        jLabel12.setBackground(new java.awt.Color(102, 102, 102));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 102, 0));
        jLabel12.setText("Retype Password");

        pf_pass2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pf_pass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pf_pass2FocusLost(evt);
            }
        });
        pf_pass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_pass2ActionPerformed(evt);
            }
        });

        lb_promptUserName.setForeground(new java.awt.Color(255, 0, 0));
        lb_promptUserName.setText(" This account already exists! Please choose another account.");

        lb_promprRepass.setForeground(new java.awt.Color(255, 0, 0));
        lb_promprRepass.setText("Your confirmation password does not match!");

        lb_promptFullname.setForeground(new java.awt.Color(255, 0, 0));
        lb_promptFullname.setText("Full name does not empty!");
        lb_promptFullname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lb_promptFullnameFocusLost(evt);
            }
        });

        lb_promptPass.setForeground(new java.awt.Color(255, 0, 0));
        lb_promptPass.setText("Password does not empty!");
        lb_promptPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lb_promptPassFocusLost(evt);
            }
        });

        tf_fullname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tf_fullname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        tf_fullname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_fullnameFocusLost(evt);
            }
        });
        tf_fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fullnameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_signUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pf_pass)
                            .addComponent(pf_pass2)
                            .addComponent(tf_username)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lb_promptFullname)
                                .addComponent(lb_promprRepass)
                                .addComponent(lb_promptUserName)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(lb_promptPass)
                                .addComponent(tf_fullname)))))
                .addGap(65, 65, 65))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lb_promptFullname)
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_promptUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pf_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_promptPass)
                .addGap(4, 4, 4)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pf_pass2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lb_promprRepass)
                .addGap(18, 18, 18)
                .addComponent(btn_signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        LoginGUI LoginFrame = new LoginGUI();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_btn_LoginActionPerformed
    public boolean CheckForm(String name, String user, String pass, String rePass){
        
        if (dao.Check_resemble_username(user) > 0) {
           DialogMessage.alert(jPanel1, "Trùng tên đăng nhập vui lòng thử lại");
           return false;
       }else
           if(pass.equals("")) {
               DialogMessage.alert(jPanel1, "Vui lòng không để trống mật khẩu!");
               return false;
           }else
               if(!pass.equals(rePass)) {
                   DialogMessage.alert(jPanel1, "Nhập lại mật khẩu không khớp nhau. Hãy thử lại!");
                   return false;
               }else if(name.equals("")){ 
                    return DialogMessage.confirm(jPanel1, "Bạn không muốn cho chúng tôi biết tên của bạn?");
               }
        return true;
    }
    private void btn_signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signUpActionPerformed
        String name = tf_fullname.getText();
        String user = tf_username.getText();
        String pass  = String.valueOf(pf_pass.getPassword());
        String retypePass = String.valueOf(pf_pass2.getPassword());
        if(CheckForm(name, user, pass, retypePass)){
            Boolean role = true;
            AccountModel ac1 = new AccountModel(user, name, pass, role);
            int i = dao.Add(ac1);
            if(i > 0){
                DialogMessage.alert(jPanel1, "Đăng kí tài khoản thành công");
                btn_LoginActionPerformed(evt);
            }else{
                DialogMessage.alert(jPanel1, "Đăng kí tài khoản không thành công!");
            }
        }else{
            return;
        }
    }//GEN-LAST:event_btn_signUpActionPerformed

    private void pf_pass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_pass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_pass2ActionPerformed

    private void pf_pass2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pf_pass2FocusLost
        if(pf_pass2.getPassword().equals("")){
            lb_promprRepass.setText("Your confirmation password does not empty");
            lb_promprRepass.setVisible(true);
        }else{
            lb_promprRepass.setVisible(false);
        }
        
    }//GEN-LAST:event_pf_pass2FocusLost

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void tf_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_usernameFocusLost
        if(tf_username.getText().equals("")){
                lb_promptUserName.setText("User name does not empty!");
                lb_promptUserName.setVisible(true);
            }else if(dao.Check_resemble_username(tf_username.getText()) > 0) {
                lb_promptUserName.setText("This username already exists! Please choose another name.");
                lb_promptUserName.setVisible(true);
            }else{
                lb_promptUserName.setText("");
            }
    }//GEN-LAST:event_tf_usernameFocusLost

    private void pf_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_passActionPerformed

    private void pf_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pf_passFocusLost
    if(pf_pass.getPassword().equals("")){
            lb_promptPass.setText("Password does not empty!");
            lb_promptPass.setVisible(true);
        }else{
            lb_promptPass.setVisible(false);
        }
    }//GEN-LAST:event_pf_passFocusLost

    private void lb_promptPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lb_promptPassFocusLost
       
    }//GEN-LAST:event_lb_promptPassFocusLost

    private void lb_promptFullnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lb_promptFullnameFocusLost
       
    }//GEN-LAST:event_lb_promptFullnameFocusLost

    private void tf_fullnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_fullnameFocusLost
        if(this.isVisible()){
            if(tf_fullname.getText().equals("")){
                    lb_promptFullname.setVisible(true);
            }else{
                lb_promptFullname.setVisible(false);
            }
        }
    }//GEN-LAST:event_tf_fullnameFocusLost

    private void tf_fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_fullnameActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Login;
    private javax.swing.JButton btn_signUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lb_promprRepass;
    private javax.swing.JLabel lb_promptFullname;
    private javax.swing.JLabel lb_promptPass;
    private javax.swing.JLabel lb_promptUserName;
    private javax.swing.JPasswordField pf_pass;
    private javax.swing.JPasswordField pf_pass2;
    private javax.swing.JTextField tf_fullname;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}

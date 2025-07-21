package com.caglar.finalprojectaws.Views;

import com.caglar.finalprojectaws.Controllers.Controllers;
//import com.caglar.finalprojectaws.Controllers.Controllers.CryptoUtils;
import static com.caglar.finalprojectaws.ValidationAndMethod.ValidationAndCalculation.*;
import java.awt.Color;

public class LoginFrame extends javax.swing.JFrame {

    Controllers connect = new Controllers();
    
//    public PreparedStatement prest = null;

    public LoginFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        loginFramePanel = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        emailTF = new javax.swing.JTextField();
        logoHeadingLabel = new javax.swing.JLabel();
        loginBTN = new javax.swing.JButton();
        loginCB = new javax.swing.JComboBox<>();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GTI Record-Keeping System");
        setBounds(new java.awt.Rectangle(700, 170, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        loginFramePanel.setBackground(new java.awt.Color(239, 240, 234));

        emailLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(0, 0, 0));
        emailLabel.setText("Email");
        emailLabel.setPreferredSize(new java.awt.Dimension(100, 30));

        passwordLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(0, 0, 0));
        passwordLabel.setText("Password");
        passwordLabel.setPreferredSize(new java.awt.Dimension(100, 30));

        passwordField.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        passwordField.setText("jPasswordField1");
        passwordField.setToolTipText("Enter password");
        passwordField.setPreferredSize(new java.awt.Dimension(200, 30));
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldKeyTyped(evt);
            }
        });

        emailTF.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        emailTF.setToolTipText("Enter email address");
        emailTF.setPreferredSize(new java.awt.Dimension(200, 30));
        emailTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTFFocusLost(evt);
            }
        });
        emailTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailTFMouseClicked(evt);
            }
        });
        emailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTFActionPerformed(evt);
            }
        });
        emailTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailTFKeyTyped(evt);
            }
        });

        logoHeadingLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        logoHeadingLabel.setForeground(new java.awt.Color(0, 0, 0));
        logoHeadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoHeadingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/caglar/finalprojectaws/Images/gti-logo.png"))); // NOI18N
        logoHeadingLabel.setLabelFor(logoHeadingLabel);
        logoHeadingLabel.setText("Record-Keeping System Further Education College");
        logoHeadingLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoHeadingLabel.setIconTextGap(8);
        logoHeadingLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        loginBTN.setBackground(new java.awt.Color(0, 153, 153));
        loginBTN.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        loginBTN.setForeground(new java.awt.Color(255, 255, 255));
        loginBTN.setText("Login");
        loginBTN.setPreferredSize(new java.awt.Dimension(90, 30));
        loginBTN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginBTNFocusGained(evt);
            }
        });
        loginBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBTNMouseExited(evt);
            }
        });
        loginBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBTNActionPerformed(evt);
            }
        });

        loginCB.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        loginCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Teacher" }));
        loginCB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginCBFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                loginCBFocusLost(evt);
            }
        });
        loginCB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginCBMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginCBMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginCBMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginFramePanelLayout = new javax.swing.GroupLayout(loginFramePanel);
        loginFramePanel.setLayout(loginFramePanelLayout);
        loginFramePanelLayout.setHorizontalGroup(
            loginFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginFramePanelLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(loginFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoHeadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(loginFramePanelLayout.createSequentialGroup()
                        .addGroup(loginFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(loginFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loginBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailTF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        loginFramePanelLayout.setVerticalGroup(
            loginFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginFramePanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(logoHeadingLabel)
                .addGap(71, 71, 71)
                .addGroup(loginFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(loginFramePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(loginCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(loginBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginFramePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginFramePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTFActionPerformed

    }//GEN-LAST:event_emailTFActionPerformed

    private void loginBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBTNActionPerformed
        String email = emailTF.getText();
        String password = new String(passwordField.getPassword());
//        String encryptedInput = CryptoUtils.encrypt(password);

        passwordValidation(passwordField);

        // Admin Login setup
        if (loginCB.getSelectedIndex() == 0) {
            boolean successfulLogin = connect.loginAdmin(email, password);

            if (successfulLogin) {
                DisplayMessage("Succesful Login");
                AdminFrame admin = new AdminFrame();
                admin.setVisible(true);
            } else {
                Invalidlogin();
            }
        }

        // Teacher Login setup
        if (loginCB.getSelectedIndex() == 1) {
            boolean successfulLogin = connect.loginTeacher(email, password);

            if (successfulLogin) {
                DisplayMessage("Succesful Login");
                TeacherFrame teacher = new TeacherFrame();
                teacher.setVisible(true);

            } else {
                Invalidlogin();
            }
        }
    }//GEN-LAST:event_loginBTNActionPerformed

    private void loginBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBTNMouseEntered
        loginBTN.setBackground(new Color(0, 204, 204));
        loginBTN.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_loginBTNMouseEntered

    private void loginBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBTNMouseExited
        loginBTN.setBackground(new Color(0, 153, 153));
        loginBTN.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_loginBTNMouseExited

    private void loginCBMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginCBMouseEntered

    }//GEN-LAST:event_loginCBMouseEntered

    private void loginCBMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginCBMouseExited

    }//GEN-LAST:event_loginCBMouseExited

    private void loginCBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginCBMouseClicked

    }//GEN-LAST:event_loginCBMouseClicked

    private void emailTFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailTFMouseClicked

    }//GEN-LAST:event_emailTFMouseClicked

    private void emailTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTFFocusGained
        emailTF.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_emailTFFocusGained

    private void emailTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTFFocusLost
        emailTF.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_emailTFFocusLost

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        passwordField.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        passwordField.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_passwordFieldFocusLost

    private void loginCBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginCBFocusGained

    }//GEN-LAST:event_loginCBFocusGained

    private void loginCBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginCBFocusLost

    }//GEN-LAST:event_loginCBFocusLost

    private void loginBTNFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginBTNFocusGained

    }//GEN-LAST:event_loginBTNFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void emailTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTFKeyTyped
        emailValidation(evt,emailTF);
    }//GEN-LAST:event_emailTFKeyTyped

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyTyped
       
    }//GEN-LAST:event_passwordFieldKeyTyped

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTF;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JButton loginBTN;
    private javax.swing.JComboBox<String> loginCB;
    private javax.swing.JPanel loginFramePanel;
    private javax.swing.JLabel logoHeadingLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    // End of variables declaration//GEN-END:variables
}

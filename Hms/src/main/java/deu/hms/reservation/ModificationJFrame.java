/*


 */
package deu.hms.reservation;

/**
 *
 * @author Administrator1
 */
public class ModificationJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ModificationJFrame
     */
    public ModificationJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Modification");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        searchAddressButton = new javax.swing.JButton();
        chargeLabel = new javax.swing.JLabel();
        defaultPhoneJTextField = new javax.swing.JTextField();
        checkInDateChooser = new com.toedter.calendar.JDateChooser();
        checkOutDateChooser = new com.toedter.calendar.JDateChooser();
        nameLabel = new javax.swing.JLabel();
        chargeJTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        secondPhoneJTextField = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        thirdPhoneJTextField = new javax.swing.JTextField();
        checkInLabel = new javax.swing.JLabel();
        wonLabel = new javax.swing.JLabel();
        checkOutLabel = new javax.swing.JLabel();
        registButton = new javax.swing.JButton();
        lastNameJTextField = new javax.swing.JTextField();
        disposeButton = new javax.swing.JButton();
        firstNameJTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        searchAddressButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        searchAddressButton.setText("주소 검색");

        chargeLabel.setText("총 금액");

        defaultPhoneJTextField.setText("010");

        nameLabel.setText("이름");

        chargeJTextField.setEditable(false);
        chargeJTextField.setBackground(new java.awt.Color(240, 240, 240));

        phoneLabel.setText("전화번호");

        addressLabel.setText("주소");
        addressLabel.setToolTipText("");

        checkInLabel.setText("체크인");

        wonLabel.setText("원");

        checkOutLabel.setText("체크아웃");

        registButton.setText("등록");
        registButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registButtonActionPerformed(evt);
            }
        });

        lastNameJTextField.setText("성");
        lastNameJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameJTextFieldFocusLost(evt);
            }
        });

        disposeButton.setText("취소");
        disposeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disposeButtonActionPerformed(evt);
            }
        });

        firstNameJTextField.setText("이름");
        firstNameJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstNameJTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameJTextFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(registButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(disposeButton))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(checkInLabel)
                                    .addGap(30, 30, 30)
                                    .addComponent(checkInDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(checkOutLabel)
                                        .addComponent(chargeLabel))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(checkOutDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chargeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(wonLabel)))
                    .addComponent(nameLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneLabel)
                            .addComponent(addressLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchAddressButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(defaultPhoneJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secondPhoneJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thirdPhoneJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(lastNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(defaultPhoneJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondPhoneJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thirdPhoneJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressLabel)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchAddressButton)
                        .addGap(6, 6, 6)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkInLabel)
                        .addGap(18, 18, 18)
                        .addComponent(checkOutLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkInDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkOutDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chargeLabel)
                    .addComponent(chargeJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wonLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registButton)
                    .addComponent(disposeButton))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registButtonActionPerformed
        // TODO 등록 - 데이터베이스에 추가

    }//GEN-LAST:event_registButtonActionPerformed

    private void lastNameJTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameJTextFieldFocusGained

        if (lastNameJTextField.getText().equals("성")) { // 기본값 "성"(사용자 임의 입력이 "성"일 경우 포함)이면 Text Field에 focus가 생길 경우 Text Field를 비움
            lastNameJTextField.setText("");
        }
    }//GEN-LAST:event_lastNameJTextFieldFocusGained

    private void lastNameJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameJTextFieldFocusLost

        if (lastNameJTextField.getText().equals("")) { // 사용자 임의 입력 없이 Text Field에서 focus가 없어지면 "성"을 보이게 함
            lastNameJTextField.setText("성");
        }
    }//GEN-LAST:event_lastNameJTextFieldFocusLost

    private void disposeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disposeButtonActionPerformed

        dispose();
    }//GEN-LAST:event_disposeButtonActionPerformed

    private void firstNameJTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameJTextFieldFocusGained

        if (firstNameJTextField.getText().equals("이름")) { // 기본값 "이름"(사용자 임의 입력이 "이름"일 경우 포함)이면 Text Field에 focus가 생길 경우 Text Field를 비움
            firstNameJTextField.setText("");
        }
    }//GEN-LAST:event_firstNameJTextFieldFocusGained

    private void firstNameJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameJTextFieldFocusLost

        if (firstNameJTextField.getText().equals("")) { // 사용자 임의 입력 없이 Text Field에서 focus가 없어지면 "이름"을 보이게 함
            firstNameJTextField.setText("이름");
        }
    }//GEN-LAST:event_firstNameJTextFieldFocusLost

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
            java.util.logging.Logger.getLogger(ModificationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificationJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificationJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField chargeJTextField;
    private javax.swing.JLabel chargeLabel;
    private com.toedter.calendar.JDateChooser checkInDateChooser;
    private javax.swing.JLabel checkInLabel;
    private com.toedter.calendar.JDateChooser checkOutDateChooser;
    private javax.swing.JLabel checkOutLabel;
    private javax.swing.JTextField defaultPhoneJTextField;
    private javax.swing.JButton disposeButton;
    private javax.swing.JTextField firstNameJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField lastNameJTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton registButton;
    private javax.swing.JButton searchAddressButton;
    private javax.swing.JTextField secondPhoneJTextField;
    private javax.swing.JTextField thirdPhoneJTextField;
    private javax.swing.JLabel wonLabel;
    // End of variables declaration//GEN-END:variables
}

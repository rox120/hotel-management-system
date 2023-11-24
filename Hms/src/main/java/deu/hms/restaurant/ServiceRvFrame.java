/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deu.hms.restaurant;

import java.awt.Component;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ServiceRvFrame extends javax.swing.JFrame {

    private String Hour = null;
    private String Min = null;
    private String Year = null;
    private String Month = null;
    private String Day = null;

    WriteReservation WS = new WriteReservation();

    public ServiceRvFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public ServiceRvFrame(DefaultTableModel orderTableModel, int Total) {
        initComponents();
        setLocationRelativeTo(null);
        // OrderTable의 모델을 가져와서 RVTable로 복사
        copyOrderToRVTable(orderTableModel);
        WS.setTotal(Total);
    }

    private void copyOrderToRVTable(DefaultTableModel orderTableModel) {
        DefaultTableModel RVTableModel = (DefaultTableModel) RVTable.getModel();

        int rowCount = orderTableModel.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            Object[] rowData = {
                orderTableModel.getValueAt(i, 0),
                orderTableModel.getValueAt(i, 1),
                orderTableModel.getValueAt(i, 2)
            };
            System.out.println(rowData);
            RVTableModel.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Reservation = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hour = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        min = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        month = new javax.swing.JTextField();
        day = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        RVTable = new javax.swing.JTable();
        Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 22)); // NOI18N
        jLabel1.setText("예약하기");

        Reservation.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        Reservation.setText("예약하기");
        Reservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservationActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 246, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel2.setText("날짜 : ");
        jLabel2.setAutoscrolls(true);

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel3.setText("시간 : ");
        jLabel3.setAutoscrolls(true);

        hour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21" }));
        hour.setName("시"); // NOI18N
        hour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel4.setText("시");

        min.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "20", "30", "40", "50" }));
        min.setName("시"); // NOI18N
        min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel5.setText("분");

        jLabel6.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel6.setText("년");
        jLabel6.setAutoscrolls(true);

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel7.setText("월");
        jLabel7.setAutoscrolls(true);

        jLabel8.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel8.setText("일");
        jLabel8.setAutoscrolls(true);

        year.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        month.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        day.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        RVTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "메뉴", "가격", "수량"
            }
        ));
        RVTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(RVTable);

        Cancel.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        Cancel.setText("취소");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Reservation))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(180, 180, 180))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reservation)
                    .addComponent(Cancel))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        dispose();
    }//GEN-LAST:event_CancelActionPerformed

    private void ReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservationActionPerformed

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        Year = String.valueOf(year.getText());
        Month = String.valueOf(month.getText());
        Day = String.valueOf(day.getText());

        //년값이 유효한지 확인
        try {
            int yearValue = Integer.parseInt(Year);
            if (yearValue < currentYear) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "유효한 년도 값을 입력하세요 (" + currentYear + " 이상)");
            return;
        }

        //월 값이 유효한지 확인
        try {
            int monthValue = Integer.parseInt(Month);
            if (monthValue < 1 || monthValue > 12) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "유효한 월 값을 입력하세요 (1부터 12까지)");
            return;
        }
        //일 값이 유효한지 확인
        try {
            int dayValue = Integer.parseInt(Day);
            int maxDay = getMaxDayOfMonth(Integer.parseInt(Year), Integer.parseInt(Month));
            if (dayValue < 1 || dayValue > maxDay) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "유효한 일 값을 입력하세요 (1부터 " + getMaxDayOfMonth(Integer.parseInt(Year), Integer.parseInt(Month)) + "까지)");
            return;
        }

        //날짜 합치기
        WS.setDate(Year,Month,Day);
        
        try {
            WS.setTime(Hour, Min);
            if (Hour == null || Min == null) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "시간을 선택해주세요", "오류", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //시간 합치기
        WS.setTime(Hour,Min);

        if (WS.getTime() != null && WS.getDate() != null) {
            String MenuNum = null;
            //메뉴 합치기
            for (int i = 0; i < RVTable.getRowCount(); i++) {
                if (i == 0) {
                    MenuNum = (String.valueOf(RVTable.getValueAt(i, 0)) + " " + String.valueOf(RVTable.getValueAt(i, 2)) + "개");
                } else {
                    MenuNum = MenuNum.concat("/ " + String.valueOf(RVTable.getValueAt(i, 0)) + " " + String.valueOf(RVTable.getValueAt(i, 2)) + "개");
                }
            }
            WS.setMenuNum(MenuNum);
            WS.WriteReservationList();
            JOptionPane.showMessageDialog(null, "예약 완료", "알림", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_ReservationActionPerformed

    private void hourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourActionPerformed
        Hour = String.valueOf(hour.getSelectedItem());
    }//GEN-LAST:event_hourActionPerformed

    private void minActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minActionPerformed
        Min = String.valueOf(min.getSelectedItem());
    }//GEN-LAST:event_minActionPerformed

// 해당 월의 날짜를 반환하는 메서드
    private static int getMaxDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1); // month는 0부터 시작하므로 1을 빼줌
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

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
            java.util.logging.Logger.getLogger(ServiceRvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiceRvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiceRvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiceRvFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiceRvFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JTable RVTable;
    private javax.swing.JButton Reservation;
    private javax.swing.JTextField day;
    private javax.swing.JComboBox<String> hour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> min;
    private javax.swing.JTextField month;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}

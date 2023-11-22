package deu.hms.manageinfo;

import deu.hms.reservation.BookingInfo;
import deu.hms.reservation.FileManagement;
import deu.hms.reservation.ReservationManagementJFrame;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hyunwoo
 */
public class SettlementJFrame extends javax.swing.JFrame {

    /**
     * Creates new form SettlementJFrame
     */
    
    private ReservationManagementJFrame reservationManager = new ReservationManagementJFrame();
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String startDate;
    private String endDate;
    private int startDateValue = 0;
    private int endDateValue = 0;
    
    public String getStartDate() {
        
        startDate = dateFormat.format(inquiryStartDateChooser.getDate());
        
        return startDate;
    }
    
    public String getEndDate() {
        
        endDate = dateFormat.format(inquiryEndDateChooser.getDate());
        
        return endDate;
    }
    
    public void setStartDateValue(String startDate) {
        
        String[] dateValues = startDate.split("-");
        
        for (int i = 0; i < dateValues.length; ++i) {
            
            startDateValue += Integer.parseInt(dateValues[i]);
        }
    }
    
    public void setEndDateValue(String endDate) {
        
        String[] dateValues = endDate.split("-");
        
        for (int i = 0; i < dateValues.length; ++i) {
            
            endDateValue += Integer.parseInt(dateValues[i]);
        }
    }
    
    public SettlementJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        settlementTable = new javax.swing.JTable();
        inquiryStartDateChooser = new com.toedter.calendar.JDateChooser();
        inquiryEndDateChooser = new com.toedter.calendar.JDateChooser();
        fromLabel = new javax.swing.JLabel();
        toLabel = new javax.swing.JLabel();
        inquiryButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        settlementTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "투숙 인원", "예상 점유율", "객실 수익", "식품 수입"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(settlementTable);

        fromLabel.setText("부터");

        toLabel.setText("까지");

        inquiryButton.setText("조회");
        inquiryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inquiryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addComponent(inquiryStartDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromLabel)
                .addGap(18, 18, 18)
                .addComponent(inquiryEndDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toLabel)
                .addGap(18, 18, 18)
                .addComponent(inquiryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inquiryStartDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inquiryEndDateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(toLabel)
                        .addComponent(inquiryButton)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inquiryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inquiryButtonActionPerformed
        // TODO inquiryStartDateChooser~inquiryEndDateChooser
        
    }//GEN-LAST:event_inquiryButtonActionPerformed

    private int settlementThings() {
        
        
        
        ArrayList<BookingInfo> bookingInfo = new ArrayList<>();
        try {
            FileManagement fileMgmt = new FileManagement();
            fileMgmt.readBookingFileData(reservationManager.getFilePath());
            fileMgmt.splitBookingFileData();
            bookingInfo = fileMgmt.returnBookingInfo();

            // 데이터를 담을 2차원 배열 생성
            Object[][] data = new Object[bookingInfo.size()][12];
            int numberOfGuests = 0;
            int futureOccupancy = 0;
            int roomRevenue = 0;
            int serviceRevenue = 0;

            // 2차원 배열에 데이터 채우기
            for (int i = 0; i < bookingInfo.size(); ++i) {
                
                     
                data[i][5] = bookingInfo.get(i).getCheckInDate();
                data[i][6] = bookingInfo.get(i).getCheckOutDate();
                numberOfGuests += Integer.parseInt(bookingInfo.get(i).getNumberOfGuests());
                roomRevenue += Integer.parseInt(bookingInfo.get(i).getCostOfStaying());
            }
        } catch (IOException e) {
        }
        
        return 0;
    }
    
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
            java.util.logging.Logger.getLogger(SettlementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettlementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettlementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettlementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettlementJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fromLabel;
    private javax.swing.JButton inquiryButton;
    private com.toedter.calendar.JDateChooser inquiryEndDateChooser;
    private com.toedter.calendar.JDateChooser inquiryStartDateChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable settlementTable;
    private javax.swing.JLabel toLabel;
    // End of variables declaration//GEN-END:variables
}

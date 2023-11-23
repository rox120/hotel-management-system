/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deu.hms.manageinfo.hotelaccounts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bennyjung
 */
public class ModifyAccountsFrame extends javax.swing.JFrame {
    private DefaultTableModel accsTableModel;
    private final String path = System.getProperty("user.dir");
    private final String fileName = "/user_list.txt";
    private final String filePath = path + fileName; 

    /**
     * Creates new form ModifyAccountsFrame
     */
    public ModifyAccountsFrame() {
        initComponents();
        showAccountsData();
    }
    
    public void showAccountsData() {
        ArrayList<ModifyAccounts> accsData = new ArrayList<>();
        accsTableModel = (DefaultTableModel) accsTable.getModel();
        AccountsInfoList AIL = new AccountsInfoList();
        accsData = AIL.getAccsInfo();
        
        Object[][] data = new Object[accsData.size()][4];
        for (int i = 0; i < accsData.size(); ++i) {
            data[i][0] = accsData.get(i).getAccsNumb();
            data[i][1] = accsData.get(i).getAccsId();
            data[i][2] = accsData.get(i).getAccsPw();
            data[i][3] = accsData.get(i).getAccsAuth();
            
        }
        
        accsTableModel.setDataVector(data, new Object[] {
            "사용자 고유번호", "사용자 ID", "사용자 PW", "사용자 권한"
        });
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accsTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("사용자 계정 관리");

        accsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "사용자 고유번호", "사용자 ID", "사용자 PW", "사용자 권한"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        accsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accsTable);

        saveButton.setText("저장");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("삭제");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addButton.setText("등록");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accsTableMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2) {
            int selRow = accsTable.getSelectedRow();
            if(selRow != -1) {
                showPwEditDialog(selRow);
            }
        }
    }//GEN-LAST:event_accsTableMouseClicked

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        updateFile();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = accsTable.getSelectedRow();
        if (selectedRow != -1) {
        // Delete the row from the JTable
        accsTableModel.removeRow(selectedRow);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        ModifyAccountsDialog addDialog = new ModifyAccountsDialog(this,"Add Account", true, null);
        addDialog.setVisible(true);
        Object[] newData = addDialog.getEditedData();
        
        // Add the new row to the table model
        accsTableModel.addRow(newData);
        
    }//GEN-LAST:event_addButtonActionPerformed
    private void showPwEditDialog(int rowIndex) {
        ModifyAccountsDialog editDialog = new ModifyAccountsDialog(this, "Edit Pw", true,
                new Object[]{accsTableModel.getValueAt(rowIndex, 0),
                        accsTableModel.getValueAt(rowIndex, 1),
                        accsTableModel.getValueAt(rowIndex, 2),
                        accsTableModel.getValueAt(rowIndex, 3)});

        editDialog.setVisible(true);

        if (editDialog.getEditedData() != null) {
            Object[] editedData = editDialog.getEditedData();
            accsTableModel.setValueAt(editedData[0], rowIndex, 0);
            accsTableModel.setValueAt(editedData[1], rowIndex, 1);
            accsTableModel.setValueAt(editedData[2], rowIndex, 2);
            accsTableModel.setValueAt(editedData[3], rowIndex, 3);
        }
    
    }
    private void updateFile() {
       try{
            
            int rowCount = accsTableModel.getRowCount();
            int colCount = accsTableModel.getColumnCount();
            File file = new File(filePath);
            BufferedWriter wr = new BufferedWriter(new FileWriter(file));
            
            for(int row =0; row< rowCount; row++){
                for(int col =0; col< colCount; col++){
                    Object roomDatas = accsTableModel.getValueAt(row, col);
                    
                    wr.write(roomDatas.toString());
                    
                    // 열이 이동할때마다 탭 문자 추가 
                    if(col < colCount -1) {
                        wr.write("\t");
                    }
                }
                // 한 행이 끝날때마다 개행문자(%n) 추가 
                wr.write(System.lineSeparator());
            }
            
            wr.close();
        
        } catch(IOException e) {
        
        }
   
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
            java.util.logging.Logger.getLogger(ModifyAccountsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyAccountsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyAccountsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyAccountsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyAccountsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accsTable;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}

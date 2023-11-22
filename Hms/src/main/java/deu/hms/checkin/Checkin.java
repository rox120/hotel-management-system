/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deu.hms.checkin;


/**
 *
 * @author 장성열
 */

import deu.hms.login.MasterFrame;
import deu.hms.login.UserFrame;
import deu.hms.reservation.BookingInfo;
import deu.hms.reservation.FileManagement;
import deu.hms.reservation.ReservationManagementJFrame;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Checkin extends javax.swing.JFrame {

    /**
     * Creates new form Checkin
     */
    public Checkin() {
        initComponents();//초기화
        setLocationRelativeTo(null);//창 띄울때 가운데에서 띄움
    }
    private final String path = System.getProperty("user.dir");
    private final String filePath = path + "/reservationInfoList.txt";
    String path2 = System.getProperty("user.dir");
    String filePath2 = path2 + "/specialRequestsList.txt";
    //String[] PreviousStateCheckin;
    //String[] PreviousStateReservation;
    
    public void serchReservationData() {//예약자 검색
        ArrayList<UserInfoList> userInfo = new ArrayList<>();
        DefaultTableModel reservationTableModel = (DefaultTableModel) ReservationListTable.getModel();
        
        try {
            LoadUserList fileMgmt = new LoadUserList();
            userInfo = fileMgmt.returnUserInfo();
            int j=0;
            // 데이터를 담을 2차원 배열 생성
            Object[][] data = new Object[userInfo.size()][11];
            
            // 2차원 배열에 데이터 채우기
            if (SerchComboBox.getSelectedIndex()==0) { //고객명일 경우
            //JOptionPane.showMessageDialog(null,"0");
            
            for (int i = 0; i < userInfo.size(); ++i) {
                if(userInfo.get(i).getName().equals(SerchTextField.getText())){
                data[j][0] = userInfo.get(i).getIndex();
                data[j][1] = userInfo.get(i).getName();
                data[j][2] = userInfo.get(i).getRoomNumber();
                data[j][3] = userInfo.get(i).getPhone();
                data[j][4] = userInfo.get(i).getPhone(); //지불유형
                data[j][5] = userInfo.get(i).getCostOfStaying();
//                System.out.println(userInfo.get(i).getCheckInStatus());
                /*if(userInfo.get(i).getCheckInStatus().equals("N") || userInfo.get(i).getCheckInStatus().equals("D")){
                    PreviousStateReservation[i]=userInfo.get(i).getCheckInStatus();
                    data[j][6] = PreviousStateReservation[i];
                }
                else if(PreviousStateReservation[i] == null){
                    data[j][6] = "-";
                }
                else{
                    data[j][6] = PreviousStateReservation[i];
                }
                if(userInfo.get(i).getCheckInStatus().equals("Y") || userInfo.get(i).getCheckInStatus().equals("O")){
                    PreviousStateCheckin[i]=userInfo.get(i).getCheckInStatus();
                    data[j][7] = PreviousStateCheckin[i];
                }
                else if(PreviousStateCheckin[i]==null){
                    data[j][7] = "-";
                }
                else{
                    data[j][7] = PreviousStateCheckin[i];
                }*/
                data[j][6]=userInfo.get(i).getCheckInStatus();
                //data[j][7]=userInfo.get(i).getCheckInStatus();
                j++;
                }
            }
            }
        else if(SerchComboBox.getSelectedIndex()==1){ //고유번호일 경우
            for (int i = 0; i < userInfo.size(); ++i) {
                if(userInfo.get(i).getName().equals(SerchTextField.getText())){
                data[j][0] = userInfo.get(i).getIndex();
                data[j][1] = userInfo.get(i).getName();
                data[j][2] = userInfo.get(i).getRoomNumber();
                data[j][3] = userInfo.get(i).getPhone();
                data[j][4] = userInfo.get(i).getPhone(); //지불유형
                data[j][5] = userInfo.get(i).getCostOfStaying();
                /*
                if(userInfo.get(i).getCheckInStatus().equals("N") || userInfo.get(i).getCheckInStatus().equals("D")) {
                    PreviousStateReservation[i] = userInfo.get(i).getCheckInStatus();
                }
                else if(PreviousStateReservation[i].equals("")) {
                    PreviousStateReservation[i] = "-";
                }
                data[j][6] = PreviousStateReservation[i];// 예약
                PreviousStateCheckin[i] = "-";
                if(userInfo.get(i).getCheckInStatus().equals("Y") || userInfo.get(i).getCheckInStatus().equals("O")) {
                    PreviousStateCheckin[i] = userInfo.get(i).getCheckInStatus();
                }
                else if(PreviousStateCheckin[i].equals("")) {
                    PreviousStateCheckin[i] = "-";
                }
                data[j][7] = PreviousStateCheckin[i];*/
                data[j][6]=userInfo.get(i).getCheckInStatus();
                //data[j][7]=userInfo.get(i).getCheckInStatus();
                j++;
                }
            }
        }
            // 테이블 모델 업데이트
            reservationTableModel.setDataVector(data, new Object[]{
                "고유번호", "고객명", "객실호수", "전화번호", "지불유형",
                "객실요금", "예약/체크인"
            });
            SetTableWidth();
        }
        catch (IOException e) {
        }
        
    }
    
    public void addSRList(int x,int y){ //x부터 y-1까지 특이사항 리스트를 생성(임시코드)
    for (int i = x; i < y; i++) {
            //if(){
            String inputData = String.format("%s\t%s\t", 
                                        Integer.toString(i),"");
            try (FileWriter fileWriter = new FileWriter(filePath2, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                    bufferedWriter.write(inputData);
                    bufferedWriter.newLine();

                    bufferedWriter.flush();
                    bufferedWriter.close();

        } catch (IOException e) {
                    e.printStackTrace();
        }
    }
    }
    
    public void SetTableWidth(){//ReservationListTable의 셀 너비 설정
    ReservationListTable.getColumn("고유번호").setPreferredWidth(65);
    ReservationListTable.getColumn("고객명").setPreferredWidth(65);
    ReservationListTable.getColumn("객실호수").setPreferredWidth(65);
    ReservationListTable.getColumn("전화번호").setPreferredWidth(130);
    ReservationListTable.getColumn("지불유형").setPreferredWidth(65);
    ReservationListTable.getColumn("객실요금").setPreferredWidth(65);
    ReservationListTable.getColumn("예약/체크인").setPreferredWidth(80);
    //ReservationListTable.getColumn("체크인").setPreferredWidth(50);
    }
    public String getSpecialRequest(){//선택된 셀의 특별요청을 리턴하는 함수
        
        Object targetIndex;
        int selectedRow = ReservationListTable.getSelectedRow();
        targetIndex = ReservationListTable.getValueAt(selectedRow, 0);
        String[] columns = null;
        String SR=""; // 리턴할 데이터

        try {
            File file = new File(filePath2);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();

            // 파일의 내용을 읽어오면서 리턴할 부분을 찾음
            String line;
            int currentIndex = 1;
            while ((line = br.readLine()) != null) {
                if (currentIndex == Integer.parseInt((String) targetIndex)) {
                    // 특정 행일 경우, 리턴할 데이터로 변경
                    columns = line.split("\t");
                    SR=columns[1];
                    sb.append(line).append("\n");
                } else {
                    // 나머지 행은 그대로 유지
                    sb.append(line).append("\n");
                }
                ++currentIndex;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return SR;
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
        CheckinButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReservationListTable = new javax.swing.JTable();
        SerchButton = new javax.swing.JButton();
        SerchComboBox = new javax.swing.JComboBox<>();
        SerchTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SpecialRequests = new javax.swing.JTextField();
        CheckoutButton = new javax.swing.JButton();
        SpecialRequestsButton = new javax.swing.JButton();
        ReservationModificationButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel1.setText("체크인/체크아웃");

        CheckinButton.setText("체크인");
        CheckinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckinButtonActionPerformed(evt);
            }
        });

        BackButton.setText("취소");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        ReservationListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, "", null, null, null},
                {null, null, null, "", null, null, null},
                {null, null, null, "", null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "고유번호", "고객명", "객실호수", "전화번호", "지불유형", "객실요금", "예약/체크인"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ReservationListTable.getTableHeader().setReorderingAllowed(false);
        ReservationListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReservationListTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ReservationListTable);
        if (ReservationListTable.getColumnModel().getColumnCount() > 0) {
            ReservationListTable.getColumnModel().getColumn(0).setResizable(false);
            ReservationListTable.getColumnModel().getColumn(0).setPreferredWidth(65);
            ReservationListTable.getColumnModel().getColumn(1).setResizable(false);
            ReservationListTable.getColumnModel().getColumn(1).setPreferredWidth(65);
            ReservationListTable.getColumnModel().getColumn(2).setResizable(false);
            ReservationListTable.getColumnModel().getColumn(2).setPreferredWidth(65);
            ReservationListTable.getColumnModel().getColumn(3).setResizable(false);
            ReservationListTable.getColumnModel().getColumn(3).setPreferredWidth(130);
            ReservationListTable.getColumnModel().getColumn(4).setResizable(false);
            ReservationListTable.getColumnModel().getColumn(4).setPreferredWidth(65);
            ReservationListTable.getColumnModel().getColumn(5).setResizable(false);
            ReservationListTable.getColumnModel().getColumn(5).setPreferredWidth(65);
            ReservationListTable.getColumnModel().getColumn(6).setResizable(false);
            ReservationListTable.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        SerchButton.setText("검색");
        SerchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerchButtonActionPerformed(evt);
            }
        });

        SerchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "고객명", "고유번호" }));
        SerchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerchComboBoxActionPerformed(evt);
            }
        });

        SerchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerchTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("예약자 명단");

        jLabel3.setText("특이사항");

        SpecialRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpecialRequestsActionPerformed(evt);
            }
        });

        CheckoutButton.setText("체크아웃");
        CheckoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutButtonActionPerformed(evt);
            }
        });

        SpecialRequestsButton.setText("특이사항 수정");
        SpecialRequestsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpecialRequestsButtonActionPerformed(evt);
            }
        });

        ReservationModificationButton.setText("예약정보 수정");
        ReservationModificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservationModificationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(SerchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(SerchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SerchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(12, 12, 12)
                                    .addComponent(ReservationModificationButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(SpecialRequestsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CheckoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(CheckinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(SpecialRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addComponent(jLabel2))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel1)
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SerchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SerchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SerchButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SpecialRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton)
                    .addComponent(CheckinButton)
                    .addComponent(CheckoutButton)
                    .addComponent(SpecialRequestsButton)
                    .addComponent(ReservationModificationButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jScrollPane1.getAccessibleContext().setAccessibleParent(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckinButtonActionPerformed
        //체크인버튼
        Object targetIndex;
        int selectedRow = ReservationListTable.getSelectedRow();
        targetIndex = ReservationListTable.getValueAt(selectedRow, 0);
        String[] columns = null;
        
        String replacementData = "Y"; // 체크인유무를 Y로 변경

        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();

            // 파일의 내용을 읽어오면서 수정할 부분을 찾음
            String line;
            int currentIndex = 1;
            while ((line = br.readLine()) != null) {
                if (currentIndex == Integer.parseInt((String) targetIndex)) {
                    // 특정 행일 경우, 수정할 데이터로 변경
                    columns = line.split("\t");
                    columns[columns.length - 1] = replacementData;//체크인유무를 변경
                    line = reWriteLine(columns);
                    sb.append(line).append("\n");
                
                } else {
                    // 나머지 행은 그대로 유지
                    sb.append(line).append("\n");
                }
                ++currentIndex;
            }
            br.close();

            // 수정된 내용을 파일에 다시 쓰고 저장
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            writer.flush();
            writer.close();
            serchReservationData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CheckinButtonActionPerformed
    private String reWriteLine(String[] columns) {//유저리스트
        String line = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t", 
                                    columns[0], columns[1], columns[2], columns[3],
                                    columns[4], columns[5], columns[6], columns[7],
                                    columns[8], columns[9], columns[10]);
        
        return line;
    }
    private String reWriteLine2(String[] columns) {//요청사항
        String line = String.format("%s\t%s\t", 
                                    columns[0], columns[1]);
        
        return line;
    }
    private void SerchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SerchButtonActionPerformed
        // TODO add your handling code here:
        serchReservationData();        
    }//GEN-LAST:event_SerchButtonActionPerformed

    private void SerchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SerchComboBoxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SerchComboBoxActionPerformed

    private void SerchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SerchTextFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SerchTextFieldActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed
    
    private void SpecialRequestsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpecialRequestsButtonActionPerformed
        // TODO add your handling code here:
        Object targetIndex;
        int selectedRow = ReservationListTable.getSelectedRow();
        targetIndex = ReservationListTable.getValueAt(selectedRow, 0);
        String[] columns = null;
    
        String replacementData = SpecialRequests.getText(); // 수정할 데이터

        try {
            File file = new File(filePath2);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();

            // 파일의 내용을 읽어오면서 수정할 부분을 찾음
            String line;
            int currentIndex = 1;
            while ((line = br.readLine()) != null) {
                if (currentIndex == Integer.parseInt((String) targetIndex)) {
                    // 특정 행일 경우, 수정할 데이터로 변경
                    columns = line.split("\t");
                    columns[1] = replacementData;
                    line = reWriteLine2(columns);
                    sb.append(line).append("\n");
                } else {
                    // 나머지 행은 그대로 유지
                    sb.append(line).append("\n");
                }
                ++currentIndex;
            }
            br.close();

            // 수정된 내용을 파일에 다시 쓰고 저장
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_SpecialRequestsButtonActionPerformed
    private String DayTime;

    public String getDayTime() {
        return DayTime;
    }

    public void setDayTime() {//DayTime을 현재시간으로 설정
        LocalDateTime now = LocalDateTime.now();
        this.DayTime = now.format(DateTimeFormatter.ofPattern("HH"));
    }
    public int AdditionalCost(){
        int additionalcost=0;
        setDayTime();
        //2023-11-23
        String time = getDayTime();
        if(Integer.parseInt(time)>=11){//현재시간이 11시를 넘으면
            additionalcost = 10000;//추가요금을 10000원으로 변경
        }
        return additionalcost;
}
    private void CheckoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutButtonActionPerformed
        //체크아웃 버튼
        Object targetIndex;
        int selectedRow = ReservationListTable.getSelectedRow();
        targetIndex = ReservationListTable.getValueAt(selectedRow, 0);
        String[] columns = null;
        
        String replacementData = "O"; // 수정할 데이터를 지정하세요
        
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();

            // 파일의 내용을 읽어오면서 수정할 부분을 찾음
            String line;
            int currentIndex = 1;
            while ((line = br.readLine()) != null) {
                if (currentIndex == Integer.parseInt((String) targetIndex)) {
                    // 특정 행일 경우, 수정할 데이터로 변경
                    columns = line.split("\t");
                    if(!columns[columns.length - 1].equals("O")){
                        // 11시를 넘겨서 체크아웃시 객실요금 추가
                        columns[columns.length - 2] = Integer.toString(Integer.parseInt(columns[columns.length - 2])+AdditionalCost());
                        columns[columns.length - 1] = replacementData;
                    }
                    line = reWriteLine(columns);
                    
                    sb.append(line).append("\n");
                } else {
                    // 나머지 행은 그대로 유지
                    sb.append(line).append("\n");
                }
                ++currentIndex;
            }
            br.close();

            // 수정된 내용을 파일에 다시 쓰고 저장
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            writer.flush();
            writer.close();

            serchReservationData();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_CheckoutButtonActionPerformed

    private void ReservationModificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservationModificationButtonActionPerformed
        // TODO add your handling code here:
        ReservationManagementJFrame Mod = new ReservationManagementJFrame();
        Mod.setVisible(true);
    }//GEN-LAST:event_ReservationModificationButtonActionPerformed

    private void ReservationListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReservationListTableMouseClicked
        // 선택된 셀의 특별요청을 텍스트필드에 뛰우는 함수
        SpecialRequests.setText(getSpecialRequest());
    }//GEN-LAST:event_ReservationListTableMouseClicked

    private void SpecialRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpecialRequestsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SpecialRequestsActionPerformed

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
            java.util.logging.Logger.getLogger(Checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CheckinButton;
    private javax.swing.JButton CheckoutButton;
    private javax.swing.JTable ReservationListTable;
    private javax.swing.JButton ReservationModificationButton;
    private javax.swing.JButton SerchButton;
    private javax.swing.JComboBox<String> SerchComboBox;
    private javax.swing.JTextField SerchTextField;
    private javax.swing.JTextField SpecialRequests;
    private javax.swing.JButton SpecialRequestsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

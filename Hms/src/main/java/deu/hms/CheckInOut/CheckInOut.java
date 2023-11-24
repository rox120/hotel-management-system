/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package deu.hms.CheckInOut;

/**
 *
 * @author 장성열
 */
import deu.hms.login.MasterFrame;
import deu.hms.login.UserFrame;
import deu.hms.reservation.BookingInfo;
import deu.hms.reservation.FileManagement;
import deu.hms.reservation.ReservationManagementJFrame;
import deu.hms.restaurant.OrderModifyFrame;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javax.swing.JTable;
import javax.swing.JTextField;

public class CheckInOut extends javax.swing.JFrame {

    /**
     * Creates new form Checkin
     */
    public CheckInOut() {
        initComponents();//초기화
        setLocationRelativeTo(null);//창 띄울때 가운데에서 띄움
    }
    private final String path = System.getProperty("user.dir");
    private final String filePath = path + "/clientInfo.txt";
    private final String filePath2 = path + "/specialRequestsList.txt";
    private final String filePath3 = path + "/feedbackList.txt";

    public void serchReservationData() {//예약자 검색
        ArrayList<ClientInfoList> userInfo = new ArrayList<>();
        DefaultTableModel reservationTableModel = (DefaultTableModel) ReservationListTable.getModel();

        try {
            LoadClientList fileMgmt = new LoadClientList();
            userInfo = fileMgmt.returnUserInfo();
            int j = 0;
            // 데이터를 담을 2차원 배열 생성
            Object[][] data = new Object[userInfo.size()][11];
            // 2차원 배열에 데이터 채우기
            if (SerchComboBox.getSelectedIndex() == 0) { //고객명일 경우
                //JOptionPane.showMessageDialog(null,"0");

                for (int i = 0; i < userInfo.size(); ++i) {
                    if (userInfo.get(i).getName().equals(SerchTextField.getText())) {
                        data[j][0] = userInfo.get(i).getIndex();        //고유번호
                        data[j][1] = userInfo.get(i).getName();         //고객명
                        data[j][2] = userInfo.get(i).getRoomNumber();   //방번호
                        data[j][3] = userInfo.get(i).getPhone();        //전화번호
                        data[j][4] = userInfo.get(i).getPaymentMethod();//지불유형
                        data[j][5] = userInfo.get(i).getCostOfStaying();//객실요금
                        data[j][6] = userInfo.get(i).getCheckInStatus();//예약/체크인
                        j++;
                    }
                }
            } else if (SerchComboBox.getSelectedIndex() == 1) { //고유번호일 경우
                for (int i = 0; i < userInfo.size(); ++i) {
                    if (userInfo.get(i).getIndex().equals(SerchTextField.getText())) {
                        data[j][0] = userInfo.get(i).getIndex();        //고유번호
                        data[j][1] = userInfo.get(i).getName();         //고객명
                        data[j][2] = userInfo.get(i).getRoomNumber();   //방번호
                        data[j][3] = userInfo.get(i).getPhone();        //전화번호
                        data[j][4] = userInfo.get(i).getPaymentMethod();//지불유형
                        data[j][5] = userInfo.get(i).getCostOfStaying();//객실요금
                        data[j][6] = userInfo.get(i).getCheckInStatus();//예약/체크인
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
        } catch (IOException e) {
        }
    }

    public int getFoodRevenue(String roomnumber) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/order_list.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        String[] column;
        int foodRevenue = 0;
        try {
            while ((line = br.readLine()) != null) {
                column = line.split("\t");
                if (roomnumber.equals(column[1])) {
                    if (column[4].equals("객실청구")) {
                        foodRevenue += Integer.parseInt(column[5]);
                    }
                }

            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(CheckInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        return foodRevenue;
    }

    public void addSRList(int x, int y, String filepath) { //x부터 y-1까지 특이사항 리스트, 피드백 리스트를 생성(임시코드)
        for (int i = x; i < y; i++) {
            //if(){
            String inputData = String.format("%s\t%s\t",
                    Integer.toString(i), " ");
            try (FileWriter fileWriter = new FileWriter(filepath, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                bufferedWriter.write(inputData);
                bufferedWriter.newLine();

                bufferedWriter.flush();
                bufferedWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void SetTableWidth() { //ReservationListTable의 셀 너비 설정
        ReservationListTable.getColumn("고유번호").setPreferredWidth(65);
        ReservationListTable.getColumn("고객명").setPreferredWidth(65);
        ReservationListTable.getColumn("객실호수").setPreferredWidth(65);
        ReservationListTable.getColumn("전화번호").setPreferredWidth(130);
        ReservationListTable.getColumn("지불유형").setPreferredWidth(65);
        ReservationListTable.getColumn("객실요금").setPreferredWidth(65);
        ReservationListTable.getColumn("예약/체크인").setPreferredWidth(80);
    }

    public String getSpecialRequestORFeedback(String filepath) { //매개변수 파일에 따라 선택된 셀의 특이사항, 피드백을 리턴하는 함수

        Object targetIndex;
        int selectedRow = ReservationListTable.getSelectedRow();
        targetIndex = ReservationListTable.getValueAt(selectedRow, 0);//선택된 고객의 고유번호를 저장
        String[] columns = null;
        String SR = ""; // 특이사항을 저장하여 리턴하는 변수

        try {
            File file = new File(filepath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();

            // 파일의 내용을 읽어오면서 리턴할 부분을 찾음
            String line;
            int currentIndex = 1;
            while ((line = br.readLine()) != null) {
                if (currentIndex == Integer.parseInt((String) targetIndex)) {
                    // 특정 행일 경우, 리턴할 데이터로 변경
                    columns = line.split("\t");
                    SR = columns[1];
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
        SaveTextContentButton = new javax.swing.JButton();
        ReservationModificationButton = new javax.swing.JButton();
        Feedback = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        OrderList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel1.setText("고객관리");

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

        SaveTextContentButton.setText("입력내용 저장");
        SaveTextContentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveTextContentButtonActionPerformed(evt);
            }
        });

        ReservationModificationButton.setText("예약정보 수정");
        ReservationModificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservationModificationButtonActionPerformed(evt);
            }
        });

        Feedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FeedbackActionPerformed(evt);
            }
        });

        jLabel4.setText("피드백");

        OrderList.setText("서비스 확인");
        OrderList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ReservationModificationButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(OrderList)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SaveTextContentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(162, 162, 162))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(SerchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(SerchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SerchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(SpecialRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CheckoutButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CheckinButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(Feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SerchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SerchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SerchButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SpecialRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Feedback, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackButton)
                    .addComponent(CheckinButton)
                    .addComponent(SaveTextContentButton)
                    .addComponent(ReservationModificationButton)
                    .addComponent(OrderList)
                    .addComponent(CheckoutButton))
                .addGap(30, 30, 30))
        );

        jScrollPane1.getAccessibleContext().setAccessibleParent(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckinButtonActionPerformed
        //체크인버튼
        int selectedrow = ReservationListTable.getSelectedRow();
        if (selectedrow == -1) {
            JOptionPane.showMessageDialog(null, "고객을 선택해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
        } else {
            Object targetIndex;
            int selectedRow = ReservationListTable.getSelectedRow();
            targetIndex = ReservationListTable.getValueAt(selectedRow, 0);
            String[] columns = null;

            String replacementData = "체크인"; // 체크인유무를 "체크인"으로 변경

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
                JOptionPane.showMessageDialog(null, "체크인 되었습니다.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_CheckinButtonActionPerformed
    private String reWriteLine(String[] columns) {//유저리스트
        String line = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t",
                columns[0], columns[1], columns[2], columns[3],
                columns[4], columns[5], columns[6], columns[7],
                columns[8], columns[9], columns[10], columns[11]);

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

    private void SaveTextContentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveTextContentButtonActionPerformed
        // 입력내용 저장 버튼
        int selectedrow = ReservationListTable.getSelectedRow();
        if (selectedrow == -1) {
            JOptionPane.showMessageDialog(null, "고객을 선택해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
        } else {
            modifyFile(filePath2, ReservationListTable, SpecialRequests);
            modifyFile(filePath3, ReservationListTable, Feedback);
            JOptionPane.showMessageDialog(null, "입력내용이 저장되었습니다.");
            SpecialRequests.setText("");
            Feedback.setText("");
        }
    }//GEN-LAST:event_SaveTextContentButtonActionPerformed

    public void modifyFile(String filepath, JTable targetTable, JTextField targetField) {
        Object targetIndex;
        int selectedRow = targetTable.getSelectedRow();
        targetIndex = targetTable.getValueAt(selectedRow, 0);//선택된 셀의 0번째 값 고유번호를 저장
        String[] columns = null;

        String replacementData = targetField.getText(); // targetField에 적은 텍스트를 저장

        try {
            File file = new File(filepath);//특이사항 리스트 읽어옴
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();

            // 파일의 내용을 읽어오면서 수정할 부분을 찾음
            String line;
            int currentIndex = 1;//고유번호 1부터 검사하기위한 변수
            while ((line = br.readLine()) != null) {
                if (currentIndex == Integer.parseInt((String) targetIndex)) {
                    // 특정 행일 경우, 수정할 데이터로 변경
                    columns = line.split("\t");//"\t"를 기준으로 line을 나눔
                    columns[1] = replacementData;//입력내용 저장
                    line = reWriteLine2(columns);
                    sb.append(line).append("\n");//sb에 line과 "\n" 추가
                } else {
                    // 나머지 행은 그대로 유지
                    sb.append(line).append("\n");
                }
                ++currentIndex;
            }
            br.close();

            // 수정된 내용을 파일에 다시 쓰고 저장
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());//sb를 적음
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String setoneDayCost(String roomnumber) throws FileNotFoundException {//하루 숙박비용 저장
        File file = new File(System.getProperty("user.dir") + "/test_room.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        String[] column;
        String oneDayCost = "";
        String roomNumber = roomnumber.substring(0, roomnumber.length() - 2); //룸번호에서 뒤에 두자리를 제외하고 저장
        System.out.println(roomNumber);
        try {
            while ((line = br.readLine()) != null) {
                column = line.split("\t");
                if (roomNumber.equals(column[0])) {
                    oneDayCost = column[3];
                }
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(CheckInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oneDayCost;
    }

    private String DayTime;

    public String getDayTime() {
        return DayTime;
    }

    public void setDayTime() {//DayTime을 현재시간으로 설정
        LocalDateTime now = LocalDateTime.now();
        this.DayTime = now.format(DateTimeFormatter.ofPattern("HH"));//현재 시간만 저장 ex)11(시)
    }

    public int AdditionalCost(String roomnumber) { //객실호수를 받아와 11시가 넘었다면 해당객실의 1박요금을 리턴하는 함수
        int additionalcost = 0;
        setDayTime();
        String time = getDayTime();
        if (Integer.parseInt(time) >= 11) {
            try {                            //현재시간이 11시를 넘으면
                additionalcost = Integer.parseInt(setoneDayCost(roomnumber));   //추가요금을 1박 요금으로 변경
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CheckInOut.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return additionalcost;
    }
    private void CheckoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutButtonActionPerformed
        //체크아웃 버튼
        int selectedrow = ReservationListTable.getSelectedRow();
        if (selectedrow == -1) {
            JOptionPane.showMessageDialog(null, "고객을 선택해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
        } else {
            Object targetIndex;
            int selectedRow = ReservationListTable.getSelectedRow();
            targetIndex = ReservationListTable.getValueAt(selectedRow, 0); //선택된 셀의 0번째 값 고유번호를 저장
            String[] columns = null;

            String replacementData = "체크아웃"; // 체크인유무를 "체크아웃으로 변경
            String roomRevenue = "0";
            int foodRevenue = 0;
            int totalRevenue = 0;
            int additionalCost = 0;
            String additionalCostMessage = ""; //추가요금 발생시 출력할 메시지를 저장할 변수
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
                        columns = line.split("\t");                             //"\t"를 기준으로 line을 나눔
                        additionalCost = AdditionalCost(columns[8]);                 // 11시를 넘겨서 체크아웃시 객실요금 추가
                        if (!columns[columns.length - 1].equals("체크아웃")) {//체크아웃 상태일때 추가요금이 생기지 않도록 체크
                            columns[columns.length - 3] = Integer.toString(Integer.parseInt(columns[columns.length - 3]) + additionalCost);
                        }
                        columns[columns.length - 1] = replacementData;              //예약/체크인 상태를"체크아웃"으로 변경
                        roomRevenue = columns[9];                                   //룸 비용 출력을 위해 변수에 저장
                        foodRevenue = getFoodRevenue(columns[8]);                     //방번호를 넘겨서 객실청구된 비용을 foodRevenue에 저장
                        totalRevenue = Integer.parseInt(roomRevenue) + foodRevenue; //총 비용 계산
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

                serchReservationData();//테이블 업데이트
                if (additionalCost != 0) {
                    additionalCostMessage = "11시가 넘어 추가요금" + additionalCost + "원이 객실요금에 추가되었습니다.";
                }
                JOptionPane.showMessageDialog(null,
                        additionalCostMessage + "\n" + "객실요금   " + roomRevenue + "원\n"
                        + "음식비용  " + foodRevenue + "원\n"
                        + "총 비용   " + totalRevenue + "원");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_CheckoutButtonActionPerformed

    private void ReservationModificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservationModificationButtonActionPerformed
        // 예약수정버튼
        ReservationManagementJFrame Mod = new ReservationManagementJFrame();
        Mod.setVisible(true);
    }//GEN-LAST:event_ReservationModificationButtonActionPerformed
    public String selectedRoomNumber = "0";
    private void ReservationListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReservationListTableMouseClicked
        // 선택된 셀의 특별요청을 텍스트필드에 띄움
        SpecialRequests.setText(getSpecialRequestORFeedback(filePath2));
        // 선택된 셀의 피드백을 텍스트필드에 띄움
        Feedback.setText(getSpecialRequestORFeedback(filePath3));
        //selectedRoomNumber 에 선택된 셀의 객실호수를 저장
        getselectedRoomNumber();
    }//GEN-LAST:event_ReservationListTableMouseClicked

    public String getselectedRoomNumber() {
        selectedRoomNumber = (String) (ReservationListTable.getValueAt(ReservationListTable.getSelectedRow(), 2));
        return selectedRoomNumber;
    }

    private void SpecialRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpecialRequestsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SpecialRequestsActionPerformed

    private void FeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FeedbackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FeedbackActionPerformed

    private void OrderListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderListActionPerformed
        int selectedrow = ReservationListTable.getSelectedRow();
        if (selectedrow != -1) {
            OrderModifyFrame OM = new OrderModifyFrame();
            OM.setVisible(true);
            OM.initServiceList(selectedRoomNumber);
        } else {
            JOptionPane.showMessageDialog(null, "호실을 선택해주세요.", "에러", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_OrderListActionPerformed

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
            java.util.logging.Logger.getLogger(CheckInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckInOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckInOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CheckinButton;
    private javax.swing.JButton CheckoutButton;
    private javax.swing.JTextField Feedback;
    private javax.swing.JButton OrderList;
    private javax.swing.JTable ReservationListTable;
    private javax.swing.JButton ReservationModificationButton;
    private javax.swing.JButton SaveTextContentButton;
    private javax.swing.JButton SerchButton;
    private javax.swing.JComboBox<String> SerchComboBox;
    private javax.swing.JTextField SerchTextField;
    private javax.swing.JTextField SpecialRequests;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

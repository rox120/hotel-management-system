package deu.hms.reservation;

import java.io.BufferedReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/**
 *
 * @author Hyunwoo
 */
public class ReservationManagementJFrame extends javax.swing.JFrame {

    private int index = 0;
    private String name;
    private String phoneNumber;
    private String zipNo;
    private String address;
    private String checkInDate;
    private String checkOutDate;
    private int numberOfGuests;
    private String roomNumber;
    private String roomGrade;
    private int costOfStaying;
    private String paymentMethod;
    
    private String creditCardNumber;
    private String creditValidMonth;
    private String creditValidYear;
    private String creditCvcNumber;
    private String inputCardData="0";
    private boolean registCard=false;
    private boolean updateButtonWork=false;
    
    private final String path = System.getProperty("user.dir");
    private final String fileName = "/clientInfo.txt";
    private final String filePath = path + fileName;
    private final String filePathRoom = path + "/test_room.txt";
    private final String filePathCard = path + "/cardInfo.txt";
    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public JDialog getRegistDialog() {
        return registDialog;
    }
    
    public JDialog getUpdateDialog() {
        return updateDialog;
    }
    
    public String getLastName() {
        
        return lastNameTextField.getText();
    }
    
    public String getFirstName() {
        
        return firstNameTextField.getText();
    }
    
    public String getThisName() {
        
        return getLastName() + getFirstName();
    }
    
    public String getDefaultPhone() {
        return defaultPhoneTextField.getText();
    }
    
    public String getSecondPhone() {
        return secondPhoneTextField.getText();
    }
    
    public String getThirdPhone() {
        return thirdPhoneTextField.getText();
    }
    
    public String getPhone() {
        
        return getDefaultPhone() + "-" + getSecondPhone() + "-" + getThirdPhone();
    }
    
    public String getZipNo() {
        
        return zipNoLabel.getText();
    }
    
    public String getRoadAddrPart1() {
        
        return roadAddrPart1Label.getText();
    }
    
    public String getRoadAddrPart2() {
        
        return roadAddrPart2Label.getText();
    }
    
    public String getCheckInDate() {
        
        checkInDate = dateFormat.format(checkInDateChooser.getDate());
        
        return checkInDate;
    }
    
    public String getCheckOutDate() {
        
        checkOutDate = dateFormat.format(checkOutDateChooser.getDate());
        
        return checkOutDate;
    }
    
    public int getNumberOfGuests() {
        
        return Integer.parseInt(numberOfGuestsComboBox.getSelectedItem().toString());
    }
    
    public String getRoomNumber() {
        
        return roomNumberTextField.getText();
    }
    
    public String getRoomGrade() {
        
        return extractRoomGrade(getRoomNumber());
    }
    
    public int getCostOfStaying() {
        
        return costOfStaying;
    }
    
    public String getPaymentMethod() {
        
        if (cardRadioButton.isSelected()) {
            return "카드";
        } else if (cashRadioButton.isSelected()) {
            return "현금";
        } else {
            return "";
        }
    }
    
    public String getUpdateLastName() {
        
        return updateLastNameTextField.getText();
    }
    
    public String getUpdateFirstName() {
        
        return updateFirstNameTextField.getText();
    }
    
    public String getUpdateThisName() {
        
        return getUpdateLastName() + getUpdateFirstName();
    }
    
    public String getUpdateDefaultPhone() {
        return updateDefaultPhoneTextField.getText();
    }
    
    public String getUpdateSecondPhone() {
        return updateSecondPhoneTextField.getText();
    }
    
    public String getUpdateThirdPhone() {
        return updateThirdPhoneTextField.getText();
    }
    
    public String getUpdatePhone() {
        
        return getUpdateDefaultPhone() + "-" + getUpdateSecondPhone() + "-" + getUpdateThirdPhone();
    }
    
    public String getUpdateCheckInDate() {
        
        checkInDate = dateFormat.format(updateCheckInDateChooser.getDate());
        
        return checkInDate;
    }
    
    public String getUpdateCheckOutDate() {
        
        checkOutDate = dateFormat.format(updateCheckOutDateChooser.getDate());
        
        return checkOutDate;
    }
    
    public int getUpdateNumberOfGuests() {
        
        return Integer.parseInt(updateNumberOfGuestsComboBox.getSelectedItem().toString());
    }
    
    public String getUpdateRoomNumber() {
        
        return updateRoomNumberTextField.getText();
    }
    
    public String getUpdateRoomGrade() {
        
        return extractRoomGrade(getUpdateRoomNumber());
    }
    
    public int getUpdateCostOfStaying() {
        
        return costOfStaying;
    }
    
    public String getUpdatePaymentMethod() {
        
        if (updateCardRadioButton.isSelected()) {
            return "카드";
        } else if (updateCashRadioButton.isSelected()) {
            return "현금";
        } else {
            return "";
        }
    }
    
    public String getFilePath() {
        
        return filePath;
    }
        
    public ReservationManagementJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("예약 관리");
        loadReservationData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registDialog = new javax.swing.JDialog();
        roomNumberTextField = new javax.swing.JTextField();
        roomLabel = new javax.swing.JLabel();
        checkInLabel = new javax.swing.JLabel();
        creditCardInfoLabel = new javax.swing.JLabel();
        checkOutLabel = new javax.swing.JLabel();
        registCreditCardButton = new javax.swing.JButton();
        firstNameTextField = new javax.swing.JTextField();
        calcCostOfStayingButton = new javax.swing.JButton();
        costOfStayingLabel = new javax.swing.JLabel();
        defaultPhoneTextField = new javax.swing.JTextField();
        checkInDateChooser = new com.toedter.calendar.JDateChooser();
        checkOutDateChooser = new com.toedter.calendar.JDateChooser();
        costOfStayingTextField = new javax.swing.JTextField();
        secondPhoneTextField = new javax.swing.JTextField();
        thirdPhoneTextField = new javax.swing.JTextField();
        wonLabel = new javax.swing.JLabel();
        registButton = new javax.swing.JButton();
        disposeButton1 = new javax.swing.JButton();
        zipNoLabel = new javax.swing.JLabel();
        roadAddrPart1Label = new javax.swing.JLabel();
        roadAddrPart2Label = new javax.swing.JLabel();
        callAddressSearchingDialogButton = new javax.swing.JButton();
        numberOfGuestsComboBox = new javax.swing.JComboBox<>();
        numberOfPeopleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        cardRadioButton = new javax.swing.JRadioButton();
        cashRadioButton = new javax.swing.JRadioButton();
        addressSearchingDialog = new javax.swing.JDialog();
        addressLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressTable = new javax.swing.JTable();
        addressSearchingTextField = new javax.swing.JTextField();
        selectAddressButton = new javax.swing.JButton();
        searchAddressButton = new javax.swing.JButton();
        setInvisibleDialogButton = new javax.swing.JButton();
        deleteDialog = new javax.swing.JDialog();
        warningLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deleteOkButton = new javax.swing.JButton();
        disposeButton2 = new javax.swing.JButton();
        updateDialog = new javax.swing.JDialog();
        updateButton = new javax.swing.JButton();
        updateInvisibleButton = new javax.swing.JButton();
        updateRoomNumberTextField = new javax.swing.JTextField();
        updateNumberOfGuestsComboBox = new javax.swing.JComboBox<>();
        roomLabel1 = new javax.swing.JLabel();
        numberOfPeopleLabel1 = new javax.swing.JLabel();
        checkInLabel1 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        creditCardInfoLabel1 = new javax.swing.JLabel();
        updateLastNameTextField = new javax.swing.JTextField();
        checkOutLabel1 = new javax.swing.JLabel();
        updateRegistCreditCardButton = new javax.swing.JButton();
        phoneLabel1 = new javax.swing.JLabel();
        updateFirstNameTextField = new javax.swing.JTextField();
        updateCalcCostOfStayingButton = new javax.swing.JButton();
        costOfStayingLabel1 = new javax.swing.JLabel();
        updateDefaultPhoneTextField = new javax.swing.JTextField();
        updateCheckInDateChooser = new com.toedter.calendar.JDateChooser();
        updateCheckOutDateChooser = new com.toedter.calendar.JDateChooser();
        updateCostOfStayingTextField = new javax.swing.JTextField();
        updateSecondPhoneTextField = new javax.swing.JTextField();
        updateThirdPhoneTextField = new javax.swing.JTextField();
        wonLabel1 = new javax.swing.JLabel();
        updateCashRadioButton = new javax.swing.JRadioButton();
        updateCardRadioButton = new javax.swing.JRadioButton();
        paymentMethodGroup = new javax.swing.ButtonGroup();
        updatePaymentMethodGroup = new javax.swing.ButtonGroup();
        registCardDialog = new javax.swing.JDialog();
        firstCardNumber = new javax.swing.JTextField();
        secondCardNumber = new javax.swing.JTextField();
        thirdCardNumber = new javax.swing.JTextField();
        fourthCardNumber = new javax.swing.JTextField();
        creditValidMonthTextField = new javax.swing.JTextField();
        creditValidYearTextField = new javax.swing.JTextField();
        creditCvcTextField = new javax.swing.JTextField();
        validityDashLabel = new javax.swing.JLabel();
        registCreditButton = new javax.swing.JButton();
        disposeCreditButton = new javax.swing.JButton();
        dashLabel = new javax.swing.JLabel();
        secondDashLabel = new javax.swing.JLabel();
        thirdDashLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        creditValidityLabel = new javax.swing.JLabel();
        cvcLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationTable = new javax.swing.JTable();
        callRegistDialogButton = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        disposeButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();

        registDialog.setMinimumSize(new java.awt.Dimension(520, 500));
        registDialog.setSize(new java.awt.Dimension(520, 500));

        roomNumberTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomNumberTextFieldMouseClicked(evt);
            }
        });
        roomNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNumberTextFieldActionPerformed(evt);
            }
        });

        roomLabel.setText("호");

        checkInLabel.setText("체크인");

        creditCardInfoLabel.setText("신용카드 정보");

        checkOutLabel.setText("체크아웃");

        registCreditCardButton.setText("카드 등록");
        registCreditCardButton.setEnabled(false);
        registCreditCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registCreditCardButtonActionPerformed(evt);
            }
        });

        firstNameTextField.setText("이름");
        firstNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstNameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameTextFieldFocusLost(evt);
            }
        });
        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });

        calcCostOfStayingButton.setText("금액 확인");
        calcCostOfStayingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcCostOfStayingButtonActionPerformed(evt);
            }
        });

        costOfStayingLabel.setText("투숙 비용");

        defaultPhoneTextField.setText("010");

        checkOutDateChooser.setDateFormatString("y. M. d");

        costOfStayingTextField.setEditable(false);
        costOfStayingTextField.setBackground(new java.awt.Color(240, 240, 240));
        costOfStayingTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        costOfStayingTextField.setText("0");

        wonLabel.setText("원");

        registButton.setText("등록");
        registButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registButtonActionPerformed(evt);
            }
        });

        disposeButton1.setText("취소");
        disposeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disposeButton1ActionPerformed(evt);
            }
        });

        callAddressSearchingDialogButton.setText("주소 검색");
        callAddressSearchingDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callAddressSearchingDialogButtonActionPerformed(evt);
            }
        });

        numberOfGuestsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6" }));
        numberOfGuestsComboBox.setToolTipText("");
        numberOfGuestsComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                numberOfGuestsComboBoxFocusGained(evt);
            }
        });
        numberOfGuestsComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numberOfGuestsComboBoxMouseClicked(evt);
            }
        });
        numberOfGuestsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfGuestsComboBoxActionPerformed(evt);
            }
        });

        numberOfPeopleLabel.setText("명");

        nameLabel.setText("이름");
        nameLabel.setToolTipText("");

        lastNameTextField.setText("성");
        lastNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameTextFieldFocusLost(evt);
            }
        });

        phoneLabel.setText("전화번호");

        addressLabel.setText("주소");
        addressLabel.setToolTipText("");

        paymentMethodGroup.add(cardRadioButton);
        cardRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardRadioButtonActionPerformed(evt);
            }
        });

        paymentMethodGroup.add(cashRadioButton);
        cashRadioButton.setText("현금");
        cashRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registDialogLayout = new javax.swing.GroupLayout(registDialog.getContentPane());
        registDialog.getContentPane().setLayout(registDialogLayout);
        registDialogLayout.setHorizontalGroup(
            registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registDialogLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registDialogLayout.createSequentialGroup()
                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, registDialogLayout.createSequentialGroup()
                                .addComponent(checkInLabel)
                                .addGap(57, 57, 57)
                                .addComponent(checkInDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(registDialogLayout.createSequentialGroup()
                                .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkOutLabel)
                                    .addComponent(costOfStayingLabel)
                                    .addComponent(creditCardInfoLabel))
                                .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(registDialogLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(registDialogLayout.createSequentialGroup()
                                                .addComponent(costOfStayingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wonLabel))
                                            .addGroup(registDialogLayout.createSequentialGroup()
                                                .addComponent(cardRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(registCreditCardButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cashRadioButton))))
                                    .addGroup(registDialogLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(checkOutDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(30, 30, 30)
                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registDialogLayout.createSequentialGroup()
                                .addComponent(numberOfGuestsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberOfPeopleLabel))
                            .addGroup(registDialogLayout.createSequentialGroup()
                                .addComponent(roomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roomLabel))
                            .addComponent(calcCostOfStayingButton)))
                    .addComponent(phoneLabel)
                    .addComponent(nameLabel)
                    .addGroup(registDialogLayout.createSequentialGroup()
                        .addComponent(addressLabel)
                        .addGap(69, 69, 69)
                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roadAddrPart2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(registDialogLayout.createSequentialGroup()
                                    .addComponent(registButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(disposeButton1))
                                .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(registDialogLayout.createSequentialGroup()
                                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(defaultPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(secondPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(thirdPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(registDialogLayout.createSequentialGroup()
                                            .addComponent(zipNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(callAddressSearchingDialogButton))
                                        .addComponent(roadAddrPart1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        registDialogLayout.setVerticalGroup(
            registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registDialogLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(registDialogLayout.createSequentialGroup()
                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel)
                            .addComponent(defaultPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thirdPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(zipNoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addressLabel)
                    .addComponent(callAddressSearchingDialogButton))
                .addGap(4, 4, 4)
                .addComponent(roadAddrPart1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roadAddrPart2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registDialogLayout.createSequentialGroup()
                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registDialogLayout.createSequentialGroup()
                                .addComponent(checkInLabel)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registDialogLayout.createSequentialGroup()
                                .addComponent(checkInDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))
                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkOutLabel)
                            .addComponent(checkOutDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(registDialogLayout.createSequentialGroup()
                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberOfGuestsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberOfPeopleLabel))
                        .addGap(7, 7, 7)
                        .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomLabel))))
                .addGap(18, 18, 18)
                .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costOfStayingLabel)
                    .addComponent(costOfStayingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wonLabel)
                    .addComponent(calcCostOfStayingButton))
                .addGap(18, 18, 18)
                .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardRadioButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(creditCardInfoLabel)
                        .addComponent(registCreditCardButton)
                        .addComponent(cashRadioButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(registDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disposeButton1)
                    .addComponent(registButton))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        creditCardInfoLabel.getAccessibleContext().setAccessibleName("결제 수단");

        addressLabel1.setText("주소");

        addressTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "우편 번호", "도로명 주소", "건물명"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(addressTable);

        selectAddressButton.setText("확인");
        selectAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAddressButtonActionPerformed(evt);
            }
        });

        searchAddressButton.setText("검색");
        searchAddressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchAddressButtonActionPerformed(evt);
            }
        });

        setInvisibleDialogButton.setText("취소");
        setInvisibleDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setInvisibleDialogButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addressSearchingDialogLayout = new javax.swing.GroupLayout(addressSearchingDialog.getContentPane());
        addressSearchingDialog.getContentPane().setLayout(addressSearchingDialogLayout);
        addressSearchingDialogLayout.setHorizontalGroup(
            addressSearchingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressSearchingDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addressSearchingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressSearchingDialogLayout.createSequentialGroup()
                        .addComponent(selectAddressButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setInvisibleDialogButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressSearchingDialogLayout.createSequentialGroup()
                        .addComponent(addressLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressSearchingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchAddressButton)
                        .addGap(111, 111, 111))))
        );
        addressSearchingDialogLayout.setVerticalGroup(
            addressSearchingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addressSearchingDialogLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(addressSearchingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel1)
                    .addComponent(addressSearchingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchAddressButton))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addressSearchingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectAddressButton)
                    .addComponent(setInvisibleDialogButton))
                .addGap(12, 12, 12))
        );

        warningLabel.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        warningLabel.setText("경고");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 14)); // NOI18N
        jLabel2.setText("정말 선택하신 예약 정보를 삭제하시겠습니까?");

        deleteOkButton.setText("예");
        deleteOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOkButtonActionPerformed(evt);
            }
        });

        disposeButton2.setText("아니오");
        disposeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disposeButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deleteDialogLayout = new javax.swing.GroupLayout(deleteDialog.getContentPane());
        deleteDialog.getContentPane().setLayout(deleteDialogLayout);
        deleteDialogLayout.setHorizontalGroup(
            deleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(warningLabel)
                .addGap(192, 192, 192))
            .addGroup(deleteDialogLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(deleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(deleteDialogLayout.createSequentialGroup()
                        .addComponent(deleteOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disposeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        deleteDialogLayout.setVerticalGroup(
            deleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteDialogLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(warningLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(deleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteOkButton)
                    .addComponent(disposeButton2))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        updateDialog.setMinimumSize(new java.awt.Dimension(520, 400));
        updateDialog.setSize(new java.awt.Dimension(520, 400));

        updateButton.setText("수정");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        updateInvisibleButton.setText("취소");
        updateInvisibleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInvisibleButtonActionPerformed(evt);
            }
        });

        updateRoomNumberTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateRoomNumberTextFieldMouseClicked(evt);
            }
        });

        updateNumberOfGuestsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6" }));
        updateNumberOfGuestsComboBox.setToolTipText("");
        updateNumberOfGuestsComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updateNumberOfGuestsComboBoxFocusGained(evt);
            }
        });
        updateNumberOfGuestsComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateNumberOfGuestsComboBoxMouseClicked(evt);
            }
        });
        updateNumberOfGuestsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateNumberOfGuestsComboBoxActionPerformed(evt);
            }
        });

        roomLabel1.setText("호");

        numberOfPeopleLabel1.setText("명");

        checkInLabel1.setText("체크인");

        nameLabel1.setText("이름");
        nameLabel1.setToolTipText("");

        creditCardInfoLabel1.setText("신용카드 정보");

        updateLastNameTextField.setText("성");
        updateLastNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updateLastNameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                updateLastNameTextFieldFocusLost(evt);
            }
        });

        checkOutLabel1.setText("체크아웃");

        updateRegistCreditCardButton.setText("카드 등록");
        updateRegistCreditCardButton.setEnabled(false);
        updateRegistCreditCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRegistCreditCardButtonActionPerformed(evt);
            }
        });

        phoneLabel1.setText("전화번호");

        updateFirstNameTextField.setText("이름");
        updateFirstNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                updateFirstNameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                updateFirstNameTextFieldFocusLost(evt);
            }
        });
        updateFirstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFirstNameTextFieldActionPerformed(evt);
            }
        });

        updateCalcCostOfStayingButton.setText("금액 확인");
        updateCalcCostOfStayingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCalcCostOfStayingButtonActionPerformed(evt);
            }
        });

        costOfStayingLabel1.setText("투숙 비용");

        updateDefaultPhoneTextField.setText("010");

        updateCheckOutDateChooser.setDateFormatString("y. M. d");

        updateCostOfStayingTextField.setEditable(false);
        updateCostOfStayingTextField.setBackground(new java.awt.Color(240, 240, 240));
        updateCostOfStayingTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        updateCostOfStayingTextField.setText("0");

        wonLabel1.setText("원");

        updatePaymentMethodGroup.add(updateCashRadioButton);
        updateCashRadioButton.setText("현금");
        updateCashRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCashRadioButtonActionPerformed(evt);
            }
        });

        updatePaymentMethodGroup.add(updateCardRadioButton);
        updateCardRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCardRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout updateDialogLayout = new javax.swing.GroupLayout(updateDialog.getContentPane());
        updateDialog.getContentPane().setLayout(updateDialogLayout);
        updateDialogLayout.setHorizontalGroup(
            updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateDialogLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateDialogLayout.createSequentialGroup()
                        .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateDialogLayout.createSequentialGroup()
                                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateDialogLayout.createSequentialGroup()
                                        .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkOutLabel1)
                                            .addComponent(costOfStayingLabel1)
                                            .addComponent(creditCardInfoLabel1))
                                        .addGap(18, 18, 18))
                                    .addGroup(updateDialogLayout.createSequentialGroup()
                                        .addComponent(checkInLabel1)
                                        .addGap(58, 58, 58)))
                                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateCheckInDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(updateDialogLayout.createSequentialGroup()
                                        .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(updateCheckOutDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(updateCostOfStayingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(wonLabel1))
                                    .addGroup(updateDialogLayout.createSequentialGroup()
                                        .addComponent(updateCardRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateRegistCreditCardButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updateCashRadioButton)))
                                .addGap(30, 30, 30)
                                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(updateDialogLayout.createSequentialGroup()
                                        .addComponent(updateNumberOfGuestsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numberOfPeopleLabel1))
                                    .addComponent(updateCalcCostOfStayingButton)
                                    .addGroup(updateDialogLayout.createSequentialGroup()
                                        .addComponent(updateRoomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(roomLabel1))))
                            .addGroup(updateDialogLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateInvisibleButton)))
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addGroup(updateDialogLayout.createSequentialGroup()
                        .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateDialogLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateDefaultPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(updateSecondPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateThirdPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(phoneLabel1)
                            .addComponent(nameLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        updateDialogLayout.setVerticalGroup(
            updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateDialogLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel1)
                    .addComponent(updateFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel1)
                    .addComponent(updateDefaultPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateSecondPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateThirdPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateDialogLayout.createSequentialGroup()
                        .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateDialogLayout.createSequentialGroup()
                                .addComponent(checkInLabel1)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateDialogLayout.createSequentialGroup()
                                .addComponent(updateCheckInDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))
                        .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkOutLabel1)
                            .addComponent(updateCheckOutDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(updateDialogLayout.createSequentialGroup()
                        .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateNumberOfGuestsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberOfPeopleLabel1))
                        .addGap(7, 7, 7)
                        .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateRoomNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomLabel1))))
                .addGap(18, 18, 18)
                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costOfStayingLabel1)
                    .addComponent(updateCostOfStayingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wonLabel1)
                    .addComponent(updateCalcCostOfStayingButton))
                .addGap(18, 18, 18)
                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditCardInfoLabel1)
                    .addComponent(updateRegistCreditCardButton)
                    .addComponent(updateCashRadioButton)
                    .addComponent(updateCardRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(updateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateInvisibleButton)
                    .addComponent(updateButton))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        registCardDialog.setMaximumSize(new java.awt.Dimension(438, 223));
        registCardDialog.setMinimumSize(new java.awt.Dimension(438, 223));
        registCardDialog.setResizable(false);
        registCardDialog.setSize(new java.awt.Dimension(438, 223));

        firstCardNumber.setMinimumSize(new java.awt.Dimension(56, 23));
        firstCardNumber.setPreferredSize(new java.awt.Dimension(56, 23));

        secondCardNumber.setMinimumSize(new java.awt.Dimension(56, 23));
        secondCardNumber.setPreferredSize(new java.awt.Dimension(56, 23));

        thirdCardNumber.setMinimumSize(new java.awt.Dimension(56, 23));
        thirdCardNumber.setPreferredSize(new java.awt.Dimension(56, 23));

        fourthCardNumber.setMinimumSize(new java.awt.Dimension(56, 23));
        fourthCardNumber.setPreferredSize(new java.awt.Dimension(56, 23));

        validityDashLabel.setText("/");

        registCreditButton.setText("등록");
        registCreditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registCreditButtonActionPerformed(evt);
            }
        });

        disposeCreditButton.setText("취소");
        disposeCreditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disposeCreditButtonActionPerformed(evt);
            }
        });

        dashLabel.setText("-");

        secondDashLabel.setText("-");

        thirdDashLabel.setText("-");

        jLabel1.setText("카드 번호");

        creditValidityLabel.setText("유효 기간");

        cvcLabel.setText("CVC");

        javax.swing.GroupLayout registCardDialogLayout = new javax.swing.GroupLayout(registCardDialog.getContentPane());
        registCardDialog.getContentPane().setLayout(registCardDialogLayout);
        registCardDialogLayout.setHorizontalGroup(
            registCardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registCardDialogLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(registCardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(creditValidityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(registCardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registCardDialogLayout.createSequentialGroup()
                        .addComponent(registCreditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(disposeCreditButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registCardDialogLayout.createSequentialGroup()
                        .addGroup(registCardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registCardDialogLayout.createSequentialGroup()
                                .addComponent(firstCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dashLabel))
                            .addGroup(registCardDialogLayout.createSequentialGroup()
                                .addComponent(creditValidMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(validityDashLabel)))
                        .addGap(6, 6, 6)
                        .addGroup(registCardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registCardDialogLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(secondCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registCardDialogLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(creditValidYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addComponent(secondDashLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(registCardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(registCardDialogLayout.createSequentialGroup()
                                .addComponent(thirdCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thirdDashLabel)
                                .addGap(4, 4, 4)
                                .addComponent(fourthCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(registCardDialogLayout.createSequentialGroup()
                                .addComponent(cvcLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(creditCvcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        registCardDialogLayout.setVerticalGroup(
            registCardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registCardDialogLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(registCardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thirdCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourthCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashLabel)
                    .addComponent(secondDashLabel)
                    .addComponent(thirdDashLabel)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(registCardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creditValidMonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditValidYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validityDashLabel)
                    .addComponent(creditValidityLabel)
                    .addComponent(creditCvcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cvcLabel))
                .addGap(29, 29, 29)
                .addGroup(registCardDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registCreditButton)
                    .addComponent(disposeCreditButton))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        reservationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "이름", "전화번호", "우편번호", "주소", "체크인 날짜", "체크아웃 날짜", "인원수", "호실", "숙박비", "결제 수단", "체크인"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reservationTable);
        if (reservationTable.getColumnModel().getColumnCount() > 0) {
            reservationTable.getColumnModel().getColumn(0).setMinWidth(30);
            reservationTable.getColumnModel().getColumn(0).setPreferredWidth(30);
            reservationTable.getColumnModel().getColumn(0).setMaxWidth(30);
            reservationTable.getColumnModel().getColumn(1).setMaxWidth(55);
            reservationTable.getColumnModel().getColumn(2).setMinWidth(100);
            reservationTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            reservationTable.getColumnModel().getColumn(2).setMaxWidth(100);
            reservationTable.getColumnModel().getColumn(4).setMinWidth(200);
            reservationTable.getColumnModel().getColumn(4).setPreferredWidth(200);
            reservationTable.getColumnModel().getColumn(4).setMaxWidth(200);
            reservationTable.getColumnModel().getColumn(7).setMinWidth(55);
            reservationTable.getColumnModel().getColumn(7).setPreferredWidth(55);
            reservationTable.getColumnModel().getColumn(7).setMaxWidth(55);
            reservationTable.getColumnModel().getColumn(8).setMinWidth(55);
            reservationTable.getColumnModel().getColumn(8).setPreferredWidth(55);
            reservationTable.getColumnModel().getColumn(8).setMaxWidth(55);
            reservationTable.getColumnModel().getColumn(9).setPreferredWidth(100);
            reservationTable.getColumnModel().getColumn(11).setMinWidth(55);
            reservationTable.getColumnModel().getColumn(11).setPreferredWidth(55);
            reservationTable.getColumnModel().getColumn(11).setMaxWidth(55);
        }

        callRegistDialogButton.setText("등록");
        callRegistDialogButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        callRegistDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                callRegistDialogButtonActionPerformed(evt);
            }
        });

        update.setText("수정");
        update.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("삭제");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        disposeButton.setText("이전");
        disposeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disposeButtonActionPerformed(evt);
            }
        });

        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(disposeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(callRegistDialogButton)
                .addGap(18, 18, 18)
                .addComponent(update)
                .addGap(18, 18, 18)
                .addComponent(delete)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(callRegistDialogButton)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(disposeButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void callRegistDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callRegistDialogButtonActionPerformed
        
        registDialog.setVisible(true);
        registDialog.setLocationRelativeTo(this);
        registDialog.setSize(520, 500);
        registDialog.setTitle("등록");
        registDialog.setLocationRelativeTo(this);
    }//GEN-LAST:event_callRegistDialogButtonActionPerformed

    private void disposeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disposeButtonActionPerformed
        
        dispose();
    }//GEN-LAST:event_disposeButtonActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        int selectedRow = -1;
        selectedRow = reservationTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "예약 정보를 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
        } else {
            updateDialog.setVisible(true);
            updateDialog.setLocationRelativeTo(this);
            updateDialog.setSize(520, 400);
            updateDialog.setTitle("수정");
            updateDialog.setLocationRelativeTo(this);
            
            Object targetIndex;
            targetIndex = reservationTable.getValueAt(selectedRow, 0);
            String[] columns;
            String[] phones;
            
            try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            
            // 파일의 내용을 읽어오면서
            String line;
            int currentIndex = 1;
            while ((line = br.readLine()) != null) {
                if (currentIndex == Integer.parseInt((String) targetIndex)) {
                    // 특정 행일 경우,
                    columns = line.split("\t"); // 데이터를 구분해서 String 배열에 저장
                    selectedIndex=columns[0];
                    String updateName = columns[1];
                    updateLastNameTextField.setText(updateName.substring(0, 1));
                    updateFirstNameTextField.setText(updateName.substring(1));
                    
                    phones = columns[2].split("-");
                    updateSecondPhoneTextField.setText(phones[1]);
                    updateThirdPhoneTextField.setText(phones[2]);
                    
                    Date updateCheckInDate = dateFormat.parse(columns[5]);
                    Date updateCheckOutDate = dateFormat.parse(columns[6]);
                    updateCheckInDateChooser.setDate(updateCheckInDate);
                    updateCheckOutDateChooser.setDate(updateCheckOutDate);
                    
                    updateNumberOfGuestsComboBox.setSelectedIndex(Integer.parseInt(columns[7]));
                    updateRoomNumberTextField.setText(columns[8]);
                    updateCostOfStayingTextField.setText("0");
                    
                }
                ++currentIndex;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(ReservationManagementJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        deleteDialog.setVisible(true);
        deleteDialog.setLocationRelativeTo(this);
        deleteDialog.setSize(420, 207);
        deleteDialog.setTitle("삭제");
        deleteDialog.setLocationRelativeTo(this);
    }//GEN-LAST:event_deleteActionPerformed

    private void roomNumberTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomNumberTextFieldMouseClicked

        JOptionPane.showMessageDialog(this, "1층: "+getroomPrice(1)+"원" + System.lineSeparator() + 
                                                         "2층: "+getroomPrice(2)+"원" +  System.lineSeparator() + 
                                                         "3층: "+getroomPrice(3)+"원" + System.lineSeparator() + 
                                                         "4층: "+getroomPrice(4)+"원" +  System.lineSeparator() + 
                                                         "5층: "+getroomPrice(5)+"원" + System.lineSeparator() + 
                                                         "6층: "+getroomPrice(6)+"원" +  System.lineSeparator() + 
                                                         "7층: "+getroomPrice(7)+"원" + System.lineSeparator() + 
                                                         "8층: "+getroomPrice(8)+"원" +  System.lineSeparator() + 
                                                         "9층: "+getroomPrice(9)+"원" +  System.lineSeparator() +
                                                         "10층: "+getroomPrice(10)+"원",
                                                   "객실 요금", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_roomNumberTextFieldMouseClicked

    private void firstNameTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameTextFieldFocusGained

        if (firstNameTextField.getText().equals("이름")) { // 기본값 "이름"(사용자 임의 입력이 "성"일 경우 포함)이면 Text Field에 focus가 생길 경우 Text Field를 비움
            firstNameTextField.setText("");
        }
    }//GEN-LAST:event_firstNameTextFieldFocusGained

    private void firstNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameTextFieldFocusLost

        if (firstNameTextField.getText().equals("")) { // 사용자 임의 입력 없이 Text Field에서 focus가 없어지면 "이름"을 보이게 함
            firstNameTextField.setText("이름");
        }
    }//GEN-LAST:event_firstNameTextFieldFocusLost

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed

    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void calcCostOfStayingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcCostOfStayingButtonActionPerformed

        Validation validater = new Validation(this);
        if (validater.isCalcCostOfStayingButtonAvailable()) {
            // JCalender로 선택한 날짜를 받아온다.
            checkInDate = getCheckInDate();
            checkOutDate = getCheckOutDate();
            numberOfGuests = getNumberOfGuests(); // 선택된 투숙객 수를 받아온다.
            // 4명을 초과하면 초과 인원당 10,000원의 추가 금액을 계산하는 calcAlphaCost(int numberOfGuests)의 인자값
            roomNumber = getRoomNumber(); // 방 번호를 받아온다.
            calcCostOfStaying(); // 숙박 일수 * 방 가격 + calcAlphaCost()

            costOfStayingTextField.setText(Integer.toString(getCostOfStaying())); // 계산 결과를 TextField에 전달
        }
    }//GEN-LAST:event_calcCostOfStayingButtonActionPerformed

    private void registButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registButtonActionPerformed

        Validation validater = new Validation(this);
        if (validater.isRegistrable()) {
            if (costOfStayingTextField.getText().equals("0")) {
                JOptionPane.showMessageDialog(this, "먼저 금액을 확인하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            } else {
                try (FileWriter fileWriter = new FileWriter(filePath, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                    bufferedWriter.write(inputData());
                    bufferedWriter.newLine();

                    bufferedWriter.flush();
                    bufferedWriter.close();
                    
                    loadReservationData();
                    
                    InitData();
                    registDialog.setVisible(false);
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                if (cardRadioButton.isSelected()&&registCard) {
                    try (FileWriter fileWriter = new FileWriter(filePathCard, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                    bufferedWriter.write(inputCardData);
                    bufferedWriter.newLine();

                    bufferedWriter.flush();
                    bufferedWriter.close();
                    registCard=false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                } else {
                    try (FileWriter fileWriter = new FileWriter(filePathCard, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                    inputCash(index);
                    bufferedWriter.write(inputCardData);
                    bufferedWriter.newLine();

                    bufferedWriter.flush();
                    bufferedWriter.close();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
                
            }
        }
    }//GEN-LAST:event_registButtonActionPerformed

    private void disposeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disposeButton1ActionPerformed

        registDialog.setVisible(false);
    }//GEN-LAST:event_disposeButton1ActionPerformed

    private void callAddressSearchingDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callAddressSearchingDialogButtonActionPerformed

        addressSearchingDialog.setVisible(true);
        addressSearchingDialog.setLocationRelativeTo(this);
        addressSearchingDialog.setSize(550, 350);
        addressSearchingDialog.setTitle("주소 검색");
        addressSearchingDialog.setLocationRelativeTo(this);
    }//GEN-LAST:event_callAddressSearchingDialogButtonActionPerformed

    private void numberOfGuestsComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_numberOfGuestsComboBoxFocusGained

    }//GEN-LAST:event_numberOfGuestsComboBoxFocusGained

    private void numberOfGuestsComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numberOfGuestsComboBoxMouseClicked

        JOptionPane.showMessageDialog(this, "기본 투숙인원은 4명입니다." +  System.lineSeparator() + 
                                                         "초과 인원 당 10,000원의 추가 요금이 발생함을 고객님께 고지하십시오.", 
                                                    "주의", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_numberOfGuestsComboBoxMouseClicked

    private void lastNameTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameTextFieldFocusGained

        if (lastNameTextField.getText().equals("성")) { // 기본값 "성"(사용자 임의 입력이 "성"일 경우 포함)이면 Text Field에 focus가 생길 경우 Text Field를 비움
            lastNameTextField.setText("");
        }
    }//GEN-LAST:event_lastNameTextFieldFocusGained

    private void lastNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameTextFieldFocusLost
        // TODO add your handling code here:
        if (lastNameTextField.getText().equals("")) { // 기본값 "성"(사용자 임의 입력이 "성"일 경우 포함)이면 Text Field에 focus가 생길 경우 Text Field를 비움
            lastNameTextField.setText("성");
        }
    }//GEN-LAST:event_lastNameTextFieldFocusLost

    private void selectAddressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAddressButtonActionPerformed

        int selectedRow = addressTable.getSelectedRow();

        if (selectedRow != -1) { // 선택된 행이 있다면 데이터 가져오기
            zipNo = addressTable.getValueAt(selectedRow, 0).toString();
            String roadAddrPart1 = addressTable.getValueAt(selectedRow, 1).toString();
            String roadAddrPart2 = addressTable.getValueAt(selectedRow, 2).toString();

            // 가져온 데이터를 등록창의 주소 칸 JLabel에 전달
            zipNoLabel.setText(zipNo);
            roadAddrPart1Label.setText(roadAddrPart1);
            roadAddrPart2Label.setText(roadAddrPart2);

            addressSearchingDialog.setVisible(false);
        } else {
            // 선택된 행이 없을 경우에 대한 처리
            JOptionPane.showMessageDialog(this, "주소를 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_selectAddressButtonActionPerformed

    private void searchAddressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchAddressButtonActionPerformed

        try {
            String currentPage = "1";
            String countPerPage = "100";
            String confmKey = "devU01TX0FVVEgyMDIzMTExMjA2NDkxNDExNDI2NTI=";
            String keyword = addressSearchingTextField.getText(); // 검색하고자 하는 키워드 입력

            String apiUrl = "https://business.juso.go.kr/addrlink/addrLinkApi.do?currentPage=" + currentPage
            + "&countPerPage=" + countPerPage + "&keyword=" + URLEncoder.encode(keyword, "UTF-8")
            + "&confmKey=" + confmKey;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream inputStream = connection.getInputStream();

            // XML 파싱
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            DefaultTableModel tableModel = (DefaultTableModel) addressTable.getModel();
            tableModel.setRowCount(0);

            // 주소 정보 추출
            NodeList jusoList = document.getElementsByTagName("juso");
            for (int i = 0; i < jusoList.getLength(); ++i) {
                Element jusoElement = (Element) jusoList.item(i);

                zipNo = getElementValue(jusoElement, "zipNo"); // [우편번호]
                String roadAddrPart1 = getElementValue(jusoElement, "roadAddrPart1"); // [도로명 주소] 도로명주소(참고항목 제외)
                String roadAddrPart2 = getElementValue(jusoElement, "roadAddrPart2"); // [건물명] 도로명주소 참고항목

                tableModel.addRow(new Object[]{zipNo, roadAddrPart1, roadAddrPart2});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchAddressButtonActionPerformed

    private void setInvisibleDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setInvisibleDialogButtonActionPerformed

        addressSearchingDialog.setVisible(false);
    }//GEN-LAST:event_setInvisibleDialogButtonActionPerformed

    private void deleteOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOkButtonActionPerformed

        Object targetIndex;
        int selectedRow = reservationTable.getSelectedRow();
        targetIndex = reservationTable.getValueAt(selectedRow, 0);
        String[] columns = null;
        
        String replacementData = "취소";
        
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
                    columns[columns.length - 1] = replacementData;
                    line = reWriteLine(columns);
                    
                    sb.append(line).append(System.lineSeparator());
                } else {
                    // 나머지 행은 그대로 유지
                    sb.append(line).append(System.lineSeparator());
                }
                ++currentIndex;
            }
            br.close();

            // 수정된 내용을 파일에 다시 쓰고 저장
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            writer.flush();
            writer.close();

            loadReservationData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        deleteDialog.setVisible(false);
    }//GEN-LAST:event_deleteOkButtonActionPerformed

    private void disposeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disposeButton2ActionPerformed

        deleteDialog.setVisible(false);
    }//GEN-LAST:event_disposeButton2ActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        
        // TODO 버그 고치기
        updateButtonWork=true;
        Object targetIndex;
        int selectedRow = reservationTable.getSelectedRow();
        targetIndex = reservationTable.getValueAt(selectedRow, 0);
        String[] columns;
        String[] phones;

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
                    columns = line.split("\t"); // 데이터를 구분해서 String 배열에 저장
                    phones = columns[2].split("-");

                    if (updateCostOfStayingTextField.getText().equals("0")) {
                        JOptionPane.showMessageDialog(this, "먼저 금액을 확인하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (!columns[1].substring(0, 1).equals(updateLastNameTextField.getText())) {
                            columns[1] = updateLastNameTextField.getText() + updateFirstNameTextField.getText();
                        }
                        if (!columns[1].substring(1, 2).equals(updateFirstNameTextField.getText())) {
                            columns[1] = updateLastNameTextField.getText() + updateFirstNameTextField.getText();
                        }
                        if (!phones[1].equals(updateSecondPhoneTextField.getText())) {
                            columns[2] = getUpdateDefaultPhone() + updateSecondPhoneTextField.getText() + updateThirdPhoneTextField.getText();
                        }
                        if (!phones[2].equals(updateThirdPhoneTextField.getText())) {
                            columns[2] = getUpdateDefaultPhone() + updateSecondPhoneTextField.getText() + updateThirdPhoneTextField.getText();
                        }
                        if (!columns[5].equals(updateCheckInDateChooser.getDate())) {
                            columns[5] = getUpdateCheckInDate();
                        }
                        if (!columns[6].equals(updateCheckOutDateChooser.getDate())) {
                            columns[6] = getUpdateCheckOutDate();
                        }
                        if (!(Integer.parseInt(columns[7]) == updateNumberOfGuestsComboBox.getSelectedIndex())) {
                            columns[7] = Integer.toString(getUpdateNumberOfGuests());
                        }
                        if (!columns[8].equals(updateRoomNumberTextField.getText())) {
                            columns[8] = updateRoomNumberTextField.getText();
                        }
                        if (!columns[9].equals(updateCostOfStayingTextField.getText())) {
                            columns[9] = updateCostOfStayingTextField.getText();
                        }
                        /*if (cardRadioButton.isSelected() && registCard) {
                            try (FileWriter fileWriter = new FileWriter(filePathCard, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                                bufferedWriter.write(inputCardData);
                                bufferedWriter.newLine();

                                bufferedWriter.flush();
                                bufferedWriter.close();
                                registCard = false;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try (FileWriter fileWriter = new FileWriter(filePathCard, true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                                inputCash(currentIndex);
                                bufferedWriter.write(inputCardData);
                                bufferedWriter.newLine();

                                bufferedWriter.flush();
                                bufferedWriter.close();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }*/
                        line = reWriteLine(columns);
                        sb.append(line).append(System.lineSeparator());
                        updateDialog.setVisible(false);
                    }
                } else {
                    // 나머지 행은 그대로 유지
                    sb.append(line).append( System.lineSeparator());
                }
                ++currentIndex;
            }
            
            
            
            br.close();
            
            // 수정된 내용을 파일에 다시 쓰고 저장
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            writer.flush();
            writer.close();
            
            loadReservationData();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        updateButtonWork=false;
    }//GEN-LAST:event_updateButtonActionPerformed
private String selectedIndex="0";
    private void updateInvisibleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInvisibleButtonActionPerformed
        // TODO add your handling code here:
        updateDialog.setVisible(false);
    }//GEN-LAST:event_updateInvisibleButtonActionPerformed

    private void updateRoomNumberTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateRoomNumberTextFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateRoomNumberTextFieldMouseClicked

    private void updateNumberOfGuestsComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateNumberOfGuestsComboBoxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_updateNumberOfGuestsComboBoxFocusGained

    private void updateNumberOfGuestsComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateNumberOfGuestsComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_updateNumberOfGuestsComboBoxMouseClicked

    private void updateLastNameTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateLastNameTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_updateLastNameTextFieldFocusGained

    private void updateLastNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateLastNameTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_updateLastNameTextFieldFocusLost

    private void updateFirstNameTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateFirstNameTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_updateFirstNameTextFieldFocusGained

    private void updateFirstNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_updateFirstNameTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_updateFirstNameTextFieldFocusLost

    private void updateFirstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFirstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateFirstNameTextFieldActionPerformed

    private void updateCalcCostOfStayingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCalcCostOfStayingButtonActionPerformed

        Validation validater = new Validation(this);
        if (validater.isUpdateCalcCostOfStayingButtonAvailable()) {
            // JCalender로 선택한 날짜를 받아온다.
            checkInDate = getUpdateCheckInDate();
            checkOutDate = getUpdateCheckOutDate();
            numberOfGuests = getUpdateNumberOfGuests(); // 선택된 투숙객 수를 받아온다.
            // 4명을 초과하면 초과 인원당 10,000원의 추가 금액을 계산하는 calcAlphaCost(int numberOfGuests)의 인자값
            roomNumber = getUpdateRoomNumber(); // 방 번호를 받아온다.
            updateCalcCostOfStaying(); // 숙박 일수 * 방 가격 + calcAlphaCost()

            updateCostOfStayingTextField.setText(Integer.toString(getUpdateCostOfStaying())); // 계산 결과를 TextField에 전달
        }
    }//GEN-LAST:event_updateCalcCostOfStayingButtonActionPerformed

    private void cardRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardRadioButtonActionPerformed

        registCreditCardButton.setEnabled(true);
    }//GEN-LAST:event_cardRadioButtonActionPerformed

    private void cashRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashRadioButtonActionPerformed
        
        registCreditCardButton.setEnabled(false);
    }//GEN-LAST:event_cashRadioButtonActionPerformed

    private void updateCardRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCardRadioButtonActionPerformed
        
        updateRegistCreditCardButton.setEnabled(true);
    }//GEN-LAST:event_updateCardRadioButtonActionPerformed

    private void updateCashRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCashRadioButtonActionPerformed
        
        updateRegistCreditCardButton.setEnabled(false);
    }//GEN-LAST:event_updateCashRadioButtonActionPerformed

    private void roomNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNumberTextFieldActionPerformed

    private void registCreditCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registCreditCardButtonActionPerformed
        // TODO add your handling code here:
        registCardDialog.setVisible(true);
        registCardDialog.setLocationRelativeTo(this);
        registCardDialog.setSize(438, 223);
        registCardDialog.setTitle("카드 등록");
        registCardDialog.setLocationRelativeTo(this);
    }//GEN-LAST:event_registCreditCardButtonActionPerformed

    private void disposeCreditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disposeCreditButtonActionPerformed
        // TODO add your handling code here:
        registCardDialog.setVisible(false);
    }//GEN-LAST:event_disposeCreditButtonActionPerformed

    private void registCreditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registCreditButtonActionPerformed
        try {
            if(updateButtonWork){
                inputCard(Integer.parseInt(selectedIndex));
            }
            else{
                inputCard(getPreviousIndex());
            }
        } catch (IOException ex) {
            Logger.getLogger(ReservationManagementJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        registCard=true;
        registCardDialog.setVisible(false);
    }//GEN-LAST:event_registCreditButtonActionPerformed

    private void updateRegistCreditCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRegistCreditCardButtonActionPerformed
        // TODO add your handling code here:
        registCardDialog.setVisible(true);
        registCardDialog.setLocationRelativeTo(this);
        registCardDialog.setSize(438, 223);
        registCardDialog.setTitle("카드 등록");
        registCardDialog.setLocationRelativeTo(this);
    }//GEN-LAST:event_updateRegistCreditCardButtonActionPerformed

    private void updateNumberOfGuestsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateNumberOfGuestsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateNumberOfGuestsComboBoxActionPerformed

    private void numberOfGuestsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfGuestsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfGuestsComboBoxActionPerformed

    public void loadReservationData() {
        ArrayList<BookingInfo> bookingInfo = new ArrayList<>();
        DefaultTableModel reservationTableModel = (DefaultTableModel) reservationTable.getModel();
        try {
            FileManagement fileMgmt = new FileManagement();
            fileMgmt.readBookingFileData(filePath);
            fileMgmt.splitBookingFileData();
            bookingInfo = fileMgmt.returnBookingInfo();

            // 데이터를 담을 2차원 배열 생성
            Object[][] data = new Object[bookingInfo.size()][12];

            // 2차원 배열에 데이터 채우기
            for (int i = 0; i < bookingInfo.size(); ++i) {
                data[i][0] = bookingInfo.get(i).getIndex();
                data[i][1] = bookingInfo.get(i).getName();
                data[i][2] = bookingInfo.get(i).getPhone();
                data[i][3] = bookingInfo.get(i).getZipNo();
                data[i][4] = bookingInfo.get(i).getAddress();
                data[i][5] = bookingInfo.get(i).getCheckInDate();
                data[i][6] = bookingInfo.get(i).getCheckOutDate();
                data[i][7] = bookingInfo.get(i).getNumberOfGuests();
                data[i][8] = bookingInfo.get(i).getRoomNumber();
                data[i][9] = bookingInfo.get(i).getCostOfStaying();
                data[i][10] = bookingInfo.get(i).getPaymentMethod();
                data[i][11] = bookingInfo.get(i).getCheckInStatus();
            }

            // 테이블 모델 업데이트
            reservationTableModel.setDataVector(data, new Object[]{
                "고유번호", "이름", "전화번호", "우편번호", "주소", "체크인 날짜", "체크아웃 날짜",
                "인원수", "방번호", "숙박비", "결제 수단", "상태"
            });
        } catch (IOException e) {
        }
    }
    
    private static String getElementValue(Element element, String tagName) {

        NodeList nodeList = element.getElementsByTagName(tagName);

        if (nodeList.getLength() > 0) {

            return nodeList.item(0).getTextContent();
        }

        return "";
    }
    
    private int getPreviousIndex() throws IOException {
        
        int previousIndex = 1;
        String[] columns = null;
        boolean isFirstData = true;
        
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null) {
                
                columns = line.split("\t");
            }
            
            if (columns != null) {
                previousIndex = Integer.parseInt(columns[0]);
                isFirstData = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (!isFirstData) {
            return previousIndex + 1;
        }
        else {
            return previousIndex;
        }
    }
    
    private String inputData() throws IOException {
        
        index = getPreviousIndex();
        name = getThisName();
        phoneNumber = getPhone();
        zipNo = getZipNo();
        address = getRoadAddrPart1() + " " + getRoadAddrPart2();
        
        checkInDate = getCheckInDate();
        checkOutDate = getCheckOutDate();
        
        numberOfGuests = getNumberOfGuests();
        roomNumber = getRoomNumber();
        costOfStaying = getCostOfStaying();
        paymentMethod = getPaymentMethod();
        String checkInStatus = "예약"; // 체크인: 체크인, 체크아웃: 체크아웃, 예약 취소: 취소
        
        String inputData = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t", 
                                        index, 
                                        name, phoneNumber, 
                                        zipNo, address, 
                                        checkInDate, checkOutDate, 
                                        numberOfGuests, roomNumber, 
                                        costOfStaying, paymentMethod, 
                                        checkInStatus);
        
        return inputData;
    }
    
    private void inputCard(int index) {
        
        creditCardNumber = String.format("%s%s%s%s%s%s%s",
                                            firstCardNumber.getText(),
                                            "-",
                                            secondCardNumber.getText(),
                                            "-",
                                            thirdCardNumber.getText(),
                                            "-",
                                            fourthCardNumber.getText());
        
        creditValidMonth = creditValidMonthTextField.getText();
        creditValidYear = creditValidYearTextField.getText();
        String creditValid = creditValidMonth + "/" + creditValidYear;
        
        creditCvcNumber = creditCvcTextField.getText();
        
        inputCardData = String.format("%s\t%s\t%s\t%s\t", 
                                    index, 
                                    creditCardNumber, 
                                    creditValid, 
                                    creditCvcNumber);
    }
    
    private void inputCash(int index) {
        
        inputCardData = String.format("%s\t%s\t", 
                                    index,
                                        "0");
    }
    
    private void InitData() {
        
        lastNameTextField.setText("성");
        firstNameTextField.setText("이름");
        secondPhoneTextField.setText(null);
        thirdPhoneTextField.setText(null);
        zipNoLabel.setText(null);
        roadAddrPart1Label.setText(null);
        roadAddrPart2Label.setText(null);
        checkInDateChooser.setDate(null);
        checkOutDateChooser.setDate(null);
        numberOfGuestsComboBox.setSelectedIndex(0);
        roomNumberTextField.setText(null);
        cardRadioButton.setSelected(false);
        cashRadioButton.setSelected(false);
        costOfStayingTextField.setText("0");
    }
    
    private int calcAlphaCost(int numberOfGuests) {
        
        int alphaCost = 0;
        
        if (numberOfGuests > 4) { // 4명을 넘기면
            alphaCost = (numberOfGuests - 4) * 10000; // 인당 10,000원의 추가 금액 발생
        }
        
        return alphaCost;
    }
    
    public int getroomPrice(int roomGrade) { //객실 층수를 받아서 test_room파일의 객실가격을 리턴

        String[] columns = null;
        String roomprice = ""; // 객실가격을 저장하여 리턴하는 변수

        try {
            File file = new File(filePathRoom);
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();

            // 파일의 내용을 읽어오면서 리턴할 부분을 찾음
            String line;
            int currentIndex = 1;
            while ((line = br.readLine()) != null) {
                if (currentIndex == roomGrade) {
                    // 특정 행일 경우, 리턴할 데이터로 변경
                    columns = line.split("\t");
                    roomprice = columns[3];
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
        return Integer.parseInt(roomprice);
    }
    
    private int roomPricing(String roomGrade) {
        int roomgrade=Integer.parseInt(roomGrade);
        int roomPrice = getroomPrice(roomgrade);
        return roomPrice;
    }
    
    private long calcDaysBetween() {
        
        LocalDate startDate = LocalDate.parse(checkInDate, formatter);
        LocalDate endDate = LocalDate.parse(checkOutDate, formatter);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        ChronoUnit.DAYS.between(startDate, endDate);
        
        return daysBetween;
    }
    
        private long updateCalcDaysBetween() {
        
        LocalDate startDate = LocalDate.parse(checkInDate, formatter);
        LocalDate endDate = LocalDate.parse(checkOutDate, formatter);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        ChronoUnit.DAYS.between(startDate, endDate);
        
        return daysBetween;
    }
    
    private String extractRoomGrade(String roomNumber) {
        if (roomNumber == null || roomNumber.isEmpty()) {
            
            return "1";
        }

        if (roomNumber.length() < 4) {
            return roomNumber.substring(0, 1);
        } else {
            return roomNumber.substring(0, 2);
        }
    }
    
    private void calcCostOfStaying() {
        
        costOfStaying = (int)calcDaysBetween() * roomPricing(getRoomGrade()) + calcAlphaCost(getNumberOfGuests());
    }
    
    private void updateCalcCostOfStaying() {
        
        costOfStaying = (int)calcDaysBetween() * roomPricing(getUpdateRoomGrade()) + calcAlphaCost(getUpdateNumberOfGuests());
    }
    
    private String reWriteLine(String[] columns) {
        String line = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t", 
                                    columns[0], columns[1], columns[2], columns[3],
                                    columns[4], columns[5], columns[6], columns[7],
                                    columns[8], columns[9], columns[10], columns[11]);
        
        return line;
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
            java.util.logging.Logger.getLogger(ReservationManagementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationManagementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationManagementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationManagementJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservationManagementJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JDialog addressSearchingDialog;
    private javax.swing.JTextField addressSearchingTextField;
    private javax.swing.JTable addressTable;
    private javax.swing.JButton calcCostOfStayingButton;
    private javax.swing.JButton callAddressSearchingDialogButton;
    private javax.swing.JButton callRegistDialogButton;
    private javax.swing.JRadioButton cardRadioButton;
    private javax.swing.JRadioButton cashRadioButton;
    private com.toedter.calendar.JDateChooser checkInDateChooser;
    private javax.swing.JLabel checkInLabel;
    private javax.swing.JLabel checkInLabel1;
    private com.toedter.calendar.JDateChooser checkOutDateChooser;
    private javax.swing.JLabel checkOutLabel;
    private javax.swing.JLabel checkOutLabel1;
    private javax.swing.JLabel costOfStayingLabel;
    private javax.swing.JLabel costOfStayingLabel1;
    private javax.swing.JTextField costOfStayingTextField;
    private javax.swing.JLabel creditCardInfoLabel;
    private javax.swing.JLabel creditCardInfoLabel1;
    private javax.swing.JTextField creditCvcTextField;
    private javax.swing.JTextField creditValidMonthTextField;
    private javax.swing.JTextField creditValidYearTextField;
    private javax.swing.JLabel creditValidityLabel;
    private javax.swing.JLabel cvcLabel;
    private javax.swing.JLabel dashLabel;
    private javax.swing.JTextField defaultPhoneTextField;
    private javax.swing.JButton delete;
    private javax.swing.JDialog deleteDialog;
    private javax.swing.JButton deleteOkButton;
    private javax.swing.JButton disposeButton;
    private javax.swing.JButton disposeButton1;
    private javax.swing.JButton disposeButton2;
    private javax.swing.JButton disposeCreditButton;
    private javax.swing.JTextField firstCardNumber;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JTextField fourthCardNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JComboBox<String> numberOfGuestsComboBox;
    private javax.swing.JLabel numberOfPeopleLabel;
    private javax.swing.JLabel numberOfPeopleLabel1;
    private javax.swing.ButtonGroup paymentMethodGroup;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel phoneLabel1;
    private javax.swing.JButton registButton;
    private javax.swing.JDialog registCardDialog;
    private javax.swing.JButton registCreditButton;
    private javax.swing.JButton registCreditCardButton;
    private javax.swing.JDialog registDialog;
    private javax.swing.JTable reservationTable;
    private javax.swing.JLabel roadAddrPart1Label;
    private javax.swing.JLabel roadAddrPart2Label;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JLabel roomLabel1;
    private javax.swing.JTextField roomNumberTextField;
    private javax.swing.JButton searchAddressButton;
    private javax.swing.JTextField secondCardNumber;
    private javax.swing.JLabel secondDashLabel;
    private javax.swing.JTextField secondPhoneTextField;
    private javax.swing.JButton selectAddressButton;
    private javax.swing.JButton setInvisibleDialogButton;
    private javax.swing.JTextField thirdCardNumber;
    private javax.swing.JLabel thirdDashLabel;
    private javax.swing.JTextField thirdPhoneTextField;
    private javax.swing.JButton update;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateCalcCostOfStayingButton;
    private javax.swing.JRadioButton updateCardRadioButton;
    private javax.swing.JRadioButton updateCashRadioButton;
    private com.toedter.calendar.JDateChooser updateCheckInDateChooser;
    private com.toedter.calendar.JDateChooser updateCheckOutDateChooser;
    private javax.swing.JTextField updateCostOfStayingTextField;
    private javax.swing.JTextField updateDefaultPhoneTextField;
    private javax.swing.JDialog updateDialog;
    private javax.swing.JTextField updateFirstNameTextField;
    private javax.swing.JButton updateInvisibleButton;
    private javax.swing.JTextField updateLastNameTextField;
    private javax.swing.JComboBox<String> updateNumberOfGuestsComboBox;
    private javax.swing.ButtonGroup updatePaymentMethodGroup;
    private javax.swing.JButton updateRegistCreditCardButton;
    private javax.swing.JTextField updateRoomNumberTextField;
    private javax.swing.JTextField updateSecondPhoneTextField;
    private javax.swing.JTextField updateThirdPhoneTextField;
    private javax.swing.JLabel validityDashLabel;
    private javax.swing.JLabel warningLabel;
    private javax.swing.JLabel wonLabel;
    private javax.swing.JLabel wonLabel1;
    private javax.swing.JLabel zipNoLabel;
    // End of variables declaration//GEN-END:variables
}

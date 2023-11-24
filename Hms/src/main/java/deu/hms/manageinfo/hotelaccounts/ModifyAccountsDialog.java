/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.manageinfo.hotelaccounts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author bennyjung
 */
public class ModifyAccountsDialog extends JDialog {
    
    JLabel accsNumb;
    JLabel accsId;
    JLabel accsAuth;
    JLabel accsNumbTag;
    JLabel accsIdTag;
    JLabel accsPwTag;
    JTextField accsNumbField;
    JTextField accsIdField;
    JTextField accsPwField;
    JButton confirmButton;
    JButton cancelButton;
    int isRowData;
    
    
    public ModifyAccountsDialog(JFrame parent, String title, boolean modal,  Object[] rowData) {
        super(parent,title,modal);
        
        setSize(400,400);
        setLayout(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        //add case
        if(rowData == null) {
            accsNumbTag = new JLabel("사용자 고유 번호 ");
            accsIdTag = new JLabel("사용자 ID ");
            accsPwTag = new JLabel("사용자 PW ");
            isRowData = -1;
            accsNumbField = new JTextField();
            accsIdField = new JTextField();
            accsPwField = new JTextField();
            //set bounds 
            accsNumbField.setBounds(30,30,100,30);
            accsIdField.setBounds(150,30,100,30);
            accsNumbTag.setBounds(30,10,100,30);
            accsIdTag.setBounds(150,10,100,30);
            accsPwTag.setBounds(250,10,100,30);
            accsAuth = new JLabel("S");
            add(accsNumbField);
            add(accsIdField);
            add(accsNumbTag);
            add(accsIdTag);
            add(accsPwTag);
            
        } else {
            accsNumb = new JLabel(rowData[0].toString());
            accsId = new JLabel(rowData[1].toString());
            accsAuth = new JLabel(rowData[3].toString());
            accsPwField = new JTextField(rowData[2].toString());
            //set bounds
            accsNumb.setBounds(30,30,100,30);
            accsId.setBounds(80,30,100,30);
            
            add(accsNumb);
            add(accsId);
            
        }
        
        
        
        accsPwField.setBounds(250,30,100,30);
        accsAuth.setBounds(305,30,100,30);
        
        add(accsPwField);
        add(accsAuth);
        
        confirmButton = new JButton("확인 ");
        cancelButton = new JButton("취소 ");
        
        confirmButton.setBounds(100,100,100,30);
        cancelButton.setBounds(200,100,100,30);
        
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // add case
                if(rowData == null ) {
                    if(validateInputText() == -1){
                        
                    } else {
                        dispose();
                    }
                    
                //edit case
                } else {
                    if(validatePwText() == -1){
                    
                    } else {
                        dispose();
                    }
                }
                
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // add case
                if(rowData == null) {
                    
                    accsAuth.setText("");
                    
                    dispose();
                    // edit case 
                } else {
                    if (accsPwField != null) {
                        accsPwField.setText(rowData[2].toString());
                        
                    }
                }
                
                dispose();
            }
        });
        add(confirmButton);
        add(cancelButton);
        
        
        
    }
    
    // add case
    private int validateInputText(){
        int errnumb = 0;
        String accsNumbText = accsNumbField.getText().trim();
        String accsId = accsIdField.getText().trim();
        String accsPw = accsPwField.getText().trim();
        
        String regex = "\\d+";
        
        if (!accsNumbText.matches(regex)) {
            JOptionPane.showMessageDialog(this, "사용자 고유번호는 양의 정수이어야 합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            errnumb = -1;
        }
        
        
        if(accsNumbText.isEmpty() || accsId.isEmpty() || accsId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "텍스트 필드를 채워주십시오. ", "경고", JOptionPane.WARNING_MESSAGE);
            errnumb = -1;
        }
        return errnumb;
    }
    
    //edit case
    private int validatePwText() {
        int errnumb = 0;
        String accsPw = accsPwField.getText().trim();
        if(accsPw.isEmpty()) {
            JOptionPane.showMessageDialog(this, "텍스트 필드를 채워주십시오. ", "경고", JOptionPane.WARNING_MESSAGE);
            errnumb = -1;
        }
        return errnumb;
    }
    
    
    
    public Object[] getEditedData() {
        if(isRowData == -1 ){
            return new Object[]{
               accsNumbField.getText(),
               accsIdField.getText(),
               accsPwField.getText(),
               accsAuth.getText()
            };
        
        } else {
            return new Object[]{
               accsNumb.getText(), 
               accsId.getText(),
               accsPwField.getText(),
               accsAuth.getText()
            };
        
        }
       
   }
}

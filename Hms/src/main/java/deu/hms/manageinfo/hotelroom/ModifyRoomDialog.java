/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.manageinfo.hotelroom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author bennyjung
 */
public class ModifyRoomDialog extends JDialog {
    
    
    private JTextField floorField;
    private JLabel floorLbl;
    private JLabel floorLblTag;
    private JComboBox<String> amountComboBox;
    private JComboBox<String> classComboBox;
    private JTextField priceTextField;
    private JButton confirmButton;
    private JButton cancelButton;
    private int isRowData;
    
    public ModifyRoomDialog(JFrame parent, String title, boolean modal,  Object[] rowData) {
        super(parent,title,modal);
       
        setSize(550,200);
        setLayout(null);
        
        if(rowData == null) {
            isRowData = -1;
            floorField = new JTextField();
            amountComboBox = new JComboBox<>(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "F"});
            classComboBox = new JComboBox<>(new String[]{"Regular","Deluxe","Royal","Suite"});
            priceTextField = new JTextField();
            floorField.setBounds(20, 20, 100, 30);
        
        } else {
            floorLbl = new JLabel(rowData[0].toString());
            amountComboBox = new JComboBox<>(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "F"});
            classComboBox = new JComboBox<>(new String[]{"Regular","Deluxe","Royal","Suite"});
            priceTextField = new JTextField(rowData[3].toString());
            floorLbl.setBounds(20, 20, 100, 30);
               
        }
        
        
        floorLblTag = new JLabel("층 ");
        
        floorLblTag.setBounds(50, 20, 100, 30);
        amountComboBox.setBounds(130, 20, 100, 30);
        classComboBox.setBounds(240, 20, 100, 30);
        priceTextField.setBounds(350, 20, 100, 30);
        
        if(rowData !=null){
            amountComboBox.setSelectedItem(rowData[1]);
            classComboBox.setSelectedItem(rowData[2]);
            add(floorLbl);
        } else {
            add(floorField);
        }
        add(floorLblTag);
        add(amountComboBox);
        add(classComboBox);
        add(priceTextField);
        
        //add actionListener of classComboBox
        classComboBox.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
               UpdatePrice();
           }
        });
        
        
        confirmButton = new JButton("확인 ");
        cancelButton = new JButton("취소 ");
        
        confirmButton.setBounds(300, 80, 100, 30);
        cancelButton.setBounds(150,80,100,30);
        
        ////add actionListener of confirmButton
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validatePrice() == 0 ) {
                    dispose();
                } else {
                    UpdatePrice();
                }
                
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(confirmButton);
        add(cancelButton);

                
    }
    
    private void UpdatePrice() {
        String setRoomClass = classComboBox.getSelectedItem().toString();
        
        switch (setRoomClass) {
            case "Regular" : {
                priceTextField.setText("100000");
                break;
            }
            case "Deluxe" : {
                priceTextField.setText("150000");
                break;
            }
            case "Royal" : {
                priceTextField.setText("200000");
                break;
            }
            case "Suite" : {
                priceTextField.setText("400000");
                break;
            }
        }
    }
    private int validatePrice() {
        int errnumb = 0;
        try{
            int price = Integer.parseInt(priceTextField.getText());
            
            if(price<0 ) {
                JOptionPane.showMessageDialog(this, "가격은 0 이상이어야 합니다.", "경고", JOptionPane.WARNING_MESSAGE);
                
                errnumb = -1;
            }
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "가격은 숫자여야 합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            
            errnumb = -1;
        }
        return errnumb;
        
    }
    

    public Object[] getEditedData() {
        if(isRowData == -1 ){
            
            return new Object[]{
               floorField.getText(), 
               amountComboBox.getSelectedItem(),
               classComboBox.getSelectedItem(),
               priceTextField.getText()
            };
        
        } else {
            return new Object[]{
               floorLbl.getText(), 
               amountComboBox.getSelectedItem(),
               classComboBox.getSelectedItem(),
               priceTextField.getText()
            };
        
        }
       
   }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.manageinfo.hotelrestaurant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author bennyjung
 */
public class ModifyRestDialog extends JDialog{
    
    private JTextField servNameField;
    private JTextField dishNameField;
    private JTextField dishPriceField;
    private JLabel servNameTag;
    private JLabel dishNameTag;
    private JLabel dishPriceTag;
    private JButton confirmButton;
    private JButton cancelButton;
    
    public ModifyRestDialog(JFrame parent, String title, boolean modal,  Object[] rowData){
        super(parent,title,modal);
        
        setSize(400,200);
        setLayout(null);
        
        if(rowData == null) {
            servNameField = new JTextField();
            dishNameField = new JTextField();
            dishPriceField = new JTextField();
        } else {
            servNameField = new JTextField(rowData[0].toString());
            dishNameField = new JTextField(rowData[1].toString());
            dishPriceField = new JTextField(rowData[2].toString());
        }
        servNameTag = new JLabel("서비스 종류 ");
        dishNameTag = new JLabel("음식 이름 ");
        dishPriceTag = new JLabel("음식 가격 ");
        
        servNameField.setBounds(30,35,100,30);
        dishNameField.setBounds(130,35,100,30);
        dishPriceField.setBounds(230,35,100,30);
        
        servNameTag.setBounds(50,10,100,30);
        dishNameTag.setBounds(150,10,100,30);
        dishPriceTag.setBounds(250,10,100,30);
        
        
        add(servNameField);
        add(dishNameField);
        add(dishPriceField);
        add(servNameTag);
        add(dishNameTag);
        add(dishPriceTag);
        
        confirmButton = new JButton("확인 ");
        cancelButton = new JButton("취소 ");
        
        confirmButton.setBounds(100,100,100,30);
        cancelButton.setBounds(200,100,100,30);
        confirmButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateText() == 0 ) {
                    dispose();
                } else {
                    
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
    private int validateText(){
        int errnumb = 0;
        String servName = servNameField.getText().trim();
        String dishName = dishNameField.getText().trim();
        String dishPrice = dishPriceField.getText().trim();
        if(servName.isEmpty() || dishName.isEmpty() || dishPrice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "텍스트 필드를 채워주십시오. ", "경고", JOptionPane.WARNING_MESSAGE);
            errnumb = -1;
        }
        return errnumb;
    }
    
    
    public Object[] getEditedData() {
            return new Object[]{
               servNameField.getText(), 
               dishNameField.getText(),
               dishPriceField.getText()
            };
   }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.restaurant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Lenovo
 */
public final class LoadRoomNum {
    
    private ArrayList<String> ReadRoomNum = new ArrayList<>();
    private ArrayList<String> RoomNum = new ArrayList<>();
      
    public LoadRoomNum(DefaultComboBoxModel model) {
        
        try {
            String paths = System.getProperty("user.dir");
            File roomNum = new File(paths + "/clientInfo.txt");
            
            readRoomFile(roomNum);
            splitRoomNumtData();
            
            for (int i = 0 ; i < RoomNum.size() ; i++) {
                model.addElement(RoomNum.get(i));
            }            
        } catch (IOException ex) {
            Logger.getLogger(LoadRoomNum.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    
      private void readRoomFile(File file) throws IOException { //메뉴 파일 읽어오기
        String line = null;
        
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));

        while ((line = br.readLine()) != null) {
            ReadRoomNum.add(line);
        }
    }

    private void splitRoomNumtData() { //배열 분해 ('\t' 기준)
        String line;
        for (int i = 0; i < ReadRoomNum.size(); i++) {
            line = ReadRoomNum.get(i);
            String[] str = line.split("\t");
            if (str[11].equals("체크인")) {
                RoomNum.add(str[8]);
            }
        }
    }
    
        public static void main(String[] args) {
        //System.out.println("Find");
        
    }
}

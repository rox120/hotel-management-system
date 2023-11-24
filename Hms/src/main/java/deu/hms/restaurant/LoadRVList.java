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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class LoadRVList {
        private String line = null;

    ArrayList<String> ReadRVList = new ArrayList<>(); //일반 배열
    ArrayList<String> RVList = new ArrayList<>();

    public LoadRVList(DefaultTableModel model) {

        String paths = System.getProperty("user.dir");
        File menu = new File(paths + "/reservation_list.txt");

        try {
            readMenuFile(menu);
            splitServiceListData();

            for (int i = 0; i < RVList.size(); i++) {
                model.addRow(new Object[]{
                    RVList.get(i),
                    RVList.get(i+1),
                    RVList.get(i+2),
                    RVList.get(i+3),
                    RVList.get(i+4),
                    RVList.get(i+5)
                });
                 i += 5;
            }
        } catch (IOException ex) {
            Logger.getLogger(LoadMenuList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void readMenuFile(File file) throws IOException { //메뉴 파일 읽어오기
        
        /* 해당 서비스의 메뉴를 order_list.txt 파일에서 불러오는 역할을 한다.
        파일의 텍스트를 읽어와 Array 배열에 저장하는 역할을 한다.
        "URF-8"은 한글파일을 읽어올 수 있도록 한다. */
        
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));

        while ((line = br.readLine()) != null) {
            ReadRVList.add(line);
        }
    }

    private void splitServiceListData() { //배열 분해 ('\t' 기준)
        
         /* Array배열에 저장되어있는 메뉴 리스트를 MenuTable에 넣기 위하여 해당 테이블의 열 갯수대로 나눈다.
            "\t"를 기준으로 split()메서드를 사용해서 나누어 Array배열에 저장한다. */
        
        String line;
        for (int i = 0; i < ReadRVList.size(); i++) {
            line = ReadRVList.get(i);
            String[] str = line.split("\t");
            
            for (int j = 0; j < 6; j++) {              
                RVList.add(str[j]);
            }
        }
    }
    public static void main(String[] args) {
    
    }

}

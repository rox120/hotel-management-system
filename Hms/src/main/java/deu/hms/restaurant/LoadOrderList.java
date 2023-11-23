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
public class LoadOrderList {
   
    private String line = null;

    ArrayList<String> ReadOrderList = new ArrayList<>(); //일반 배열
    ArrayList<ServiceListInfo> OrderList = new ArrayList<>(); // 객체 배열

    public LoadOrderList(DefaultTableModel model) {

        String paths = System.getProperty("user.dir");
        File order = new File(paths + "/order_list.txt");

        try {
            readMenuFile(order);
            splitServiceListData();

            for (int i = 0; i < OrderList.size(); i++) {
                model.addRow(new Object[]{
                    OrderList.get(i).getService(),
                    OrderList.get(i).getMenu(),
                    OrderList.get(i).getPrice()
                });
            }
        } catch (IOException ex) {
            Logger.getLogger(LoadServiceList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void readMenuFile(File file) throws IOException { //메뉴 파일 읽어오기

        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));

        while ((line = br.readLine()) != null) {
            ReadOrderList.add(line);
        }
    }

    private void splitServiceListData() { //배열 분해 ('\t' 기준)
        String line;
        for (int i = 0; i < ReadOrderList.size(); i++) {
            line = ReadOrderList.get(i);
            String[] str = line.split("\t");
            OrderList.add(new ServiceListInfo(str[0], str[1], str[2]));
        }
    }
    
    public static void main(String[] args) {
        //main
    }

}

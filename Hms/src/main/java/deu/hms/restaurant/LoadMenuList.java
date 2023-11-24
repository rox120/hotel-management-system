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
 * @author bennyjung
 */
public class LoadMenuList {

    private String line = null;

    ArrayList<String> ReadServiceList = new ArrayList<>(); //일반 배열
    ArrayList<ServiceListInfo> serviceList = new ArrayList<>(); // 객체 배열

    public LoadMenuList(DefaultTableModel model) {

        String paths = System.getProperty("user.dir");
        File menu = new File(paths + "/menu_list.txt");

        try {
            readMenuFile(menu);
            splitServiceListData();

            for (int i = 0; i < serviceList.size(); i++) {
                model.addRow(new Object[]{
                    serviceList.get(i).getService(),
                    serviceList.get(i).getMenu(),
                    serviceList.get(i).getPrice()
                });
            }
        } catch (IOException ex) {
            Logger.getLogger(LoadMenuList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public LoadMenuList(DefaultTableModel model, String type, int tableColumnSize) {

        String paths = System.getProperty("user.dir");
        File menu = new File(paths + "/menu_list.txt");

        try {
            readMenuFile(menu);
            splitServiceListData();

            for (int i = 0; i < serviceList.size(); i++) {
                if (serviceList.get(i).getService().equals(type)) {
                    if (tableColumnSize == 2) {
                        model.addRow(new Object[]{
                            serviceList.get(i).getMenu(),
                            serviceList.get(i).getPrice()
                        });
                    }
                    if (tableColumnSize == 3) {
                        model.addRow(new Object[]{
                            serviceList.get(i).getService(),
                            serviceList.get(i).getMenu(),
                            serviceList.get(i).getPrice()
                        });
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(LoadMenuList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void readMenuFile(File file) throws IOException { //메뉴 파일 읽어오기

        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));

        while ((line = br.readLine()) != null) {
            ReadServiceList.add(line);
        }
    }

    public void splitServiceListData() { //배열 분해 ('\t' 기준)
        String line;
        for (int i = 0; i < ReadServiceList.size(); i++) {
            line = ReadServiceList.get(i);
            String[] str = line.split("\t");
            serviceList.add(new ServiceListInfo(str[0], str[1], str[2]));
        }
    }

    public static void main(String[] args) {
        //System.out.println("Find");
    }
}

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
    
    /* 해당 클래스의 생성자로서 현재 프로젝트가 저장되어 있는 파일경로를 받아오고 
        파일 경로를 전달해 데이터를 원하는 값으로 받아온 후 지정된 케이블의 열 크기에 따라
        DefaultTableModel(테이블 초깃값)에 추가한다. */
    private String line = null;

    ArrayList<String> ReadServiceList = new ArrayList<>(); //일반 배열
    ArrayList<ServiceListInfo> serviceList = new ArrayList<>(); // 객체 배열

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
        
        /* 해당 서비스의 메뉴를 order_list.txt 파일에서 불러오는 역할을 한다.
        파일의 텍스트를 읽어와 Array 배열에 저장하는 역할을 한다.
        "URF-8"은 한글파일을 읽어올 수 있도록 한다. */
        
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));

        while ((line = br.readLine()) != null) {
            ReadServiceList.add(line);
        }
    }

    public void splitServiceListData() { //배열 분해 ('\t' 기준)
        
         /* Array배열에 저장되어있는 메뉴 리스트를 MenuTable에 넣기 위하여 해당 테이블의 열 갯수대로 나눈다.
            "\t"를 기준으로 split()메서드를 사용해서 나누어 Array배열에 저장한다. */
        
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

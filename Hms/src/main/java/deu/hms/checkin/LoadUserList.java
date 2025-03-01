/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.checkin;

/**
 *
 * @author 장성열
 */
import deu.hms.reservation.BookingInfo;
import deu.hms.restaurant.LoadServiceList;
import deu.hms.restaurant.ServiceListInfo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.nio.charset.StandardCharsets;


public class LoadUserList {
    private ArrayList<String> readUserInfo = new ArrayList<>();
    private ArrayList<UserInfoList> UserInfo = new ArrayList<>();
    
    private final String path = System.getProperty("user.dir");
    private final String filePath = path + "/clientInfo.txt";
    
    public LoadUserList(){
        readUserFileData(filePath);
        splitUserFileData();
    }
    
    
    public void readUserFileData(String path) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            while ((line = br.readLine()) != null) {
                readUserInfo.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("파일이 존재하지않습니다. 경로를 확인해주세요");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void splitUserFileData() {
        String line;

        for (int i = 0; i < readUserInfo.size(); i++) {
            line = readUserInfo.get(i);
            String[] str = line.split("\t");
            UserInfo.add(new UserInfoList(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10],str[11]));
        }
    }
    
    public ArrayList<UserInfoList> returnUserInfo() throws IOException {
        return UserInfo;
    }
}


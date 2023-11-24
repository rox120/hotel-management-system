/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.checkin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 장성열
 */
public class LoadSpecialRequestsList {
    private ArrayList<String> readSpecialRequests = new ArrayList<>();
    private ArrayList<SpecialRequestsList> SpecialRequests = new ArrayList<>();
    private final String path = System.getProperty("user.dir");
    private final String filePath = path + "/specialRequestsList.txt";
    
    public LoadSpecialRequestsList(){
        readUserFileData(filePath);
        splitUserFileData();
    }
    
    
    public void readUserFileData(String path) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            while ((line = br.readLine()) != null) {
                readSpecialRequests.add(line);
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

        for (int i = 0; i < readSpecialRequests.size(); i++) {
            line = readSpecialRequests.get(i);
            String[] str = line.split("\t");
            SpecialRequests.add(new SpecialRequestsList(str[0], str[1]));
        }
    }
    
    public ArrayList<SpecialRequestsList> returnSpecialRequestsList() throws IOException {
        return SpecialRequests;
    }
    
}

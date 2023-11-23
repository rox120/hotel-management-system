/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.manageinfo.hotelrestaurant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bennyjung
 */
public class RestInfoList {
    private ArrayList<String> readRestInfo = new ArrayList<>();
    private ArrayList<ModifyRest> restInfo = new ArrayList<>();
    private final String path = System.getProperty("user.dir");
    private final String filePath = path + "/menu_list.txt";
    private String line ;
    
    public RestInfoList() {
        fetchRestInfo(filePath);
        splitRestInfo();
        
    }
    
    private void fetchRestInfo(String restPath) {
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(restPath)));
            while ((line = br.readLine()) != null) {
                readRestInfo.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾지 못했습니다 ");
        } catch (IOException e) {
        
        }
    }
    
    private void splitRestInfo() {
        String splitLine;
        for (int i = 0; i < readRestInfo.size(); i++) {
            splitLine = readRestInfo.get(i);
            String[] str = splitLine.split("\t");

            restInfo.add(new ModifyRest(str[0],str[1],str[2]));
          
            }
    
    }

    public ArrayList<ModifyRest> getRestInfo() {
        return restInfo;
    }
    
    
    
}

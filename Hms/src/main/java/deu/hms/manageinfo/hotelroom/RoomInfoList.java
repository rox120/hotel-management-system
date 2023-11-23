/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.manageinfo.hotelroom;

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
public class RoomInfoList {
    private ArrayList<String> readRoomInfo = new ArrayList<>();
    private ArrayList<ModifyRoom> roomInfo = new ArrayList<>();
    private final String path = System.getProperty("user.dir");
    private final String filePath = path + "/test_room.txt";
    private String line ;

    
    public RoomInfoList(){
        fetchRoomInfo(filePath);
        splitRoomInfo();
    }
    
    private void fetchRoomInfo(String roomPath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(roomPath)));
            
            while ((line = br.readLine()) != null) {
                readRoomInfo.add(line);
            }
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
            System.out.println("파일이 존재하지않습니다. 경로를 확인해주세요");
        } catch (IOException e) {
//            e.printStackTrace();
        }
    
    }
    
    private void splitRoomInfo() {
        String splitLine;
        for (int i = 0; i < readRoomInfo.size(); i++) {
            splitLine = readRoomInfo.get(i);
            String[] str = splitLine.split("\t");
            roomInfo.add(new ModifyRoom(str[0],str[1],str[2],str[3]));
            }
        
    }

    public ArrayList<ModifyRoom> getRoomInfo() {
        return roomInfo;
    }
    
    
}

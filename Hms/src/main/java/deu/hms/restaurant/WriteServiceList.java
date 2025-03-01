/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.restaurant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lenovo
 */
public class WriteServiceList {

    private String roomNum;
    private String service;
    private String menu;
    private String pay;
    private int total;
    private String DayTime;
    
    public String getMenu() {
        return menu;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getService() {
        return service;
    }

    public String getPay() {
        return pay;
    }

    public String getDayTime() {
        return DayTime;
    }
    
    public int getTotal() {
        return total;
    }
    
    public void setRoomNum(String roomNum) {
       this.roomNum = roomNum;
    }
    
    public void setService(String service) {
       this.service = service;
    }
    
    public void setMenu(String menu) {
       this.menu = menu;
    }
    
    public void setPay(String pay) {
       this.pay = pay;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }

    public void setDayTime(String DayTime) {
        this.DayTime = DayTime;
    }
    
    
    public void WriteOrderList() {
        LocalDateTime now = LocalDateTime.now(); //현재 시간
        DayTime = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd/ HH:mm:ss"));
        
        String paths = System.getProperty("user.dir");
        File order = new File(paths + "/order_list.txt");
        
        String Data = (DayTime + "\t" + roomNum + "\t" + service + "\t" + menu + "\t" + pay + "\t" + total);
        
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(order, true), StandardCharsets.UTF_8))) { // true를 전달하여 파일을 추가 모드로 열기
            writer.write(Data+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

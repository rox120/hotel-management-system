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
import javax.swing.JOptionPane;

public class WriteReservation {

    private String Time = null;
    private String Date = null;
    private String MenuNum=null;
    private String Service = null;
    private String Room = null;
    
    private int Total;

    public String getTime() {
        return Time;
    }

    public void setTime(String Hour, String Min) {
        this.Time = Hour+"시"+Min+"분";
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String year, String month, String day) {        
        this.Date = year+"년"+month+"월"+day+"일";
    }

    public String getMenuNum() {
        return MenuNum;
    }

    public void setMenuNum(String MenuNum) {
        this.MenuNum = MenuNum;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public String getService() {
        return Service;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public String getRoom() {
        return Room;
    }

    public void setRoom(String Room) {
        this.Room = Room;
    }

    public void WriteReservationList() {
        
            String paths = System.getProperty("user.dir");
            File order = new File(paths + "/reservation_list.txt");

            String Data = (Date + "\t" + Time + "\t" + Room + "\t" + Service + "\t" + MenuNum + "\t" + Total);

            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(order, true), StandardCharsets.UTF_8))) { // true를 전달하여 파일을 추가 모드로 열기
                writer.write(Data + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

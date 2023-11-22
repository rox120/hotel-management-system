/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.manageinfo;

/**
 *
 * @author bennyjung
 */
public class ModifyRoom {
    private String roomFloor;
    private String roomAmount;
    private String roomClass;
    private String roomPrice;
    
    public ModifyRoom(String rf, String ra, String rc, String rp) {
        roomFloor = rf;
        roomAmount = ra;
        roomClass = rc;
        roomPrice = rp;
    }

    public String getRoomFloor() {
        return roomFloor;
    }

    public String getRoomAmount() {
        return roomAmount;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public String getRoomPrice() {
        return roomPrice;
    }
    
    
    
}

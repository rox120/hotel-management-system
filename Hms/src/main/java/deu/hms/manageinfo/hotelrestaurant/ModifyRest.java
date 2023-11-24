/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.manageinfo.hotelrestaurant;

/**
 *
 * @author bennyjung
 */
public class ModifyRest {
    private String serviceName;
    private String dishName;
    private String dishPrice;
    
    public ModifyRest(String serviceName, String dishName, String dishPrice) {
        this.serviceName = serviceName;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDishName() {
        return dishName;
    }

    public String getDishPrice() {
        return dishPrice;
    }
    
    
    
}

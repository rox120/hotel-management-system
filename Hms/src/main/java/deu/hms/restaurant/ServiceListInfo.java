/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.restaurant;

/**
 *
 * @author Lenovo
 */
public class ServiceListInfo {

    static void add(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String service;
    private String menu;
    private String price;

    public ServiceListInfo(String service, String menu, String price) {
        this.service = service;
        this.menu = menu;
        this.price = price;
    }

    public String getService() {
        return service;
    }

    public String getMenu() {
        return menu;
    }

    public String getPrice() {
        return price;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setMenu(String productname) {
        this.menu = productname;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}

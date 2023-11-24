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
public class SpecialRequestsList {
    
    
    String NO;
    String SpecialRequest;
    
    public SpecialRequestsList(String NO,String SR){
        this.NO=NO;
        this.SpecialRequest=SR;
    }
    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public String getSpecialRequest() {
        return SpecialRequest;
    }

    public void setSpecialRequest(String SpecialRequest) {
        this.SpecialRequest = SpecialRequest;
    }
    
    
}

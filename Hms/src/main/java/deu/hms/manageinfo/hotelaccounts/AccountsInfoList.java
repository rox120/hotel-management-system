/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.manageinfo.hotelaccounts;

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
public class AccountsInfoList {
    private ArrayList<String> readaccsInfo = new ArrayList<>();
    private ArrayList<ModifyAccounts> accsInfo = new ArrayList<>();
    private final String path = System.getProperty("user.dir");
    private final String filePath = path + "/user_list.txt";
    private String line ;
    
    public AccountsInfoList(){
        fetchAccountsInfo(filePath);
        splitAccountsInfo();
    
    }
    
    private void fetchAccountsInfo(String accsPath) {
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(accsPath)));
            while((line = br.readLine()) != null) {
                readaccsInfo.add(line);
                
            }
            
        } catch(FileNotFoundException e) {
            System.out.println("파일을 찾을수 없습니다 ");
        } catch(IOException e) {
            
        }
    
    }
    
    private void splitAccountsInfo(){
        String splitLine;
        for (int i = 0; i < readaccsInfo.size(); i++) {
            splitLine = readaccsInfo.get(i);
            String[] str = splitLine.split("\t");
            accsInfo.add(new ModifyAccounts(str[0],str[1],str[2],str[3]));
            }
        
    }

    public ArrayList<ModifyAccounts> getAccsInfo() {
        return accsInfo;
    }
    
}

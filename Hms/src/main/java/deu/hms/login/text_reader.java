/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author bennyjung
 */
public class text_reader {
    private String line = null;
    private ArrayList<String> as = new ArrayList<>();
    
    private void readFile(File file) throws IOException {
       
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
        // read txt file until end of line
        while((line = br.readLine()) != null) {
            as.add(line);
        }

        
    }
    public int checkUsrIdPw(String uId, String uPw) {
        
        int resultcode = -1;
        String paths = System.getProperty("user.dir");
        File userfile = new File(paths+"/user_list.txt");
        
        try{
            readFile(userfile);
            for(String ass:as) {
                Boolean chckId = ass.contains(uId);
                Boolean chckPw = ass.contains(uPw);
                if(chckId == true && chckPw == true) {
                    resultcode = 0;
                    //for debug
//                    System.out.println("find user!");
                    if(ass.contains("M")) {
                        resultcode = 1;
                        
                    }
                    break;
                } else {
                    //for debug
//                    System.out.println("ain't find user");
                    
                }
            }
        } 
        catch (IOException e) {
        }
        return resultcode;
        
    }
    
}

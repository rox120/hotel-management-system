/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author bennyjung
 */
public class text_reader {
    private String line = null;
    // 텍스트 파일안의 데이터를 저장하기 위해서 arraylist 생성 
    private ArrayList<String> as = new ArrayList<>();
    // BufferedReader와 InputStreamReader를 사용하기 위한 (텍스트)파일 인풋스트림 
    private FileInputStream fis;
    // 현재 프로젝트의 상대적 디렉토리 경로 반환 
    private String paths = System.getProperty("user.dir");
    // 프로젝트 안의 텍스트 파일 경로를 위한 File 객체 생성 
    private File userFile = new File(paths+"/user_list.txt");
    
    // 생성자 
    public text_reader(){
        readFile(userFile);
        
    }
    // 텍스트 파일을 행단위로 읽어와서 arraylist안에 저장하는 메소드 
    private void readFile(File file)  {
        try {
            //InputStreamReader 안의 파라미터로 사용하기위해 FileInputStream 객체 생성
            
            fis = new FileInputStream(file);
            
            //BufferedReader 객체로 텍스트 파일을 읽어옴 
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
             // 텍스트파일을 행 단위로 읽어오고, 행의 끝(null)까지 읽어냄.
             // 행 단위로 읽어온 값을 arrayList안에 저장 
            while((line = br.readLine()) != null) {
              
                as.add(line);
                }
            //파일을 읽어오는 과정에서 발생하는 예외들에 대한 출력문 
        } catch (FileNotFoundException ex) {
            System.err.println("파일을 찾을수 없습니다 : " + ex.getMessage());
        } catch (IOException e2) {
            System.err.println("IO 오류가 발생했습니다 : "+e2.getMessage());
        }
    }
    // 이 메소드에 파라미터로 String 파라미터 uId, uPw를 받아서 arrayList안에 존재하는지 확인하는 메소드 
    public int checkUsrIdPw(String uId, String uPw) {
        //LoginFrame에서 사용하기위해 resultCode의 값을 반환 
        int resultcode = -1;
        // ArrayList를 ass라는 변수에 담아 파라미터(uId,uPw)가  arrayList에 존재하는지 확인하는 반복문 
        for(String ass:as) {
            Boolean chckId = ass.contains(uId);
            Boolean chckPw = ass.contains(uPw);
            // uId, uPw 가 동시에 존재하면 로그인 성공 따라서 resultcode값 0 으로 변경 
            if(chckId == true && chckPw == true) {
                resultcode = 0;
                // 추가로 M 이라는 문자열이 있으면 resultcode값 1으로 변경 
                if(ass.contains("M")) {
                    resultcode = 1;

                }
                break;
            } 
        }
        return resultcode;
    }
    
}

package deu.hms.reservation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import deu.hms.reservation.BookingInfo;

/**
 *
 * @author Hyunwoo
 */
public class FileManagement {
    
    private ArrayList<String> readBookingInfo = new ArrayList<>();
    private ArrayList<BookingInfo> bookingInfo = new ArrayList<>();
    
    public void readBookingFileData(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            while ((line = br.readLine()) != null) {
                readBookingInfo.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("파일이 존재하지않습니다. 경로를 확인해주세요");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void splitBookingFileData() {
        String line;

        for (int i = 0; i < readBookingInfo.size(); i++) {
            
            line = readBookingInfo.get(i);
            String[] str = line.split("\t");
            bookingInfo.add(new BookingInfo(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10], str[11]));
        }
    }
    
    public ArrayList<BookingInfo> returnBookingInfo() throws IOException {
        return bookingInfo;
    }
}
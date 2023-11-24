package deu.hms.reservation;

import deu.hms.manageinfo.HotelStatsJFrame;
import javax.swing.JOptionPane;
import deu.hms.reservation.ReservationManagementJFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author Hyunwoo
 */
public class Validation {
    private ReservationManagementJFrame reservationManager = new ReservationManagementJFrame();
    private HotelStatsJFrame statsManager = new HotelStatsJFrame();
    private final Date today = new Date();
    
    public Validation(ReservationManagementJFrame reservationManager) {
        this.reservationManager = reservationManager;
    }
    
    public boolean isCalcCostOfStayingButtonAvailable() {
        
        if (!isDateChosen()) {

            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "날짜를 모두 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isDateValidated()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "체크아웃이 체크인보다 느려야 합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isCheckInAfterToday()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "예약은 내일 날짜부터 가능합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isNumberOfGeustsChosen()) {

            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "인원수를 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isRoomNumberFilled() || !isRoomNumberExists()) {

            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "올바른 방 번호를 입력하십시오.\n숫자만 입력 가능합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isRoomAvailable()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "사용할 수 없는 방입니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }
    
    public boolean isRegistrable() {

        if (!isNameFilled()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "이름을 입력하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isPhoneFilled()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "휴대폰 번호를 확인하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isAddressFilled()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "주소를 입력하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isDateChosen()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "날짜를 모두 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isNumberOfGeustsChosen()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "인원수를 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isRoomNumberFilled() || !isRoomNumberExists()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "올바른 방 번호를 입력하십시오.\n숫자만 입력 가능합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isRoomAvailable()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "사용할 수 없는 방입니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isPaymentMethodChecked()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "결제 수단을 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private boolean isNameFilled() {

        return reservationManager.getLastName().length() > 0 && reservationManager.getFirstName().length() > 0 &&
                !(reservationManager.getThisName().equals("성이름"));
    }
    
    private boolean isPhoneFilled() {
        
        return reservationManager.getDefaultPhone().equals("010") && 
                reservationManager.getSecondPhone().length() == 4 &&
                reservationManager.getThirdPhone().length() == 4;
    }
    
    private boolean isAddressFilled() {
        
        return reservationManager.getZipNo().length() > 0;
    }
    
    private boolean isDateChosen() {
        
        return reservationManager.getCheckInDate().length() > 0 && reservationManager.getCheckOutDate().length() > 0;
    }
    
    private boolean isDateValidated() {
        
        String[] inputCheckInDateArray = statsManager.splitDateByDash(reservationManager.getCheckInDate());
        String[] inputCheckOutDateArray = statsManager.splitDateByDash(reservationManager.getCheckOutDate());
        Date inputCheckInDate = new Date(Integer.parseInt(inputCheckInDateArray[0]) - 1900, 
                                    Integer.parseInt(inputCheckInDateArray[1]) - 1, 
                                    Integer.parseInt(inputCheckInDateArray[2]));
        Date inputCheckOutDate = new Date(Integer.parseInt(inputCheckOutDateArray[0]) - 1900, 
                                    Integer.parseInt(inputCheckOutDateArray[1]) - 1, 
                                    Integer.parseInt(inputCheckOutDateArray[2]));
        
        return inputCheckInDate.before(inputCheckOutDate);
    }
    
    private boolean isCheckInAfterToday() {
        
        String[] inputCheckInDateArray = statsManager.splitDateByDash(reservationManager.getCheckInDate());
        Date inputCheckInDate = new Date(Integer.parseInt(inputCheckInDateArray[0]) - 1900, 
                                    Integer.parseInt(inputCheckInDateArray[1]) - 1, 
                                    Integer.parseInt(inputCheckInDateArray[2]));
        
        return inputCheckInDate.after(today);
    }
    
    private boolean isNumberOfGeustsChosen() {
        
        return reservationManager.getNumberOfGuests() > 0;
    }
    
    private boolean isRoomNumberFilled() {
        
        return Pattern.matches("^[0-9]*$", reservationManager.getRoomNumber());
    }
    
    private boolean isRoomNumberExists() {

        return Integer.parseInt(reservationManager.getRoomNumber()) > 0 &&
            Integer.parseInt(reservationManager.getRoomNumber()) < 1011 &&
            Integer.parseInt(reservationManager.getRoomNumber()) % 100 > 0 && 
            Integer.parseInt(reservationManager.getRoomNumber()) % 100 < 11;
    }
    
    private boolean isPaymentMethodChecked() {
        
        return reservationManager.getPaymentMethod().length() > 0;
    }
    
    public boolean isUpdateCalcCostOfStayingButtonAvailable() {
        
        if (!isUpdateDateChosen()) {

            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "날짜를 모두 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isUpdateDateValidated()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "체크아웃이 체크인보다 느려야 합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isUpdateCheckInAfterToday()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "예약은 내일 날짜부터 가능합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isUpdateNumberOfGeustsChosen()) {

            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "인원수를 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isUpdateRoomNumberFilled() || !isUpdateRoomNumberExists()) {

            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "올바른 방 번호를 입력하십시오.\n숫자만 입력 가능합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isUpdateRoomAvailable()) {
            
            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "사용할 수 없는 방입니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }
    
    public boolean isUpdateRegistrable() {

        if (!isUpdateNameFilled()) {
            
            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "이름을 입력하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isUpdatePhoneFilled()) {
            
            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "휴대폰 번호를 확인하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isUpdateDateChosen()) {
            
            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "날짜를 모두 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        

        if (!isUpdateNumberOfGeustsChosen()) {
            
            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "인원수를 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isUpdateRoomNumberFilled() || !isUpdateRoomNumberExists()) {
            
            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "올바른 방 번호를 입력하십시오.\n숫자만 입력 가능합니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isUpdateRoomAvailable()) {
            
            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "사용할 수 없는 방입니다.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!isUpdatePaymentMethodChecked()) {
            
            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "결제 수단을 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private boolean isUpdateNameFilled() {

        return reservationManager.getUpdateLastName().length() > 0 && reservationManager.getUpdateFirstName().length() > 0 &&
                !(reservationManager.getUpdateThisName().equals("성이름"));
    }
    
    private boolean isUpdatePhoneFilled() {
        
        return reservationManager.getUpdateDefaultPhone().equals("010") && 
                reservationManager.getUpdateSecondPhone().length() == 4 &&
                reservationManager.getUpdateThirdPhone().length() == 4;
    }
    
    private boolean isUpdateDateChosen() {
        
        return reservationManager.getUpdateCheckInDate().length() > 0 && reservationManager.getUpdateCheckOutDate().length() > 0;
    }
    
    private boolean isUpdateDateValidated() {
        
        String[] updateCheckInDateArray = statsManager.splitDateByDash(reservationManager.getUpdateCheckInDate());
        String[] updateCheckOutDateArray = statsManager.splitDateByDash(reservationManager.getUpdateCheckOutDate());
        Date updateCheckInDate = new Date(Integer.parseInt(updateCheckInDateArray[0]) - 1900, 
                                    Integer.parseInt(updateCheckInDateArray[1]) - 1, 
                                    Integer.parseInt(updateCheckInDateArray[2]));
        Date updateCheckOutDate = new Date(Integer.parseInt(updateCheckOutDateArray[0]) - 1900, 
                                    Integer.parseInt(updateCheckOutDateArray[1]) - 1, 
                                    Integer.parseInt(updateCheckOutDateArray[2]));
        
        return updateCheckInDate.before(updateCheckOutDate);
    }
    
    private boolean isUpdateCheckInAfterToday() {
        
        String[] updateCheckInDateArray = statsManager.splitDateByDash(reservationManager.getUpdateCheckInDate());
        Date updateCheckInDate = new Date(Integer.parseInt(updateCheckInDateArray[0]) - 1900, 
                                    Integer.parseInt(updateCheckInDateArray[1]) - 1, 
                                    Integer.parseInt(updateCheckInDateArray[2]));
        
        return updateCheckInDate.after(today);
    }
    
    private boolean isUpdateNumberOfGeustsChosen() {
        
        return reservationManager.getUpdateNumberOfGuests() > 0;
    }
    
    private boolean isUpdateRoomNumberFilled() {
        
        return Pattern.matches("^[0-9]*$", reservationManager.getUpdateRoomNumber());
    }
    
    private boolean isUpdateRoomNumberExists() {
        
        return Integer.parseInt(reservationManager.getUpdateRoomNumber()) > 0 &&
                Integer.parseInt(reservationManager.getUpdateRoomNumber()) < 1100 &&
                Integer.parseInt(reservationManager.getUpdateRoomNumber()) % 100 > 0 && 
                Integer.parseInt(reservationManager.getUpdateRoomNumber()) % 100 < 11;
    }
    
    private boolean isUpdatePaymentMethodChecked() {
        
        return reservationManager.getUpdatePaymentMethod().length() > 0;
    }
    
    private boolean isRoomAvailable() {

        String[] inputCheckInDateArray = statsManager.splitDateByDash(reservationManager.getCheckInDate());
        String[] inputCheckOutDateArray = statsManager.splitDateByDash(reservationManager.getCheckOutDate());
        String[] loadCheckInDateArray;
        String[] loadCheckOutDateArray;

        Date inputCheckInDate = new Date(Integer.parseInt(inputCheckInDateArray[0]) - 1900,
                                        Integer.parseInt(inputCheckInDateArray[1]) - 1,
                                        Integer.parseInt(inputCheckInDateArray[2]));
        Date inputCheckOutDate = new Date(Integer.parseInt(inputCheckOutDateArray[0]) - 1900,
                                        Integer.parseInt(inputCheckOutDateArray[1]) - 1,
                                        Integer.parseInt(inputCheckOutDateArray[2]));
        Date loadCheckInDate;
        Date loadCheckOutDate;

        ArrayList<BookingInfo> bookingInfo;
        try {
            FileManagement fileMgmt = new FileManagement();
            fileMgmt.readBookingFileData(reservationManager.getFilePath());
            fileMgmt.splitBookingFileData();
            bookingInfo = fileMgmt.returnBookingInfo();

            for (int i = 0; i < bookingInfo.size(); ++i) {

                loadCheckInDateArray = statsManager.splitDateByDash(bookingInfo.get(i).getCheckInDate());
                loadCheckOutDateArray = statsManager.splitDateByDash(bookingInfo.get(i).getCheckOutDate());
                loadCheckInDate = new Date(Integer.parseInt(loadCheckInDateArray[0]) - 1900,
                                            Integer.parseInt(loadCheckInDateArray[1]) - 1,
                                            Integer.parseInt(loadCheckInDateArray[2]));
                loadCheckOutDate = new Date(Integer.parseInt(loadCheckOutDateArray[0]) - 1900,
                                            Integer.parseInt(loadCheckOutDateArray[1]) - 1,
                                            Integer.parseInt(loadCheckOutDateArray[2]));

                boolean isIncludeCase1 = inputCheckOutDate.after(loadCheckInDate) &&
                                            inputCheckOutDate.before(loadCheckOutDate);
                boolean isIncludeCase2 = inputCheckInDate.before(loadCheckOutDate) &&
                                            inputCheckInDate.after(loadCheckInDate);
                boolean isIncludeCase3 = inputCheckInDate.after(loadCheckInDate) &&
                                            inputCheckOutDate.before(loadCheckOutDate);

                if (!(inputCheckOutDate.before(loadCheckInDate) || inputCheckInDate.after(loadCheckOutDate))) { // 예약하려는 기간에
                    if (bookingInfo.get(i).getRoomNumber().equals(reservationManager.getRoomNumber())) { // 이미 예약된 방이라면
                        
                        return false;
                    }
                }
            }
        } catch (IOException e) {
        }

        return true;
    }
    
        private boolean isUpdateRoomAvailable() {

        String[] updateCheckInDateArray = statsManager.splitDateByDash(reservationManager.getUpdateCheckInDate());
        String[] updateCheckOutDateArray = statsManager.splitDateByDash(reservationManager.getUpdateCheckOutDate());
        String[] loadCheckInDateArray = new String[3];
        String[] loadCheckOutDateArray = new String[3];

        Date updateCheckInDate = new Date(Integer.parseInt(updateCheckInDateArray[0]) - 1900,
                                            Integer.parseInt(updateCheckInDateArray[1]) - 1,
                                            Integer.parseInt(updateCheckInDateArray[2]));
        Date updateCheckOutDate = new Date(Integer.parseInt(updateCheckOutDateArray[0]) - 1900,
                                            Integer.parseInt(updateCheckOutDateArray[1]) - 1,
                                            Integer.parseInt(updateCheckOutDateArray[2]));
        Date loadCheckInDate;
        Date loadCheckOutDate;

        ArrayList<BookingInfo> bookingInfo;
        try {
            FileManagement fileMgmt = new FileManagement();
            fileMgmt.readBookingFileData(reservationManager.getFilePath());
            fileMgmt.splitBookingFileData();
            bookingInfo = fileMgmt.returnBookingInfo();

            for (int i = 0; i < bookingInfo.size(); ++i) {

                loadCheckInDateArray = statsManager.splitDateByDash(bookingInfo.get(i).getCheckInDate());
                loadCheckOutDateArray = statsManager.splitDateByDash(bookingInfo.get(i).getCheckOutDate());
                loadCheckInDate = new Date(Integer.parseInt(loadCheckInDateArray[0]) - 1900,
                                            Integer.parseInt(loadCheckInDateArray[1]) - 1,
                                            Integer.parseInt(loadCheckInDateArray[2]));
                loadCheckOutDate = new Date(Integer.parseInt(loadCheckOutDateArray[0]) - 1900,
                                            Integer.parseInt(loadCheckOutDateArray[1]) - 1,
                                            Integer.parseInt(loadCheckOutDateArray[2]));

                if (!(updateCheckOutDate.before(loadCheckInDate) || updateCheckInDate.after(loadCheckOutDate))) { // 예약하려는 기간에
                    if (bookingInfo.get(i).getRoomNumber().equals(reservationManager.getUpdateRoomNumber())) { // 이미 예약된 방이라면

                        return false;
                    }
                }
            }
        } catch (IOException e) {
        }

        return true;
    }
}
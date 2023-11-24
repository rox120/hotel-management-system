package deu.hms.reservation;

import deu.hms.manageinfo.HotelStatsJFrame;
import javax.swing.JOptionPane;
import deu.hms.reservation.ReservationManagementJFrame;
import java.util.regex.Pattern;

/**
 *
 * @author Hyunwoo
 */
public class Validation {
    private ReservationManagementJFrame reservationManager = new ReservationManagementJFrame();
    private HotelStatsJFrame statsManager = new HotelStatsJFrame();
    
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
        
        return statsManager.calcDateValue(reservationManager.getCheckInDate()) < statsManager.calcDateValue(reservationManager.getCheckOutDate());
    }
    
    private boolean isCheckInAfterToday() {
        
        return statsManager.calcDateValue(reservationManager.getCheckInDate()) > statsManager.calcTodaysValue();
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
        
        return statsManager.calcDateValue(reservationManager.getUpdateCheckInDate()) < statsManager.calcDateValue(reservationManager.getUpdateCheckOutDate());
    }
    
    private boolean isUpdateCheckInAfterToday() {
        
        return statsManager.calcDateValue(reservationManager.getUpdateCheckInDate()) > statsManager.calcTodaysValue();
    }
    
    private boolean isUpdateNumberOfGeustsChosen() {
        
        return reservationManager.getUpdateNumberOfGuests() > 0;
    }
    
    private boolean isUpdateRoomNumberFilled() {
        
        return Pattern.matches("^[0-9]*$", reservationManager.getUpdateRoomNumber());
    }
    
    private boolean isUpdatePaymentMethodChecked() {
        
        return reservationManager.getUpdatePaymentMethod().length() > 0;
    }
    

    private boolean isUpdateRoomNumberExists() {
        
        return Integer.parseInt(reservationManager.getUpdateRoomNumber()) > 0 &&
                Integer.parseInt(reservationManager.getUpdateRoomNumber()) < 1100 &&
                Integer.parseInt(reservationManager.getUpdateRoomNumber()) % 100 > 0 && 
                Integer.parseInt(reservationManager.getUpdateRoomNumber()) % 100 < 11;
    }
}
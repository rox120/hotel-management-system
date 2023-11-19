package deu.hms.reservation;

import javax.swing.JOptionPane;
import deu.hms.reservation.ReservationManagementJFrame;

/**
 *
 * @author Hyunwoo
 */
public class Validation {
    private ReservationManagementJFrame reservationManager = new ReservationManagementJFrame();
    
    public Validation(ReservationManagementJFrame reservationManager) {
        this.reservationManager = reservationManager;
    }
    
    public boolean isCalcCostOfStayingButtonAvailable() {
        
        if (!isDateChosen()) {

            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "날짜를 모두 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isNumberOfGeustsChosen()) {

            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "인원수를 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isRoomNumberFilled()) {

            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "호실을 입력하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
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
        
        if (!isRoomNumberFilled()) {
            
            JOptionPane.showMessageDialog(reservationManager.getRegistDialog(), "호실을 입력하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
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
    
    private boolean isNumberOfGeustsChosen() {
        
        return reservationManager.getNumberOfGuests() > 0;
    }
    
    private boolean isRoomNumberFilled() {
        
        return reservationManager.getRoomNumber().length() > 0;
    }
    
    public boolean isUpdateCalcCostOfStayingButtonAvailable() {
        
        if (!isUpdateDateChosen()) {

            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "날짜를 모두 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isUpdateNumberOfGeustsChosen()) {

            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "인원수를 선택하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!isUpdateRoomNumberFilled()) {

            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "호실을 입력하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
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
        
        if (!isUpdateRoomNumberFilled()) {
            
            JOptionPane.showMessageDialog(reservationManager.getUpdateDialog(), "호실을 입력하십시오.", "경고", JOptionPane.WARNING_MESSAGE);
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
    
    private boolean isUpdateNumberOfGeustsChosen() {
        
        return reservationManager.getUpdateNumberOfGuests() > 0;
    }
    
    private boolean isUpdateRoomNumberFilled() {
        
        return reservationManager.getUpdateRoomNumber().length() > 0;
    }
}
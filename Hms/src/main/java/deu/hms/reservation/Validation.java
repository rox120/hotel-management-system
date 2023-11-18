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
}
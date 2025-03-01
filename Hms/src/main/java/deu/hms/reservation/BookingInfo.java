package deu.hms.reservation;

/**
 *
 * @author Hyumwoo
 */
public class BookingInfo {
    
    private String index;
    private String name;
    private String phone;
    private String zipNo;
    private String address;
    private String checkInDate;
    private String checkOutDate;
    private String numberOfGuests;
    private String roomNumber;
    private String costOfStaying;
    private String paymentMethod;
    private String checkInStatus;
    
    public BookingInfo (String index, String name, String phoneNumber, String zipNo, String address, String checkInDate, String checkOutDate, String numberOfGuests, String roomNumber, String costOfStaying, String paymentMethod, String checkInStatus) {
        
        this.index = index;
        this.name = name;
        this.phone = phoneNumber;
        this.zipNo = zipNo;
        this.address = address;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
        this.roomNumber = roomNumber;
        this.costOfStaying = costOfStaying;
        this.paymentMethod = paymentMethod;
        this.checkInStatus = checkInStatus;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipNo() {
        return zipNo;
    }

    public String getAddress() {
        return address;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public String getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCostOfStaying() {
        return costOfStaying;
    }
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public String getCheckInStatus() {
        return checkInStatus;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setZipNo(String zipNo) {
        this.zipNo = zipNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setNumberOfGuests(String numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCostOfStaying(String costOfStaying) {
        this.costOfStaying = costOfStaying;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public void setCheckInStatus(String checkInStatus) {
        this.checkInStatus = checkInStatus;
    }
}
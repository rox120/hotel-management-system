/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.manageinfo.hotelaccounts;

/**
 *
 * @author bennyjung
 */
public class ModifyAccounts {
    private String accsNumb;
    private String accsId;
    private String accsPw;
    private String accsAuth;
    
    public ModifyAccounts(String accsNumb,String accsId, String accsPw, String accsAuth){
        this.accsNumb = accsNumb;
        this.accsId = accsId;
        this.accsPw = accsPw;
        this.accsAuth = accsAuth;
    }

    public String getAccsNumb() {
        return accsNumb;
    }

    public String getAccsId() {
        return accsId;
    }

    public String getAccsPw() {
        return accsPw;
    }

    public String getAccsAuth() {
        return accsAuth;
    }
    
    
    
    
}

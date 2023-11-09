/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.hms.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author bennyjung
 */
public class MySqlLink {
    
    private Connection con;
    private PreparedStatement pat;
    private ResultSet rs;
    private String localurl = "jdbc:mysql://localhost:3306/Hms";
    
    /**
     *
     */
    public MySqlLink() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = DriverManager.getConnection(localurl,"root","0000");
                
                System.out.println(con);
                System.out.println("Successfully Connect SqlServer! ");
                
            //Sql exception 
            } catch (SQLException ex) {
                Logger.getLogger(MySqlLink.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Fail to Connect SqlServer! ");
            }
        // Class exception
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlLink.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    // Check user ID, PW in database
    public int LoginQuery(String u_id, String u_pw) {
        int queryNumb = 0;
        try{
            // sql query statement for use ID,PW
            pat = con.prepareStatement("select * from User where ID = ? and PW = ?");
            // 1, uid => ID In(u_id) | 2, u_pw => PW ON(u_pw)
            pat.setString(1,u_id); 
            pat.setString(2,u_pw);
            
            // query result assign 'rs'
            rs = pat.executeQuery();
            
            if(rs.next()) {
                System.out.println("User Data exist");
                boolean master = rs.getBoolean("is_master");
                
                // check the master account
                if(master == true) {
                    queryNumb = 1;
                } else {
                    queryNumb = 2;
                }
                
            
            } else {
                System.out.println("User Data can't find! ");
                queryNumb = 0;
            }
            con.close();
        
        } catch  (SQLException e){
            System.out.println("error occur!"+e.getMessage());
        
        }
        System.out.println(queryNumb);
        return queryNumb;
    }
    
    
}

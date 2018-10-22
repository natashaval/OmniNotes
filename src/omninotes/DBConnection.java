/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omninotes;
import java.sql.*;  
/**
 *
 * @author adis
 */
public class DBConnection {
    private Connection con = null;
    public DBConnection(){

    }
    
    //opens a new connecting to DB
    public Connection newConnection(){        
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/omninotes","root","");                                                 
        }
        catch(Exception e){ 
            System.out.println(e);
        }  
        System.out.println("DB connected--1");
        return con; //returnn connection obj
    }  
    
    public boolean closeConnection(){
        try{
         this.con.close();   
        }catch(Exception e){
            System.out.println(e);
        }        
        return true;
    }
}


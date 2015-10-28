/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project1;
import java.sql.*;

public class connection{
    Connection Conn;
  
    public connection() throws ClassNotFoundException, SQLException{
    String JDBC_DRIVER= "com.mysql.jdbc.Driver";
    String DB_URL= "jdbc:mysql://199.83.103.133:8080/process?zeroDateTimeBehavior=convertToNull";
    Class.forName(JDBC_DRIVER);
    Conn = DriverManager.getConnection(DB_URL, "shibani", "shibani");
    
    
    }
    
}

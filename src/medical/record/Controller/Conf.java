/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.record.Controller;

/**
 *
 * @author zetsuen
 */
import java.sql.*;

public class Conf {
    private static Connection conn;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_NAME = "db_rekam_medis";
    private static final String DB_URL = "jdbc:mysql://localhost/"+DB_NAME+"?serverTimezone=UTC";
    private static final String DB_UNAME = "root";
    private static final String DB_PASS = "";   
    
    public static Connection databaseConnected(){
            if(conn == null){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection(DB_URL,DB_UNAME,DB_PASS);           
                }catch(ClassNotFoundException e){
                    System.err.format("Class not found");
                }catch(SQLException e){
                    System.err.format("SQL State: " +e.getSQLState(),e.getMessage());
                }catch(Exception e){
                e.printStackTrace();
            }
        }
        return conn;
    }

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

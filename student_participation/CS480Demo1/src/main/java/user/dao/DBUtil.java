

package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {

     public static final String DB_URL = "jdbc:mysql://localhost:3306/student";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Nani12392";
    public static Connection connection;
    
    
    static {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception ex){ex.printStackTrace();};
    }
    
    public static Connection getConnection()throws SQLException{
        if(connection==null || connection.isClosed()){
            connection=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
        }
        return connection;
    }
    
}

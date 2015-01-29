/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseUtilities;

import java.sql.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.sql.Timestamp;

/**
 *
 * @author dbennett3
 */
public class DatabaseExporter {
    
    /**
     *     NNNNNEEEEEEDDDD CCOOMMMMMMEEEENNNNNTTTTTSSSSS
     */
    public static void exportDatabase(String tableName) throws ClassNotFoundException, SQLException {
        String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
        String clientDriverName = "org.apache.derby.jdbc.ClientDriver";
        String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;create=true";
        Connection connection = null;
        
        //Check for DB drivers
        try {
            Class.forName(clientDriverName);
            Class.forName(driverName);
        }catch(java.lang.ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Can't load JavaDb ClientDriver");
            throw e;
        }
        
        //try to connect
        try {
            connection = DriverManager.getConnection(databaseConnectionName);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Loaded JavaDB ClientDriver, something else wrong");
            throw e;
        }
        
        try {
            exportTable(connection, tableName);
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Couldn't export table");
            System.out.println(e);
            e.printStackTrace();
            throw e;
        }
    }
    
    private static void exportTable(Connection connect, String name) throws SQLException {
        //Calendar calendar = Calendar.getInstance();
        //Date now = calendar.getTime();
        //Timestamp timestamp = new Timestamp(now.getTime());
        name = name.toUpperCase();
        
        String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        System.out.println(name + " " + timestamp);
        String fileName = "C:\\ExportedTables\\output_" + name + "_" + timestamp + ".csv";
        
        PreparedStatement ps = connect.prepareStatement(
                "CALL SYSCS_UTIL.SYSCS_EXPORT_TABLE (?,?,?,?,?,?)");
        ps.setString(1, null);
        ps.setString(2, name);
        ps.setString(3, fileName);
        ps.setString(4, null);
        ps.setString(5, null);
        ps.setString(6, null);   
        ps.execute();
    } 

    
}

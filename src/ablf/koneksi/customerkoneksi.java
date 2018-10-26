/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ablf.koneksi;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import ablf.service.CustomerDao;
import ablf.service.impl.customerDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Penghuni Warnet
 */
public class customerkoneksi {
    private static Connection connection;
    private static CustomerDao anggotaDao;
    
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/perpusmvc");
            dataSource.setUser("root");
            dataSource.setPassword("");
            
            connection = dataSource.getConnection();
        }
        return connection;
    }
    
    public static CustomerDao getAnggotaDao() throws SQLException {
        if (anggotaDao == null) {
            anggotaDao = new customerDaoImpl(getConnection());
        }
        return anggotaDao;
    }
}

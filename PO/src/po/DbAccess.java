package po;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author CJay
 */


public class DbAccess {
    Connection conn;
    
    public void DbAccess() throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/BAZA_PRODUKTOW";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","postgres");
        props.setProperty("ssl","false");
        conn = DriverManager.getConnection(url, props);
    }
    
    public void SzukajN(String nazwa) throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs;
        
        rs = stmt.executeQuery("SELECT * FROM produkt WHERE nazwa LIKE '"+ nazwa +"'");
        
        while ( rs.next() ) {
            String produkt = rs.getString("id_produktu");
            String produkt1 = rs.getString("nazwa");
            String produkt2 = rs.getString("cena");
            
            System.out.println(produkt + " " + produkt1 + " " + produkt2);
        }
    }
    
    public void SzukajC(double cena) throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs;
        
        rs = stmt.executeQuery("SELECT * FROM produkt WHERE cena ="+ cena +"");
        
        while ( rs.next() ) {
            String produkt = rs.getString("id_produktu");
            String produkt1 = rs.getString("nazwa");
            String produkt2 = rs.getString("cena");
            
            System.out.println(produkt + " " + produkt1 + " " + produkt2);
        }
    }
}

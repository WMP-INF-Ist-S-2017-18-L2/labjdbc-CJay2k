package po;

import java.sql.SQLException;


/**
 * @author CJay
 */
public class PO {
    public static void main(String[] args) throws SQLException {
        DbAccess baza = new DbAccess();
        
        baza.DbAccess();
        baza.SzukajN("banan");
        baza.SzukajC(10);
    }
}

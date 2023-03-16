package test;

import org.junit.Assert;
import org.junit.Test;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C02 {

    // yazili not ortalamasinin 90 dan kucuk oldugunu test edin


    @Test
    public void test01() throws SQLException {

        String hostname = "localhost";
        String dbisim = "databasetesting";
        String username = "postgres";
        String password = "123135";

        DBUtils.connectionOlustur(hostname, dbisim, username, password);

        Statement st = DBUtils.statementOlustur();

        String query = "select avg(yazili_notu) from ogrenciler;";

        ResultSet rs = st.executeQuery(query);
        rs.next();

        double ort= rs.getDouble(1);
        System.out.println(ort);

        Assert.assertTrue(ort<90);
        DBUtils.connectionStatementKapat();

    }
}

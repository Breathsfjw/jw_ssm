package cn.ovea_y.oracle;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    @Test
    public void fun() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/ORCL","C##SSM","123456");
        System.out.println(connection);
    }
}

package Facade;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class DBFacadeTest {
    Connection con = null;

    @BeforeEach
    void setUp() {
        System.out.println("TESTINNNNGGGG");

        try {
            con = DBconnector.connection();
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            con.prepareStatement("DELETE FROM `startcode_test`.`usertable`").executeUpdate();

            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Hans");
            ps.setString(2, "Hansen");
            ps.setString(3, "Hemmelig123");
            ps.setString(4, "40404040");
            ps.setString(5, "Rolighedsvej 3");
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @AfterEach
    void tearDown() {

    }

    @Test
    public void test() throws SQLException {
        System.out.println("Testing database connection... ");
        String sql = "SELECT * FROM startcode_test.usertable";
        try (ResultSet set = con.prepareStatement(sql).executeQuery()) {
            set.next();
            String name = set.getString("fname");
            assertEquals("Hans", name);

        }
    }

    @Test
    public void testshowdetail() throws SQLException {
        System.out.println("Testing database connection... showing phone... ");
        String sql = "SELECT * FROM startcode_test.usertable";
        try (ResultSet set = con.prepareStatement(sql).executeQuery()) {
            set.next();
            String phone = set.getString("phone");
            assertEquals("40404040", phone);


        }
    }

    @Test
    public void testalldetails() throws SQLException{
        System.out.println("Testing database connection... showing specific details... ");
        User user = null;
        String SQL = "SELECT * FROM startcode_test.usertable where fname = 'Hans'";
        try (ResultSet set = con.prepareStatement(SQL).executeQuery()){
            set.next();
            String name = set.getString("fname");
            String address = set.getString("address");
            String phone = set.getString("phone");
            User actualinfo = new User(name,address,phone);
            User expectedinfo = new User("Hans","Rolighedsvej 3","40404040");

            assertEquals(expectedinfo,actualinfo);

        }


}
}

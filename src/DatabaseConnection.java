
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    static Connection c = null;
    static Statement stmt = null;
    static String sql = null;

    public static void main(String args[]) {

        try {
            c = DriverManager.getConnection("jdbc:postgresql://localhost/Boeing?currentSchema=OneBoeing",
                    "postgres", "Northeast10");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            DatabaseConnection t = new DatabaseConnection();
            /*t.insert();
            t.delete();
            t.update();
            t.alter();*/
            t.selectQuery();
            c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    void insert() throws SQLException {
        sql = "INSERT INTO  " + " \"OneBoeing\".\"Contact\" (\"FirstName\",\"LastName\",email,id) "
                + "VALUES ('Peter','Godmann','peter@gmail.com',900);";
        stmt.executeUpdate(sql);
    }

    void delete() throws SQLException {
        //Delete Record
        sql = "DELETE from \"OneBoeing\".\"Contact\" where ID = 900;";
        stmt.executeUpdate(sql);
    }

    void update() throws SQLException {
        sql = "UPDATE \"OneBoeing\".\"Contact\" set \"LastName\" = 'Vadthya' where ID=100;";
        stmt.executeUpdate(sql);

    }

    void alter() throws SQLException {
         /*   sql = "ALTER TABLE \"OneBoeing\".\"Contact\"" +
                    "            DROP COLUMN \"phonenumber\";";
            stmt.executeUpdate(sql);*/

    }

    void selectQuery() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM  \"OneBoeing\".\"Contact\" ORDER BY ID ;");
        System.out.println("Records from Table Contacts");
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstname = rs.getString("FirstName");
            String lastname = rs.getString("LastName");
            System.out.print(" ID = " + id);
            System.out.println(" | FirstName = " + firstname + "  Lastname = " + lastname);

        }
        rs.close();
    }
}


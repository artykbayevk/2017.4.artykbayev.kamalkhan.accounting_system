package kz.sdu.register.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresChecker {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/testdb",
                            "patrick", "qwerty12");
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM test_users;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                String  surname = rs.getString("surname");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "ADDRESS = " + surname );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");


    }
}

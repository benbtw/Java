import java.sql.*;
public class bank_sql {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    public void create_connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_accounts", "root", "password");
            /*ResultSet rs = stmt.executeQuery("select * from accounts;");
            while(rs.next()) {
                String name = rs.getString(1);
                System.out.println(name); // prints all in column one, so only usernames
            }*/
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            System.out.println("class for name error");
        } catch (SQLException ex) {
            System.out.println("database connection failed");
        }
    }

    public boolean exec_cursor(String query) {
        boolean valid = false;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            valid = rs.isBeforeFirst();
        } catch (SQLException ex) {
            System.out.println("cursor error");
        }
        return valid;
    }

    public void add_new_info(String query) {
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException ex) {
            System.out.println("insert error");
        }
    }

    public double get_balance(double balance, String account, String user) {
        try {
            ResultSet rs;
            rs = stmt.executeQuery("select " + account + " from accounts where username = '" + user + "';");
            if(rs.next()){
                balance = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            System.out.println("error getting balance");
        }

        return balance;
    }
}

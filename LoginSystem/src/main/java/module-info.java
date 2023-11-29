module com.loginsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.loginsystem to javafx.fxml;
    exports com.loginsystem;
}
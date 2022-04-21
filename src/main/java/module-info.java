module com.example.bank_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.bank_system to javafx.fxml;
    exports com.example.bank_system;
}
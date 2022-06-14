module com.example.tvstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tvstore to javafx.fxml;
    exports com.example.tvstore;
}
module com.example.project5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project5 to javafx.fxml;
    exports com.example.project5;
}
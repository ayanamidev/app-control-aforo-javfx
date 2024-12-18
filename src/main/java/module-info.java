module com.example.examendilaura {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.examendilaura to javafx.fxml;
    exports com.example.examendilaura;
}
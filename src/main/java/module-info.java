module com.example.scrabblepointsgenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scrabblepointsgenerator to javafx.fxml;
    exports com.example.scrabblepointsgenerator;
}
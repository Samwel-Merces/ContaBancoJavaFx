module com.samuel {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.samuel to javafx.fxml;
    exports com.samuel;
}

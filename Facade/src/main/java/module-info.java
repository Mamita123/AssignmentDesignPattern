module org.example.facade {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires android.json;


    opens org.example.facade to javafx.fxml;
    exports org.example.facade;
}
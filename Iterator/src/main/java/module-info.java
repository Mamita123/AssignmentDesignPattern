module org.example.iterator {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.iterator to javafx.fxml;
    exports org.example.iterator;
}
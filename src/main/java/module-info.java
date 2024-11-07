module org.example.cryptoanalyzer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.cryptoanalyzer to javafx.fxml;
    exports org.example.cryptoanalyzer;
}
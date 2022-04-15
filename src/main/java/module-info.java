module com.example.javafx_tirgol2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafx_tirgol2 to javafx.fxml;
    exports com.example.javafx_tirgol2;
}
module org.example.efficiencyapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens org.example.efficiencyapp to javafx.fxml;
    exports org.example.efficiencyapp;
}
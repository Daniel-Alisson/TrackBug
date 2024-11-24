module com.sistema.trackbug {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.sistema.trackbug to javafx.fxml;
    exports com.sistema.trackbug;
    exports com.sistema.trackbug.controllers;
    opens com.sistema.trackbug.controllers to javafx.fxml;
}
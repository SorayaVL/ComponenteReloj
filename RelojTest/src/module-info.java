module RelojTest {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.base;
    requires ComponenteReloj;
    requires javafx.controls;
    exports com.soraya.test;
    exports com.soraya.test.fxml;
    opens com.soraya.test.fxml;
}
module RelojTest {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.base;
    requires ComponenteReloj;
    exports com.soraya.test;
    exports com.soraya.test.fxml;
    opens com.soraya.test.fxml;
}
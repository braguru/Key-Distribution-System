module key {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.base;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	opens kds to javafx.graphics, javafx.fxml, javafx.base;
	opens skp to javafx.graphics, javafx.fxml, javafx.base;
}

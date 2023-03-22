package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyApp extends Application {
	
	@Override
	public void start(Stage stage) {
		var tField = new TextField();
		var tArea = new TextArea();
		
		tField.setOnAction(e -> {
			tArea.appendText(tField.getText());
			tField.clear();
		});

		var vBox = new VBox();
		vBox.getChildren().add(tField);
		vBox.getChildren().add(tArea);

		var scene = new Scene(vBox, 320, 200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
package com.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyApp extends Application {
	
	@Override
	public void start(Stage stage) {
		var tField = new TextField();
		var listView = new ListView<String>();
		ObservableList<String> list = listView.getItems();
		
		tField.setOnAction(e -> {
			list.add(tField.getText());
			tField.clear();
		});

		var vBox = new VBox();
		vBox.getChildren().add(tField);
		vBox.getChildren().add(listView);

		var scene = new Scene(vBox, 320, 200);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
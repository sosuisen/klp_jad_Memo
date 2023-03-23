package com.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyApp extends Application {
	private ObservableList<Node> model;

	private void addItem(String txt) {
		model.add(new TextField(txt));
	}

	@Override
	public void start(Stage stage) {
		var tField = new TextField();

		tField.setOnAction(e -> {
			addItem(tField.getText());
			tField.clear();
		});

		Button btn = new Button("コンソールへ出力");
		// ボタンを押すと、リストの内容をコンソールへ出力	
		btn.setOnAction(e -> model.forEach(node -> System.out.println(((TextField) node).getText())));

		// 画面レイアウト用のVBoxとリスト表示用のVBoxは分けておいたほうが便利
		VBox layout = new VBox();
		VBox textFieldList = new VBox();

		// レイアウト
		layout.getChildren().add(tField);
		layout.getChildren().add(btn);
		layout.getChildren().add(textFieldList);

		model = textFieldList.getChildren();

		var scene = new Scene(layout, 320, 500);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
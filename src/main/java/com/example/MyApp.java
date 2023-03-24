package com.example;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyApp extends Application {

	@Override
	public void start(Stage stage) {
		ObservableList<Node> model;
		
		var tField = new TextField();
		Button outputBtn = new Button("コンソールへ出力");
		// 発展課題 4b
		Button removeBtn = new Button("削除");

		// 画面レイアウト用のVBoxとリスト表示用のVBoxは分けておいたほうが便利
		VBox layout = new VBox();
		VBox textFieldList = new VBox();

		// レイアウト
		layout.getChildren().add(tField);
		layout.getChildren().add(outputBtn);
		layout.getChildren().add(removeBtn); // 発展課題 4b
		layout.getChildren().add(textFieldList);

		// 発展課題 4b
		model = textFieldList.getChildren();
		model.addListener((ListChangeListener.Change<? extends Node> c) -> System.out.println("リストが変更されました"));
		// ボタンを押すと、リストの最後尾を削除
		removeBtn.setOnAction(e -> {
			if (model.size() > 0)
				model.remove(model.size() - 1);
		});

		// ボタンを押すと、リストの内容をコンソールへ出力	
		outputBtn.setOnAction(e -> model.forEach(node -> System.out.println(((TextField) node).getText())));

		// ボタンを押すと項目を追加
		tField.setOnAction(e -> {
			model.add(new TextField(tField.getText()));
			tField.clear();
		});

		var scene = new Scene(layout, 320, 500);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
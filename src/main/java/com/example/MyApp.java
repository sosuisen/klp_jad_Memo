package com.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyApp extends Application {

	@Override
	public void start(Stage stage) {
		var tField = new TextField();
		var listView = new ListView<String>();
		ObservableList<String> model = listView.getItems();
		
		// 編集できるようにする
		listView.setEditable(true);
		listView.setCellFactory(TextFieldListCell.forListView());
		listView.setOnEditCommit(e -> {
		    // 編集されたセルの値を取得
		    String newStr = e.getNewValue();
		    // 何番目のセルが編集されたかを取得
		    int index = e.getIndex();
		    // modelのindex番目の値をnewStrに変更する
		    model.set(index, newStr);
		    // 現在のmodelの内容を表示
			model.forEach(str->{
				System.out.println(str);
			});
		});
	
		tField.setOnAction(e -> {
			model.add(tField.getText());
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
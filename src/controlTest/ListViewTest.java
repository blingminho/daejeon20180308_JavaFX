package controlTest;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ListViewTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		ListView<String> list = new ListView<String>();
		Label lb1 = new Label();
		
		// ListView에 나타날 데이터 구성하기
		ObservableList<String> data = FXCollections.observableArrayList(
				"green", "gold", "red", "blue", "black",
				"brown", "blueviolet", "pink", "chocolate"
		);
		
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(list,lb1);
		
		lb1.setFont(Font.font(20));
		list.setItems(data);// ListView에 데이터 셋팅하기
		
		// ListView에서 값이 선택되었을 때 처리
		list.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<String>() {
					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						
						lb1.setText(newValue);// Label에 선택한 내용 출력
						lb1.setTextFill(Color.web(newValue));// Label의 글자색 변경
					}
					
				}
		);
		
		
		Scene scene = new Scene(vbox);
		primaryStage.setTitle("ListView연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package controlTest;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

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
		
		// ListView의 실제 내용은 변경되지 않고 화면에 보이는 내용을 변경하는 방법
		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			
			@Override
			public ListCell<String> call(ListView<String> param) {
				return new ListCell<String>() {// 익명 구현체 생성
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						Rectangle rect = new Rectangle(100, 20);
						if (item != null) {
							rect.setFill(Color.web(item));
							// 변경되는 값이 문자열이면 setText()메서드를
							// 변경되는 값이 문자열 이외의 객체이면 setGrphic()메서드를 사용하여 변경한다
							setGraphic(rect);// 값 변경
							
						}
					}
				};
			}
		});
		
		Scene scene = new Scene(vbox);
		primaryStage.setTitle("ListView연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

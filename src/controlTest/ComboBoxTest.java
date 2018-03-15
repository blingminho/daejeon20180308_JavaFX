package controlTest;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		
		HBox hbox = new HBox(10);
		TextArea txtArea = new TextArea();
		
		// ComboBox를 생성하고 데이터를 셋팅하는 방법1
		ComboBox<String> combo = new ComboBox<String>();
		combo.getItems().addAll("한강", "금강", "영산강", "낙동강");
		combo.setValue("한강");// 초기에 화면에 보여줄 데이터 설정
		
		// 콤보박스에 데이터 셋팅하는 방법2
		ObservableList<String> fruitList =
				FXCollections.observableArrayList(
						"사과", "딸기", "수박", "오렌지", "감"
		);
		
		ComboBox<String> combo2 = new ComboBox<String>(fruitList);
		
		// 콤보박스 기존의 데이터에 새로운 데이터를 추가하기
		combo2.getItems().addAll("대추", "바나나");
		combo2.setValue("사과");// 초기에 화면에 보여줄 데이터 설정
		
		
		Button button = new Button("확인");
		
		// 콤보박스에서 값이 변경될 때의 처리. 즉, change이벤트 처리 방법
		combo.valueProperty().addListener(
				new ChangeListener<String>() {

					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {

						txtArea.setText(newValue);
						
					}
		});
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if (combo.getValue() != null && combo2.getValue() != null) {
					txtArea.setText("첫번째 콤보박스의 선택값 : " + combo.getValue() + "\n");
					txtArea.appendText("두번째 콤보박스의 선택값 : " + combo2.getValue() + "\n\n");
					txtArea.appendText(combo2.getItems().get(1));// combo2에 있는 자료들 중 1번째에 있는 딸기를 출력
				}
				
			}
		});
		
		
		
		hbox.getChildren().addAll(combo, combo2, button);
		
		root.setTop(hbox);
		root.setCenter(txtArea);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("ComboBox 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

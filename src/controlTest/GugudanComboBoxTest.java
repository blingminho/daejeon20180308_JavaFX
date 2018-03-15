package controlTest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GugudanComboBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		ComboBox<Integer> cmbDan = new ComboBox<>();
		cmbDan.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		Button btnOk = new Button("출 력");
		TextArea taResult = new TextArea();
		
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(0, 0, 10, 0));
		hbox.getChildren().addAll(cmbDan, btnOk);
		hbox.setAlignment(Pos.CENTER);
		
		root.setTop(hbox);
		root.setCenter(taResult);
		root.setPadding(new Insets(10));
		
		
		// 선택되기 전 첫 상태
		cmbDan.setPromptText("단선택");
		
		/*
		// 콤보박스를 클릭했을 때
		cmbDan.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// 선택한 값 읽어오기
//				int dan = cmbDan.getValue(); // 방법 1
				int dan = cmbDan.getSelectionModel().getSelectedItem();// 방법 2
				
				taResult.setText(dan + "단\n\n");
				for (int i = 1; i <= 9; i++) {
					int r = dan * i;
					taResult.appendText(dan + " * " + i + " = " + r + "\n");
				}
				
			}
		});
		
		*/
		
		// 버튼을 클릭했을 때
		btnOk.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// getSelectedIndex()는 선택값이 없으면 -1을 반환한다
//				if (cmbDan.getSelectionModel().getSelectedIndex() != -1) {
				if (cmbDan.getSelectionModel().getSelectedItem() != null) {
					int dan = cmbDan.getSelectionModel().getSelectedItem();// 방법 2
					
					taResult.setText(dan + "단\n\n");
					for (int i = 1; i <= 9; i++) {
						int r = dan * i;
						taResult.appendText(dan + " * " + i + " = " + r + "\n");
					}
				}
				
			}
		});
		
		
		
		
		
		
		
		Scene scene = new Scene(root, 300, 300);
		primaryStage.setTitle("콤보 구구단");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package controlTest;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(10);
		root.setPrefSize(600, 500);
		
		//===================================================
		// 이름
		HBox hbox1 = new HBox(10);
		Label label1 = new Label("이 름 :");
		TextField txtInput = new TextField();
		
		hbox1.getChildren().addAll(label1, txtInput);
		
		//===================================================
		// 성별
		HBox hbox2 = new HBox(10);
		Label label2 = new Label("성 별 :");
		ToggleGroup group = new ToggleGroup();
		RadioButton radio1 = new RadioButton("남");
		RadioButton radio2 = new RadioButton("여");
		
		radio1.setUserData("남");
		radio1.setToggleGroup(group);
		radio2.setUserData("여");
		radio2.setToggleGroup(group);
		
		hbox2.getChildren().addAll(label2, radio1, radio2);
		
		radio1.setSelected(true);
		
		//===================================================
		// 취미
		HBox hbox3 = new HBox(10);
		Label label3 = new Label("취 미 :");
		CheckBox[] chk = {
				new CheckBox("여행"),
				new CheckBox("등산"),
				new CheckBox("독서"),
				new CheckBox("바둑"),
				new CheckBox("장기"),
				new CheckBox("게임"),
				new CheckBox("테니스"),
				new CheckBox("배드민턴")
		};
		
		
		hbox3.getChildren().add(label3);
		hbox3.getChildren().addAll(chk);
		
		//===================================================
		// 결과창
		TextArea txtResult = new TextArea();
		HBox hbox4 = new HBox(10);
		hbox4.getChildren().add(txtResult);
		hbox4.setPrefSize(100, 100);
		
		//===================================================
		// 보기
		Button button = new Button("보  기");
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			
			
			@Override
			public void handle(ActionEvent event) {
				String name = "";
				String gender = "";
				List<String> list = new ArrayList<String>();
				
				// 경고창
				Alert alertError = new Alert(AlertType.ERROR);
				
				alertError.setTitle("Error");
				alertError.setHeaderText("오류 제목");
				alertError.setContentText("Error Alert 창입니다.");
				
				
				if (!txtInput.getText().equals("")) {
					name =  txtInput.getText();
				} else {
					alertError.showAndWait();
					return;
				}
				
				if (group.getSelectedToggle().getUserData() != null) {
					gender = (String)group.getSelectedToggle().getUserData();
				}
				
				for (int i = 0; i < chk.length; i++) {
					if (chk[i].isSelected()) {
						list.add(chk[i].getText());
					}
				}
				
				txtResult.setText("이 름 : " + name + "\n");
				txtResult.appendText("성 별 : " + gender + "\n");
				txtResult.appendText("취 미 : ");
				
				if (list.size() == 0) {
					txtResult.appendText("좀 가지세요!");
					return;
				}
				
				for (int j = 0; j < list.size(); j++) {
					String hobby = list.get(j);
					if (j != list.size()-1) {
						txtResult.appendText(hobby + ", ");						
					} else {
						txtResult.appendText(hobby);						
					}
				}
				
			}
		});
		
		
		//===================================================
		// 출력
		root.getChildren().addAll(hbox1, hbox2, hbox3, button, hbox4);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("과제");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

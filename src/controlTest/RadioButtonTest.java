package controlTest;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RadioButtonTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		// 라디오 버튼들을 묶음으로 처리할 객체
		ToggleGroup group = new ToggleGroup();
		
		ImageView icon = new ImageView();
		
		RadioButton rb1 = new RadioButton("Home");
		rb1.setUserData("Home");// 선택했을때 사용할 값
		rb1.setToggleGroup(group);// 라디오 버튼을 그룹에 추가
		
		RadioButton rb2 = new RadioButton("Calendar");
		rb2.setUserData("Calendar");// 선택했을때 사용할 값
		rb2.setToggleGroup(group);// 라디오 버튼을 그룹에 추가
		
		RadioButton rb3 = new RadioButton("Contacts");
		rb3.setUserData("Contacts");// 선택했을때 사용할 값
		rb3.setToggleGroup(group);// 라디오 버튼을 그룹에 추가
		
		// 그룹내에서 RadioButton중 하나가 선택되었을 때 처리하기
		group.selectedToggleProperty().addListener(
				new ChangeListener<Toggle>() {

					@Override
					public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue,
							Toggle newValue) {
						// getSelectedToggle() ==> 그룹내에서 선택된 객체를 찾는다
						if (group.getSelectedToggle().getUserData() != null) {
							String fileName = group.getSelectedToggle().getUserData().toString();
							Image img = new Image(
									getClass().getResourceAsStream("images/" + fileName + ".jpg")
							);
							
							icon.setImage(img);

						}
					}
				}
		);
		
		HBox hbox = new HBox();
		VBox vbox = new VBox();
		
		vbox.getChildren().addAll(rb1, rb2, rb3);
		vbox.setSpacing(10);
		
		hbox.getChildren().addAll(vbox, icon);
		hbox.setPadding(new Insets(10));
		
		Scene scene = new Scene(hbox, 250, 150);
		primaryStage.setTitle("RadioButton 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

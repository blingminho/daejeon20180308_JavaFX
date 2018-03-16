package fxTest;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("FxTest.fxml")));
			primaryStage.setTitle("fxml을 이용한 과제");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

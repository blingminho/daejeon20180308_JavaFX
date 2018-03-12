package basic;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlLayout extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Fxml파일을 읽어와 현재 Stage에 적용하는 방법
		
		try {
			/*
			// 방법 1) FXMLLoader객체의 load() static메서드 이용하는 방법
			Parent root = FXMLLoader.load(
					getClass().getResource("FxmlLayout.fxml")// 상대경로 가능
			);
			*/
			
			// 방법 2) FXMLLoader객체의 인스턴스 메서드인 load()메서드 이용하는 방법
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("FxmlLayout.fxml")
			);
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Fxml문서를 이용한 레이아웃");
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

package chartAndDialog.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainTest extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../view/ChartAndDialog.fxml"));
		Scene scene = new Scene(root);
		
		Controller_Main.setPrimaryStage(primaryStage);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("차트 및 모달창 과제");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

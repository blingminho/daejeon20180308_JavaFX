package basic;

import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GugudanTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20));
		root.setPrefSize(300, 300);
		
		HBox hbox = new HBox(20);
		hbox.setPadding(new Insets(10));
		hbox.setAlignment(Pos.CENTER);
		
		Button btn = new Button("출력");
		
		
		TextField txtf = new TextField();
		hbox.getChildren().addAll(txtf, btn);
		
		TextArea txta = new TextArea();
		txta.setPrefSize(200, 200);
		
		btn.setOnAction(
			(ActionEvent event) -> {
				String input = txtf.getText();
				if (input.isEmpty() || !Pattern.matches("^[0-9]+$", input)) {
					txta.setText("출력할 단을 정확히 입력하세요");
					txtf.requestFocus();// 포커스 주기
					return;
				}
				
				int in = Integer.valueOf(input);
				
				txta.setText(in + "단\n\n");
				for (int i = 1; i < 10; i++) {
					String result = in + " * " + i + " = " + in *i + "\n";
					txta.appendText(result);
				}
				
			}
		);
		
		
		root.setTop(hbox);
		root.setCenter(txta);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("구구단 출력");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

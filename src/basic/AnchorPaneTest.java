package basic;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/*
 * AnchorPane => 컨트롤들이 나타나는 위치를 좌표로 설정해서
 * 					배치하는 컨테이너
 */
public class AnchorPaneTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		AnchorPane root = new AnchorPane();
		root.setPrefSize(300, 150);
		
		Label lblId = new Label("아이디 : ");
		lblId.setLayoutX(62);
		lblId.setLayoutY(22);
		
		Label lblPass = new Label("패스워드 : ");
		lblPass.setLayoutX(62);
		lblPass.setLayoutY(68);
		
		TextField tfId = new TextField();
		tfId.setLayoutX(132);
		tfId.setLayoutY(18);
		
		PasswordField pfPass = new PasswordField();
		pfPass.setLayoutX(132);
		pfPass.setLayoutY(64);
		
		Button btnLogin = new Button("로그인");
		btnLogin.setLayoutX(86);
		btnLogin.setLayoutY(106);
		
		Button btnCancel = new Button("취 소");
		btnCancel.setLayoutX(160);
		btnCancel.setLayoutY(106);
		
		root.getChildren().addAll(lblId, lblPass, tfId, pfPass, btnLogin, btnCancel);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("AnchorPane 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

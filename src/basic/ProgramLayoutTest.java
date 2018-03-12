package basic;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProgramLayoutTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		// 수평
		HBox hbox = new HBox();// HBox 컨테이너 객체 생성
		
		// 안쪽 여백 설정
		// 		=> Insets객체는 위, 오른쪽, 아래, 왼쪽 순으로 값을 설정한다
		hbox.setPadding(new Insets(10, 10, 10, 10));
		
		hbox.setSpacing(10);// 컨트롤 객체간의 간격
		
		// textField객체 생성 후 크기 설정
		TextField textField = new TextField();
		textField.setPrefWidth(200);
		
		// Button객체 생성
		Button button = new Button();
		button.setText("확 인");
		
//		// Button에 대한 이벤트 처리
//		button.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				// 이벤트에 대한 처리 내용을 기술한다
//				Platform.exit();// 프로그램 종료
//				System.exit(0);// stop()메서드를 실행하지 않고 프로그램이 끝난다
//			}
//			
//		});
		
		// Button에 대한 이벤트 처리
		button.setOnAction(
				(ActionEvent event) -> {
					// 이벤트에 대한 처리 내용을 기술한다
					Platform.exit();// 프로그램 종료
					System.exit(0);// stop()메서드를 실행하지 않고 프로그램이 끝난다
				}
		);
		
		// 생성한 컨트롤들을 컨테이너에 추가하기
		
		// 방법 1 --> add() 메서드로 하나씩 차례로 추가하기
		hbox.getChildren().add(textField);
		hbox.getChildren().add(button);
		
		// 방법 2 --> addAll()메서드로 한번에 추가하기
//		hbox.getChildren().addAll(textField, button);
		
		
		
		VBox root = new VBox();
		root.setSpacing(20);// 컨트롤 객체간의 간격
		// 4군데 모두 같은 값이면 값을 1개만 설정해도 된다.
		root.setPadding(new Insets(15));
		root.setAlignment(Pos.CENTER);// 컨트롤들을 가운데 정렬
		root.setPrefWidth(650);// VBox의 너비
		root.setPrefHeight(300);// VBox의 높이
		
		Label label = new Label();
		label.setText("안녕하세요. JavaFX입니다");
		label.setFont(new Font(50));// Font객체를 이용하여 글자 크기 설정
		
		// VBox에 컨트롤 추가
		root.getChildren().addAll(label, hbox);
		
		// Vbox를 루트 컨테이너로 하는 Scene객체 생성
		Scene scene = new Scene(root);
		
		// 창제목
		primaryStage.setTitle("Program Layout 연습");
		
		// Stage에 Scene 추가하기
		primaryStage.setScene(scene);
		
		// 윈도우(Stage) 보이기
		primaryStage.show();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

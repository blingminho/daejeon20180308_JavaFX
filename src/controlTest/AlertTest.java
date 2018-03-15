package controlTest;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class AlertTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		Alert alertInformation = new Alert(AlertType.INFORMATION);
		
		// 창제목
		alertInformation.setTitle("Information");
		// 부제목
		alertInformation.setHeaderText("본제목");
		// 출력할 메세지
		alertInformation.setContentText("Information Alert 창입니다.");
		
//		alertInformation.showAndWait();// Alert창 보여주기
		
		//--------------------------------------------------------------
		
		Alert alertError = new Alert(AlertType.ERROR);
		
		alertError.setTitle("Error");
		alertError.setHeaderText("오류 제목");
		alertError.setContentText("Error Alert 창입니다.");
		
//		alertError.showAndWait();
		
		//--------------------------------------------------------------
		
		Alert alertWarning = new Alert(AlertType.WARNING);
		
		alertWarning.setTitle("Warning");
		alertWarning.setHeaderText("경고 제목");
		alertWarning.setContentText("Warning Alert 창입니다.");
		
//		alertWarning.showAndWait();
		
		//--------------------------------------------------------------
		
		Alert alertConfirmation = new Alert(AlertType.CONFIRMATION);
		
		alertConfirmation.setTitle("Confirmation");
		alertConfirmation.setHeaderText("선택 제목");
		alertConfirmation.setContentText("Confirmation Alert 창입니다.\n프로그램을 종료할까요?");
		
		// Alert창을 보여주고 사용자가 누른 버튼 값 읽어오기
		ButtonType confirmResult = alertConfirmation.showAndWait().get();// 선택한 값을 받아서 처리하기 위해서는 showAndWait() 사용
		
		if (confirmResult == ButtonType.OK) {// OK버튼
			System.out.println("OK버튼 선택");
		} else if (confirmResult == ButtonType.CANCEL) {// 취소버튼 (X버튼이나 강제 종료도 취소이다)
			System.out.println("취소버튼 선택");
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

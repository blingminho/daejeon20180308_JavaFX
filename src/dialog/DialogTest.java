package dialog;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox(10);
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		
		
		Button btnFileOpen = new Button("Open FileChooser 실행");
		Button btnFileSave = new Button("Save FileChooser 실행");
		Button btnDirectory = new Button("DirectoryChooser 실행");
		Button btnPopup = new Button("Popup 실행");
		Button btnCustom = new Button("사용자 정의 창 실행(Java Code)");
		Button btnCustomFxml = new Button("사용자 정의 창 실행(FXML)");
		
		//------------------------------------------------------------------
		btnFileOpen.setOnAction(
				e -> {
					FileChooser fileChooser = new FileChooser();
					fileChooser.getExtensionFilters().addAll(
							new ExtensionFilter("Text Files", "*.txt"),
							new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
							new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
							new ExtensionFilter("All Files", "*.*")
					);
				
					File selectedFile = fileChooser.showOpenDialog(primaryStage);
					if (selectedFile != null) {
						System.out.println(selectedFile.getPath());
					}
				}
		);
		//------------------------------------------------------------------
		btnFileSave.setOnAction(
				e -> {
					FileChooser fileChooser = new FileChooser();
					fileChooser.getExtensionFilters().add(
							new ExtensionFilter("All Files", "*.*")
					);
				File selectedFile = fileChooser.showSaveDialog(primaryStage);
				if (selectedFile != null) {
					System.out.println(selectedFile.getPath());
				}
				}
		);
		
		//------------------------------------------------------------------
		btnDirectory.setOnAction(
				e -> {
					DirectoryChooser dirChooser = new DirectoryChooser();
					File selectedDir = dirChooser.showDialog(primaryStage);
					if (selectedDir != null) {
						System.out.println(selectedDir.getPath());
					}
				}
		);
		//------------------------------------------------------------------
		btnPopup.setOnAction(
				e -> {
					Popup popup = new Popup();
					
					HBox popRoot = new HBox();
					popRoot.setAlignment(Pos.CENTER_LEFT);
					popRoot.setStyle("-fx-background-color:yellow; -fx-background-radius:20;");
					
					Rectangle rect = new Rectangle(30, 30);
					rect.setFill(Color.RED);
					rect.setOnMouseClicked(
							e2 -> {
								popup.hide();
							}
					);
					
					Label lblMsg = new Label();
					lblMsg.setText("메시지가 도착했습니다.");
					HBox.setMargin(lblMsg, new Insets(0, 5, 0, 5));
					
					popRoot.getChildren().add(rect);
					popRoot.getChildren().add(lblMsg);
					
					popup.getContent().add(popRoot);
//					popup.setAutoHide(true);
					popup.show(primaryStage);
					
				}
		);
		//------------------------------------------------------------------
		// 사용자 정의 새 창 띄우기
		btnCustom.setOnAction(
				e -> {
					// Stage객체 생성(창의 스타일 지정)
//					Stage childStage = new Stage(StageStyle.DECORATED);// 기본창
					Stage childStage = new Stage(StageStyle.UTILITY);// 종료버튼만 존재
//					Stage childStage = new Stage(StageStyle.UNDECORATED);// 테두리가 없다// 투명 배경이 불가능하다
//					Stage childStage = new Stage(StageStyle.UNIFIED);// 내부 테두리가 없다
//					Stage childStage = new Stage(StageStyle.TRANSPARENT);// 테두리가 없다// 투명 배경이 가능하다
					
					// 모달리스 또는 모달창 여부 설정
//					childStage.initModality(Modality.NONE);// 모달리스 설정
					childStage.initModality(Modality.WINDOW_MODAL);// 모달 창 설정
					
					// 부모창 지정
					childStage.initOwner(primaryStage);
					childStage.setTitle("자식창(모달리스) 연습");
					
					// 자식창에 나타날 Control 객체들 구성
					VBox childRoot = new VBox(10);
					childRoot.setPadding(new Insets(15));
					childRoot.setStyle("-fx-background-color:transparent;");
					
					Label lblMsg = new Label("안녕하세요");
					lblMsg.setFont(Font.font(15));
					Button btnOk = new Button("확인");
					btnOk.setOnAction(
							e2 -> {
								childStage.close();
							}
					);
					
					childRoot.getChildren().addAll(lblMsg, btnOk);
					Scene scene = new Scene(childRoot, 400, 200);
					scene.setFill(Color.TRANSPARENT);
					childStage.setScene(scene);
					childStage.show();
					
				}
		);
		//------------------------------------------------------------------
		btnCustomFxml.setOnAction(e -> {
			try {
				Stage childStage = new Stage(StageStyle.UTILITY);
				childStage.initModality(Modality.WINDOW_MODAL);
				childStage.initOwner(primaryStage);
				childStage.setTitle("FXML 자식창 연습");
				Parent childRoot = FXMLLoader.load(
						getClass().getResource("CustomDialog.fxml")
				);
				
				// FXML문서에 구성해 놓은 컨트롤 객체 구하기
				// FXML문서의 컨트롤에 설정해 놓은 ID값을 이용한다.
				Label lblMsg = (Label) childRoot.lookup("#lblMsg");
				Button btnOk = (Button) childRoot.lookup("#btnOk");
				Button btnClose = (Button) childRoot.lookup("#btnClose");
				
				btnClose.setOnAction(e2 -> {
					childStage.close();
				});
				
				btnOk.setOnAction(e3 -> {
					lblMsg.setText("새로운 내용입니다.");
				});
				
				
				Scene scene = new Scene(childRoot);
				childStage.setScene(scene);
				childStage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
		});
		
		
		
		
		//------------------------------------------------------------------
		root.getChildren().addAll(btnFileOpen, btnFileSave, btnDirectory, btnPopup, btnCustom, btnCustomFxml);
		
		
		Scene scene = new Scene(root, 1000, 300);
		primaryStage.setTitle("Dialog창 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package controlTest;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TabelViewTestMine extends Application {

	@Override
	public void start(Stage primaryStage) {
		ObservableList<MyMem> dataList = FXCollections.observableArrayList(
				new MyMem("홍길동", "gildong", 33, "1234-5678", "대전"),
				new MyMem("홍길서", "gilseo", 43, "3333-3333", "서울"),
				new MyMem("홍길남", "gilnam", 23, "2222-5555", "제주"),
				new MyMem("홍길북", "gilbook", 53, "8888-9999", "원주")
		);
		
		BorderPane root = new BorderPane();
		
		VBox vboxRight = new VBox(10);
		GridPane gridBottom = new GridPane();
		TableView<MyMem> tableView = new TableView<MyMem>(dataList);
//		tableView.setItems(dataList);
		
		
		// TableView의 각 컬럼에 대한 설정
		TableColumn<MyMem, String> korNameCol = new TableColumn<MyMem,String>("한글이름");// 컬럼의 맨 윗줄에 뜨는 컬럼명
		korNameCol.setCellValueFactory(
				new PropertyValueFactory<MyMem, String>("korName")// MyMem의 속성인 korName을 받음
		);
		
		TableColumn<MyMem, String> engNameCol = new TableColumn<>("영문이름");
		engNameCol.setCellValueFactory(new PropertyValueFactory<MyMem, String>("engName"));
		
		TableColumn<MyMem, Integer> ageCol = new TableColumn<>("나 이");
		ageCol.setCellValueFactory(new PropertyValueFactory<MyMem, Integer>("age"));
		
		TableColumn<MyMem, String> telCol = new TableColumn<>("전 화 번 호");
		telCol.setCellValueFactory(new PropertyValueFactory<MyMem, String>("tel"));
		
		TableColumn<MyMem, String> addrCol = new TableColumn<>("주 소");
		addrCol.setCellValueFactory(new PropertyValueFactory<MyMem, String>("addr"));
		
		tableView.getColumns().addAll(korNameCol, engNameCol, ageCol, telCol, addrCol);
		
		
		// 버튼
		Button btn1 = new Button("추가");
		Button btn2 = new Button("수정");
		Button btn3 = new Button("삭제");
		
		vboxRight.getChildren().addAll(btn1, btn2, btn3);
		
		
		// 아래
		Label l1 = new Label("한글이름");
		Label l2 = new Label("영문이름");
		Label l3 = new Label("나    이");
		Label l4 = new Label("전화번호");
		Label l5 = new Label("주    소");
		
		TextField txt1 = new TextField();
		TextField txt2 = new TextField();
		TextField txt3 = new TextField();
		TextField txt4 = new TextField();
		TextField txt5 = new TextField();
		
		gridBottom.add(l1, 1, 1);
		gridBottom.add(txt1, 1, 2);
		gridBottom.add(l2, 2, 1);
		gridBottom.add(txt2, 2, 2);
		gridBottom.add(l3, 3, 1);
		gridBottom.add(txt3, 3, 2);
		gridBottom.add(l4, 4, 1);
		gridBottom.add(txt4, 4, 2);
		gridBottom.add(l5, 5, 1);
		gridBottom.add(txt5, 5, 2);
		
		//=============================== 액션 =============================
		// 추가 버튼 클릭
		btn1.setOnAction(
				event -> {
					String korName = txt1.getText();
					String engName = txt2.getText();
					String tel = txt4.getText();
					String addr = txt5.getText();
					
					if (korName.isEmpty() || engName.isEmpty() || txt3.getText().isEmpty() || tel.isEmpty() || addr.isEmpty()) {
						getAlert("추가 오류", "빈입력이 있습니다");
						return;
					}
					
					int age = 0;
					try {
						age = Integer.valueOf(txt3.getText());
					} catch (Exception e) {
						getAlert("나이 타입 오류", "나이에 숫자를 입력해주세요");
						return;
					}
					
					dataList.add(new MyMem(korName, engName, age, tel, addr));
					txt1.clear();
					txt2.clear();
					txt3.clear();
					txt4.clear();
					txt5.clear();
					
				}
		);
		
		// TableView 선택시
		tableView.setOnMouseClicked(
				event -> {
					// 빈 공간 클릭시 오류 처리 방법 1
//					if (tableView.getSelectionModel().isEmpty()) {
//						return;
//					}
					
					// 빈 공간 클릭시 오류 처리 방법 2
					MyMem selectedMem = tableView.getSelectionModel().getSelectedItem();
					if (selectedMem == null) {
						return;
					}
					
					txt1.setText(selectedMem.getKorName());
					txt2.setText(selectedMem.getEngName());
					txt3.setText(String.valueOf(selectedMem.getAge()));
					txt4.setText(selectedMem.getTel());
					txt5.setText(selectedMem.getAddr());
				}
		);
		
		// 수정 버튼 클릭
		btn2.setOnAction(
				event -> {
					if (tableView.getSelectionModel().isEmpty()) {
						getAlert("선택 오류", "클릭하신 행이 없습니다. 다시 클릭해주세요");
						return;
					}
					
					
					String korName = txt1.getText();
					String engName = txt2.getText();
					String tel = txt4.getText();
					String addr = txt5.getText();
					
					if (korName.isEmpty() || engName.isEmpty() || txt3.getText().isEmpty() || tel.isEmpty() || addr.isEmpty()) {
						getAlert("수정 오류", "빈입력이 있습니다");
						return;
					}
					
					int age = 0;
					try {
						age = Integer.valueOf(txt3.getText());
					} catch (Exception e) {
						getAlert("나이 타입 오류", "나이에 숫자를 입력해주세요");
						return;
					}
					
					int index = tableView.getSelectionModel().getSelectedIndex();
					
					dataList.set(index, new MyMem(korName, engName, age, tel, addr));
					
				}
		);
		
		
		// 삭제 버튼 클릭
		btn3.setOnAction(
				event -> {
					if (tableView.getSelectionModel().isEmpty()) {
						getAlert("선택 오류", "클릭하신 행이 없습니다. 다시 클릭해주세요");
						return;
					}
					
					int index = tableView.getSelectionModel().getSelectedIndex();
					dataList.remove(index);
					
				}
		);
		
		
		
		// 마지막 세팅
		root.setCenter(tableView);
		root.setRight(vboxRight);
		root.setBottom(gridBottom);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("나의 TableView 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void getAlert(String headerText, String contentText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
	
	
	public class MyMem{
		private String korName;
		private String engName;
		private int age;
		private String tel;
		private String addr;
		
		// 생성자
		public MyMem() {}
		
		public MyMem(String korName, String engName, int age, String tel, String addr) {
			super();
			this.korName = korName;
			this.engName = engName;
			this.age = age;
			this.tel = tel;
			this.addr = addr;
		}
		
		// getter, setter
		public String getKorName() {
			return korName;
		}
		
		public void setKorName(String korName) {
			this.korName = korName;
		}
		
		public String getEngName() {
			return engName;
		}
		
		public void setEngName(String engName) {
			this.engName = engName;
		}
		
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public String getTel() {
			return tel;
		}
		
		public void setTel(String tel) {
			this.tel = tel;
		}
		
		public String getAddr() {
			return addr;
		}
		
		public void setAddr(String addr) {
			this.addr = addr;
		}	
	}
}
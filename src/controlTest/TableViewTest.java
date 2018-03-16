package controlTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableViewTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		ObservableList<Member> dataList = FXCollections.observableArrayList(
			new Member("홍길동", "gildong", 33, "1234-5678", "대전"),
			new Member("홍길서", "gilseo", 43, "3333-3333", "서울"),
			new Member("홍길남", "gilnam", 23, "2222-5555", "제주"),
			new Member("홍길북", "gilbook", 53, "8888-9999", "원주")
		);
		
		BorderPane root = new BorderPane();
		
		TableView<Member> table = new TableView<Member>(dataList);
		//table.setItems(dataList);
		
		// TableView의 각 컬럼에 대한 설정
		TableColumn<Member, String> korNameCol = new TableColumn<Member,String>("한글이름");
		korNameCol.setCellValueFactory(
				new PropertyValueFactory<Member, String>("korName")
		);
		
		TableColumn<Member, String> engNameCol = new TableColumn<Member, String>("영문이름");
		engNameCol.setCellValueFactory(
				new PropertyValueFactory<Member, String>("engName")
		);
		
		TableColumn<Member, Integer> ageCol = new TableColumn<Member, Integer>("나이");
		ageCol.setCellValueFactory(new PropertyValueFactory<Member, Integer>("age"));
		
		TableColumn<Member, String> telCol = new TableColumn<Member, String>("전화번호");
		telCol.setCellValueFactory(
				new PropertyValueFactory<Member, String>("tel")
		);
		
		TableColumn<Member, String> addrCol = new TableColumn<Member, String>("주 소");
		addrCol.setCellValueFactory(new PropertyValueFactory<Member, String>("addr"));
		
		// 생성된 각 컬럼을 TableView에 추가하기
		table.getColumns().addAll(korNameCol, engNameCol, ageCol, telCol, addrCol);
		//table.getColumns().setAll(korNameCol, engNameCol, ageCol, telCol, addrCol);
		
		GridPane grid = new GridPane();
		Text txt1 = new Text("한글이름");
		Text txt2 = new Text("영문이름");
		Text txt3 = new Text("나  이");
		Text txt4 = new Text("전화번호");
		Text txt5 = new Text("주  소");
		
		TextField tfKorName = new TextField();
		TextField tfEngName = new TextField();
		TextField tfAge = new TextField();
		TextField tfTel = new TextField();
		TextField tfAddr = new TextField();
		
		grid.add(txt1, 1, 1);
		grid.add(txt2, 2, 1);
		grid.add(txt3, 3, 1);
		grid.add(txt4, 4, 1);
		grid.add(txt5, 5, 1);
		
		grid.add(tfKorName, 1, 2);
		grid.add(tfEngName, 2, 2);
		grid.add(tfAge, 3, 2);
		grid.add(tfTel, 4, 2);
		grid.add(tfAddr, 5, 2);
		grid.setHgap(5);
		grid.setVgap(10);
		
		VBox vbox = new VBox(15);
		vbox.setPadding(new Insets(10));
		
		Button btnAdd = new Button("추가");
		Button btnEdit = new Button("수정");
		Button btnDel = new Button("삭제");
		
		// 추가버튼 이벤트 처리
		btnAdd.setOnAction(
				event -> {
					if (tfKorName.getText().isEmpty() || tfEngName.getText().isEmpty() || tfAge.getText().isEmpty()
							|| tfTel.getText().isEmpty() || tfAddr.getText().isEmpty()) {
						System.out.println("빈 항목이 있습니다 => alert로 변경하기");
						return;
					}
					
					dataList.add(
							new Member(tfKorName.getText(), tfEngName.getText(),
									Integer.valueOf(tfAge.getText()),
									tfTel.getText(), tfAddr.getText())
					);
					
					System.out.println(tfKorName.getText() + "씨 정보 추가 완료");
					
					tfKorName.clear();
					tfEngName.clear();
					tfAge.clear();
					tfTel.clear();
					tfAddr.clear();
					
				}
		);
		
		// TableView를 클릭했을 때 처리
		table.setOnMouseClicked(
				event -> {
					if (!table.getSelectionModel().isEmpty()) {
						Member m = table.getSelectionModel().getSelectedItem();
						
						tfKorName.setText(m.getKorName());
						tfEngName.setText(m.getEngName());
						tfAge.setText(String.valueOf(m.getAge()));
						tfTel.setText(m.getTel());
						tfAddr.setText(m.getAddr());
					}
				}
		);
		
//		table.setOnMouseClicked(new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event event) {
//				
//			}
//		});
		
		// 수정 버튼 처리
		btnEdit.setOnAction(
				event -> {
					if (table.getSelectionModel().isEmpty()) {// 선택한 값이 없으면
						System.out.println("show alert 수정할 자료가 없거나 선택되지 않았습니다");
						return;
					}
					
					if (tfKorName.getText().isEmpty() || tfEngName.getText().isEmpty() || tfAge.getText().isEmpty()
							|| tfTel.getText().isEmpty() || tfAddr.getText().isEmpty()) {
						System.out.println("빈 항목이 있습니다 => alert로 변경하기");
						return;
					}
					
					// 선택된 데이터의 index값 구하기
					int index = table.getSelectionModel().getSelectedIndex();
					dataList.set(index, 
							new Member(tfKorName.getText(), tfEngName.getText(),
									Integer.valueOf(tfAge.getText()),
									tfTel.getText(), tfAddr.getText())
					);
					System.out.println("alert" + tfKorName.getText() + "씨의 정보를 수정했습니다.");
					
				}
		);
		
		// 삭제 버튼 처리
		btnDel.setOnAction(
				e -> {
					if (table.getSelectionModel().isEmpty()) {
						System.out.println("삭제할 자료가 없거나 선택되지 않았습니다");
						return;
					}
					
					int index = table.getSelectionModel().getSelectedIndex();
					
					String name = dataList.get(index).getKorName();
					
					dataList.remove(index);
					
					System.out.println(name + "씨 정보를 삭제했습니다.");
					
					
				}
		);
		
		
		
		vbox.getChildren().addAll(btnAdd, btnEdit, btnDel);
				
		root.setCenter(table);
		root.setBottom(grid);
		root.setRight(vbox);
		root.setPadding(new Insets(15));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("TableView 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	// Inner클래스로 VO클래스 구성
	public class Member{
		private String korName;
		private String engName;
		private int age;
		private String tel;
		private String addr;
		
		// 생성자
		public Member() {}

		public Member(String korName, String engName, int age, String tel, String addr) {
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

package controlTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ComboBoxTest3 extends Application {

	@Override
	public void start(Stage primaryStage) {
		HBox hbox = new HBox(10);
		VBox root = new VBox(10);
		
		ComboBox<MyMember2> combo = new ComboBox<MyMember2>();
		
		Button button = new Button("출력");
		
		TextArea taResult = new TextArea();
		
		ObservableList<MyMember2> list = FXCollections.observableArrayList(
				new MyMember2("aaa", "홍길동", 22, "010-1111-1111", "대전"),
				new MyMember2("bbb", "일지매", 11, "010-1111-1111", "광주"),
				new MyMember2("ccc", "성춘향", 33, "010-1111-1111", "전주"),
				new MyMember2("ddd", "이순신", 44, "010-1111-1111", "부산"),
				new MyMember2("eee", "강감찬", 55, "010-1111-1111", "대구"),
				new MyMember2("fff", "이몽룡", 30, "010-1111-1111", "포항")
		);
		
		combo.setItems(list);
		
		
		combo.setCellFactory(new Callback<ListView<MyMember2>, ListCell<MyMember2>>() {
			
			@Override
			public ListCell<MyMember2> call(ListView<MyMember2> param) {
				return new ListCell<MyMember2>() {
					@Override
					protected void updateItem(MyMember2 item, boolean empty) {
						super.updateItem(item, empty);
						if (item == null || empty) {
							setText(null);
						} else {
							setText(item.getName() + " ( " + item.getId() + " ) ");
						}
					};
				};
			}
		});
		
		combo.setButtonCell(
				new ListCell<MyMember2>() {
					protected void updateItem(MyMember2 item, boolean empty) {
						super.updateItem(item, empty);
						if (item == null || empty) {
							setText(null);
						} else {
							setText(item.getName() + " ( " + item.getId() + " ) ");
						}
					};
				}
		);
		
		
		button.setOnAction(
				e -> {
					MyMember2 selData = combo.getSelectionModel().getSelectedItem();
					
					taResult.setText("선택한 회원 정보\n\n");
					taResult.appendText("ID : " + selData.getId() + "\n");
					taResult.appendText("이름 : " + selData.getName() + "\n");
					taResult.appendText("나이 : " + selData.getAge() + "\n");
					taResult.appendText("전화번호 : " + selData.getTel() + "\n");
					taResult.appendText("주소 : " + selData.getAddr()+ "\n");
				}
		);
		
		combo.setValue(list.get(0));
		
		
		
		hbox.getChildren().addAll(combo, button);
		root.getChildren().addAll(hbox, taResult);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("내가 만든 콤보테스트");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
//데이터가 저장될 Class 구성하기
class MyMember2{
	private String id;
	private String name;
	private int age;
	private String tel;
	private String addr;
	
	// 생성자
	public MyMember2(String id, String name, int age, String tel, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.addr = addr;
	}
	
	// Getter, Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
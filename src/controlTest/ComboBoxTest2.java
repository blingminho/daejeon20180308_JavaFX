package controlTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ComboBoxTest2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		VBox vbox = new VBox(10);
		ComboBox<MyMember> combo  = new ComboBox<MyMember>();
		TextArea taResult = new TextArea();
		
		ObservableList<MyMember> dataList = FXCollections.observableArrayList(
				new MyMember("aaa", "홍길동", 22, "010-1111-1111", "대전"),
				new MyMember("bbb", "일지매", 11, "010-1111-1111", "광주"),
				new MyMember("ccc", "성춘향", 33, "010-1111-1111", "전주"),
				new MyMember("ddd", "이순신", 44, "010-1111-1111", "부산"),
				new MyMember("eee", "강감찬", 55, "010-1111-1111", "대구"),
				new MyMember("fff", "이몽룡", 30, "010-1111-1111", "포항")
		);
		
		combo.setItems(dataList);
		
		// 콤보박스의 목록이 보여지는 곳의 내용 변경하기
		// 화면에 나타나는 셀의 내용을 변경한다
		// 이 부분의 변경은 셀부분만 변경하는 것이고,
		// 선택된 값이 나타나는 버튼 부분은 변경되지 않는다
		combo.setCellFactory(new Callback<ListView<MyMember>, ListCell<MyMember>>() {
			
			@Override
			public ListCell<MyMember> call(ListView<MyMember> param) {
				return new ListCell<MyMember>() {
						@Override
						protected void updateItem(MyMember item, boolean empty) {
							super.updateItem(item, empty);
							if (item == null || empty) {
								setText(null);
							} else {
								setText(item.getName() + "(" + item.getId() + ")");
							}
						
						}
				};
			}
		});
		
		// 콤보박스의 버튼부분(항목을 선택했을 때 선택한 항목이 나타나는 부분)도 변경해 주어야 한다.
		combo.setButtonCell(
				new ListCell<MyMember>() {
					 protected void updateItem(MyMember item, boolean empty) {
						 if (item == null || empty) {
							 setText(null);
						 } else {
							 setText(item.getName() + "(" + item.getId() + ")");
						 }
					 }
				}
		);
		
		// 콤보박스를 클릭했을 때 이벤트 처리
		combo.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				MyMember selData = combo.getSelectionModel().getSelectedItem();
				
				taResult.setText("선택한 회원 정보\n\n");
				taResult.appendText("ID : " + selData.getId() + "\n");
				taResult.appendText("이름 : " + selData.getName() + "\n");
				taResult.appendText("나이 : " + selData.getAge() + "\n");
				taResult.appendText("전화번호 : " + selData.getTel() + "\n");
				taResult.appendText("주소 : " + selData.getAddr()+ "\n");
			}
		});
		combo.setValue(dataList.get(0));// 초기 선택값 지정
		
		
		vbox.setPadding(new Insets(10));
		vbox.getChildren().addAll(combo, taResult);
		Scene scene = new Scene(vbox, 500, 250);
		
		primaryStage.setTitle("ComboBox 연습2");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

// 데이터가 저장될 Class 구성하기
class MyMember{
	private String id;
	private String name;
	private int age;
	private String tel;
	private String addr;
	
	// 생성자
	public MyMember(String id, String name, int age, String tel, String addr) {
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
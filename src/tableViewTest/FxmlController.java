package tableViewTest;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class FxmlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    @FXML
    private TextField txt5;

    @FXML
    private TableView<MyMem> tableView;

    @FXML
    private TableColumn<MyMem, String> korNameCol;

    @FXML
    private TableColumn<MyMem, String> engNameCol;

    @FXML
    private TableColumn<MyMem, Integer> ageCol;

    @FXML
    private TableColumn<MyMem, String> telCol;

    @FXML
    private TableColumn<MyMem, String> addrCol;
    
    private ObservableList<MyMem> dataList;
    
    void getAlert(String headerText, String contentText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
    
    @FXML
    void clickedBtn1(ActionEvent event) {
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

    @FXML
    void clickedBtn2(ActionEvent event) {
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

    @FXML
    void clickedBtn3(ActionEvent event) {
    	if (tableView.getSelectionModel().isEmpty()) {
			getAlert("선택 오류", "클릭하신 행이 없습니다. 다시 클릭해주세요");
			return;
		}
		
		int index = tableView.getSelectionModel().getSelectedIndex();
		dataList.remove(index);
    }

    @FXML
    void setOnMouseClicked(MouseEvent event) {
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

    @FXML
    void initialize() {
        assert btn1 != null : "fx:id=\"btn1\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert btn2 != null : "fx:id=\"btn2\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert btn3 != null : "fx:id=\"btn3\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert txt1 != null : "fx:id=\"txt1\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert txt2 != null : "fx:id=\"txt2\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert txt3 != null : "fx:id=\"txt3\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert txt4 != null : "fx:id=\"txt4\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert txt5 != null : "fx:id=\"txt5\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert korNameCol != null : "fx:id=\"korNameCol\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert engNameCol != null : "fx:id=\"engNameCol\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert ageCol != null : "fx:id=\"ageCol\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert telCol != null : "fx:id=\"telCol\" was not injected: check your FXML file 'Fxml.fxml'.";
        assert addrCol != null : "fx:id=\"addrCol\" was not injected: check your FXML file 'Fxml.fxml'.";
        
        
        dataList = FXCollections.observableArrayList(
				new MyMem("홍길동", "gildong", 33, "1234-5678", "대전"),
				new MyMem("홍길서", "gilseo", 43, "3333-3333", "서울"),
				new MyMem("홍길남", "gilnam", 23, "2222-5555", "제주"),
				new MyMem("홍길북", "gilbook", 53, "8888-9999", "원주")
		);
        tableView.setItems(dataList);
        
        korNameCol.setCellValueFactory(new PropertyValueFactory<MyMem, String>("korName"));// MyMem의 속성인 korName을 받음);
		engNameCol.setCellValueFactory(new PropertyValueFactory<MyMem, String>("engName"));
		ageCol.setCellValueFactory(new PropertyValueFactory<MyMem, Integer>("age"));
		telCol.setCellValueFactory(new PropertyValueFactory<MyMem, String>("tel"));
		addrCol.setCellValueFactory(new PropertyValueFactory<MyMem, String>("addr"));
		
        
//      tableView.getColumns().addAll(korNameCol, engNameCol, ageCol, telCol, addrCol);

        
        
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

package mvc.homework.main;

import java.net.URL;
import java.util.List;
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
import mvc.homework.service.MemberService;
import mvc.homework.vo.MemberVO;

public class MemberMainController {
	MemberService service;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfMem_name;

    @FXML
    private TextField tfMem_tel;

    @FXML
    private TextField tfMem_addr;

    @FXML
    private TextField tfMem_id;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    private TableView<MemberVO> tableView;

    @FXML
    private TableColumn<?, ?> colMem_id;

    @FXML
    private TableColumn<?, ?> colMem_name;

    @FXML
    private TableColumn<?, ?> colMem_tel;

    @FXML
    private TableColumn<?, ?> colMem_addr;
    
    ObservableList<MemberVO> list = FXCollections.observableArrayList();
    
    int selection = 0;
    
    @FXML
    void onMouseCliked(MouseEvent event) {
    	MemberVO memberVO = tableView.getSelectionModel().getSelectedItem();
    	if (memberVO == null) {
			return;
		}
    	
    	tfMem_id.setText(memberVO.getMem_id());
    	tfMem_name.setText(memberVO.getMem_name());
    	tfMem_tel.setText(memberVO.getMem_tel());
    	tfMem_addr.setText(memberVO.getMem_addr());
    	
    }
    
    
    @FXML
    void onInsert(ActionEvent event) {
    	selection = 1;
    	
    	btnInsert.setDisable(true);
    	btnUpdate.setDisable(true);
    	btnDel.setDisable(true);
    	btnOk.setDisable(false);
    	btnCancel.setDisable(false);
    	
    	tfMem_id.setDisable(false);
    	tfMem_name.setDisable(false);
    	tfMem_tel.setDisable(false);
    	tfMem_addr.setDisable(false);
    	
    	tfMem_id.clear();
    	tfMem_name.clear();
    	tfMem_tel.clear();
    	tfMem_addr.clear();
    	
    }
    
    @FXML
    void onUpdate(ActionEvent event) {
    	selection = 2;
    	
    	btnInsert.setDisable(true);
    	btnUpdate.setDisable(true);
    	btnDel.setDisable(true);
    	btnOk.setDisable(false);
    	btnCancel.setDisable(false);
    	
    	tfMem_name.setDisable(false);
    	tfMem_tel.setDisable(false);
    	tfMem_addr.setDisable(false);
    	
    }
    
    @FXML
    void onDelete(ActionEvent event) {
    	MemberVO memberVO = new MemberVO();
    	
    	memberVO.setMem_id(tfMem_id.getText());
    	memberVO.setMem_name(tfMem_name.getText());
    	memberVO.setMem_tel(tfMem_tel.getText());
    	memberVO.setMem_addr(tfMem_addr.getText());
    	
    	int cnt = service.delete(memberVO);
    	alertInfo(cnt + "행이 삭제되었습니다.");
    	
    	List<MemberVO> result = service.getMemberAll();
    	list.clear();
    	list.addAll(result);
    	tableView.setItems(list);
    	
    	tfMem_id.clear();
    	tfMem_name.clear();
    	tfMem_tel.clear();
    	tfMem_addr.clear();
    }

    @FXML
    void onOk(ActionEvent event) {
    	MemberVO memberVO = new MemberVO();
    	
    	if (tfMem_id.getText().isEmpty() || tfMem_name.getText().isEmpty() || tfMem_tel.getText().isEmpty() || tfMem_addr.getText().isEmpty()) {
    		alertInfo("입력중에 누락된 부분이 있습니다. 채우고 난뒤 확인 버튼을 눌러주세요.");
    		return;
		}
    	
    	memberVO.setMem_id(tfMem_id.getText());
    	memberVO.setMem_name(tfMem_name.getText());
    	memberVO.setMem_tel(tfMem_tel.getText());
    	memberVO.setMem_addr(tfMem_addr.getText());
    	
    	
    	if (selection == 1) {
    		int result = service.getMember(tfMem_id.getText());
    		
    		if (result != 0) {
    			alertInfo("해당 회원이 있으므로 추가하지 않고 종료합니다");
				return;
			}
    		
    		int cnt = service.insert(memberVO);
    		alertInfo(cnt + "행이 입력되었습니다");
		}else if (selection == 2) {
			int cnt = service.update(memberVO);
			alertInfo(cnt + "행이 수정되었습니다");
		}
    	selection = 0;
    	
    	
    	List<MemberVO> result = service.getMemberAll();
    	list.clear();
    	list.addAll(result);
    	tableView.setItems(list);
    	
    	btnInsert.setDisable(false);
    	btnUpdate.setDisable(false);
    	btnDel.setDisable(false);
    	btnOk.setDisable(true);
    	btnCancel.setDisable(true);
    	
    	tfMem_id.setDisable(true);
    	tfMem_name.setDisable(true);
    	tfMem_tel.setDisable(true);
    	tfMem_addr.setDisable(true);
    	
    }
    
    @FXML
    void onCancel(ActionEvent event) {
    	selection = 0;
    	
    	btnInsert.setDisable(false);
    	btnUpdate.setDisable(false);
    	btnDel.setDisable(false);
    	btnOk.setDisable(true);
    	btnCancel.setDisable(true);
    	
    	tfMem_id.setDisable(true);
    	tfMem_name.setDisable(true);
    	tfMem_tel.setDisable(true);
    	tfMem_addr.setDisable(true);
    	
    	onMouseCliked(null);
    	
    }

    

    @FXML
    void initialize() {
    	assert tfMem_id != null : "fx:id=\"tfMem_id\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert tfMem_name != null : "fx:id=\"tfMem_name\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert tfMem_tel != null : "fx:id=\"tfMem_tel\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert tfMem_addr != null : "fx:id=\"tfMem_addr\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert btnInsert != null : "fx:id=\"btnInsert\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert btnDel != null : "fx:id=\"btnDel\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert btnOk != null : "fx:id=\"btnOk\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert colMem_id != null : "fx:id=\"colMem_id\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert colMem_name != null : "fx:id=\"colMem_name\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert colMem_tel != null : "fx:id=\"colMem_tel\" was not injected: check your FXML file 'memberMain.fxml'.";
        assert colMem_addr != null : "fx:id=\"colMem_addr\" was not injected: check your FXML file 'memberMain.fxml'.";
        
        // service 인스턴스 받음
        service = MemberService.getInstance();
        
        // 첫화면에 띄워줄 데이터 받아옴
        List<MemberVO> result = service.getMemberAll();
        
        // 컬럼 설정
        colMem_id.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
        colMem_name.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
        colMem_tel.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
        colMem_addr.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
        
        // 데이터 추가하기 및 출력
        list.addAll(result);
        tableView.setItems(list);
        
        
        // 확인, 취소 버튼 비활성화
        btnOk.setDisable(true);
        btnCancel.setDisable(true);
        
        // 입력창 비활성화
        tfMem_id.setDisable(true);
    	tfMem_name.setDisable(true);
    	tfMem_tel.setDisable(true);
    	tfMem_addr.setDisable(true);
    }
    
    private void alertInfo(String msg) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("확인");
    	alert.setHeaderText(msg);
		alert.showAndWait();
    }
    
}

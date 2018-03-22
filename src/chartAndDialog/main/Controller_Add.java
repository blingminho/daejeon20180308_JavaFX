package chartAndDialog.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import chartAndDialog.service.StudentService;
import chartAndDialog.service.StudentServiceInf;
import chartAndDialog.vo.StudentVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller_Add {
	StudentServiceInf service;
	static TableView<StudentVO> gettedTableView;
	
	private static Stage parentStage;
	private static Controller_Main parentController;

	public static void setController(Controller_Main controller) {
		parentController = controller;
	}
	
	public static void setPrimaryStage(Stage input_parentStage) {
		parentStage = input_parentStage;
	}
	
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //============================================================================
    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_kor;

    @FXML
    private TextField tf_mat;

    @FXML
    private TextField tf_eng;

    @FXML
    private Button btn_save;

    @FXML
    private Button btn_cancel;

    @FXML
    void onbtn_cancel(ActionEvent event) {
    	parentStage.close();
    }

    @FXML
    void onbtn_save(ActionEvent event) {
    	StudentVO studentVO = new StudentVO();
    	int flag = service.checkedStudent(tf_name.getText());
    	if (flag == 1) {
			System.out.println("해당하는 회원이 있습니다 종료합니다.");
			return;
		}
    	
    	try {
    		studentVO.setStu_name(tf_name.getText());
    		studentVO.setStu_kor(Integer.valueOf(tf_kor.getText()));
    		studentVO.setStu_mat(Integer.valueOf(tf_mat.getText()));
    		studentVO.setStu_eng(Integer.valueOf(tf_eng.getText()));
		} catch (Exception e) {
			System.out.println("잘못된 입력이므로 저장 실패!");
			return;
		}
    	
    	int result = service.insert(studentVO);
    	
    	System.out.println("학생 추가 result : " + result);
    	
    	parentController.renewal();
    	tf_name.clear();
    	tf_kor.clear();
    	tf_eng.clear();
    	tf_mat.clear();
    }
    
    
    
    @FXML
    void initialize() {
        assert tf_name != null : "fx:id=\"tf_name\" was not injected: check your FXML file 'ModalView.fxml'.";
        assert tf_kor != null : "fx:id=\"tf_kor\" was not injected: check your FXML file 'ModalView.fxml'.";
        assert tf_mat != null : "fx:id=\"tf_mat\" was not injected: check your FXML file 'ModalView.fxml'.";
        assert tf_eng != null : "fx:id=\"tf_eng\" was not injected: check your FXML file 'ModalView.fxml'.";
        assert btn_save != null : "fx:id=\"btn_save\" was not injected: check your FXML file 'ModalView.fxml'.";
        assert btn_cancel != null : "fx:id=\"btn_cancel\" was not injected: check your FXML file 'ModalView.fxml'.";
        
        service = StudentService.getInstance();
        
    }
}

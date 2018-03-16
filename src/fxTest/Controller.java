package fxTest;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tf;

    @FXML
    private RadioButton radio1;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton radio2;

    @FXML
    private CheckBox chk1;

    @FXML
    private CheckBox chk2;

    @FXML
    private CheckBox chk3;

    @FXML
    private CheckBox chk4;

    @FXML
    private CheckBox chk5;

    @FXML
    private CheckBox chk6;

    @FXML
    private CheckBox chk7;

    @FXML
    private CheckBox chk8;

    @FXML
    private Button btn;

    @FXML
    private TextArea ta;

    @FXML
    void gogo(ActionEvent event) {
    	String name = "";
		String gender2 = "";
		List<String> list = new ArrayList<String>();
		
		// 경고창
		Alert alertError = new Alert(AlertType.ERROR);
		
		alertError.setTitle("Error");
		alertError.setHeaderText("오류 제목");
		alertError.setContentText("블링블링 킹갓빛상준");
		
		
		if (!tf.getText().equals("")) {
			name =  tf.getText();
		} else {
			alertError.showAndWait();
			return;
		}
		
		
		if (gender.getSelectedToggle().getUserData() != null) {
			gender2 = (String)gender.getSelectedToggle().getUserData();
		}
		
		for (int i = 0; i < chkList.length; i++) {
			if (chkList[i].isSelected()) {
				list.add(chkList[i].getText());
			}
		}
		
		ta.setText("이 름 : " + name + "\n");
		ta.appendText("성 별 : " + gender2 + "\n");
		ta.appendText("취 미 : ");
		
		if (list.size() == 0) {
			ta.appendText("좀 가지세요!");
			return;
		}
		
		for (int j = 0; j < list.size(); j++) {
			String hobby = list.get(j);
			if (j != list.size()-1) {
				ta.appendText(hobby + ", ");						
			} else {
				ta.appendText(hobby);						
			}
		}
		
    }
    
    CheckBox[] chkList;
    @FXML
    void initialize() {
        assert tf != null : "fx:id=\"tf\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert radio1 != null : "fx:id=\"radio1\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert gender != null : "fx:id=\"gender\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert radio2 != null : "fx:id=\"radio2\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert chk1 != null : "fx:id=\"chk1\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert chk2 != null : "fx:id=\"chk2\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert chk3 != null : "fx:id=\"chk3\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert chk4 != null : "fx:id=\"chk4\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert chk5 != null : "fx:id=\"chk5\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert chk6 != null : "fx:id=\"chk6\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert chk7 != null : "fx:id=\"chk7\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert chk8 != null : "fx:id=\"chk8\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'FxTest.fxml'.";
        assert ta != null : "fx:id=\"ta\" was not injected: check your FXML file 'FxTest.fxml'.";
        
        radio1.setUserData("남");
        radio2.setUserData("여");
        
        chkList = new CheckBox[]{
        		chk1, chk2, chk3, chk4, chk5, chk6, chk7, chk8
        };
    }
}

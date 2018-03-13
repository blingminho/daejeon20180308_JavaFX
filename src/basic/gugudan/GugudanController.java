package basic.gugudan;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GugudanController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtf;

    @FXML
    private Button btn;

    @FXML
    private TextArea txta;

    @FXML
    void onClick(ActionEvent event) {
    	// 이벤트 설정에 지정한 메서드에서는 이벤트 처리에 관련된 내용을 기술한다
    	String input = txtf.getText();
    	if (input.isEmpty() || !Pattern.matches("^[0-9]+$", input)) {
			txta.setText("출력할 단을 정확히 입력하세요");
			txtf.requestFocus();
			return;
		}
    	
    	int dan = Integer.parseInt(input);
    	
    	txta.setText(dan + " 단\n\n");
    	for (int i = 1; i <= 9; i++) {
			txta.appendText(dan + " * " + i + " = " + dan*i + "\n");
		}
    	
    }

    // 이 메서드는 초기화를 진행하는 메서이다.
    @FXML
    void initialize() {
        assert txtf != null : "fx:id=\"txtf\" was not injected: check your FXML file 'GugudanTest2.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'GugudanTest2.fxml'.";
        assert txta != null : "fx:id=\"txta\" was not injected: check your FXML file 'GugudanTest2.fxml'.";
    }
}

package chartAndDialog.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import chartAndDialog.service.StudentService;
import chartAndDialog.vo.StudentVO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller_barChart {
	private static Stage parentStage;
	
	public static void setPrimaryStage(Stage input_parentStage) {
		parentStage = input_parentStage;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button btnClose;
    
    @FXML
    void onClose(ActionEvent event) {
    	parentStage.close();
    }
    
    @FXML
    void initialize() {
        assert barChart != null : "fx:id=\"barChart\" was not injected: check your FXML file 'barchart.fxml'.";
        assert xAxis != null : "fx:id=\"xAxis\" was not injected: check your FXML file 'barchart.fxml'.";
        assert yAxis != null : "fx:id=\"yAxis\" was not injected: check your FXML file 'barchart.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'barchart.fxml'.";

        List<StudentVO> list = StudentService.getInstance().getStudentAll();
        
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("국어");
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("영어");
        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        series3.setName("수학");
        for (StudentVO studentVO : list) {
			series1.getData().add(new XYChart.Data<>(studentVO.getStu_name(), studentVO.getStu_kor()));
			series2.getData().add(new XYChart.Data<>(studentVO.getStu_name(), studentVO.getStu_eng()));
			series3.getData().add(new XYChart.Data<>(studentVO.getStu_name(), studentVO.getStu_mat()));
		}
        
        barChart.getData().addAll(series1, series2, series3);
        
        
    }
}

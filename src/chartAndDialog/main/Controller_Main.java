package chartAndDialog.main;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller_Main {
	static StudentServiceInf service;
	
	
	private static Stage parentStage;
	
	public static void setPrimaryStage(Stage input_parentStage) {
		parentStage = input_parentStage;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<StudentVO> tableView;

    @FXML
    private TableColumn<?, ?> stu_name;

    @FXML
    private TableColumn<?, ?> stu_kor;

    @FXML
    private TableColumn<?, ?> stu_mat;

    @FXML
    private TableColumn<?, ?> stu_eng;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_graph;


    @FXML
    void onbtn_add(ActionEvent event) throws IOException {
    	
    	Scene addScene = new Scene(FXMLLoader.load(getClass().getResource("../view/ModalView.fxml")));
    	Stage addStage = new Stage(StageStyle.UTILITY);
    	addStage.initModality(Modality.WINDOW_MODAL);
    	addStage.initOwner(parentStage);
    	addStage.setTitle("추가");
    	addStage.setScene(addScene);
    	Controller_Add.setPrimaryStage(addStage);
    	Controller_Add.setController(this);
    	addStage.show();
    	
    }

    @FXML
    void onTableViewCliked(MouseEvent event) throws IOException {
    	Stage pieChartStage = new Stage();
    	Parent parent = FXMLLoader.load(getClass().getResource("../view/piechart.fxml"));
    	PieChart pieChart = (PieChart) parent.lookup("#pieChart");
    	
    	ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
    	StudentVO selectedStudentVO = tableView.getSelectionModel().getSelectedItem();
    	
    	ObservableList<TableColumn<StudentVO, ?>> columnsName = tableView.getColumns();
    	pieChart.getData().add(new PieChart.Data(columnsName.get(1).getText(), selectedStudentVO.getStu_kor()));
    	pieChart.getData().add(new PieChart.Data(columnsName.get(2).getText(), selectedStudentVO.getStu_eng()));
    	pieChart.getData().add(new PieChart.Data(columnsName.get(3).getText(), selectedStudentVO.getStu_mat()));
    	
    	
    	pieChart.setLabelLineLength(10);// 지시선 길이
    	pieChart.setLegendSide(Side.BOTTOM);// 범례가 놓이는 위치 설정
    	
    	Button btn = (Button) parent.lookup("#btn");
    	btn.setOnAction(e -> {
    		pieChartStage.close();
    	});
    	
    	Scene scene = new Scene(parent);
    	
    	pieChartStage.initModality(Modality.WINDOW_MODAL);
    	pieChartStage.initOwner(parentStage);
    	pieChartStage.setTitle("파이그래프");
    	pieChartStage.setScene(scene);
    	pieChartStage.show();
    	
    }
    
    @FXML
    void onbtn_graph(ActionEvent event) throws IOException {
    	Stage barChartStage = new Stage();
    	Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/barchart.fxml")));
    	barChartStage.initModality(Modality.WINDOW_MODAL);
    	barChartStage.initOwner(parentStage);
    	barChartStage.setTitle("막대그래프");
    	barChartStage.setScene(scene);
    	Controller_barChart.setPrimaryStage(barChartStage);
    	barChartStage.show();
    }
    
    static ObservableList<StudentVO> obserList = FXCollections.observableArrayList();
    
    @FXML
    void initialize() {
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ChartAndDialog.fxml'.";
        assert stu_name != null : "fx:id=\"stu_name\" was not injected: check your FXML file 'ChartAndDialog.fxml'.";
        assert stu_kor != null : "fx:id=\"stu_kor\" was not injected: check your FXML file 'ChartAndDialog.fxml'.";
        assert stu_mat != null : "fx:id=\"stu_mat\" was not injected: check your FXML file 'ChartAndDialog.fxml'.";
        assert stu_eng != null : "fx:id=\"stu_eng\" was not injected: check your FXML file 'ChartAndDialog.fxml'.";
        assert btn_add != null : "fx:id=\"btn_add\" was not injected: check your FXML file 'ChartAndDialog.fxml'.";
        assert btn_graph != null : "fx:id=\"btn_graph\" was not injected: check your FXML file 'ChartAndDialog.fxml'.";
        
        service = StudentService.getInstance();
        
        List<StudentVO> list = service.getStudentAll();
        
        ObservableList<StudentVO> obserList = FXCollections.observableArrayList();
        
        stu_name.setCellValueFactory(new PropertyValueFactory<>("stu_name"));
        stu_kor.setCellValueFactory(new PropertyValueFactory<>("stu_kor"));
        stu_mat.setCellValueFactory(new PropertyValueFactory<>("stu_mat"));
        stu_eng.setCellValueFactory(new PropertyValueFactory<>("stu_eng"));
        
        
        obserList.addAll(list);
        tableView.setItems(obserList);

    }
    
    public void renewal() {
    	List<StudentVO> list = service.getStudentAll();
    	ObservableList<StudentVO> obserList = FXCollections.observableArrayList();
    	obserList.addAll(list);
    	tableView.setItems(obserList);
    }
    
}

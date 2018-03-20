package dialog;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		// X축, Y축 관련 객체 생성
		CategoryAxis xAxis = new CategoryAxis();// X축
		NumberAxis yAxis = new NumberAxis();// Y축
		
		// BarChart객체 생성
		BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		
		bc.setTitle("나라별 결산");
		xAxis.setLabel("나라이름");
		yAxis.setLabel("경상수지");
		
		// 각 막대는 Series 객체를 이용해서 나타낸다
		XYChart.Series<String, Number> series1 = new XYChart.Series<>();
		series1.setName("2015년");
		series1.getData().add(new XYChart.Data<>("호주", 25000));
		series1.getData().add(new XYChart.Data<>("한국", 20000));
		series1.getData().add(new XYChart.Data<>("브라질", 10000));
		series1.getData().add(new XYChart.Data<>("영국", 35000));
		series1.getData().add(new XYChart.Data<>("미국", 32000));
		
		XYChart.Series<String, Number> series2 = new XYChart.Series<>();
		series2.setName("2016년");
		series2.getData().add(new XYChart.Data<>("호주", 57000));
		series2.getData().add(new XYChart.Data<>("한국", 41000));
		series2.getData().add(new XYChart.Data<>("브라질", 45000));
		series2.getData().add(new XYChart.Data<>("영국", 85000));
		series2.getData().add(new XYChart.Data<>("미국", 22000));
		
		XYChart.Series<String, Number> series3 = new XYChart.Series<>();
		series3.setName("2017년");
		series3.getData().add(new XYChart.Data<>("호주", 45000));
		series3.getData().add(new XYChart.Data<>("한국", 44000));
		series3.getData().add(new XYChart.Data<>("브라질", 20000));
		series3.getData().add(new XYChart.Data<>("영국", 17000));
		series3.getData().add(new XYChart.Data<>("미국", 66000));
		
		bc.getData().addAll(series1, series2, series3);
		
		
		Scene scene = new Scene(bc);
		
		primaryStage.setTitle("BarChart 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

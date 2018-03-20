package dialog;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		// PieChart에 나타날 데이터 구성
		ObservableList<PieChart.Data> pieChartData = 
				FXCollections.observableArrayList(
						new PieChart.Data("포도", 15),
						new PieChart.Data("오렌지", 25),
						new PieChart.Data("딸기", 10),
						new PieChart.Data("사과", 33),
						new PieChart.Data("배", 35),
						new PieChart.Data("복숭아", 22)
				);
		
		// PieChart를 생성과 동시에 데이터 설정
		PieChart chart = new PieChart(pieChartData);
		
		// PieChart생성 후 데이터 설정
//		PieChart chart = new PieChart();
//		chart.getData().addAll(pieChartData);
		
		chart.setTitle("과일 단가");
		chart.setLabelLineLength(10);// 지시선 길이
		chart.setLegendSide(Side.BOTTOM);// 범례가 놓이는 위치 설정
		
		
		
		
		
		
		Scene scene = new Scene(chart, 500, 500);
		primaryStage.setTitle("PieChart 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

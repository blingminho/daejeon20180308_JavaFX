package dialog;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		// 메뉴바의 가로 크기를 창 크기의 가로크기와 같도록한다
		// 창 크기가 변하면 자동으로 메뉴바의 가로 크기도 변한다.
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		
		root.setTop(menuBar);
		
		//------------------------------------------------------------------------
		// File menu -- new, save, exit
		Menu fileMenu = new Menu("File");
		
		MenuItem newMenuItem = new MenuItem("New");
		MenuItem saveMenuItem = new MenuItem("Save");
		MenuItem exitMenuItem = new MenuItem("Exit");
		
		// 메뉴에 이벤트 설정하기
		exitMenuItem.setOnAction(e -> {
			Platform.exit();// 프로그램 종료
		});
		
		// File메뉴 설정 끝
		fileMenu.getItems().addAll(newMenuItem, saveMenuItem, exitMenuItem);
		//------------------------------------------------------------------------
		
		
		Menu webMenu = new Menu("Web");
		
		CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
		htmlMenuItem.setSelected(true);// 체크하기
		CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
		
		webMenu.getItems().addAll(htmlMenuItem, cssMenuItem);
		
		//------------------------------------------------------------------------
		Menu sqlMenu = new Menu("SQL");
		ToggleGroup tg = new ToggleGroup();
		
		RadioMenuItem mysqlMenuItem = new RadioMenuItem("MySQL");
		mysqlMenuItem.setToggleGroup(tg);
		
		RadioMenuItem oracleMenuItem = new RadioMenuItem("Oracle");
		oracleMenuItem.setToggleGroup(tg);
		oracleMenuItem.setSelected(true);

		RadioMenuItem mssqlMenuItem = new RadioMenuItem("MS-SQL");
		mssqlMenuItem.setToggleGroup(tg);
		
		sqlMenu.getItems().addAll(mysqlMenuItem, oracleMenuItem, mssqlMenuItem, new SeparatorMenuItem());

		//------------------------------------------------------------------------
		
		Menu tutorialMenu = new Menu("Tutorial");
		tutorialMenu.getItems().addAll(
				new CheckMenuItem("Java 기초"),
				new CheckMenuItem("Java Thread"),
				new CheckMenuItem("Java Fx")
		);
		
		sqlMenu.getItems().add(tutorialMenu);
		
		
		//------------------------------------------------------------------------
		menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu);
		
		
		
		Scene scene = new Scene(root, 300, 250);
		
		primaryStage.setTitle("메뉴 구성하기 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

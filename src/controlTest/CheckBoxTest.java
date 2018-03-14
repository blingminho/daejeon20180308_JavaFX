package controlTest;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CheckBoxTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		String[] names = new String[] {"Security", "Project", "Chart"};
		Image[] images = new Image[names.length];
		ImageView[] icons = new ImageView[names.length];
		CheckBox[] chkboxs = new CheckBox[names.length];
		
		Rectangle rect = new Rectangle(90, 30);
		rect.setArcHeight(10);
		rect.setArcWidth(10);
		rect.setFill(Color.rgb(41, 41, 41));
		
		for (int i = 0; i < names.length; i++) {
			// 이미지 파일 읽어오기
			final Image img = images[i] = new Image(getClass().getResourceAsStream("images/" + names[i] + ".png"));
			int a = 12;
			// 이미지를 보여줄 ImageView객체 생성
			final ImageView icon = icons[i] = new ImageView();
			
			// CheckBox객체 생성
			chkboxs[i] = new CheckBox(names[i]);
			
			// CheckBox를 클릭해서 값이 변경되었을 때(체크되거나 해제되는...)
			chkboxs[i].selectedProperty().addListener(
					new ChangeListener<Boolean>() {
						@Override
						public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
								Boolean newValue) {
							// oldValue => 변경되기 전 값, newValue => 변경된 후 값
							icon.setImage(newValue ? img : null);
							;
						}
					}
			);
			
		}
		
		Button btn = new Button("확인");
		
		btn.setOnAction(
			e -> {
				// CheckBox의 체크 여부는 isSelected()메서드를 통해서 확인 할 수 있다.
				if (chkboxs[0].isSelected()) {// 0번째 CheckBox
					System.out.println("체크 됨.");
				} else {
					System.out.println("체크 안됨.");
				}
				
				// CheckBox를 직접 체크하거나 해제하려면 setSelected()메서드를 사용한다.
				// true값을 지정하면 체크되고, false값을 지정하면 체크가 해제된다
//				chkboxs[2].setSelected(true);
//				chkboxs[1].setSelected(false);
				
				chkboxs[1].setSelected(!chkboxs[2].isSelected());
			}
		);
		
		
		
		
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(chkboxs);
		vbox.getChildren().add(btn);
		vbox.setSpacing(10);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(icons);
		hbox.setPadding(new Insets(0, 0, 0, 5));
		
		StackPane stack = new StackPane();
		stack.getChildren().addAll(rect, hbox);
		StackPane.setAlignment(rect, Pos.TOP_CENTER);
		
		HBox root = new HBox();
		root.getChildren().addAll(vbox, stack);
		root.setSpacing(10);
		root.setPadding(new Insets(20, 10, 10, 20));
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("CheckBox 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

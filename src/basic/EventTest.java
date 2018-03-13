package basic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventTest extends Application {
	TextArea txtArea = new TextArea();

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(10);
		root.setPadding(new Insets(10));
		
		HBox hbox = new HBox(15);
		hbox.setPadding(new Insets(10));
		
		
		Button btn1 = new Button("첫번째");
		Button btn2 = new Button("두번째");
		Button btn3 = new Button("세번째");
		Button btn4 = new Button("네번째");
		
		
		/*
		1. 이벤트 처리방법1
		 ==> 객체.setOn이벤트명()메서드에 EventHandler인터페이스를 구현체 형식으로 구현한다.
		 	(이 인터페이스에는 handle()메서드가 있는데 이 메서드에 이벤트에 대한 처리 내용을 기술하면 된다.)
		*/
		btn1.setOnAction(
				
			/*
			new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// 이곳에 처리할 내용을 기술한다.
//					txtArea.setText("첫번째 버튼을 눌렀습니다."); //원래있던 내용을 지우고 처음부터
					txtArea.appendText("첫번째 버튼을 눌렀습니다.\n"); //기존에 있던 내용에 추가하는
				}
			}
			*/
				
			//람다식
			(ActionEvent e) -> {
				// 이곳에 처리할 내용을 기술한다.
//				txtArea.setText("람다식 - 첫번째 버튼을 눌렀습니다."); //원래있던 내용을 지우고 처음부터
				txtArea.appendText("람다식 - 첫번째 버튼을 눌렀습니다.\n"); //기존에 있던 내용에 추가하는
			}
		);
		
		/*
		2. 이벤트 처리방법2
			==> 객체.addEventHandler()메서드를 사용한다
			==> 이 메서드의 첫번째 매개변수로 '이벤트 종류'를 지정하고
				두번째 매개변수는 EventHandler인터페이스를 구현한 객체를 지정한다.
		*/
		btn2.addEventHandler(ActionEvent.ACTION,
				/*
				new EventHandler<Event>() {

					@Override
					public void handle(Event event) {
						// TODO Auto-generated method stub
						txtArea.appendText("두번째 버튼에 대한 이벤트입니다.\n");
					}
				}
				*/
				
				//람다식
				e -> {
					txtArea.appendText("두번째 버튼의 람다식 처리....\n");
				}
				
		);
		
		// 3-2. setOn이벤트명()메서드나 addEventHandler()메서드의
		//		매개변수로 EventHandler인터페이스를 구현한 객체를 지정한다.
		btn3.setOnAction(new MyEventHandler());
		
		
		// 4. 이벤트 처리방법4
		// 4-2. setOn이벤트명()메서드나 addEventHandler()메서드의
		//		매개변수로 EventHandler인터페이스를 구현한 객체를 지정한다.
		btn4.addEventHandler(ActionEvent.ACTION, new MyEventHandler2(txtArea));
		
		
		hbox.getChildren().addAll(btn1, btn2, btn3, btn4);
		root.getChildren().addAll(hbox, txtArea);
		
		// Scene객체르 생성할 때 크기를 정할 수 있다.
		Scene scene = new Scene(root, 300, 200);
		
		primaryStage.setTitle("Event 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	/*
	3. 이벤트 처리방법3
	  3-1. inner클래스로 EventHandler인터페이스를 구현한 클래스를 작성한다.
	*/
	class MyEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			txtArea.appendText("세번째 버튼 - inner클래스를 이용한 처리...\n");
		}
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}



/*
4. 이벤트 처리방법4
  4-1. 외부의 독립적인 객체를 이용하는 방법
  		==> 이 객체도 EventHandler 인터페이스를 구현해야 한다.
*/

class MyEventHandler2 implements EventHandler<ActionEvent>{
	TextArea txt2;

	public MyEventHandler2(TextArea t) {
		txt2 = t;
	}
	
	@Override
	public void handle(ActionEvent event) {
		txt2.appendText("네번째 방법입니다...\n");
	}
	
}
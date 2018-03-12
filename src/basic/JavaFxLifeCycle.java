package basic;

import javafx.application.Application;
import javafx.stage.Stage;
/*
 * Stage(무대) ==> window객체
 * Scene(장면) ==> 무대에는 하나의 장면이 배치된다
 * 
 * 실행순서 : main()메서드 --> launch()호출 --> 객체생성(생성자 실행)
 * 				--> init()메서드 --> start()메서드 -->프로그램 사용
 * 				--> 종료하기 --> stop()메서드 --> 끝...
 */
public class JavaFxLifeCycle extends Application {
	public JavaFxLifeCycle() {
		System.out.println(Thread.currentThread().getName() + " : 생성자 함수");
	}
	
	@Override
	public void init() throws Exception {
		// 자원 초기화 작업에 사용
		System.out.println(Thread.currentThread().getName() + " : init()메서드");
	}
	
	@Override
	public void start(Stage primaryStage) {
		// 창을 구성하고 처리하는 작업을 수행한다
		// 주로 이 메서드만 작성해서 사용한다.
		System.out.println(Thread.currentThread().getName() + " : start()메서드");
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		// 사용하던 자원등을 반납한다.
		System.out.println(Thread.currentThread().getName() + " : stop()메서드");
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " : main()메서드");
		launch(args);
	}
}

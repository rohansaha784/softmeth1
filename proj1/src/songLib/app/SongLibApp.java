package songLib.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import songLab.view.songLabController;

public class SongLibApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
		Scene show = songLabController.show();
		primaryStage.setScene(show);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

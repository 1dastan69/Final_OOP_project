package main.java.org.javafx.studentsmanagementsystem.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.com.goxr3plus.fxborderlessscene.borderless.BorderlessScene;
import main.java.org.javafx.studentsmanagementsystem.controller.TopBar;
import main.java.org.javafx.studentsmanagementsystem.model.SQLiteJDBC;

public class Main extends Application {
	
	public final static String FXMLS = "/fxml/";
	public final static String IMAGES = "/images/";

	public static TopBar topBar;
	
	public static BorderPane root;
	
	public static Stage window;

	public static BorderlessScene borderlessScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		topBar = new TopBar();

		Parent content = FXMLLoader.load(getClass().getResource(FXMLS + "MainController.fxml"));

		root = new BorderPane();
		root.setStyle("-fx-background-color:#202020");
		root.setTop(topBar);
		root.setCenter(content);

		window = primaryStage;
		primaryStage.setTitle("Students Management System");

		borderlessScene = new BorderlessScene(window, StageStyle.UNDECORATED, root, 600, 400);
		borderlessScene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
		borderlessScene.setMoveControl(topBar);
		primaryStage.setScene(borderlessScene);
		primaryStage.show();

		SQLiteJDBC.makeDb();
	}
	
	public static void setContent(Node node , String title) {
		
		root.setCenter(null);
		root.setCenter(node);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package sample;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ToggleButton toggleButton = new ToggleButton("TOGGLE ME");
        Label label = new Label();
        //Observable<Boolean> selectedStates = Observable.
        VBox vbox = new VBox(toggleButton,label);
        primaryStage.setScene(new Scene(vbox));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

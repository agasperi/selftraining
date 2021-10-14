import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import io.reactivex.Observable;

public class MyJavaFxApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ToggleButton toggleButton = new ToggleButton("TOGGLE ME!");
        Label label = new Label();

        Observable<Boolean> selectedStates = valuesOf(toggleButton.selectedProperty());
        selectedStates.map(selected -> selected ? "DOWN" : "UP")
                .subscribe(label::setText);

        VBox vbox = new VBox(toggleButton,label);
        primaryStage.setScene(new Scene(vbox));
        primaryStage.show();
    }

    private static <T> Observable<T> valuesOf(final ObservableValue<T> fxObservable){
        return Observable.create(observableEmitter -> {
            observableEmitter.onNext(fxObservable.getValue());
            final ChangeListener<T> listener =
                    (observableValue,prev,current) -> observableEmitter.onNext(current);
            fxObservable.addListener(listener);
        });
    }

}

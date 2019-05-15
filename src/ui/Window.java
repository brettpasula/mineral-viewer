
package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Window extends Application {

    Button button1, button2, alertButton, confirmButton, closeButton;
    Stage window;
    Scene scene2, scene3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("GeoViewer");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        button1 = new Button("Go to scene 2!");
        button1.setOnAction(e -> {
            window.setScene(scene2);
        });

        button2 = new Button("This scene sucks, go back.");
        button2.setOnAction(e -> {
            window.setScene(scene3);
        });

        alertButton = new Button("Alert button");
        alertButton.setOnAction(e -> {
            AlertBox.display("Alert Box", "Close");
        });

        confirmButton = new Button("Confirm button");
        confirmButton.setOnAction(e -> {
            ConfirmBox.display("Confirm", "Are you sure?");
        });

        closeButton = new Button("Close properly");
        closeButton.setOnAction(e -> {
            closeProgram();
        });

        // Layout 1 - VBox
        Label label1 = new Label("Welcome to the first scene!");
        VBox layout1 = new VBox(20);
        layout1.setPadding(new Insets(10));
        layout1.getChildren().addAll(label1, button1, alertButton, confirmButton, closeButton);

        // Layout 2 - StackPane
        StackPane layout2 = new StackPane(button2);
        scene2 = new Scene(layout2, 600, 300);

        // Layout 3 - HBox
        HBox topMenu = new HBox();
        Button file = new Button("File");
        Button edit = new Button("Edit");
        Button view = new Button("View");
        topMenu.getChildren().addAll(file, edit, view);

        // Layout 5 - GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField("Brett");
        GridPane.setConstraints(nameInput, 1, 0);

        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1,2);

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

        // Layout 4 - BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(layout1);
        borderPane.setCenter(grid);
        scene3 = new Scene(borderPane, 500, 500);

        window.setScene(scene3);
        window.show();

    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Confirm", "Are you sure you want to exit?");
        if(answer) {
           window.close();
       }
    }
}

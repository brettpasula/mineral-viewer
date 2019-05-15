// GUI built with the help of thenewboston's JavaFX tutorials on YouTube.

package ui;

import io.FileIO;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.Favourites;
import minerals.*;

import java.util.HashSet;

public class GUI extends Application {

    Stage window;
    Scene welcomeScene, mineralSelectScene, biotiteScene, calciteScene, feedbackScene, favouritesScene, magnetiteScene, plagioclaseScene, quartzScene;
    double BUTTON_WIDTH = 150;
    double BUTTON_HEIGHT = 2;
    FileIO io = new FileIO();
    Favourites favs = new Favourites();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("MineralViewer");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        //////////////////////////////////////////////////////////// WELCOME WINDOW  ////////////////////////////////////////////////////////////////
        Label welcomeMessage = new Label("Welcome to MineralViewer!");
        VBox welcomeVBox = new VBox(20);
        welcomeVBox.setAlignment(Pos.CENTER);
        welcomeVBox.setPadding(new Insets(40));

        Button minerals = new Button("Minerals");
        minerals.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        minerals.setOnAction(e -> {
            window.setScene(mineralSelectScene);
        });

        Button favourites = new Button("Favourites");
        favourites.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        favourites.setOnAction(e -> {
            window.setScene(favouritesScene);
        });

        Button feedback = new Button("Feedback");
        feedback.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        feedback.setOnAction(e -> {
            window.setScene(feedbackScene);
        });

        ImageView welcomeImage = new ImageView(new Image("/welcome_image.jpg"));
        welcomeVBox.getChildren().addAll(welcomeMessage, minerals, favourites, feedback, welcomeImage);

        welcomeScene = new Scene(welcomeVBox);

        //////////////////////////////////////////////////////////// MINERAL SELECT  ////////////////////////////////////////////////////////////
        VBox mineralSelect = new VBox(10);
        mineralSelect.setAlignment(Pos.CENTER);
        mineralSelect.setPadding(new Insets(40));
        Label mineralSelectHeader = new Label("Select a mineral to see it's properties and an image!");

        Button biotite = new Button("Biotite");
        biotite.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        biotite.setOnAction(e -> {
            window.setScene(biotiteScene);
        });

        Button calcite = new Button("Calcite");
        calcite.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        calcite.setOnAction(e -> {
            window.setScene(calciteScene);
        });

        Button magnetite = new Button("Magnetite");
        magnetite.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        magnetite.setOnAction(e -> {
            window.setScene(magnetiteScene);
        });

        Button plagioclase = new Button("Plagioclase");
        plagioclase.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        plagioclase.setOnAction(e -> {
            window.setScene(plagioclaseScene);
        });

        Button quartz = new Button("Quartz");
        quartz.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        quartz.setOnAction(e -> {
            window.setScene(quartzScene);
        });

        Button backToMainButton = new Button("Back to Home");
        backToMainButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        backToMainButton.setOnAction(e -> {
            window.setScene(welcomeScene);
        });
        mineralSelect.getChildren().addAll(mineralSelectHeader, biotite, calcite, magnetite, plagioclase, quartz, backToMainButton);

        mineralSelectScene = new Scene(mineralSelect);

        //////////////////////////////////////////////////////////// BACK BUTTON TO WELCOME TOP  /////////////////////////////////////////////////////////
        HBox backButtonToWelcomeTop = new HBox();
        backButtonToWelcomeTop.setPadding(new Insets(10));

        Button backToWelcomeButton = new Button("Back");
        backToWelcomeButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        backToWelcomeButton.setOnAction(e -> {
            window.setScene(welcomeScene);
        });

        backButtonToWelcomeTop.getChildren().add(backToWelcomeButton);

        //////////////////////////////////////////////////////////// FAVOURITES WINDOW  ////////////////////////////////////////////////////////////////

        ////////// FAVOURITES WINDOW TOP //////////
        HBox favsWindowTop = new HBox();
        favsWindowTop.setPadding(new Insets(10));
        Button backButton = new Button("Back");
        backButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        backButton.setOnAction(e -> {
            window.setScene(welcomeScene);
        });
        favsWindowTop.getChildren().add(backButton);

        ////////// FAVOURITES WINDOW CENTER //////////
        VBox favsWindowCenter = new VBox(10);
        favsWindowCenter.setAlignment(Pos.CENTER);
        favsWindowCenter.setPadding(new Insets(10));
        HashSet<String> favMin = new HashSet<>();
        HashSet<String> favRock = new HashSet<>();
        try {
            favMin = io.loadSet("favourite_minerals.txt");
        } catch(Exception e) {
            AlertBox.display("", "Error loading favourites");
        }
        Label favMinerals = new Label("Your favourite minerals: " + favMin);
        ImageView favsImage = new ImageView(new Image("/favourites_image.jpg"));
        favsWindowCenter.getChildren().addAll(favMinerals, favsImage);

        ////////// FAVOURITE WINDOW BORDERPANE /////////
        BorderPane favsWindow = new BorderPane();
        favsWindow.setPadding(new Insets(10));
        favsWindow.setTop(backButton);
        favsWindow.setRight(favsWindowCenter);

        favouritesScene = new Scene(favsWindow);

        //////////////////////////////////////////////////////////// BIOTITE WINDOW  ////////////////////////////////////////////////////////////////

        ////////// BIOTITE WINDOW TOP /////////
        HBox biotiteWindowTop = new HBox();
        biotiteWindowTop.setPadding(new Insets(10));

        Button biotiteBackButton = new Button("Back");
        biotiteBackButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        biotiteBackButton.setOnAction(e -> {
            window.setScene(mineralSelectScene);
        });

        biotiteWindowTop.getChildren().add(biotiteBackButton);

        ////////// BIOTITE WINDOW LEFT //////////

        ///// BIOTITE PROPERTIES /////
        VBox biotiteProperties = new VBox(5);
        biotiteProperties.setPadding(new Insets(10));
        Label biotitePropertiesHeader = new Label("The Properties of Biotite:");
        biotitePropertiesHeader.setAlignment(Pos.CENTER);
        Label biotiteFormula = new Label("Formula: " + Biotite.FORMULA);
        Label biotiteColour = new Label("Colour: " + Biotite.COLOUR);
        Label biotiteStreak = new Label("Streak: " + Biotite.STREAK);
        Label biotiteLuster = new Label("Luster: " + Biotite.LUSTER);
        Label biotiteDiaphaneity = new Label("Diaphaneity: " + Biotite.DIAPHANEITY);
        Label biotiteCleavage = new Label("Cleavage: " + Biotite.CLEAVAGE);
        Label biotiteCrystalSystem = new Label("Crystal System: " + Biotite.CRYSTAL_SYSTEM);
        Label biotiteHardness = new Label("Hardness: " + Biotite.HARDNESS);
        biotiteProperties.getChildren().addAll(biotitePropertiesHeader, biotiteFormula, biotiteColour, biotiteStreak, biotiteLuster, biotiteDiaphaneity,
                biotiteCleavage, biotiteCrystalSystem, biotiteHardness);

        ///// BIOTITE ATOMIC STRUCTURE /////
        ScrollPane biotiteAtomicStructureTop = new ScrollPane();
        ImageView biotiteAtomicStructureImage = new ImageView(new Image("/bt_atomic_structure.jpg"));
        biotiteAtomicStructureTop.setContent(biotiteAtomicStructureImage);
        HBox biotiteAtomicStructureBottom = new HBox();
        Label biotiteAtomicStructureCaption = new Label("The atomic structure of Biotite.");
        biotiteAtomicStructureBottom.getChildren().add(biotiteAtomicStructureCaption);
        BorderPane biotiteAtomicStructure = new BorderPane();
        biotiteAtomicStructure.setCenter(biotiteAtomicStructureTop);
        biotiteAtomicStructure.setBottom(biotiteAtomicStructureBottom);

        BorderPane biotiteLeftWindow = new BorderPane();
        biotiteLeftWindow.setCenter(biotiteProperties);
        biotiteLeftWindow.setBottom(biotiteAtomicStructure);

        ////////// BIOTITE WINDOW BOTTOM //////////
        HBox biotiteWindowBottom = new HBox();
        biotiteWindowBottom.setAlignment(Pos.CENTER_RIGHT);
        biotiteWindowBottom.setPadding(new Insets(10));

        Button addBiotiteToFavs = new Button("Add to Favourites");
        addBiotiteToFavs.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        addBiotiteToFavs.setOnAction(e -> {
            Boolean answer = ConfirmBox.display("", "Are you sure you'd like to add Biotite to your favourites?");
            if(answer) {
                favs.addToFavMin("Biotite");
            }
        });
        biotiteWindowBottom.getChildren().add(addBiotiteToFavs);

        ////////// BIOTITE WINDOW CENTER //////////

        ///// BIOTITE IMAGE PANE /////
        ScrollPane biotiteImagePane = new ScrollPane();
        biotiteImagePane.setContent(new ImageView(new Image("/btimage1.jpg")));

        ///// BIOTITE IMAGE CAPTION /////
        HBox biotiteCaption = new HBox();
        Label biotiteCaptionLabel = new Label("In this image of biotite you can clearly see the perfect planar cleavage and characteristic dark brown colour.");
        biotiteCaption.getChildren().add(biotiteCaptionLabel);

        BorderPane biotiteCenterWindow = new BorderPane();
        biotiteCenterWindow.setCenter(biotiteImagePane);
        biotiteCenterWindow.setBottom(biotiteCaption);

        ////////// BIOTITE BORDERPANE //////////
        BorderPane biotiteWindow = new BorderPane();
        biotiteWindow.setPadding(new Insets(10));
        biotiteWindow.setLeft(biotiteLeftWindow);
        biotiteWindow.setTop(biotiteWindowTop);
        biotiteWindow.setBottom(biotiteWindowBottom);
        biotiteWindow.setCenter(biotiteCenterWindow);
        biotiteScene = new Scene(biotiteWindow, 1000, 700);

        //////////////////////////////////////////////////////////// CALCITE WINDOW  ////////////////////////////////////////////////////////////////

        ////////// CALCITE WINDOW TOP /////////
        HBox calciteWindowTop = new HBox();
        calciteWindowTop.setPadding(new Insets(10));

        Button calciteBackButton = new Button("Back");
        calciteBackButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        calciteBackButton.setOnAction(e -> {
            window.setScene(mineralSelectScene);
        });

        calciteWindowTop.getChildren().add(calciteBackButton);

        ////////// CALCITE WINDOW LEFT //////////

        ///// CALCITE PROPERTIES /////
        VBox calciteProperties = new VBox(5);
        calciteProperties.setPadding(new Insets(10));
        Label calcitePropertiesHeader = new Label("The Properties of Calcite:");
        calcitePropertiesHeader.setAlignment(Pos.CENTER);
        Label calciteFormula = new Label("Formula: " + Calcite.FORMULA);
        Label calciteColour = new Label("Colour: " + Calcite.COLOUR);
        Label calciteStreak = new Label("Streak: " + Calcite.STREAK);
        Label calciteLuster = new Label("Luster: " + Calcite.LUSTER);
        Label calciteDiaphaneity = new Label("Diaphaneity: " + Calcite.DIAPHANEITY);
        Label calciteCleavage = new Label("Cleavage: " + Calcite.CLEAVAGE);
        Label calciteCrystalSystem = new Label("Crystal System: " + Calcite.CRYSTAL_SYSTEM);
        Label calciteHardness = new Label("Hardness: " + Calcite.HARDNESS);
        calciteProperties.getChildren().addAll(calcitePropertiesHeader, calciteFormula, calciteColour, calciteStreak, calciteLuster, calciteDiaphaneity,
                calciteCleavage, calciteCrystalSystem, calciteHardness);

        ///// CALCITE ATOMIC STRUCTURE /////
        ScrollPane calciteAtomicStructureTop = new ScrollPane();
        ImageView calciteAtomicStructureImage = new ImageView(new Image("/cal_atomic_structure.png"));
        calciteAtomicStructureTop.setContent(calciteAtomicStructureImage);
        HBox calciteAtomicStructureBottom = new HBox();
        Label calciteAtomicStructureCaption = new Label("The atomic structure of Calcite.");
        calciteAtomicStructureBottom.getChildren().add(calciteAtomicStructureCaption);
        BorderPane calciteAtomicStructure = new BorderPane();
        calciteAtomicStructure.setCenter(calciteAtomicStructureTop);
        calciteAtomicStructure.setBottom(calciteAtomicStructureBottom);

        BorderPane calciteLeftWindow = new BorderPane();
        calciteLeftWindow.setCenter(calciteProperties);
        calciteLeftWindow.setBottom(calciteAtomicStructure);

        ////////// CALCITE WINDOW BOTTOM //////////
        HBox calciteWindowBottom = new HBox();
        calciteWindowBottom.setAlignment(Pos.CENTER_RIGHT);
        calciteWindowBottom.setPadding(new Insets(10));

        Button addCalciteToFavs = new Button("Add to Favourites");
        addCalciteToFavs.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        addCalciteToFavs.setOnAction(e -> {
            Boolean answer = ConfirmBox.display("", "Are you sure you'd like to add Calcite to your favourites?");
            if(answer) {
                favs.addToFavMin("Calcite");
            }
        });

        calciteWindowBottom.getChildren().add(addCalciteToFavs);

        ////////// CALCITE WINDOW CENTER //////////

        ///// CALCITE IMAGE PANE /////
        ScrollPane calciteImagePane = new ScrollPane();
        calciteImagePane.setContent(new ImageView(new Image("/calimage1.jpg")));

        ///// CALCITE IMAGE CAPTION /////
        HBox calciteCaption = new HBox();
        Label calciteCaptionLabel = new Label("This image of calcite displays the perfect rhomobhedral cleavage of the mineral.");
        calciteCaption.getChildren().add(calciteCaptionLabel);

        BorderPane calciteCenterWindow = new BorderPane();
        calciteCenterWindow.setCenter(calciteImagePane);
        calciteCenterWindow.setBottom(calciteCaption);

        ////////// CALCITE BORDERPANE //////////
        BorderPane calciteWindow = new BorderPane();
        calciteWindow.setPadding(new Insets(10));
        calciteWindow.setLeft(calciteLeftWindow);
        calciteWindow.setTop(calciteBackButton);
        calciteWindow.setBottom(calciteWindowBottom);
        calciteWindow.setCenter(calciteCenterWindow);
        calciteScene = new Scene(calciteWindow, 1000, 700);

        //////////////////////////////////////////////////////////// MAGNETITE WINDOW  ////////////////////////////////////////////////////////////////

        ////////// MAGNETITE WINDOW TOP /////////
        HBox magnetiteWindowTop = new HBox();
        magnetiteWindowTop.setPadding(new Insets(10));

        Button magnetiteBackButton = new Button("Back");
        magnetiteBackButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        magnetiteBackButton.setOnAction(e -> {
            window.setScene(mineralSelectScene);
        });

        magnetiteWindowTop.getChildren().add(magnetiteBackButton);

        ////////// MAGNETITE WINDOW LEFT //////////
        VBox magnetiteProperties = new VBox(5);
        magnetiteProperties.setPadding(new Insets(10));
        Label magnetitePropertiesHeader = new Label("The Properties of Magnetite:");
        magnetitePropertiesHeader.setAlignment(Pos.CENTER);
        Label magnetiteFormula = new Label("Formula: " + Magnetite.FORMULA);
        Label magnetiteColour = new Label("Colour: " + Magnetite.COLOUR);
        Label magnetiteStreak = new Label("Streak: " + Magnetite.STREAK);
        Label magnetiteLuster = new Label("Luster: " + Magnetite.LUSTER);
        Label magnetiteDiaphaneity = new Label("Diaphaneity: " + Magnetite.DIAPHANEITY);
        Label magnetiteCleavage = new Label("Cleavage: " + Magnetite.CLEAVAGE);
        Label magnetiteCrystalSystem = new Label("Crystal System: " + Magnetite.CRYSTAL_SYSTEM);
        Label magnetiteHardness = new Label("Hardness: " + Magnetite.HARDNESS);
        magnetiteProperties.getChildren().addAll(magnetitePropertiesHeader, magnetiteFormula, magnetiteColour, magnetiteStreak, magnetiteLuster, magnetiteDiaphaneity,
                magnetiteCleavage, magnetiteCrystalSystem, magnetiteHardness);

        ////////// MAGNETITE WINDOW BOTTOM //////////
        HBox magnetiteWindowBottom = new HBox();
        magnetiteWindowBottom.setAlignment(Pos.CENTER_RIGHT);
        magnetiteWindowBottom.setPadding(new Insets(10));

        Button addMagnetiteToFavs = new Button("Add to Favourites");
        addMagnetiteToFavs.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        addMagnetiteToFavs.setOnAction(e -> {
            Boolean answer = ConfirmBox.display("", "Are you sure you'd like to add Magnetite to your favourites?");
            if(answer) {
                favs.addToFavMin("Magnetite");
            }
        });
        magnetiteWindowBottom.getChildren().add(addMagnetiteToFavs);

        ////////// MAGNETITE WINDOW CENTER //////////

        ///// MAGNETITE IMAGE PANE /////
        ScrollPane magnetiteImagePane = new ScrollPane();
        magnetiteImagePane.setContent(new ImageView(new Image("/mtimage1.png")));

        ///// MAGNETITE IMAGE CAPTION /////
        HBox magnetiteCaption = new HBox();
        Label magnetiteCaptionLabel = new Label("This image of magnetite displays its dark black metallic colour.");
        magnetiteCaption.getChildren().add(magnetiteCaptionLabel);

        BorderPane magnetiteCenterWindow = new BorderPane();
        magnetiteCenterWindow.setCenter(magnetiteImagePane);
        magnetiteCenterWindow.setBottom(magnetiteCaption);

        ////////// MAGNETITE BORDERPANE //////////
        BorderPane magnetiteWindow = new BorderPane();
        magnetiteWindow.setPadding(new Insets(10));
        magnetiteWindow.setLeft(magnetiteProperties);
        magnetiteWindow.setTop(magnetiteBackButton);
        magnetiteWindow.setBottom(magnetiteWindowBottom);
        magnetiteWindow.setCenter(magnetiteCenterWindow);
        magnetiteScene = new Scene(magnetiteWindow, 800, 600);

        //////////////////////////////////////////////////////////// PLAGIOCLASE WINDOW  ////////////////////////////////////////////////////////////////

        ////////// PLAGIOCLASE WINDOW TOP /////////
        HBox plagioclaseWindowTop = new HBox();
        plagioclaseWindowTop.setPadding(new Insets(10));

        Button plagioclaseBackButton = new Button("Back");
        plagioclaseBackButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        plagioclaseBackButton.setOnAction(e -> {
            window.setScene(mineralSelectScene);
        });

        plagioclaseWindowTop.getChildren().add(plagioclaseBackButton);

        ////////// PLAGIOCLASE WINDOW LEFT //////////
        VBox plagioclaseProperties = new VBox(5);
        plagioclaseProperties.setPadding(new Insets(10));
        Label plagioclasePropertiesHeader = new Label("The Properties of Plagioclase:");
        plagioclasePropertiesHeader.setAlignment(Pos.CENTER);
        Label plagioclaseFormula = new Label("Formula: " + Plagioclase.FORMULA);
        Label plagioclaseColour = new Label("Colour: " + Plagioclase.COLOUR);
        Label plagioclaseStreak = new Label("Streak: " + Plagioclase.STREAK);
        Label plagioclaseLuster = new Label("Luster: " + Plagioclase.LUSTER);
        Label plagioclaseDiaphaneity = new Label("Diaphaneity: " + Plagioclase.DIAPHANEITY);
        Label plagioclaseCleavage = new Label("Cleavage: " + Plagioclase.CLEAVAGE);
        Label plagioclaseCrystalSystem = new Label("Crystal System: " + Plagioclase.CRYSTAL_SYSTEM);
        Label plagioclaseHardness = new Label("Hardness: " + Plagioclase.HARDNESS);
        plagioclaseProperties.getChildren().addAll(plagioclasePropertiesHeader, plagioclaseFormula, plagioclaseColour, plagioclaseStreak, plagioclaseLuster, plagioclaseDiaphaneity,
                plagioclaseCleavage, plagioclaseCrystalSystem, plagioclaseHardness);

        ////////// PLAGIOCLASE WINDOW BOTTOM //////////
        HBox plagioclaseWindowBottom = new HBox();
        plagioclaseWindowBottom.setAlignment(Pos.CENTER_RIGHT);
        plagioclaseWindowBottom.setPadding(new Insets(10));

        Button addPlagioclaseToFavs = new Button("Add to Favourites");
        addPlagioclaseToFavs.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        addPlagioclaseToFavs.setOnAction(e -> {
            Boolean answer = ConfirmBox.display("", "Are you sure you'd like to add Plagioclase to your favourites?");
            if(answer) {
                favs.addToFavMin("Plagioclase");
            }
        });
        plagioclaseWindowBottom.getChildren().add(addPlagioclaseToFavs);

        ////////// PLAGIOCLASE WINDOW CENTER //////////

        ///// PLAGIOCLASE IMAGE PANE /////
        ScrollPane plagioclaseImagePane = new ScrollPane();
        plagioclaseImagePane.setContent(new ImageView(new Image("/plagimage1.png")));

        ///// PLAGIOCLASE IMAGE CAPTION /////
        HBox plagioclaseCaption = new HBox();
        Label plagioclaseCaptionLabel = new Label("Notice the cream-white colour and linear cleavage of plagioclase.");
        plagioclaseCaption.getChildren().add(plagioclaseCaptionLabel);

        BorderPane plagioclaseCenterWindow = new BorderPane();
        plagioclaseCenterWindow.setCenter(plagioclaseImagePane);
        plagioclaseCenterWindow.setBottom(plagioclaseCaption);

        ////////// PLAGIOCLASE BORDERPANE //////////
        BorderPane plagioclaseWindow = new BorderPane();
        plagioclaseWindow.setLeft(plagioclaseProperties);
        plagioclaseWindow.setTop(plagioclaseWindowTop);
        plagioclaseWindow.setBottom(plagioclaseWindowBottom);
        plagioclaseWindow.setCenter(plagioclaseCenterWindow);
        plagioclaseScene = new Scene(plagioclaseWindow, 1000, 800);

        //////////////////////////////////////////////////////////// QUARTZ WINDOW  ////////////////////////////////////////////////////////////////

        ////////// QUARTZ WINDOW TOP /////////
        HBox quartzWindowTop = new HBox();
        quartzWindowTop.setPadding(new Insets(10));

        Button quartzBackButton = new Button("Back");
        quartzBackButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        quartzBackButton.setOnAction(e -> {
            window.setScene(mineralSelectScene);
        });

        quartzWindowTop.getChildren().add(quartzBackButton);

        ////////// QUARTZ WINDOW LEFT //////////
        VBox quartzProperties = new VBox(5);
        quartzProperties.setPadding(new Insets(10));
        Label quartzPropertiesHeader = new Label("The Properties of Quartz:");
        quartzPropertiesHeader.setAlignment(Pos.CENTER);
        Label quartzFormula = new Label("Formula: " + Quartz.FORMULA);
        Label quartzColour = new Label("Colour: " + Quartz.COLOUR);
        Label quartzStreak = new Label("Streak: " + Quartz.STREAK);
        Label quartzLuster = new Label("Luster: " + Quartz.LUSTER);
        Label quartzDiaphaneity = new Label("Diaphaneity: " + Quartz.DIAPHANEITY);
        Label quartzCleavage = new Label("Cleavage: " + Quartz.CLEAVAGE);
        Label quartzCrystalSystem = new Label("Crystal System: " + Quartz.CRYSTAL_SYSTEM);
        Label quartzHardness = new Label("Hardness: " + Quartz.HARDNESS);
        quartzProperties.getChildren().addAll(quartzPropertiesHeader, quartzFormula, quartzColour, quartzStreak, quartzLuster, quartzDiaphaneity,
                quartzCleavage, quartzCrystalSystem, quartzHardness);

        ////////// QUARTZ WINDOW BOTTOM //////////
        HBox quartzWindowBottom = new HBox();
        quartzWindowBottom.setAlignment(Pos.CENTER_RIGHT);
        quartzWindowBottom.setPadding(new Insets(10));

        Button addQuartzToFavs = new Button("Add to Favourites");
        addQuartzToFavs.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        addQuartzToFavs.setOnAction(e -> {
            Boolean answer = ConfirmBox.display("", "Are you sure you'd like to add Quartz to your favourites?");
            if(answer) {
                favs.addToFavMin("Quartz");
            }
        });
        quartzWindowBottom.getChildren().add(addQuartzToFavs);

        ////////// QUARTZ WINDOW CENTER //////////

        ///// QUARTZ IMAGE PANE /////
        ScrollPane quartzImagePane = new ScrollPane();
        quartzImagePane.setContent(new ImageView(new Image("/qtzimage1.jpg")));

        ///// QUARTZ IMAGE CAPTION /////
        HBox quartzCaption = new HBox();
        Label quartzCaptionLabel = new Label("This large hexagonal quartz growing from a substrate indicates that this quartz grew in a void.");
        quartzCaption.getChildren().add(quartzCaptionLabel);

        BorderPane quartzCenterWindow = new BorderPane();
        quartzCenterWindow.setCenter(quartzImagePane);
        quartzCenterWindow.setBottom(quartzCaption);

        ////////// QUARTZ BORDERPANE //////////
        BorderPane quartzWindow = new BorderPane();
        quartzWindow.setLeft(quartzProperties);
        quartzWindow.setTop(quartzWindowTop);
        quartzWindow.setBottom(quartzWindowBottom);
        quartzWindow.setCenter(quartzCenterWindow);
        quartzScene = new Scene(quartzWindow, 800, 500);


        //////////////////////////////////////////////////////////// FEEDBACK WINDOW  ////////////////////////////////////////////////////////////////
        GridPane feedbackWindowCenter = new GridPane();
        feedbackWindowCenter.setPadding(new Insets(10, 10, 10, 10));
        feedbackWindowCenter.setVgap(8);
        feedbackWindowCenter.setHgap(10);

        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput, 1, 0);

        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 1);
        TextField emailInput = new TextField();
        emailInput.setPromptText("email");
        GridPane.setConstraints(emailInput, 1, 1);

        Label feedbackLabel = new Label("Feedback:");
        GridPane.setConstraints(feedbackLabel, 0, 2);
        TextField feedbackInput = new TextField();
        feedbackInput.setPromptText("feedback");
        GridPane.setConstraints(feedbackInput, 1, 2);

        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 1,3);
        submitButton.setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        submitButton.setOnAction(e -> {
            try {
                io.saveFeedback(nameInput.getText(), emailInput.getText(), feedbackInput.getText());
            } catch (Exception ex) {
                AlertBox.display("", "Error saving feedback.");
            }
            AlertBox.display("", "Thank you, your feedback is appreciated.");
            window.setScene(welcomeScene);
        });

        feedbackWindowCenter.getChildren().addAll(nameLabel, nameInput, emailLabel, emailInput, feedbackLabel, feedbackInput, submitButton);

        BorderPane feedbackWindow = new BorderPane();
        feedbackWindow.setCenter(feedbackWindowCenter);
        feedbackWindow.setTop(backButtonToWelcomeTop);

        feedbackScene = new Scene(feedbackWindow);

        //////////////////////////////////////////////////////////// WINDOW SETTINGS  ////////////////////////////////////////////////////////////////
        window.setScene(welcomeScene);
        window.show();

    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("", "Are you sure you want to exit?");
        if(answer) {
            window.close();
            try {
                io.saveSet(favs.favouriteMinerals, "favourite_minerals.txt");
            } catch(Exception e) {
                AlertBox.display("Error", "We were unable to save your favourites, sorry.");
            }
        }
    }

}

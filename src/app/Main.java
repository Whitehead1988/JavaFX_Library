package app;

import app.controller.ScreensPageController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        ScreensPageController mainContainer = new ScreensPageController();
        mainContainer.loadScreen("login", "/app/views/loginPage.fxml");
        mainContainer.loadScreen("first", "/app/views/menuFramePage.fxml");
        mainContainer.loadScreen("home", "/app/views/homePage.fxml");
        mainContainer.loadScreen("books", "/app/views/booksPage.fxml");
        mainContainer.loadScreen("search", "/app/views/searchPage.fxml");
        mainContainer.loadScreen("addBook", "/app/views/addPage.fxml");
        mainContainer.loadScreen("settings", "/app/views/settingsPage.fxml");
        mainContainer.loadScreen("about", "/app/views/aboutPage.fxml");

        mainContainer.setScreens("login");

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/klok.png")));
        primaryStage.setTitle("La librairie");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


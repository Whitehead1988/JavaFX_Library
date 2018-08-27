package app.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuFramePageController implements Initializable, ControlledScreen
{
    ScreensPageController myController;

    @FXML
    private JFXButton home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton settings;

    @FXML
    private JFXButton search;

    @FXML
    private JFXButton books;

    @FXML
    private JFXButton about;

    @FXML
    private AnchorPane placeHolder;

    @FXML
    private void displayHome(ActionEvent event) {
        myController.setScreens("home", placeHolder);
    }

    @FXML
    private void displayBooks(ActionEvent event) {
        myController.setScreens("books", placeHolder);
    }

    @FXML
    private void displayAdd(ActionEvent event) {
        myController.setScreens("addBook", placeHolder);
    }

    @FXML
    private void displaySearch(ActionEvent event) {
        myController.setScreens("search", placeHolder);
    }

    @FXML
    private void displaySettings(ActionEvent event){
        myController.setScreens("settings",placeHolder);
    }

    @FXML
    private void displayAbout(ActionEvent event) {
        myController.setScreens("about", placeHolder);
    }

    @Override
    public void setScreenParent(ScreensPageController screenPage) {
        myController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Image image = new Image(getClass().getResource("/images/home-512.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);

        home.setGraphic(imageView);
        home.setAlignment(Pos.BASELINE_CENTER);
        home.setContentDisplay(ContentDisplay.TOP);
        home.setText("Home");

        Image image2 = new Image(getClass().getResource("/images/book-5.png").toExternalForm());
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(35);
        imageView2.setFitWidth(35);

        books.setGraphic(imageView2);
        books.setAlignment(Pos.BASELINE_CENTER);
        books.setContentDisplay(ContentDisplay.TOP);
        books.setText("Books");

        Image imageSearch = new Image(getClass().getResource("/images/searchButton.png").toExternalForm());
        ImageView imageSearchView = new ImageView(imageSearch);
        imageSearchView.setFitHeight(35);
        imageSearchView.setFitWidth(35);

        search.setGraphic(imageSearchView);
        search.setAlignment(Pos.BASELINE_CENTER);
        search.setContentDisplay(ContentDisplay.TOP);
        search.setText("Search");


        Image imageAdd = new Image(getClass().getResource("/images/plus-icon-21.png").toExternalForm());
        ImageView imageAddView = new ImageView(imageAdd);
        imageAddView.setFitHeight(35);
        imageAddView.setFitWidth(35);

        add.setGraphic(imageAddView);
        add.setAlignment(Pos.BASELINE_CENTER);
        add.setContentDisplay(ContentDisplay.TOP);
        add.setText("Add book");


        Image imageSettings = new Image(getClass().getResource("/images/img_406982.png").toExternalForm());
        ImageView imageSettingsView = new ImageView(imageSettings);
        imageSettingsView.setFitHeight(35);
        imageSettingsView.setFitWidth(35);

        settings.setGraphic(imageSettingsView);
        settings.setAlignment(Pos.BASELINE_CENTER);
        settings.setContentDisplay(ContentDisplay.TOP);
        settings.setText("Settings");


        Image imageAbout = new Image(getClass().getResource("/images/about (1).png").toExternalForm());
        ImageView imageAboutView = new ImageView(imageAbout);
        imageAboutView.setFitHeight(35);
        imageAboutView.setFitWidth(35);

        about.setGraphic(imageAboutView);
        about.setAlignment(Pos.BASELINE_CENTER);
        about.setContentDisplay(ContentDisplay.TOP);
        about.setText("About");
    }
}

package app.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable, ControlledScreen {

    ScreensPageController myController;

    @Override
    public void setScreenParent(ScreensPageController screenPage) {
        myController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

package app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable, ControlledScreen {

    ScreensPageController myController;

    @FXML
    void loginAction(ActionEvent event) {
        myController.setScreens("first");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ScreensPageController screenPage) {
        myController = screenPage;
    }
}

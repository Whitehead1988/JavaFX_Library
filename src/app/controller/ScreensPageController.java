package app.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.HashMap;

public class ScreensPageController extends StackPane {

    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensPageController(){
        super();
    }

    public void addScreen(String name, Node screen){
        screens.put(name, screen);
    }

    public Node getScreen(String name){
        return screens.get(name);
    }

    public void loadScreen(String name, String resource){
        try {
            FXMLLoader newLoadedScreen = new FXMLLoader(getClass().getResource(resource));
            Parent loadedScreen =  newLoadedScreen.load();
            ((ControlledScreen) newLoadedScreen.getController()).setScreenParent(this);
            addScreen(name, loadedScreen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScreens(String name){
        getChildren().clear();
        getChildren().addAll(getScreen(name));
    }

    public void setScreens(String name, Pane placeHolder){
        placeHolder.getChildren().clear();
        placeHolder.getChildren().addAll(getScreen(name));
    }


}
